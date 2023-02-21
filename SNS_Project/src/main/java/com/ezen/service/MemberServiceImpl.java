package com.ezen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.dao.MemberDao;
import com.ezen.dto.MemberVO;


@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao mDao;
	
	@Override
	public MemberVO MemberCheck(MemberVO vo) {
		return mDao.MemberCheck(vo);
	}

	@Override
	public void insertMember(MemberVO vo) {
		mDao.insertMember(vo);
		
	}

	@Override
	public MemberVO findId(MemberVO vo) {
		
		return mDao.findId(vo);
	}

	@Override
	public MemberVO findPwd(MemberVO vo) {
		
		return mDao.findPwd(vo);
	}

	@Override
	public List<String> recomMember() {
		return mDao.recomMember();
	}

	@Override
	public void updateMember(MemberVO vo) {
		mDao.updateMember(vo);
		
	}


}
