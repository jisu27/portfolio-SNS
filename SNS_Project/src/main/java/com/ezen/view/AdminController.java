package com.ezen.view;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ezen.dto.AdminVO;
import com.ezen.service.AdminService;
import com.ezen.service.BoardService;
import com.ezen.service.ShortsService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private BoardService boardService;
	@Autowired
	private ShortsService shortsService;
	
	@GetMapping("goAdmin.do")
	public String goAdmin(Model model) {
		
		List<AdminVO> list = adminService.viewAd();
		List<AdminVO> checkList = adminService.viewAd2();
		
		model.addAttribute("deAd",list);
		model.addAttribute("checkAd",checkList);
		
		return "adminPay";
	}
	
	@GetMapping("cancleAD.do")
	public String cancleAD(AdminVO avo,HttpServletRequest request) {
		
		
		if (avo.getbSeq() != 0) {
			boardService.updateManusPay(avo.getbSeq());
			adminService.deleteAd(avo);
		}else {
			avo.setbSeq(0);
			shortsService.updateManusPay(avo.getsSeq());
			adminService.deleteAd(avo);
		}
		return "redirect:" + (String) request.getHeader("Referer");
	}
	
	@GetMapping("insertAD.do")
	public String insertAD(AdminVO vo,HttpServletRequest request) {
		System.out.println(vo);
		
		adminService.insertAd(vo);
		
		if (vo.getbSeq()!=0) {
			boardService.updatePay(vo.getbSeq());			
		}else {
			shortsService.updatePay(vo.getsSeq());
		}
		
		return "redirect:" + (String) request.getHeader("Referer");
	}
	
	@PostMapping("checkAd.do")
	public String checkAd(AdminVO avo) {
		
		System.out.println("avo=="+avo);
		
		if (avo.getbSeq() != 0) {
			boardService.updatePay(avo.getbSeq());
		}else {
			
			avo.setbSeq(0);
			shortsService.updatePay(avo.getsSeq());
		}
		
		adminService.updateAdmin(avo.getaSeq());
		
		return "redirect:goAdmin.do";
	}
	
	@PostMapping("checkManusAd.do")
	public String checkManusAd(AdminVO avo) {
		
		System.out.println("avo=="+avo);
		
		if (avo.getbSeq() != 0) {
			boardService.updateManusPay(avo.getbSeq());
		}else {
			avo.setbSeq(0);
			shortsService.updateManusPay(avo.getsSeq());
		}
		
		adminService.updateManusAdmin(avo.getaSeq());
		
		return "redirect:goAdmin.do";
	}
	
}
