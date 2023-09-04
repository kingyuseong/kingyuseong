package com.javaclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaclass.domain.JobVO;
import com.javaclass.service.JobService;


@Controller
public class JobController {
	@Autowired
	private JobService jobService;
	// 일자리 목록 검색
	@RequestMapping("/jobList.do")
	public String jobList(JobVO vo, Model model) {
		model.addAttribute("jobList", jobService.jobList(vo));
		// ViewResolver를 지정하지 않으면 아래처럼 페이지명 지정
		// return "views/getBoardList.jsp"; // View 이름 리턴
		return "job";
	}
	
}
