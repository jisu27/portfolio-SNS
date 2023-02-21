package com.ezen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.dao.AdminDao;
import com.ezen.dto.AdminVO;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao aDao;
	
	@Override
	public List<AdminVO> viewAd() {
		return aDao.viewAd();
	}
	@Override
	public List<AdminVO> viewAd2() {
		return aDao.viewAd2();
	}

	@Override
	public void updateAdmin(int aSeq) {
		aDao.updateAdmin(aSeq);
		
	}

	@Override
	public void insertAd(AdminVO vo) {
		aDao.insertAd(vo);
	}
	@Override
	public void updateManusAdmin(int aSeq) {
		aDao.updateManusAdmin(aSeq);
		
	}
	@Override
	public void deleteAd(AdminVO vo) {
		aDao.deleteAd(vo);
		
	}

}
