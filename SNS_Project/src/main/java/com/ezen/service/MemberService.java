package com.ezen.service;

import java.util.List;

import com.ezen.dto.MemberVO;

public interface MemberService {

	MemberVO MemberCheck(MemberVO vo);

	MemberVO findId(MemberVO vo);
	
	MemberVO findPwd(MemberVO vo);
	
	void insertMember(MemberVO vo);

	List<String> recomMember();
	
	void updateMember(MemberVO vo);
}