package com.javaclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.dao.ReservationDAOImpl;
import com.javaclass.domain.ReservationVO;


@Service("reservationService")
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private ReservationDAOImpl reservationDAO;
	
	@Override
	public List<ReservationVO> reservationList(ReservationVO vo) {
		return reservationDAO.reservationList(vo);
	}
}
