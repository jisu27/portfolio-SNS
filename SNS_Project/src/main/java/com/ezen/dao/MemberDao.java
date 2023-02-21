package com.ezen.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.dto.MemberVO;

@Repository
public class MemberDao{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public MemberVO MemberCheck(MemberVO vo) {
		return mybatis.selectOne("memberMapper.memberCheck",vo.getId());
	}
	public MemberVO findId(MemberVO vo) {
		return mybatis.selectOne("memberMapper.findId",vo);
	}
	public MemberVO findPwd(MemberVO vo) {
		return mybatis.selectOne("memberMapper.findPwd",vo);
	}
	
	public void insertMember(MemberVO vo) {
		mybatis.insert("memberMapper.insertMember",vo);
	}
	public List<String> recomMember(){
		return mybatis.selectList("memberMapper.recomMember");
	}
	public void updateMember(MemberVO vo) {
		mybatis.update("memberMapper.updateMember",vo);
	}
}


