package com.javaclass.service;

import java.util.List;

import com.javaclass.domain.ReservationVO;


public interface ReservationService {

	// 글 목록 조회
	List<ReservationVO> reservationList(ReservationVO vo);

}
