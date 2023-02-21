package com.ezen.service;

import java.util.List;

import com.ezen.dto.CommentVO;

public interface CommentService {
	
	void insertComment(CommentVO vo);

	void updateComment(CommentVO vo);

	void deleteComment(CommentVO vo);

	CommentVO getComment(CommentVO vo);

	List<CommentVO> getCommentList(CommentVO vo);
	
	void updateCount(CommentVO vo);

}