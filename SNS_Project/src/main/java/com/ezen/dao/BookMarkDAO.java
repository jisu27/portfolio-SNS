package com.ezen.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.dto.BoardVO;
import com.ezen.dto.BookMarkVO;
import com.ezen.dto.ShortsVO;

@Repository("BookMarkDAO")
public class BookMarkDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertBookMark(BookMarkVO vo) {
		mybatis.insert("bookMarkMapper.insertBookMark", vo);
	}

	public void insertBoardBookMark(BookMarkVO vo) {
		mybatis.insert("bookMarkMapper.insertBoardBookMark", vo);
	}

	public void insertShortsBookMark(BookMarkVO vo) {
		mybatis.insert("bookMarkMapper.insertShortsBookMark", vo);
	}

	public void updateBookMark(BookMarkVO vo) {
		mybatis.update("bookMarkMapper.updateBookMark", vo);

	}

	public void deleteBookMark(BookMarkVO vo) {
		mybatis.delete("bookMarkMapper.deleteBookMark", vo);

	}

	public void deleteShortsBookMark(BookMarkVO vo) {
		mybatis.delete("bookMarkMapper.deleteShortsBookMark", vo);
	}

	public void deleteBoardBookMark(BookMarkVO vo) {
		mybatis.delete("bookMarkMapper.deleteBoardBookMark", vo);
	}

	public List<BookMarkVO> getBoardBookMarkList(BookMarkVO vo) {

		return mybatis.selectList("bookMarkMapper.getBoardBookMarkList", vo);
	}

	public List<BookMarkVO> getShortsBookMarkList(BookMarkVO vo) {

		return mybatis.selectList("bookMarkMapper.getShortsBookMarkList", vo);
	}

	public List<BookMarkVO> getBookMarkList(BookMarkVO vo) {

		return mybatis.selectList("bookMarkMapper.getBookMarkList", vo);
	}

	public BookMarkVO getBookMark(BookMarkVO vo) {

		return mybatis.selectOne("bookMarkMapper.getBookMark", vo);
	}

	public List<Integer> getBoardBookMarkNums(BookMarkVO vo) {

		return mybatis.selectList("bookMarkMapper.getBoardBookMarkNums", vo);
	}

	public List<Integer> getShortsBookMarkNums(BookMarkVO vo) {

		return mybatis.selectList("bookMarkMapper.getShortsBookMarkNums", vo);
	}

	public String getBoardBookMarkTitle(BookMarkVO vo) {

		return mybatis.selectOne("bookMarkMapper.getBoardBookMarkTitle", vo);
	}

	public String getShortsBookMarkTitle(BookMarkVO vo) {

		return mybatis.selectOne("bookMarkMapper.getShortsBookMarkTitle", vo);
	}
	
	public List<BookMarkVO> getMyBoardList(BookMarkVO vo) {
		return mybatis.selectList("bookMarkMapper.getMyBoardList", vo);
	}
}
