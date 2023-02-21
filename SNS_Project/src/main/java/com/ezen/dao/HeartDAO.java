package com.ezen.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.dto.HeartVO;

@Repository
public class HeartDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	public HeartVO like(HeartVO vo) {

		return mybatis.selectOne("heartMapper.like", vo);
	}

	public HeartVO Insertlike(HeartVO vo) {

		return mybatis.selectOne("heartMapper.insertLike", vo);
	}

	public List<Integer> boardLike(HeartVO vo) {

		return mybatis.selectList("heartMapper.likeBoard", vo);
	}

	public void deleteLike(HeartVO vo) {
		mybatis.selectOne("heartMapper.deleteLike", vo);
	}

	public void deleteLike_c(HeartVO vo) {
		mybatis.selectOne("heartMapper.deleteLike_c", vo);
	}
	public void deleteLike_s(HeartVO vo) {
		mybatis.selectOne("heartMapper.deleteLike_s", vo);
	}

	public int getLikeCount(HeartVO vo) {
		return mybatis.selectOne("heartMapper.likeCount", vo);
	}

	public List<Integer> commentLike(HeartVO vo) {

		return mybatis.selectList("heartMapper.likeComment",vo);

	}

	public int getLikeCommentCount(HeartVO vo) {

		return mybatis.selectOne("heartMapper.likeCommentCount", vo);
	}

	public List<Integer> shortsLike(HeartVO vo) {

		return mybatis.selectList("heartMapper.likeShorts", vo);
	}


	public int likeShortsCount(HeartVO vo) {
		return mybatis.selectOne("heartMapper.likeShortsCount", vo);
	}
}
