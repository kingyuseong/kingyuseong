package com.javaclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaclass.domain.ReservationVO;
import com.javaclass.service.ReservationService;



@Controller
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	// 상담사  검색
	@RequestMapping("/reservationList.do")
	public String reservationList(ReservationVO vo, Model model) {
		model.addAttribute("reservationList", reservationService.reservationList(vo));
		// ViewResolver를 지정하지 않으면 아래처럼 페이지명 지정
		// return "views/getBoardList.jsp"; // View 이름 리턴
		return "reservation";
	}
	
}
