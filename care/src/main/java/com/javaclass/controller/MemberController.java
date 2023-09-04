package com.javaclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaclass.domain.MemberVO;
import com.javaclass.domain.SdsMemberVO;
import com.javaclass.service.MemberService;
import com.javaclass.service.SdsMemberService;


@Controller
public class MemberController {
	
		//회원
		@Autowired
		private MemberService memberService;
		//상담사
		@Autowired
		private SdsMemberService sdsmemberService;
		
		// 아이디 중복 체크
		@RequestMapping(value="/idCheck.do", produces="application/text; charset=utf8")
		@ResponseBody // 비동기 통신
		public String idcheck(MemberVO vo) // 인자로 사용자아이디(String)만 받아도 된다
		{
			
			String result = "ID 사용 가능합니다.";
			
			MemberVO memberVo = memberService.idCheck_Login(vo);			
			if (memberVo != null) result = "중복된 아이디 입니다.";
			return result;
		}
		
		// 아이디 찾기
		@RequestMapping(value ="/conid.do")
		public String conid(MemberVO vo, Model model) {			
			model.addAttribute("conid", memberService.conid(vo));
			System.out.println(model);
			return "conid";
		}
		
		// 비밀번호 찾기
		@RequestMapping(value = "/conpw.do")
		public String conpw(MemberVO vo, Model model) {
			model.addAttribute("conpw", memberService.conpw(vo));
			System.out.println(model);
			return "conpw";
		}
		
		// 닉네임 중복 체크
		@RequestMapping(value="/nickCheck.do", produces="application/text; charset=utf8")
		@ResponseBody // 비동기 통신
		public String nickcheck(MemberVO vo) // 인자로 닉네임(String)만 받아도 된다
		{
			String result = "닉네임 사용 가능합니다.";
			
			MemberVO memberVo = memberService.nickCheck_Login(vo);			
			if (memberVo != null) result = "중복된 닉네임 입니다.";
			
			return result;
		}
				
		// 회원가입 /saveMember.do는 순수하게 action을 걸기위해 넣은 것이고 redirect에 넘어가는 페이지를 return
		@RequestMapping(value="/saveMember.do", method=RequestMethod.POST)
		public String userInsert(MemberVO vo) {
			memberService.memberInsert(vo);
			return "redirect:/login.do";
		}
		
		// 회원 탈퇴
		
		@RequestMapping("/memberDelete.do")
		public String memberDelete(MemberVO vo) {
			memberService.memberDelete(vo);
			return "redirect:/login.do";
		}
		
		
		
		//상담사 아이디 중복 체크
		@RequestMapping(value="/sdsIdCheck.do", produces="application/text; charset=utf8")
		@ResponseBody //비동기 통신
		public String sdsidcheck(SdsMemberVO vo) // 인자로 사용자아이디(String)만 받아도 된다
		{
			String sdsresult = "ID 사용 가능합니다.";
			
			SdsMemberVO sdsmemberVo = sdsmemberService.sdsidCheck_Login(vo);
			if(sdsmemberVo != null) sdsresult = "중복된 아이디 입니다.";
			
			return sdsresult;
		}
		
		//상담사 닉네임 중복 체크
		@RequestMapping(value="/sdsNickCheck.do", produces="application/text; charset=utf8")
		@ResponseBody //비동기 통신
		public String sdsnickcheck(SdsMemberVO vo) // 인자로 사용자아이디(String)만 받아도 된다
		{
			String sdsresult = "닉네임 사용 가능합니다.";
			
			SdsMemberVO sdsmemberVo = sdsmemberService.sdsnickCheck_Login(vo);
			if(sdsmemberVo != null) sdsresult = "중복된 닉네임 입니다.";
			
			return sdsresult;
		}
		
		// 상담사 아이디 찾기
				@RequestMapping(value ="/sdsconid.do")
				public String sdsconid(SdsMemberVO vo, Model model) {			
					model.addAttribute("sdsconid", sdsmemberService.sdsconid(vo));
					System.out.println(model);
					return "sdsconid";
				}
				
		// 상담사 비밀번호 찾기
		@RequestMapping(value = "/sdsconpw.do")
		public String sdsconpw(SdsMemberVO vo, Model model) {
			model.addAttribute("sdsconpw", sdsmemberService.sdsconpw(vo));
			System.out.println(model);
			return "sdsconpw";
		}
		
		// 상담사가입 /sdssaveMember.do는 순수하게 action을 걸기위해 넣은 것이고 redirect에 넘어가는 페이지를 return
		@RequestMapping(value="/sdssaveMember.do", method=RequestMethod.POST)
		public String sdsuserInsert(SdsMemberVO vo) {
			sdsmemberService.sdsMemberInsert(vo);
			return "redirect:/login.do";
		}
		
		// 상담사 탈퇴		
		@RequestMapping("/sdsmemberDelete.do")
		public String sdsmemberDelete(SdsMemberVO vo) {
		sdsmemberService.sdsmemberDelete(vo);
		return "redirect:/login.do";
		}
		
		
}
