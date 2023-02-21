package com.ezen.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.dto.AdvertisementVO;


@Repository
public class AdvertisementDAO  {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public List<AdvertisementVO> AdverList(AdvertisementVO vo) {
		return mybatis.selectList("advertiseMapper.adverList", vo);
		
	}
}
