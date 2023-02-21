package com.ezen.view;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.ezen.dto.BookMarkVO;
import com.ezen.dto.FollowVO;
import com.ezen.dto.HeartVO;
import com.ezen.dto.MemberVO;
import com.ezen.service.BookMarkService;
import com.ezen.service.FollowService;
import com.ezen.service.HeartService;
import com.ezen.service.MemberService;

@Controller
public class LoginController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private FollowService followService;
	@Autowired
	private BookMarkService bookMarkService;

	@Autowired
	private HeartService heartService;
	

	@GetMapping("/")
	public String goHome() {

		return "index";
	}

//	##############################################################################################################--goInsertMember
	@GetMapping("/goInsertMember.do")
	public String goInsertMember() {

		return "NewMember";
	}

// ##############################################################################################################--check.do	
	@GetMapping("/check.do")
	public String goIdCheck(Model model) {

		model.addAttribute("msg", "");
		model.addAttribute("check", 0);
		model.addAttribute("id", "");

		return "check_id";
	}

//	##############################################################################################################--IdCheck
	@PostMapping("/idCheck.do")
	public String check_id(MemberVO vo, Model model) {

		MemberVO mvo = memberService.MemberCheck(vo);
		System.out.println(vo);
		System.out.println(mvo);

		if (mvo == null) {

			model.addAttribute("msg", "는 사용할수 있는 아이디입니다.");
			model.addAttribute("id", vo.getId());
			model.addAttribute("check", 1);

		} else {
			model.addAttribute("msg", "는 이미 사용중인 아이디 입니다.");
			model.addAttribute("id", vo.getId());
			model.addAttribute("check", 0);
		}

		return "check_id";

	}

//	##############################################################################################################--insertMember
	@PostMapping("/insertMember.do")
	   public String insertMember(MemberVO vo, HttpSession session) throws IllegalStateException, IOException {

	      String fileName = "";

	      if (!vo.getFile().isEmpty()) {

	         fileName = vo.getFile().getOriginalFilename();
	         String realPath = session.getServletContext().getRealPath("profile/");
	         vo.getFile().transferTo(new File(realPath + fileName));

	         vo.setProfile(vo.getFile().getOriginalFilename());
	      } else {
	         vo.setProfile("no-image.png");
	      }

	      memberService.insertMember(vo);

	      return "index";
	   }
//	##############################################################################################################--login.do
	@PostMapping("/login.do")
	public String login(MemberVO vo, HttpSession session) {
		String url = "redirect:/";
		MemberVO mvo;

		// System.out.println(vo);

		mvo = memberService.MemberCheck(vo);
		System.out.println(vo);

		if (mvo != null) {

			if (vo.getId().equals(mvo.getId())
					&& vo.getPwd().equals(mvo.getPwd())) {

				FollowVO fvo = new FollowVO();
				fvo.setId1(mvo.getId().toString());

				HeartVO hvo = new HeartVO();
				hvo.setId(mvo.getId().toString());
				
				BookMarkVO bookMark = new BookMarkVO();
				bookMark.setId(mvo.getId());
				
				List<Integer> heart = heartService.boardLike(hvo);
				List<Integer> c_heart = heartService.commentLike(hvo);
				List<Integer> s_heart = heartService.shortsLike(hvo);
				List<String> follower = followService.getFollowList(fvo);
				List<Integer> boardBookMarkNums = bookMarkService.getBoardBookMarkNums(bookMark);
				
				session.setAttribute("boardBookMarkNums", boardBookMarkNums);
				session.setAttribute("user", mvo);
				session.setAttribute("follower", follower);
				session.setAttribute("heart", heart);
				session.setAttribute("c_heart", c_heart);
				session.setAttribute("s_heart", s_heart);

				if (mvo.getRole() == 1) {

					url = "redirect:/home.do";

				} else {
					url = "redirect:goAdmin.do";
				}

			}
		} else {
			url = "redirect:/";
		}

		return url;
	}
//	##############################################################################################################--goFIndId

	@GetMapping("/goFindId.do")
	public String goFindId(Model model) {

		model.addAttribute("id", "");
		model.addAttribute("pwd", "");

		return "findId";
	}

//	##############################################################################################################--FindID.do
	@PostMapping("/findId.do")
	public String FindIdAction(MemberVO vo, Model model) {

		MemberVO mvo = memberService.findId(vo);

		System.out.println(vo);
		System.out.println(mvo);

		if (mvo != null) {
			model.addAttribute("id", "아이디는" + mvo.getId() + "입니다.");
		} else {
			model.addAttribute("id", "정보가 다릅니다.");
		}

		return "findId";
	}

	@PostMapping("/findPwd.do")
	public String FindPwdAction(MemberVO vo, Model model) {

		MemberVO mvo = memberService.findPwd(vo);
		System.out.println(vo);
		System.out.println(mvo);

		if (mvo != null) {
			model.addAttribute("pwd", "비밀번호는" + mvo.getPwd() + "입니다.");
		} else {
			model.addAttribute("pwd", "입력하신 정보가 일치하지 않습니다.");
		}

		return "findId";
	}
	@GetMapping("profile_edit.do")
	public String goProfileEdit(MemberVO vo, Model model) {

		MemberVO member = memberService.MemberCheck(vo);
		model.addAttribute("member", member);

		return "profile_edit";
	}
	// ##############################################################################################################--updateMember
		@PostMapping("updateMember.do")
		public String updateMember(MemberVO vo, HttpSession session)
				throws IllegalStateException, IOException {

			String fileName = "";
			if (!vo.getFile().isEmpty()) {

				fileName = vo.getFile().getOriginalFilename();
				
				
				String realPath = session.getServletContext()
						.getRealPath("/profile/");
				
				vo.getFile().transferTo(new File(realPath + fileName));
				vo.setProfile(vo.getFile().getOriginalFilename());

			} else {
				vo.setProfile("no-image.png");
			}

			memberService.updateMember(vo);

			return "redirect:profile.do?id=" + vo.getId();
		}

//	##############################################################################################################--myPage.do
	@GetMapping("/logout.do")
	public String Logout(SessionStatus sessionStatus, HttpSession session) {

		sessionStatus.setComplete();
		session.invalidate();

		return "redirect:/";
	}
}
