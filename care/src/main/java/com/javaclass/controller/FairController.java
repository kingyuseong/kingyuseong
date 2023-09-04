package com.javaclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaclass.domain.FairVO;
import com.javaclass.service.FairService;


@Controller
public class FairController {
	@Autowired
	private FairService fairService;
	// 박람회 목록 검색
	@RequestMapping("/fairList.do")
	public String fairList(FairVO vo, Model model) {
		model.addAttribute("fairList", fairService.fairList(vo));
		// ViewResolver를 지정하지 않으면 아래처럼 페이지명 지정
		// return "views/getBoardList.jsp"; // View 이름 리턴
		return "exposition";
	}
	
	@RequestMapping("/fairReserve.do")
	public String fairReserve(FairVO vo, Model model) {
		model.addAttribute("fairReserve", fairService.fairReserve(vo));
		return "index.jsp";
	}
	
}
