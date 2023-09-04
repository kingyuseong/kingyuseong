package com.javaclass.dao;


import java.util.List;

import com.javaclass.domain.FreeBoardVO;

public interface FreeBoardDAO {
    // 모든 자유게시판 글 조회
    List<FreeBoardVO> getAllFreeBoards();

    // 자유게시판 글 생성
    void createFreeBoard(FreeBoardVO freeBoard);

    // 자유게시판 글 수정
    void updateFreeBoard(FreeBoardVO freeBoard);

    // 자유게시판 글 삭제
    void deleteFreeBoard(FreeBoardVO freeBoard);
    
    FreeBoardVO getFreeBoard(FreeBoardVO freeBoard);
    
    List<FreeBoardVO> searchFreeBoards(String searchCondition, String searchKeyword);
    
}
