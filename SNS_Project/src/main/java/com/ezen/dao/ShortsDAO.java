package com.ezen.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.dto.ShortsVO;

@Repository
public class ShortsDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	public ShortsVO getShorts(ShortsVO vo) {

		System.out.println("--getShort() �떎�뻾: " + vo);
		return mybatis.selectOne("ShortsMapper.getShorts", vo);
	}

	public List<ShortsVO> getShortsList(ShortsVO vo) {
		return mybatis.selectList("ShortsMapper.getShortsList", vo);
	}

	public List<ShortsVO> getAdShortsList(ShortsVO vo) {
		return mybatis.selectList("ShortsMapper.getAdShortsList", vo);
	}

	public void insertShorts(ShortsVO vo) {
		mybatis.insert("ShortsMapper.insertShorts", vo);
	}

	public void updateShorts(ShortsVO vo) {
		mybatis.update("ShortsMapper.updateShorts", vo);
	}

	public void updateShortsCount(ShortsVO vo) {
		mybatis.update("ShortsMapper.updateShortsCount", vo);
	}

	public void deleteShorts(ShortsVO vo) {
		mybatis.delete("ShortsMapper.deleteShorts", vo);
	}

	public void updatePay(int sSeq) {
		mybatis.selectOne("ShortsMapper.updatePay", sSeq);
	}

	public void updateManusPay(int sSeq) {
		mybatis.selectOne("ShortsMapper.update-Pay", sSeq);
	}

	public List<ShortsVO> getStoryShortsList(ShortsVO vo) {
		return mybatis.selectList("ShortsMapper.getStoryShortsList", vo);
	}

}
