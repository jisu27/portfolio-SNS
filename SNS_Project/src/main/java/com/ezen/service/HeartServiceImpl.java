package com.ezen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.dao.HeartDAO;
import com.ezen.dto.HeartVO;

@Service
public class HeartServiceImpl implements HeartService {

	@Autowired
	private HeartDAO hDao;

	@Override
	public HeartVO like(HeartVO vo) {

		return hDao.like(vo);
	}

	@Override
	public void insertLike(HeartVO vo) {

		hDao.Insertlike(vo);

	}

	@Override
	public List<Integer> boardLike(HeartVO vo) {

		return hDao.boardLike(vo);
	}

	@Override
	public void deleteLike(HeartVO vo) {
		hDao.deleteLike(vo);

	}

	@Override
	public int likeCount(HeartVO vo) {

		return hDao.getLikeCount(vo);
	}

	@Override
	public List<Integer> commentLike(HeartVO vo) {

		return hDao.commentLike(vo);
	}

	@Override
	public int likeCommentCount(HeartVO vo) {

		return hDao.getLikeCommentCount(vo);
	}

	@Override
	public void deleteLike_c(HeartVO vo) {
		hDao.deleteLike_c(vo);

	}

	@Override
	public List<Integer> shortsLike(HeartVO vo) {

		return hDao.shortsLike(vo);
	}

	@Override
	public int likeShortsCount(HeartVO vo) {

		return hDao.likeShortsCount(vo);
	}

	@Override
	public void deleteLike_s(HeartVO vo) {
		hDao.deleteLike_s(vo);
		
	}

}