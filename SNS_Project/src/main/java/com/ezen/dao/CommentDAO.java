package com.ezen.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.dto.CommentVO;

@Repository("commentDAO")
public class CommentDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	// �뜝�뙃�떆源띿삕 �뜝�룞�삕�뜝占�
	public void insertComment(CommentVO vo) {
		// System.out.println("===> Mybatis�뜝�룞�삕 insertComment() �뜝�룞�삕�뜝占� 泥섇뜝�룞�삕");
		mybatis.insert("commentMapper.insertComment", vo);

	}

	// �뜝�뙃�떆源띿삕 �뜝�룞�삕�뜝�룞�삕
	public void updateComment(CommentVO vo) {
		// System.out.println("===> Mybatis�뜝�룞�삕 updateComment() �뜝�룞�삕�뜝占� 泥섇뜝�룞�삕");
		mybatis.update("commentMapper.updateComment", vo);

	}

	// �뜝�뙃�떆源띿삕 �뜝�룞�삕�뜝�룞�삕

	public void deleteComment(CommentVO vo) {
		// System.out.println("===> Mybatis�뜝�룞�삕 deleteComment() �뜝�룞�삕�뜝占� 泥섇뜝�룞�삕");
		mybatis.delete("commentMapper.deleteComment", vo);
	}

	public CommentVO getComment(CommentVO vo) {
		// System.out.println("===> Mybatis�뜝�룞�삕 getComment() �뜝�룞�삕�뜝占� 泥섇뜝�룞�삕");
		return mybatis.selectOne("commentMapper.getComment", vo);
	}

	public List<CommentVO> getCommentList(CommentVO vo) {
		// System.out.println("===> Mybatis�뜝�룞�삕 getCommentList() �뜝�룞�삕�뜝占� 泥섇뜝�룞�삕");
		return mybatis.selectList("commentMapper.getCommentList", vo);
	}
	
	public void updateCount(CommentVO vo) {
		mybatis.update("commentMapper.updateCount", vo);
	}

}
