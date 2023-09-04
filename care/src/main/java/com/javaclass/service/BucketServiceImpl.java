package com.javaclass.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.dao.BucketDAO;
import com.javaclass.domain.BucketVO;
import com.javaclass.domain.Criteria;
import com.javaclass.domain.DiaryVO;



@Service("bucketService")
public class BucketServiceImpl implements BucketService {
	
	@Autowired
	private BucketDAO bucketDAO;

	// 입력
	@Override
	public void insertBucket(BucketVO vo) {
		bucketDAO.insertBucket(vo);
		
	}

	// 전체목록
	@Override
	public List<BucketVO> getBucketList(HashMap map, Criteria cri) {
		// TODO Auto-generated method stub
		return bucketDAO.getBucketList(map, cri);
	}

	// 수정
	@Override
	public void updateBucket(BucketVO vo) {
		bucketDAO.updateBucket(vo);
		
	}

	// 숫자세기
	@Override
	public BucketVO DiarySum(BucketVO vo) {
		// TODO Auto-generated method stub
		return bucketDAO.DiarySum(vo);
		
	}

	// 삭제
	@Override
	public void deleteBucket(BucketVO vo) {
		// TODO Auto-generated method stub
		bucketDAO.deleteBucket(vo);
		
	}

	


}