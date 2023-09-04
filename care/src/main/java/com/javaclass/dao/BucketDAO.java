package com.javaclass.dao;

import java.util.HashMap;
import java.util.List;

import com.javaclass.domain.BucketVO;
import com.javaclass.domain.Criteria;

public interface BucketDAO {

	public void insertBucket(BucketVO vo);

	public List<BucketVO> getBucketList(HashMap map, Criteria cri);

	public void updateBucket(BucketVO vo);

	public BucketVO DiarySum(BucketVO vo);

	public void deleteBucket(BucketVO vo);
	
}
