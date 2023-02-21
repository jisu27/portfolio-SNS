package com.ezen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.dao.BoardDAO;
import com.ezen.dto.BoardVO;

@Service("BoardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO bDao;
	
	@Override
	public List<BoardVO> BoardList(BoardVO vo) {
		
		return bDao.BoardList(vo);
	}

	@Override
	public void InsertBoard(BoardVO vo) {
		bDao.insertBoard(vo);
		
	}

	@Override
	public List<BoardVO> myBoardList(BoardVO vo) {
		return 	bDao.myBoardList(vo);
	}

	@Override
	public BoardVO myBoard(BoardVO vo) {
		
		return bDao.myBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		bDao.updateBoard(vo);
		
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		
		return bDao.getBoardList(vo);
	}

	@Override
	public List<BoardVO> getAdverList(BoardVO vo) {
		
		return bDao.getAdverList(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		bDao.deleteBoard(vo);
		
	}

	@Override
	public void updateCount(BoardVO vo) {
		bDao.updateCount(vo);
		
	}

	@Override
	public int boardCount(BoardVO vo) {
		
		return bDao.boardCount(vo);
	}

	@Override
	public void updatePay(int bSeq) {
		bDao.updatePay(bSeq);
	}

	@Override
	public void updateManusPay(int bSeq) {
		bDao.updateManusPay(bSeq);
		
	}
	
}
