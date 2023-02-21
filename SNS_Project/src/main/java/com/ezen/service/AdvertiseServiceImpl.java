package com.ezen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.dao.AdvertisementDAO;
import com.ezen.dto.AdvertisementVO;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {

	@Autowired
	public AdvertisementDAO adverDao;
	
	@Override
	public List<AdvertisementVO> AdverList(AdvertisementVO vo) {
		
		return adverDao.AdverList(vo);
	}

}
