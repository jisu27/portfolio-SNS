package com.ezen.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.ezen.dto.CommentVO;
import com.ezen.dto.MemberVO;
import com.ezen.service.CommentService;

@Controller
public class ShortsCommentController {
	
	@Autowired
	private CommentService commentService;
	 
	
	@PostMapping(value="/insertShortsComment")
	public String insertShortsComment(CommentVO vo, HttpSession session, HttpServletRequest request) {
		
		MemberVO user= (MemberVO) session.getAttribute("user");
		
		if(user == null) {
			return "redirect:/";
			
		}else {
			vo.setId(user.getId());
			System.out.println(vo);
			commentService.insertComment(vo);
			
			return "redirect:" + (String)request.getHeader("Referer");
		}	
	}
	
//	@GetMapping(value="/updateShortsComment")
//	public String updateShortsCommentView(ShortsCommentVO vo, Model model, HttpSession session) {
//		MemberVO user = (MemberVO) session.getAttribute("user");
//		
//		ShortsCommentVO comment = CommentService.getShortsComment(vo);
//		
//		model.addAttribute("comment", comment);
//		return "updateComment";
//	}
//	
//	@PostMapping(value="/updateShortsComment")
//	public String updateShortsComment(ShortsCommentVO vo, Model model, HttpSession session)throws IOException {
//		MemberVO user = (MemberVO)session.getAttribute("user");
//		
//		if(user == null) {
//			return "login";
//			
//		}else if (user.getId() != vo.getId()) {
//			return "getShortsList";
//		} else {
//			CommentService.updateShortsComment(vo);
//			return "getShorts?sSeq="+vo.getsSeq();
//		}
//	}
//	
//	@RequestMapping(value="/deleteShortsComment")
//	public String deleteShortsComment(ShortsCommentVO vo, HttpSession session) {
//		MemberVO user = (MemberVO)session.getAttribute("user");
//		
//		if(!session.getAttribute("id").equals(vo.getId())) {
//			return "login";
//		}else {		
//			service.deleteShortsComment(vo);
//			return "redirect:getShorts";
//		}
//	}
	
	/*@RequestMapping(value="/getShortsCommetList", produces="application/json; charset=UTF-8")
	public Map<String, Object> getShortsCommentList(ShortsCommentVO vo){
		
		Map<String, Object> comment = new HashMap<>();
		
		List<ShortsCommentVO> list = service.getShortsCommentList(vo);
		
		comment.put("total", list.size());
		comment.put("commentList", list);
		
		return comment;
		
	}*/
	
//	@RequestMapping(value = "/getShortsCommentList")
//	public String getCommentList(ShortsCommentVO vo, Model model) {
//
//		List<ShortsCommentVO> ShortsCommentList = service.getShortsCommentList(vo);
//		System.out.println(ShortsCommentList);
//		model.addAttribute("ShortsCommentList", ShortsCommentList);
//
//		return "redirect:getShorts";
//	}

}
