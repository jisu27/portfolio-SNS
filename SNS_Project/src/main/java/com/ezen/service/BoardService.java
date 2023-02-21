package com.ezen.service;

import java.util.List;

import com.ezen.dto.BoardVO;

public interface BoardService {

	List<BoardVO> BoardList(BoardVO vo);

	BoardVO myBoard(BoardVO vo);

	List<BoardVO> myBoardList(BoardVO vo);

	void InsertBoard(BoardVO vo);

	void updateBoard(BoardVO vo);

	public List<BoardVO> getBoardList(BoardVO vo);

	public List<BoardVO> getAdverList(BoardVO vo);

	public void deleteBoard(BoardVO vo);

	void updateCount(BoardVO vo);

	public int boardCount(BoardVO vo);
	
	void updatePay(int bSeq);
	
	void updateManusPay(int bSeq);
}