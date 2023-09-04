package com.javaclass.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaclass.domain.EmoVO;

@Repository("emoDAO")
public class EmoDAOImpl implements EmoDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public List<EmoVO> getemoList(EmoVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("EmoDAO.getEmoList", vo);
	}

	@Override
	public List<EmoVO> getEmo(EmoVO vo) {
		// TODO Auto-generated method stub
		System.out.println("그래프 다오 감 맴버 코드 :" + vo.getMemcode() + " / " + vo.getNotedate());
		List a = mybatis.selectList("EmoDAO.getEmo", vo);
		
		System.out.println(" a : " + a);
		
		return a;
	}

}
