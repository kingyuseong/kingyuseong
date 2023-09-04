package com.javaclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.dao.EmoDAO;
import com.javaclass.domain.EmoVO;

@Service("emoService")
public class EmoServiceImpl implements EmoService {
	@Autowired
	private EmoDAO emoDAO;

	@Override
	public List<EmoVO> getemoList(EmoVO vo) {
		return emoDAO.getemoList(vo);
	}

	@Override
	public List<EmoVO> getEmo(EmoVO vo) {
		// TODO Auto-generated method stub
		System.out.println("그래프 시스템 옴  맴버 코드 : " + vo.getMemcode() + " / 날짜 :  " + vo.getNotedate());
		return emoDAO.getEmo(vo);
	}

}
