package com.javaclass.service;

import java.util.List;

import com.javaclass.domain.DiaryVO;
import com.javaclass.domain.EmoVO;

public interface EmoService {

	// 전체목록 가져오기
	public List<EmoVO> getemoList(EmoVO vo);

	public List<EmoVO> getEmo(EmoVO vo);
}
