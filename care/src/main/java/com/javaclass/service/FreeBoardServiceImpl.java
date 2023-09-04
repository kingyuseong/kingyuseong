package com.javaclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.dao.FreeBoardDAO;
import com.javaclass.domain.FreeBoardVO;

@Service
public class FreeBoardServiceImpl implements FreeBoardService {

    @Autowired
    private FreeBoardDAO freeBoardDAO;

    @Override
    public List<FreeBoardVO> getAllFreeBoards() {
        return freeBoardDAO.getAllFreeBoards();
    }

    @Override
    public void createFreeBoard(FreeBoardVO freeBoard) {
        freeBoardDAO.createFreeBoard(freeBoard);
    }

    @Override
    public void updateFreeBoard(FreeBoardVO freeBoard) {
        freeBoardDAO.updateFreeBoard(freeBoard);
    }

    @Override
    public void deleteFreeBoard(FreeBoardVO freeBoard) {
        freeBoardDAO.deleteFreeBoard(freeBoard);
    }

    @Override
    public FreeBoardVO getFreeBoard(FreeBoardVO freeBoard) {
        return freeBoardDAO.getFreeBoard(freeBoard);
    }
    
    @Override
    public List<FreeBoardVO> searchFreeBoards(String searchCondition, String searchKeyword) {
        return freeBoardDAO.searchFreeBoards(searchCondition, searchKeyword);
    }
}