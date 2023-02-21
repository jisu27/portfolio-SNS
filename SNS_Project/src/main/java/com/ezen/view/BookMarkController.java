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
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.dto.BoardVO;
import com.ezen.dto.BookMarkVO;
import com.ezen.dto.MemberVO;
import com.ezen.dto.ShortsVO;
import com.ezen.service.BoardService;
import com.ezen.service.BookMarkService;
import com.ezen.service.ShortsService;

@Controller
public class BookMarkController {
	@Autowired
	private BookMarkService bookMarkService;
	@Autowired
	private BoardService boardService;
	@Autowired
	private ShortsService shortsService;

	@PostMapping(value = "insertBookMark")
	public String insertBookMark(BookMarkVO vo, ShortsVO svo, BoardVO bvo, Model model, HttpServletRequest request) {
		if (svo != null)
			vo.setsSeq(svo.getsSeq());
		if (bvo != null)
			vo.setbSeq(bvo.getbSeq());
		bookMarkService.insertBookMark(vo);

		return "redirect:" + (String) request.getHeader("Referer");
	}
	
	@PostMapping(value= "insertBoardBookMark")
	public String insertBoardBookMark(BookMarkVO vo, BoardVO bvo, Model model, HttpServletRequest request) {
		vo.setbSeq(bvo.getbSeq());
		bookMarkService.insertBookMark(vo);
		
		return "redirect:" + (String) request.getHeader("Referer");
	}
	
	@PostMapping(value= "insertShortsBookMark")
	public String insertShortsBookMark(BookMarkVO vo, ShortsVO svo, Model model, HttpServletRequest request) {
		vo.setbSeq(svo.getsSeq());
		bookMarkService.insertBookMark(vo);
		
		return "redirect:" + (String) request.getHeader("Referer");
	}

	@PostMapping(value = "deleteShortsBookMark")
	public String deleteShortsBookMark(BookMarkVO vo, ShortsVO svo, Model model, HttpServletRequest request,
			HttpSession session) {
		MemberVO user = (MemberVO) session.getAttribute("user");
		vo.setId(user.getId());
		vo.setsSeq(svo.getsSeq());

		bookMarkService.deleteShortsBookMark(vo);

		return "redirect:" + (String) request.getHeader("Referer");
	}

	@PostMapping(value = "deleteBoardBookMark")
	public String deleteBoardBookMark(BookMarkVO vo, BoardVO bvo, Model model, HttpServletRequest request,
			HttpSession session) {
		MemberVO user = (MemberVO) session.getAttribute("user");
		vo.setId(user.getId());
		vo.setbSeq(bvo.getbSeq());

		bookMarkService.deleteBoardBookMark(vo);

		return "redirect:" + (String) request.getHeader("Referer");
	}

	@RequestMapping(value = "deleteBookMark")
	public String deleteBookMark(BookMarkVO vo, HttpServletRequest request) {
		bookMarkService.deleteBookMark(vo);

		return "redirect:" + (String) request.getHeader("Referer");
	}

	@GetMapping(value = "updateBookMark")
	public String getUpdateBookMark(BookMarkVO vo, Model model) {
		// bookMarkService.updateBookMark(vo);

		return "updateBookMark.do";
	}

	@PostMapping(value = "updateBookMark.do")
	public String updateBookMark(BookMarkVO vo, Model model) {
		bookMarkService.updateBookMark(vo);

		return "bookMarkList";
	}

	@GetMapping(value = "getBookMarkList")
	public String getBookMarkList(BookMarkVO bookMark, Model model, HttpSession session) {

		MemberVO member = (MemberVO) session.getAttribute("user");

		bookMark.setId(member.getId());
		System.out.println("BookMarkController: getBooardList() vo=" + bookMark);

		List<BookMarkVO> bookMarkList = bookMarkService.getBookMarkList(bookMark);
		List<Integer> boardBookMarkNums = bookMarkService.getBoardBookMarkNums(bookMark);
		List<Integer> shortsBookMarkNums = bookMarkService.getShortsBookMarkNums(bookMark);
		List<BookMarkVO> boardBookMarkList = bookMarkService.getBoardBookMarkList(bookMark);
		List<BookMarkVO> shortsBookMarkList = bookMarkService.getShortsBookMarkList(bookMark);

		session.setAttribute("boardBookMarkNums", boardBookMarkNums);
		session.setAttribute("shortsBookMarkNums", shortsBookMarkNums);
		model.addAttribute("bookMarkList", bookMarkList);
		model.addAttribute("boardBookMarkList", boardBookMarkList);
		model.addAttribute("shortsBookMarkList", shortsBookMarkList);

		return "bookMarkList";
	}

	@GetMapping(value = "getBoardBookMarkList")
	public String getBoardBookMarkList(BookMarkVO bookMark, BoardVO board, Model model, HttpSession session) {

		MemberVO member = (MemberVO) session.getAttribute("user");
		bookMark.setId(member.getId());

		List<BookMarkVO> boardBookMarkList = bookMarkService.getBoardBookMarkList(bookMark);

		model.addAttribute("boardBookMarkList", boardBookMarkList);

		return "boardBookMarkList";
	}

	@GetMapping(value = "getShortsBookMarkList")
	public String getShortsBookMarkList(BookMarkVO bookMark, ShortsVO shorts, Model model, HttpSession session) {
		
		MemberVO member = (MemberVO) session.getAttribute("user");
		bookMark.setId(member.getId());
		
		List<BookMarkVO> shortsBookMarkList = bookMarkService.getShortsBookMarkList(bookMark);

		model.addAttribute("shortsBookMarkList", shortsBookMarkList);

		return "shortsBookMarkList";
	}

	@GetMapping(value = "getBookMark")
	public String getBookMark(BookMarkVO bookMark, Model model, HttpSession session) {
		MemberVO member = new MemberVO();
		member.setId(session.getId());
		bookMarkService.getBookMark(bookMark);

		return "getBookMark";
	}
}
