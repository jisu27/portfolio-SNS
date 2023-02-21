package com.ezen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.dao.ShortsCommentDAO;
import com.ezen.dto.ShortsCommentVO;

@Service
public class ShortsCommentServiceImpl implements ShortsCommentService {

	@Autowired
	private ShortsCommentDAO sdao;

	@Override
	public void insertShortsComment(ShortsCommentVO vo) {
		sdao.insertShortsComment(vo);

	}

	@Override
	public void updateShortsComment(ShortsCommentVO vo) {
		sdao.updateShortsComment(vo);

	}

	@Override
	public void deleteShortsComment(ShortsCommentVO vo) {
		sdao.deleteShortsComment(vo);

	}

	@Override
	public List<ShortsCommentVO> getShortsCommentList(ShortsCommentVO vo) {
		return sdao.getShortsCommentList(vo);
	}

	@Override
	public ShortsCommentVO getShortsComment(ShortsCommentVO vo) {
		return sdao.getShortsComment(vo);
	}

	@Override
	public int getCountShortsCommentList(int s_seq) {
		return sdao.getCountShortsCommentList(s_seq);
	}

}
