package com.ezen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.dao.FollowDao;
import com.ezen.dto.FollowVO;

@Service("FollowService")
public class FollowServiceImpl implements FollowService {
	@Autowired
	private FollowDao dao;
	
	
	@Override
	public void insertFollow(FollowVO vo) {
		dao.insertFollow(vo);
	}

	@Override
	public void deleteFollow(FollowVO vo) {
		dao.deleteFollow(vo);

	}

	@Override
	public FollowVO getFollow(FollowVO vo) {
		
		return dao.getFollow(vo);
	}

	@Override
	public List<String> getFollowList(FollowVO vo) {
		
		return dao.getFollowList(vo);
	}

	@Override
	public int getCountFollow(FollowVO vo) {
		return dao.getCountFollow(vo);
	}

	@Override
	public int getCountFollowing(FollowVO vo) {
		
		return dao.getCountFollowing(vo);
	}

	@Override
	public List<FollowVO> getFollowListId1(FollowVO vo) {

		return dao.getFollowListId1(vo);
	}

	@Override
	public List<String> recomFollow(String id) {
		
		return dao.recomFollow(id);
	}

}
