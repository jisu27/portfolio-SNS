package com.ezen.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.dto.ShortsCommentVO;

@Repository
public class ShortsCommentDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public void insertShortsComment(ShortsCommentVO vo) {
		mybatis.insert("ShortsCommentMapper.insertShortsComment", vo);
	}
	
	
	public void updateShortsComment(ShortsCommentVO vo) {
		mybatis.update("ShortsCommentMapper.updateShortsComment", vo);
	}


	public void deleteShortsComment(ShortsCommentVO vo) {
		mybatis.delete("ShortsCommentMapper.deleteShortsComment", vo);
	}
	

	public List<ShortsCommentVO> getShortsCommentList(ShortsCommentVO vo){
		return mybatis.selectList("ShortsCommentMapper.getShortsCommentList", vo);
	}
	
	public ShortsCommentVO getShortsComment(ShortsCommentVO vo) {
		return mybatis.selectOne("ShortsCommentMapper.getShortsComment", vo);
	}

	public int getCountShortsCommentList(int s_seq) {
		return mybatis.selectOne("ShortsCommentMapper.getCountShortsCommentList", s_seq);
	}
	
	
}










