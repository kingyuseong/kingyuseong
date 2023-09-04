package com.javaclass.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaclass.domain.FreeBoardVO;
import com.javaclass.domain.MemberVO;
import com.javaclass.service.FreeBoardService;
import com.javaclass.service.MemberService;

@Controller
public class FreeBoardController {

    @Autowired
    private FreeBoardService freeBoardService;

    @Autowired
    private MemberService memberService; 

    // 자유게시판 글 목록 조회
    @GetMapping("/getAllFreeBoards.do")
    public String getAllFreeBoards(Model model) {
        model.addAttribute("freeBoards", freeBoardService.getAllFreeBoards());
        return "free"; 
    }

    // 자유게시판 글 등록
    @PostMapping("/createFreeBoard.do")
    public String createFreeBoard(@ModelAttribute("freeBoard") FreeBoardVO freeBoard) {
        freeBoardService.createFreeBoard(freeBoard);
        return "redirect:/getAllFreeBoards.do";
    }

    // 자유게시판 글 수정
    @PostMapping("/updateFreeBoard.do")
    public String updateFreeBoard(@ModelAttribute("freeBoard") FreeBoardVO freeBoard) {
        freeBoardService.updateFreeBoard(freeBoard);
        return "redirect:/getFreeBoard.do?freecode=" + freeBoard.getFreecode();
    }

    // 자유게시판 글 삭제
    @RequestMapping("/deleteFreeBoard.do")
    public String deleteFreeBoard(FreeBoardVO freeBoard) {
        freeBoardService.deleteFreeBoard(freeBoard);
        return "redirect:/getAllFreeBoards.do";
    }

    // 자유게시판 글 상세 조회
    @GetMapping("/getFreeBoard.do")
    public String getFreeBoard(FreeBoardVO freeBoard, Model model, HttpSession session) {
        // 현재 로그인한 사용자의 회원 코드 가져오기
        Integer loggedInMemcode = (Integer) session.getAttribute("MemLogin");

        // 선택한 글의 작성자 회원 코드 가져오기
        FreeBoardVO selectedFreeBoard = freeBoardService.getFreeBoard(freeBoard);
        Integer selectedMemcode = selectedFreeBoard.getMemcode();

        // 로그인한 사용자의 회원 코드와 글 작성자의 회원 코드 비교하여 수정 및 삭제 버튼 활성화 여부 판단
        boolean canEditDelete = loggedInMemcode != null && loggedInMemcode.equals(selectedMemcode);
        model.addAttribute("canEditDelete", canEditDelete);

        model.addAttribute("freeBoard", selectedFreeBoard);
        return "freeview"; 
    }
    
    // 자유게시판 글 검색
    @RequestMapping("/searchFreeBoards.do")
    public String searchFreeBoards(HttpServletRequest request, Model model) {
        String searchCondition = request.getParameter("searchCondition");
        String searchKeyword = request.getParameter("searchKeyword");

        model.addAttribute("freeBoards", freeBoardService.searchFreeBoards(searchCondition, searchKeyword));
        return "free"; 
    }

	 // 자유게시판 글 작성 페이지
    @GetMapping("/writeFreeBoard.do")
    public String writeFreeBoard(Model model, HttpSession session) {
        // 로그인된 사용자인지 확인
        String loggedInId = (String) session.getAttribute("loggedInId"); // 수정된 부분
        if (loggedInId == null) {
            return "redirect:/login.do"; // 로그인 페이지로 리다이렉트
        }

        // 로그인된 사용자의 회원코드 가져오기
        MemberVO loggedInMember = memberService.getMemberById(loggedInId);
        model.addAttribute("loggedInMember", loggedInMember);
        
        return "freeinsert"; // 글 작성 페이지로 이동
    }
}
	