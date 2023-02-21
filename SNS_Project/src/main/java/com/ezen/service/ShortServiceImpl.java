package com.ezen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.dao.ShortsDAO;
import com.ezen.dto.ShortsVO;

@Service
public class ShortServiceImpl implements ShortsService {

	@Autowired
	private ShortsDAO sDAO;

	@Override
	public ShortsVO getShorts(ShortsVO vo) {

		System.out.println("==getShort service �떎�뻾: " + vo);
		return sDAO.getShorts(vo);
	}

	@Override
	public void insertShorts(ShortsVO vo) {
		sDAO.insertShorts(vo);

	}

	@Override
	public void updateShorts(ShortsVO vo) {
		sDAO.updateShorts(vo);
		System.out.println("--updateShortService �떎�뻾: " + vo);
	}

	@Override
	public void deleteShorts(ShortsVO vo) {
		sDAO.deleteShorts(vo);

	}

	@Override
	public List<ShortsVO> getShortsList(ShortsVO vo) {
		return sDAO.getShortsList(vo);
	}

	@Override
	public void updatePay(int sSeq) {
		sDAO.updatePay(sSeq);

	}

	@Override
	public void updateManusPay(int sSeq) {
		sDAO.updateManusPay(sSeq);

	}

	@Override
	public void updateShortsCount(ShortsVO vo) {
		sDAO.updateShortsCount(vo);

	}

	@Override
	public List<ShortsVO> getAdShortsList(ShortsVO vo) {

		return sDAO.getAdShortsList(vo);
	}

	@Override
	public List<ShortsVO> getStoryShortsList(ShortsVO vo) {

		return sDAO.getStoryShortsList(vo);
	}

}
