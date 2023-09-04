package com.javaclass.service;

import java.util.List;
import java.util.HashMap;

import com.javaclass.domain.BucketVO;
import com.javaclass.domain.Criteria;
import com.javaclass.domain.DiaryVO;

public interface BucketService {

	// 등록
	void insertBucket(BucketVO vo);

	// 전체조회
	List<BucketVO> getBucketList(HashMap map, Criteria cri);

	// 수정
	void updateBucket(BucketVO vo);

	// 버킷리스트 숫자세기
	BucketVO DiarySum(BucketVO vo);

	// 버킷리스트 삭제
	void deleteBucket(BucketVO vo);
	

}
