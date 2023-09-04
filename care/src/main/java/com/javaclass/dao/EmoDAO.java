package com.javaclass.dao;

import java.util.List;

import com.javaclass.domain.EmoVO;

public interface EmoDAO {

	public List<EmoVO> getemoList(EmoVO vo);

	public List<EmoVO> getEmo(EmoVO vo);

}
