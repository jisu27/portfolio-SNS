package com.ezen.service;

import java.util.List;

import com.ezen.dto.FollowVO;

public interface FollowService {
	
	public void insertFollow(FollowVO vo);
	
	public void deleteFollow(FollowVO vo);
	
	public FollowVO getFollow(FollowVO vo);
	
	public List<String> getFollowList(FollowVO vo);
	
	public List<FollowVO> getFollowListId1(FollowVO vo);
	
	public int getCountFollow(FollowVO vo);

	public int getCountFollowing(FollowVO vo);
	
	List<String> recomFollow(String id);
}
