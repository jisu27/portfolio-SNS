package com.ezen.service;

import java.util.List;

import com.ezen.dto.HeartVO;

public interface HeartService {

	HeartVO like(HeartVO vo);

	void insertLike(HeartVO vo);

	List<Integer> boardLike(HeartVO vo);

	void deleteLike(HeartVO vo);

	void deleteLike_c(HeartVO vo);
	
	void deleteLike_s(HeartVO vo);

	int likeCount(HeartVO vo);

	List<Integer> commentLike(HeartVO vo);

	int likeCommentCount(HeartVO vo);

	List<Integer> shortsLike(HeartVO vo);

	int likeShortsCount(HeartVO vo);
}