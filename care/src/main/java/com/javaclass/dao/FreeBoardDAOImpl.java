package com.javaclass.dao;

import java.util.List;
import java.util.Map; 
import java.util.HashMap; 
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaclass.domain.FreeBoardVO;


@Repository
public class FreeBoardDAOImpl implements FreeBoardDAO {

    @Autowired
    private SqlSessionTemplate mybatis;

    @Override
    public List<FreeBoardVO> getAllFreeBoards() {
        System.out.println("===> Mybatis getAllFreeBoards() 호출");
        List<FreeBoardVO> list = mybatis.selectList("FreeBoardDAO.getAllFreeBoards");
        return list;
    }

    @Override
    public void createFreeBoard(FreeBoardVO freeBoard) {
        System.out.println("===> Mybatis createFreeBoard() 호출");
        mybatis.insert("FreeBoardDAO.createFreeBoard", freeBoard);
    }

    @Override
    public void updateFreeBoard(FreeBoardVO freeBoard) {
        System.out.println("===> Mybatis updateFreeBoard() 호출");
        mybatis.update("FreeBoardDAO.updateFreeBoard", freeBoard);
    }

    @Override
    public void deleteFreeBoard(FreeBoardVO freeBoard) {
        System.out.println("===> Mybatis deleteFreeBoard() 호출");
        mybatis.delete("FreeBoardDAO.deleteFreeBoard", freeBoard);
    }
    
    @Override
    public FreeBoardVO getFreeBoard(FreeBoardVO freeBoard) {
        System.out.println("===> Mybatis getFreeBoard() 호출");
        return mybatis.selectOne("FreeBoardDAO.getFreeBoard", freeBoard);
    }
    
    @Override
    public List<FreeBoardVO> searchFreeBoards(String searchCondition, String searchKeyword) {
        System.out.println("===> Mybatis searchFreeBoards() 호출");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("searchCondition", searchCondition);
        paramMap.put("searchKeyword", searchKeyword);

        List<FreeBoardVO> list = mybatis.selectList("FreeBoardDAO.getFreeBoardListBySearch", paramMap);
        return list;
    }
    
    
    
}