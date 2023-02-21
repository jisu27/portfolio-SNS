package com.ezen.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.dto.FollowVO;

@Repository
public class FollowDao {

	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertFollow(FollowVO vo) {
		mybatis.insert("followMapper.insertFollow", vo);
	}

	public void deleteFollow(FollowVO vo) {
		mybatis.insert("followMapper.deleteFollow", vo);
	}

	public FollowVO getFollow(FollowVO vo) {
		return mybatis.selectOne("followMapper.getFollow", vo);
	}

	public List<String> getFollowList(FollowVO vo) {
		return mybatis.selectList("followMapper.getFollowList", vo.getId1());
	}
	public List<FollowVO> getFollowListId1(FollowVO vo) {
		return mybatis.selectList("followMapper.getFollowListId1", vo.getId2());
	}
	public int getCountFollow(FollowVO vo) {
		return mybatis.selectOne("followMapper.countFollow", vo.getId2());
	}
	public int getCountFollowing(FollowVO vo) {
		return mybatis.selectOne("followMapper.countFollowing", vo.getId1());
	}
	public List<String> recomFollow(String id){
		return mybatis.selectList("followMapper.recomFollow",id);
	}
	
}
