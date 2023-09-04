package com.javaclass.controller;

import java.util.HashMap;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import com.javaclass.domain.SupportVO;
import com.javaclass.service.SupportService;



@Controller
public class SupportController {
	
	 @Autowired
	  private SupportService supportService;
	    
	   
	   // 글 목록 
	   @RequestMapping("advocacy.do")	   
	   public void getadvocacyUI(Model model) {			  
		  System.out.println("advocacy.do 요청");		  
		  model.addAttribute("supportList", supportService.getSupportList());
		
		
	   }
	   
}
