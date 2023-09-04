package com.javaclass.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaclass.domain.ReserveVO;
import com.javaclass.service.ReserveService;

@Controller
public class ReserveController {
    private final ReserveService reserveService;

    @Autowired
    public ReserveController(ReserveService reserveService) {
        this.reserveService = reserveService;
    }
    //일정 나오기
    @GetMapping("/reserve.do")
    public String showCalendar(ReserveVO vo, Model model) {
        List<ReserveVO> eventList = reserveService.getEventList(vo);
        model.addAttribute("eventList", eventList);
        return "reserve"; // Assuming "calendar" is your JSP view name
    }
  
    //일정 입력
    @RequestMapping(value="/insertReserve.do", method = RequestMethod.POST)
    public String calInsert(ReserveVO vo, Model model) throws UnsupportedEncodingException {
    	// 기존에 이미 일정이 있는지 확인
        boolean isAvailable = reserveService.isDateAvailable(vo.getStartdate(), vo.getEnddate(), vo.getSdsmemcode());
        if (!isAvailable) {
        	return "reserve";
            //return "ReservePopup"; // 예약 실패 페이지로 리다이렉트
        }
      //예약 가능하면 일정추가
    	reserveService.insertReserve(vo);
    	return "reserve";
    }
    
    //비동기 시작일정 중복 체크
    @RequestMapping(value="/dateCheck.do", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String dateCheck(ReserveVO vo) {
        System.out.println("controller지나간다아아아아아아아아아아");
        String result = "예약 가능한 날짜입니다.";
        
        ReserveVO reserveVo = reserveService.dateCheck_start(vo);
        if(reserveVo != null) result = "다른 날짜(시간)을 선택해주세요.";
        
        return result;
        
    }
    
    //상담 일정 수정
    @RequestMapping("/updateReserve.do")
    public String updateReserve(ReserveVO vo) {
    	reserveService.updateReserve(vo);
       System.out.println(vo);
       return "redirect:/reserve.do";
    }
    
    //상담 일정 삭제
 	@RequestMapping("/deleteReserve.do")
 	public String deleteReserve(ReserveVO vo) {
 		reserveService.deleteReserve(vo);
 		return "redirect:/reserve.do";
 	}
    
}
