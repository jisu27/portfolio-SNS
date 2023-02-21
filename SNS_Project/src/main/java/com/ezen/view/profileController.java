package com.ezen.view;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ezen.dto.BoardVO;
import com.ezen.dto.BookMarkVO;
import com.ezen.dto.FollowVO;
import com.ezen.dto.HeartVO;
import com.ezen.dto.MemberVO;
import com.ezen.service.BoardService;
import com.ezen.service.BookMarkService;
import com.ezen.service.FollowService;
import com.ezen.service.HeartService;
import com.ezen.service.MemberService;

@Controller
public class profileController {

	@Autowired
	private BoardService boardService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private FollowService followService;
	@Autowired
	private BookMarkService bookMarkService;
	@Autowired
	private HeartService heartService;
	
	@GetMapping("profile.do")
	public String goProfile(MemberVO mvo, BoardVO bvo, HeartVO heart, BookMarkVO bookMark, Model model, HttpSession session) {
		
		MemberVO member = memberService.MemberCheck(mvo);
		List<BoardVO> list= boardService.myBoardList(bvo);
		int boardCount = boardService.boardCount(bvo);
		bvo.setCount(boardCount);
		
		
		
		FollowVO follow = new FollowVO();
		follow.setId1(mvo.getId().toString());
		follow.setId2(mvo.getId().toString());
		//System.out.println(follow);
		
//		FollowVO checkFollow = new FollowVO();
//		checkFollow.setId1(mvo.getId().toString());
//		checkFollow.setId2((String)session.getAttribute("user.id"));
		
		int follower = followService.getCountFollow(follow);
		int following = followService.getCountFollowing(follow);
		
		//System.out.println("boardVO :"+bvo);
		
		model.addAttribute("board",bvo);
		model.addAttribute("boardList",list);
		model.addAttribute("member",member);
		model.addAttribute("follower",follower);
		model.addAttribute("following",following);
		
		//하트 관련
		heart.setId(member.getId());
		List<Integer> Shorts = heartService.shortsLike(heart);
		
		
		
		
		// 북마크 관련
		bookMark.setId(member.getId());
		System.out.println("BookMarkController: getBooardList() vo=" + bookMark);
		
		List<BookMarkVO> myBoardList = bookMarkService.getMyBoardList(bookMark);
		List<BookMarkVO> bookMarkList = bookMarkService.getBookMarkList(bookMark);
		List<Integer> boardBookMarkNums = bookMarkService.getBoardBookMarkNums(bookMark);
		List<Integer> shortsBookMarkNums = bookMarkService.getShortsBookMarkNums(bookMark);
		List<BookMarkVO> boardBookMarkList = bookMarkService.getBoardBookMarkList(bookMark);
		List<BookMarkVO> shortsBookMarkList = bookMarkService.getShortsBookMarkList(bookMark);
		System.out.println(shortsBookMarkList);
		
		
		session.setAttribute("boardBookMarkNums", boardBookMarkNums);
		session.setAttribute("shortsBookMarkNums", shortsBookMarkNums);
		model.addAttribute("myBoardList", myBoardList);
		model.addAttribute("bookMarkList", bookMarkList);
		model.addAttribute("boardBookMarkList", boardBookMarkList);
		model.addAttribute("shortsBookMarkList", shortsBookMarkList);
		
		return "myPage";
	}
}
