package com.javaclass.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javaclass.domain.LoginVO;
import com.javaclass.domain.SdsLoginVO;
import com.javaclass.service.LoginService;
import com.javaclass.service.SdsLoginService;

@Controller
public class LoginController {
      //회원로그인 Service
      @Autowired
      private LoginService loginService;
      
      //상담사로그인 Service
      @Autowired
      private SdsLoginService sdsLoginService;
      
      
      //회원 로그인
      @RequestMapping(value="/login.do", method=RequestMethod.POST)
      public String login(LoginVO vo, String pw, HttpSession session, Model model) {
         LoginVO login = loginService.getLogin(vo);
         if(login==null) {
            model.addAttribute("errorMessage", "아이디나 비밀번호가 틀렸습니다.");
            model.addAttribute("errorType", "id");
            return "login";
         }
      else {
            if(!login.getPw().equals(pw)) {
               model.addAttribute("errorMessage", "아이디나 비밀번호가 틀렸습니다.");
                  model.addAttribute("errorType", "password"); // 비밀번호 오류 플래그 추가
               return "login";
            }else {   
               session.setAttribute("IdLogin", login.getId());                                                                     
               session.setAttribute("Login", login.getNick());
               session.setAttribute("MemLogin", login.getMemcode());
                
               
               return "redirect:/index.jsp";
            }
         }
      }
      
      //마이페이지에 가져갈 VO값들 저장(model)
      @RequestMapping(value="/myPage.do")
      public String myList(LoginVO vo, Model model) {
         model.addAttribute("myList", loginService.myList(vo));
         System.out.println(model);
         return "myPage";
      }
      
      //정보수정에 가져갈 VO값들 저장(model)
      @RequestMapping(value ="/memupdate.do")
      public String memUp(LoginVO vo, Model model) {
         model.addAttribute("memUp", loginService.memUp(vo));
         System.out.println(model);
         return "memupdate";
      }
      
      //회원 정보 수정
      @RequestMapping("/updatemem.do")
      public String updatemem(LoginVO vo) {
         loginService.updatemember(vo);
         System.out.println(vo);
         return "redirect:/index.jsp";
      }
      
      //상담사 로그인
      @RequestMapping(value="/sdslogin.do", method=RequestMethod.POST)
      public String sdsLogin(SdsLoginVO vo, String sdspw, HttpSession session, Model model) {
         SdsLoginVO sdslogin = sdsLoginService.sdsLogin(vo);
         if(sdslogin==null) {
            model.addAttribute("errorMessage", "아이디나 비밀번호가 틀렸습니다.");
            model.addAttribute("errorType", "id");
            return "login";
         }
         else {
            if(!sdslogin.getSdspw().contentEquals(sdspw)) {
               model.addAttribute("errorMessage", "아이디나 비밀번호가 틀렸습니다.");
                  model.addAttribute("errorType", "password"); // 비밀번호 오류 플래그 추가
               return "login"; 
               }else {
                  session.setAttribute("SdsLogin", sdslogin.getSdsid());
                  session.setAttribute("NickLogin", sdslogin.getSdsnick());
                  session.setAttribute("sdsmemLogin", sdslogin.getSdsmemcode());
                  System.out.println(sdslogin.getSdsmemcode());
                  
                  
                  return "redirect:index.jsp"; 
                  } 
            } 
         }
      
      //상담사마이페이지에 가져갈 VO값들 저장(model)
      @RequestMapping(value="/sdsMyPage.do")
      public String sdsList(SdsLoginVO vo, Model model) {
         model.addAttribute("sdsList", sdsLoginService.sdsList(vo));
         System.out.println(model);
         return "sdsMyPage";
      }
            
      //상담사정보수정에 가져갈 VO값들 저장(model)
      
       @RequestMapping(value ="/sdsmemupdate.do")
       public String sdsmemUp(SdsLoginVO vo, Model model) {
       model.addAttribute("sdsmemUp", sdsLoginService.sdsmemUp(vo));
       System.out.println(model); 
       return "sdsmemupdate"; 
       }
      
       
      //상담사 정보 수정
      @RequestMapping("/updatesdsmem.do")
      public String updatesdsmem(SdsLoginVO vo) {
         sdsLoginService.updatesdsmember(vo);
         System.out.println(vo);
         return "redirect:/index.jsp";
      }
      
      //회원 로그아웃
      @RequestMapping("/logout.do")
      public String logout(HttpSession session) {
         session.removeAttribute("Login");
         /* session.removeAttribute("SdsLogin"); */
         return "redirect:/index.jsp";
      }
      
      //상담사 로그아웃
      @RequestMapping("/sdslogout.do")
      public String sdslogout(HttpSession session) {
         session.removeAttribute("SdsLogin");
         /* session.removeAttribute("SdsLogin"); */
         return "redirect:/index.jsp";
      }
      
}