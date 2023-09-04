package com.javaclass.service;

import java.util.List;

import com.javaclass.domain.FairVO;

public interface FairService {

	// 글 목록 조회
	List<FairVO> fairList(FairVO vo);

	List<FairVO> fairReserve(FairVO vo);

}
