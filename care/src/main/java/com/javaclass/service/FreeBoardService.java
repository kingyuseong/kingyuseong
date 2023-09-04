package com.javaclass.service;

import java.util.List;

import com.javaclass.domain.FreeBoardVO;

public interface FreeBoardService {
    List<FreeBoardVO> getAllFreeBoards();
    void createFreeBoard(FreeBoardVO freeBoard);
    void updateFreeBoard(FreeBoardVO freeBoard);
    void deleteFreeBoard(FreeBoardVO freeBoard);
    FreeBoardVO getFreeBoard(FreeBoardVO freeBoard);
    List<FreeBoardVO> searchFreeBoards(String searchCondition, String searchKeyword);
}
