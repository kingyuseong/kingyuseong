package com.javaclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaclass.domain.ReserveVO;
import com.javaclass.domain.SdsReserveVO;
import com.javaclass.service.ReserveService;
import com.javaclass.service.SdsReserveService;

@Controller
public class SdsReserveController {
	private final SdsReserveService sdsreserveService;
	
	@Autowired
	public SdsReserveController(SdsReserveService sdsreserveService) {
		this.sdsreserveService = sdsreserveService;
	}
	
	@GetMapping("/SdsReserve.do")
	public String sdsreserve(SdsReserveVO vo, Model model) {
		List<SdsReserveVO> eventList = sdsreserveService.getSdsReserveList(vo);
		model.addAttribute("eventList", eventList);
		return "SdsReserve";
	}
	
	@RequestMapping(value="/insertSdsReserve.do", method = RequestMethod.POST)
	public String insertSdsReserve(SdsReserveVO vo) {
		  sdsreserveService.insertSdsReserve(vo);
		  return "SdsReserve";
	  }
	
    @RequestMapping("/updateSdsReserve.do")
    public String updateSdsReserve(SdsReserveVO vo) {
    	sdsreserveService.updateSdsReserve(vo);
       System.out.println("컨트롤러 지나간다"+vo);
       return "redirect:/SdsReserve.do";
    }
    
 	@RequestMapping("/deleteSdsReserve.do")
 	public String deleteSdsReserve(SdsReserveVO vo) {
 		sdsreserveService.deleteSdsReserve(vo);
 		 System.out.println("컨트롤러 지나간다"+vo.getSrcode());
 		return "redirect:/SdsReserve.do";
 	}
}
