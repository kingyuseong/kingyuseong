package com.javaclass.dao;

import java.util.List;

import com.javaclass.domain.ReserveVO;
import com.javaclass.domain.SdsReserveVO;

public interface SdsReserveDAO {
	
	List<SdsReserveVO> getSdsReserveList(SdsReserveVO vo);
	
	public void insertSdsReserve(SdsReserveVO vo);
	
	   // 일정 수정 부분
    public void updateSdsReserve(SdsReserveVO vo);
    
    // 일정 삭제 부분
    public void deleteSdsReserve(SdsReserveVO vo);
}
