package com.ezen.view;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.dto.BoardVO;
import com.ezen.dto.BookMarkVO;
import com.ezen.dto.CommentVO;
import com.ezen.dto.FollowVO;
import com.ezen.dto.HeartVO;
import com.ezen.dto.MemberVO;
import com.ezen.dto.ShortsVO;
import com.ezen.service.BoardService;
import com.ezen.service.BookMarkService;
import com.ezen.service.CommentService;
import com.ezen.service.FollowService;
import com.ezen.service.HeartService;
import com.ezen.service.MemberService;
import com.ezen.service.ShortsService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private HeartService heartService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private ShortsService shortsService;
	@Autowired
	private FollowService followService;

	@Autowired
	private BookMarkService bookMarkService;

	// ##############################################################################################################--home
	@RequestMapping("/")
	public String goLogin() {

		return "index";
	}

	@RequestMapping(value = "/home.do")
	public String BoardList(BoardVO bVo, CommentVO cVo, Model model, HttpSession session, ShortsVO sVo) {

		FollowVO fvo = new FollowVO();
		List<MemberVO> recoMemberList = new ArrayList<>();
		MemberVO mvo2 = (MemberVO) session.getAttribute("user");

		if (mvo2 != null) {

			fvo.setId1(mvo2.getId());
			List<String> followerList = (List<String>) session.getAttribute("follower");
			List<String> recom = followService.recomFollow(fvo.getId1());

			if (recom == null || recom.isEmpty()) {
				recom = memberService.recomMember();
			}
			// 추천에 본인과 이미 팔로우한 사람 제거
			System.out.println("recom = " + recom);
			recom.remove(fvo.getId1());
			for (String follower : followerList) {
				recom.remove(follower);
			}
			// 추천 멤버 객체 불러오기
			for (String id : recom) {
				MemberVO member = new MemberVO();
				member.setId(id);
				MemberVO member2 = memberService.MemberCheck(member);
				recoMemberList.add(member2);
			}

			System.out.println("recoMemberList = " + recoMemberList);
			model.addAttribute("recoMember", recoMemberList);

		}
		if (bVo.getKeyWord() == null) {
			bVo.setKeyWord("");
		}
		if (sVo.getSearchKeyword() == null) {
			sVo.setSearchKeyword("");
		}

		List<BoardVO> newBoardList = new ArrayList<>();

		List<BoardVO> getboardList = boardService.getBoardList(bVo);
		List<BoardVO> getadverList = boardService.getAdverList(bVo);

		newBoardList.addAll(getboardList);
		int i = 0;

		for (BoardVO vo : getadverList) {

			newBoardList.add(i, vo);

			if (newBoardList.size() >= i + 4) {
				i = i + 3;
			} else {

				i++;
			}
		}

		List<MemberVO> memberList = new ArrayList<>();
		List<CommentVO> commentList = new ArrayList<CommentVO>();

		List<String> time = new ArrayList<>();
		List<String> stime = new ArrayList<>();

		List<ShortsVO> shortsList = shortsService.getStoryShortsList(sVo);
		List<MemberVO> shortsMemberList = new ArrayList<>();

		for (BoardVO vo : newBoardList) {

			LocalDate boarDate = vo.getInDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			Period btn = Period.between(boarDate, LocalDate.now());
			String btnTime;

			if (btn.getYears() != 0) {
				btnTime = btn.getYears() + "년" + btn.getMonths() + "월" + btn.getDays() + "일 전";
			} else if (btn.getMonths() != 0) {
				btnTime = btn.getMonths() + "월" + btn.getDays() + "일 전";
			} else {
				btnTime = btn.getDays() + "일 전";
			}

			time.add(btnTime);

			MemberVO mvo = new MemberVO();
			mvo.setId(vo.getId());

			MemberVO v1 = memberService.MemberCheck(mvo);
			memberList.add(v1);

			HeartVO hvo = new HeartVO();
			hvo.setBseq(vo.getbSeq());

			int like = heartService.likeCount(hvo);
			vo.setCount(like);

			cVo.setBseq(vo.getbSeq());
			List<CommentVO> cvo = commentService.getCommentList(cVo);
			commentList.addAll(cvo);
		}
		System.out.println("commentList==================" + commentList);

		for (ShortsVO vo : shortsList) {
			LocalDate shortsDate = vo.getInDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			Period stn = Period.between(shortsDate, LocalDate.now());
			String stnTime;

			MemberVO mvo = new MemberVO();
			mvo.setId(vo.getId());

			MemberVO v1 = memberService.MemberCheck(mvo);
			shortsMemberList.add(v1);

			if (stn.getYears() != 0) {
				stnTime = stn.getYears() + "년" + stn.getMonths() + "월" + stn.getDays() + "일 전";
			} else if (stn.getMonths() != 0) {
				stnTime = stn.getMonths() + "월" + stn.getDays() + "일 전";
			} else {
				stnTime = stn.getDays() + "일 전";
			}
			stime.add(stnTime);
		}

		model.addAttribute("newBoardList", newBoardList);
		model.addAttribute("time", time);
		model.addAttribute("stime", stime);
		model.addAttribute("memberList", memberList);

		model.addAttribute("commentList", commentList);
		model.addAttribute("shortsList", shortsList);
		model.addAttribute("getshortsList", shortsMemberList);

		// BookMark 관련
		if (session.getAttribute("user") != null) {

			BookMarkVO bookMark = new BookMarkVO();
			bookMark.setId(mvo2.getId());
			List<Integer> boardBookMarkNums = bookMarkService.getBoardBookMarkNums(bookMark);

			session.setAttribute("boardBookMarkNums", boardBookMarkNums);
		}

		return "home";
	}

	// ##############################################################################################################--goInsertBoard
	@GetMapping("goInsertBoard.do")
	public String goInsertBoard() {

		return "insertBoard";
	}

	// ##############################################################################################################--goUpdateBoard
	@GetMapping("goUpdateBoard.do")
	public String updateBoardForm(Model model, BoardVO vo) {
		BoardVO board = boardService.myBoard(vo);

		model.addAttribute("board", board);
		return "updateBoard";
	}

	// ##############################################################################################################--updateBoard
	@RequestMapping("/updateBoard.do")
	public String UpdateBoard(@RequestParam(value = "nonImg") String org_image, BoardVO vo, HttpSession session)
			throws IllegalStateException, IOException {

		String fileName = "";

		if (!vo.getUploadfile().isEmpty()) {
			fileName = vo.getUploadfile().getOriginalFilename();

			String realPath = session.getServletContext().getRealPath("/images/");

			vo.setUpload(fileName);
			vo.getUploadfile().transferTo(new File(realPath + fileName));
		} else {
			vo.setUpload(org_image);
		}

		System.out.println("UpdateBoard().vo=" + vo);
		boardService.updateBoard(vo);

		return "redirect:home.do";
	}

	// ##############################################################################################################--goInsertBoard
	@GetMapping("getBoard.do")
	public String getBoard(MemberVO mvo, CommentVO cvo, BoardVO bvo, Model model, HttpSession session) {
		List<MemberVO> list = new ArrayList<MemberVO>();

		BoardVO board = (BoardVO) boardService.myBoard(bvo);

		LocalDate boarDate = board.getInDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Period btn = Period.between(boarDate, LocalDate.now());
		String btnTime;
		if (btn.getYears() != 0) {
			btnTime = btn.getYears() + "년" + btn.getMonths() + "월" + btn.getDays() + "일 전";
		} else if (btn.getMonths() != 0) {
			btnTime = btn.getMonths() + "월" + btn.getDays() + "일 전";
		} else {
			btnTime = btn.getDays() + "일 전";
		}

		model.addAttribute("time", btnTime);
		model.addAttribute("board", board);
		model.addAttribute("profile", mvo.getProfile());

		cvo.setBseq(bvo.getbSeq());
		List<CommentVO> commentList = commentService.getCommentList(cvo);

		for (CommentVO vo : commentList) {
			MemberVO v1 = new MemberVO();
			v1.setId(vo.getId());

			MemberVO v2 = memberService.MemberCheck(v1);
			list.add(v2);
		}
		model.addAttribute("commentMemberList", list);
		model.addAttribute("commentList", commentList);

		System.out.println("commentList :" + commentList);
		System.out.println("cvo :" + cvo);

		// 북마크 관련
		if (session.getAttribute("user") != null) {

			BookMarkVO bookMark = new BookMarkVO();
			MemberVO user = (MemberVO) session.getAttribute("user");
			bookMark.setId(user.getId());
			List<Integer> boardBookMarkNums = bookMarkService.getBoardBookMarkNums(bookMark);

			session.setAttribute("boardBookMarkNums", boardBookMarkNums);
		}

		return "getBoard";
	}

	// ##############################################################################################################--insertBoard
	@PostMapping("insertBoard.do")
	public String InsertBoard(@RequestParam(value = "noImg") String no_image, BoardVO vo, HttpSession session)
			throws IllegalStateException, IOException {

		String fileName = "";

		if (!vo.getUploadfile().isEmpty()) {
			fileName = vo.getUploadfile().getOriginalFilename();

			System.out.println("filename=" + fileName);

			String realPath = session.getServletContext().getRealPath("images/");
			vo.getUploadfile().transferTo(new File(realPath + fileName));
			vo.setUpload(fileName);
		} else {
			vo.setUpload(no_image);
		}

		System.out.println(vo);
		boardService.InsertBoard(vo);

		return "redirect:home.do";
	}

	@RequestMapping("deleteBoard.do")
	public String DeleteBoard(BoardVO vo, HttpSession session) throws IllegalStateException, IOException {
		boardService.deleteBoard(vo);
		System.out.println("딜리트:" + vo);

		return "redirect:home.do";
	}
	//// ##############################################################################################################--myPage.do
	// @GetMapping("/myPage.do")
	// public String goMyPage(BoardVO vo,Model model) {
	//
	// List<BoardVO> list = boardService.myBoardList(vo);
	// model.addAttribute("boardList",list);
	//
	// return "myPage";
	// }

}