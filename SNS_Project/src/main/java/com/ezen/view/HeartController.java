package com.ezen.view;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ezen.dto.BoardVO;
import com.ezen.dto.CommentVO;
import com.ezen.dto.HeartVO;
import com.ezen.dto.MemberVO;
import com.ezen.dto.ShortsVO;
import com.ezen.service.BoardService;
import com.ezen.service.CommentService;
import com.ezen.service.HeartService;
import com.ezen.service.MemberService;
import com.ezen.service.ShortsService;

@Controller
public class HeartController {

	@Autowired
	private HeartService heartService;
	@Autowired
	private BoardService boardService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private ShortsService shortsService;

	@PostMapping("heart.do")
	public String insertLike(HeartVO vo, Model model, HttpSession session, HttpServletRequest request) {

		System.out.println("heartvo���엯�쓽 踰덊샇 !! =============" + vo);

		vo.setUse_like("y");
		heartService.insertLike(vo);

		BoardVO board = new BoardVO();
		board.setbSeq(vo.getbSeq());
		board.setCount(heartService.likeCount(vo));
		boardService.updateCount(board);

		List<Integer> heart = heartService.boardLike(vo);
		session.setAttribute("heart", heart);

		return "redirect:" + (String) request.getHeader("Referer");
	}

	@PostMapping("heart_c.do")
	public String insertLike_c(HeartVO vo, Model model, HttpSession session, HttpServletRequest request) {

		vo.setUse_like("y");
		heartService.insertLike(vo);

		CommentVO comment = new CommentVO();
		comment.setCseq(vo.getCseq());
		comment.setCount(heartService.likeCommentCount(vo));
		commentService.updateCount(comment);

		List<Integer> c_heart = heartService.commentLike(vo);

		session.setAttribute("c_heart", c_heart);

		System.out.println("heartvo���엯�쓽 踰덊샇 !! =============" + vo);

		return "redirect:" + (String) request.getHeader("Referer");
	}
	@PostMapping("heart_s.do")
	public String insertLike_s(HeartVO vo, Model model, HttpSession session, HttpServletRequest request) {
		
		vo.setUse_like("y");
		heartService.insertLike(vo);
		
		ShortsVO svo = new ShortsVO();
		svo.setsSeq(vo.getsSeq());
		svo.setCount(heartService.likeShortsCount(vo));
		shortsService.updateShortsCount(svo);
		
		List<Integer> s_heart = heartService.shortsLike(vo);
		session.setAttribute("s_heart", s_heart);
		
		
		return "redirect:" + (String) request.getHeader("Referer");
	}

	@PostMapping("getHeart.do")
	public String getInsertLike(MemberVO mvo, HeartVO vo, Model model, HttpSession session) {

		vo.setUse_like("y");
		heartService.insertLike(vo);

		BoardVO board = new BoardVO();
		board.setbSeq(vo.getbSeq());
		board.setCount(heartService.likeCount(vo));
		boardService.updateCount(board);

		List<Integer> heart = heartService.boardLike(vo);
		session.setAttribute("heart", heart);

		System.out.println("heartvo���엯�쓽 踰덊샇 !! =============" + vo);

		return "redirect:getBoard.do?bSeq=" + vo.getBseq() + "&profile=" + mvo.getProfile();
	}

	@PostMapping("getHeart_c.do")
	public String getInsertLike_c(MemberVO mvo, HeartVO vo, Model model, HttpSession session) {

		vo.setUse_like("y");
		heartService.insertLike(vo);

		CommentVO comment = new CommentVO();
		comment.setCseq(vo.getCseq());
		comment.setCount(heartService.likeCommentCount(vo));
		commentService.updateCount(comment);

		List<Integer> c_heart = heartService.commentLike(vo);

		session.setAttribute("c_heart", c_heart);

		System.out.println("heartvo���엯�쓽 踰덊샇 !! =============" + vo);

		return "redirect:getBoard.do?bSeq=" + vo.getBseq() + "&profile=" + mvo.getProfile();
	}
	@PostMapping("getHeart_s.do")
	public String getInsertLike_s(MemberVO mvo, HeartVO vo, Model model, HttpSession session) {
		
		vo.setUse_like("y");
		heartService.insertLike(vo);
		
		CommentVO comment = new CommentVO();
		comment.setCseq(vo.getCseq());
		comment.setCount(heartService.likeCommentCount(vo));
		commentService.updateCount(comment);
		
		List<Integer> c_heart = heartService.commentLike(vo);
		
		session.setAttribute("c_heart", c_heart);
		
		
		return "redirect:getShorts?sSeq="+vo.getsSeq();
	}

	@PostMapping("deleteHeart.do")
	public String deleteLike(HeartVO vo, HttpSession session, HttpServletRequest request) {

		System.out.println("heartvo���엯�쓽 踰덊샇 !! =============" + vo);
		heartService.deleteLike(vo);

		BoardVO board = new BoardVO();
		board.setbSeq(vo.getbSeq());
		board.setCount(heartService.likeCount(vo));
		boardService.updateCount(board);

		List<Integer> heart = heartService.boardLike(vo);
		session.setAttribute("heart", heart);

		return "redirect:" + (String) request.getHeader("Referer");
	}

	@PostMapping("deleteHeart_c.do")
	public String deleteLike_c(HeartVO vo, HttpSession session) {

		System.out.println("heartvo���엯�쓽 踰덊샇 !! =============" + vo);
		heartService.deleteLike_c(vo);

		CommentVO comment = new CommentVO();
		comment.setCseq(vo.getCseq());
		comment.setCount(heartService.likeCommentCount(vo));
		commentService.updateCount(comment);

		List<Integer> c_heart = heartService.commentLike(vo);
		session.setAttribute("c_heart", c_heart);

		return "redirect:home.do";
	}
	@PostMapping("deleteHeart_s.do")
	public String deleteLike_s(HeartVO vo, HttpSession session, HttpServletRequest request) {
		
		heartService.deleteLike_s(vo);
		System.out.println(vo);
		
		ShortsVO svo = new ShortsVO();
		svo.setsSeq(vo.getsSeq());
		svo.setCount(heartService.likeShortsCount(vo));
		shortsService.updateShortsCount(svo);
		
		List<Integer> s_heart = heartService.shortsLike(vo);
		session.setAttribute("s_heart", s_heart);
		
		return "redirect:" + (String) request.getHeader("Referer");
	}

	@PostMapping("getDeleteHeart.do")
	public String getDeleteLike(MemberVO mvo, HeartVO vo, HttpSession session) {

		heartService.deleteLike(vo);

		BoardVO board = new BoardVO();

		board.setbSeq(vo.getbSeq());
		board.setCount(heartService.likeCount(vo));

		boardService.updateCount(board);

		List<Integer> heart = heartService.boardLike(vo);
		session.setAttribute("heart", heart);

		return "redirect:getBoard.do?bSeq=" + vo.getBseq() + "&profile=" + mvo.getProfile();
	}

	@PostMapping("getDeleteHeart_c.do")
	public String getDeleteLike_c(MemberVO mvo, HeartVO vo, HttpSession session) {

		heartService.deleteLike_c(vo);

		CommentVO comment = new CommentVO();

		comment.setCseq(vo.getCseq());
		comment.setCount(heartService.likeCommentCount(vo));

		commentService.updateCount(comment);

		List<Integer> c_heart = heartService.commentLike(vo);
		session.setAttribute("c_heart", c_heart);

		return "redirect:getBoard.do?bSeq="+vo.getBseq() + "&profile=" + mvo.getProfile();
	}
	
	@PostMapping("getDeleteHeart_s.do")
	public String getDeleteLike_(MemberVO mvo, HeartVO vo, HttpSession session, HttpServletRequest request) {
		
		heartService.deleteLike_c(vo);
		
		CommentVO comment = new CommentVO();
		
		comment.setCseq(vo.getCseq());
		comment.setCount(heartService.likeCommentCount(vo));
		
		commentService.updateCount(comment);
		
		List<Integer> c_heart = heartService.commentLike(vo);
		session.setAttribute("c_heart", c_heart);
		
		return "redirect:" + (String) request.getHeader("Referer");
	}

	@GetMapping("getLikeList.do")
	public String goLikeList(HeartVO hvo, HttpSession session, Model model) {

		BoardVO bvo = new BoardVO();
		CommentVO cvo = new CommentVO();

		List<BoardVO> boardList = new ArrayList<>();
		List<MemberVO> memberList = new ArrayList<>();
		List<Integer> heartList = heartService.boardLike(hvo);
		
		MemberVO mvo = new MemberVO();

		for (Integer vo : heartList) {

			bvo.setbSeq(vo);
			BoardVO board = boardService.myBoard(bvo);
			if (board!=null) {
				
				boardList.add(board);
				
				MemberVO member = new MemberVO();
				member.setId(board.getId());
				MemberVO member2 = memberService.MemberCheck(member);
				
				memberList.add(member2);
			}
		}
		model.addAttribute("boardList", boardList);
		model.addAttribute("memberList", memberList);

		return "likeList";

	}

}