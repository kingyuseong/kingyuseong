package com.javaclass.dao;

import java.util.List;

import com.javaclass.domain.ReservationVO;


public interface ReservationDAO {
	
	public List<ReservationVO> reservationList(ReservationVO vo);
	
}