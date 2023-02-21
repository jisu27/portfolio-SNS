package com.ezen.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.ezen.dto.BookMarkVO;
import com.ezen.dto.CommentVO;
import com.ezen.dto.MemberVO;
import com.ezen.dto.ShortsCommentVO;
import com.ezen.dto.ShortsVO;
import com.ezen.service.BookMarkService;
import com.ezen.service.CommentService;
import com.ezen.service.HeartService;
import com.ezen.service.MemberService;
import com.ezen.service.ShortsCommentService;
import com.ezen.service.ShortsService;

@Controller
public class ShortsController {

	@Autowired
	private ShortsService shos;
	@Autowired
	private MemberService memberService;
	@Autowired
	private HeartService heartService;
	@Autowired
	private ShortsCommentService ShortsCommentService;
	@Autowired
	private BookMarkService bookMarkService;
	@Autowired
	private CommentService commentService;

	@RequestMapping("/getShorts")
	public String getShorts(ShortsVO vo, ShortsCommentVO scvo, CommentVO cvo,BookMarkVO bmvo, Model model, HttpSession session) {
		MemberVO user = (MemberVO) session.getAttribute("user");
		if (user.getId() != null)
			bmvo.setId(user.getId());
		System.out.println(bmvo.getId());

		ShortsVO shorts = shos.getShorts(vo);
		model.addAttribute("shorts", shorts);

		List<Integer> shortsBookMarkNum = bookMarkService.getShortsBookMarkNums(bmvo);
		session.setAttribute("shortsBookMarkNum", shortsBookMarkNum);

		MemberVO mVo = new MemberVO();
		mVo.setId(shorts.getId());

		MemberVO mvo= memberService.MemberCheck(mVo);
		model.addAttribute("member",mvo);
		
		List<MemberVO> list = new ArrayList<>();
		List<CommentVO> commentList = commentService.getCommentList(cvo);

		for (CommentVO comment : commentList) {
			MemberVO v1 = new MemberVO();
			v1.setId(comment.getId());

			MemberVO v2 = memberService.MemberCheck(v1);
			list.add(v2);
		}
		model.addAttribute("commentMemberList", list);
		model.addAttribute("commentList", commentList);


		scvo.setsSeq(vo.getsSeq());
		List<ShortsCommentVO> ShortsCommentList = ShortsCommentService.getShortsCommentList(scvo);
		model.addAttribute("ShortsCommentList", ShortsCommentList);


		
		return "getShorts";

	}

	@RequestMapping("/getShortsList")
	public String getShortsList(HttpSession session, ShortsVO vo, BookMarkVO bmVO, Model model) {
		MemberVO user = (MemberVO) session.getAttribute("user");

		if (user.getId() != null)
			bmVO.setId(user.getId()); // 북마크 작업전

		if (vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");
		List<ShortsVO> list = new ArrayList<>();
		List<ShortsVO> slist = shos.getShortsList(vo);
		List<ShortsVO> adList = shos.getAdShortsList(vo);
		
		list.addAll(slist);
		int i=0;
		
		for(ShortsVO svo : adList) {
			list.add(i, svo);
			
			if (list.size() >= i+4) {
				i=i+3;
			}else {
				i++;
			}
		}

		model.addAttribute("shortsList", list);

		model.addAttribute("searchKeyword", vo.getSearchKeyword());
		return "getShortsList";

	}

	@GetMapping("/insertShorts")
	public String insertShortsView(HttpSession session) {
		MemberVO user = (MemberVO) session.getAttribute("user");

		if (user == null) {
			return "index";
		} else {

			return "insertShorts";
		}

	}

	@RequestMapping(value = "/insertShorts", method = RequestMethod.POST)
	public String insertShorts(ShortsVO vo, Model model, HttpSession session) throws IOException {

		MemberVO user = (MemberVO) session.getAttribute("user");

		if (user == null) {

			return "index";

		} else {

			MultipartFile uploadFile = vo.getUploadFile();
			if (!uploadFile.isEmpty()) {

				String fileName = uploadFile.getOriginalFilename();

				uploadFile.transferTo(new File("C:/shorts/" + fileName));
				vo.setUpload(fileName);
				System.out.println("�뙆�씪�씠由� :" + fileName);

			} else {
				System.out.println("�뙆�씪�씠 �뾾�뒿�땲�떎");
				return "insertShorts";
			}

			vo.setId(user.getId());
			shos.insertShorts(vo);

			return "redirect:getShortsList";
		}

	}

	@GetMapping(value = "/goUpdateShorts.do")
	public String updateShortsVeiws(ShortsVO vo, HttpSession session, Model model) {
		MemberVO user = (MemberVO) session.getAttribute("user");

		if (user == null) {

			return "redirect:/";
		} else {
			ShortsVO shorts = shos.getShorts(vo);

			model.addAttribute("shorts", shorts);
			return "updateShorts";
		}

	}

	@PostMapping(value = "/updateShorts.do")
	public String updateShorts(ShortsVO vo, HttpSession session) throws IOException {
		MemberVO user = (MemberVO) session.getAttribute("user");

		if (user == null) {
			return "index";

		} else {
			MultipartFile uploadFile = vo.getUploadFile();
			if (!uploadFile.isEmpty()) {
	
				String fileName = uploadFile.getOriginalFilename();
	
				uploadFile.transferTo(new File("C:/shorts/" + fileName));
				vo.setUpload(fileName);
				
	
			} else {
				
				return "updatetShorts";
			}

			shos.updateShorts(vo);
			return "redirect:getShortsList";
		}

	}

	@RequestMapping("/deleteShorts.do")
	public String deleteShorts(ShortsVO vo, HttpSession session) {
		MemberVO user = (MemberVO) session.getAttribute("user");

		System.out.println("deleteShorts()..... vo=" + vo);

		if (user == null) {
			return "index";
		} else {
			shos.deleteShorts(vo);
			return "redirect:getShortsList";

		}
	}
}
