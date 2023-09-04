package com.javaclass.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaclass.domain.ReservationVO;


@Repository("reservationListDAO")
public class ReservationDAOImpl implements ReservationDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public List<ReservationVO> reservationList(ReservationVO vo) {
		System.out.println("===> Mybatis reservationList() 호출");
		List<ReservationVO> list = mybatis.selectList("ReservationDAO.reservationList", vo);
		return list;
	}



}
