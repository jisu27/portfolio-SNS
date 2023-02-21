package com.ezen.service;

import java.util.List;

import com.ezen.dto.ShortsVO;

public interface ShortsService {

	ShortsVO getShorts(ShortsVO vo);

	void insertShorts(ShortsVO vo);

	void updateShorts(ShortsVO vo);

	void updateShortsCount(ShortsVO vo);

	void deleteShorts(ShortsVO vo);

	List<ShortsVO> getShortsList(ShortsVO vo);

	List<ShortsVO> getAdShortsList(ShortsVO vo);

	void updatePay(int sSeq);

	void updateManusPay(int sSeq);

	List<ShortsVO> getStoryShortsList(ShortsVO vo);
}