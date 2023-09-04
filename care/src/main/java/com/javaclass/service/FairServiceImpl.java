package com.javaclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.dao.FairDAOImpl;
import com.javaclass.domain.FairVO;

@Service("fairService")
public class FairServiceImpl implements FairService {

	@Autowired
	private FairDAOImpl fairDAO;

	@Override
	public List<FairVO> fairList(FairVO vo) {
		return fairDAO.fairList(vo);
	}
	
	public List<FairVO> fairReserve(FairVO vo){
		return fairDAO.fairReserve(vo);
	}
}
