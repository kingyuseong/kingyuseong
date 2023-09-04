package com.javaclass.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaclass.domain.CategoryVO;
import com.javaclass.domain.ClinicVO;
import com.javaclass.service.ClinicService;

@Controller
public class ClinicController {

	@Autowired
	private ClinicService clinicService;

	// 행정구 카테고리
	@RequestMapping(value = "/counseling_center1.do")
	public String counseling_center2(CategoryVO vo, Model model) throws IOException {
		model.addAttribute("gooList", clinicService.getGooName(vo));
		return "counseling_center";
	}

	// 동 카테고리
	@RequestMapping(value = "/counseling_center.do", method = RequestMethod.GET)
	@ResponseBody
	public List<CategoryVO> getSelect(@RequestParam("reggooname") String reggooname) {
		List<CategoryVO> list = clinicService.getDongName(reggooname);
		return list;
	}
	
	// 센터 정보
	@RequestMapping(value = "/counseling_centerC.do", method = RequestMethod.GET)
	@ResponseBody
	public List<ClinicVO> getClinic(@RequestParam("regname") String regname) {
		List<ClinicVO> list = clinicService.getClinic(regname);
		return list;
	}
}
