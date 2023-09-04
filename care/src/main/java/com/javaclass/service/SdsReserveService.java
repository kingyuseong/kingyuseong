package com.javaclass.service;

import java.util.List;

import com.javaclass.domain.SdsReserveVO;

public interface SdsReserveService {
	
	List<SdsReserveVO> getSdsReserveList(SdsReserveVO vo);
	
	public void insertSdsReserve(SdsReserveVO vo);
	
    public void updateSdsReserve(SdsReserveVO vo);

    public void deleteSdsReserve(SdsReserveVO vo);
}
