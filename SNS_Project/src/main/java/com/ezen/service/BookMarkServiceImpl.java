package com.ezen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.dao.BookMarkDAO;
import com.ezen.dto.BoardVO;
import com.ezen.dto.BookMarkVO;
import com.ezen.dto.ShortsVO;

@Service
public class BookMarkServiceImpl implements BookMarkService {
	@Autowired
	BookMarkDAO bmDAO;

	@Override
	public void insertBookMark(BookMarkVO vo) {
		bmDAO.insertBookMark(vo);

	}

	@Override
	public void updateBookMark(BookMarkVO vo) {
		bmDAO.updateBookMark(vo);
	}

	@Override
	public void deleteBookMark(BookMarkVO vo) {
		bmDAO.deleteBookMark(vo);

	}

	@Override
	public void deleteShortsBookMark(BookMarkVO vo) {
		bmDAO.deleteShortsBookMark(vo);
	}

	@Override
	public void deleteBoardBookMark(BookMarkVO vo) {
		bmDAO.deleteBoardBookMark(vo);
	}

	@Override
	public List<BookMarkVO> getBoardBookMarkList(BookMarkVO vo) {

		return bmDAO.getBoardBookMarkList(vo);
	}

	@Override
	public List<BookMarkVO> getShortsBookMarkList(BookMarkVO vo) {

		return bmDAO.getShortsBookMarkList(vo);
	}

	@Override
	public List<BookMarkVO> getBookMarkList(BookMarkVO vo) {

		return bmDAO.getBookMarkList(vo);
	}

	@Override
	public BookMarkVO getBookMark(BookMarkVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getBoardBookMarkNums(BookMarkVO vo) {
		return bmDAO.getBoardBookMarkNums(vo);
	}

	@Override
	public List<Integer> getShortsBookMarkNums(BookMarkVO vo) {
		return bmDAO.getShortsBookMarkNums(vo);
	}

	@Override
	public String getBoardBookMarkTitle(BookMarkVO vo) {

		return bmDAO.getBoardBookMarkTitle(vo);
	}

	@Override
	public String getShortsBookMarkTitle(BookMarkVO vo) {

		return bmDAO.getShortsBookMarkTitle(vo);
	}
	@Override
	public List<BookMarkVO> getMyBoardList(BookMarkVO vo) {
		return bmDAO.getMyBoardList(vo);
	}
}
