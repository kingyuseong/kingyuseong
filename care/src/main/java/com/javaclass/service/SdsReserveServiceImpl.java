package com.javaclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.dao.SdsReserveDAO;
import com.javaclass.domain.SdsReserveVO;

@Service
public class SdsReserveServiceImpl implements SdsReserveService{
	private final SdsReserveDAO sdsreserveDAO;
	
	@Autowired
	public SdsReserveServiceImpl(SdsReserveDAO sdsreserveDAO) {
		this.sdsreserveDAO = sdsreserveDAO;
	}
	
	@Override
	public List<SdsReserveVO> getSdsReserveList(SdsReserveVO vo) {
		return sdsreserveDAO.getSdsReserveList(vo);
	}
	
	public void insertSdsReserve(SdsReserveVO vo) {
		sdsreserveDAO.insertSdsReserve(vo);
	}
	
	  //일정 수정 부분
  	public void updateSdsReserve(SdsReserveVO vo) {
  		sdsreserveDAO.updateSdsReserve(vo);
  	}

  	//일정 삭제 부분
  	public void deleteSdsReserve(SdsReserveVO vo) {
  		sdsreserveDAO.deleteSdsReserve(vo);
  	}
}
