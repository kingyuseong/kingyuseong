package com.javaclass.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaclass.domain.BucketVO;
import com.javaclass.domain.Criteria;
import com.javaclass.domain.DiaryVO;

@Repository("bucketDAO")
public class BucketDAOImpl implements BucketDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public void insertBucket(BucketVO vo) {
		// TODO Auto-generated method stub
		mybatis.insert("BucketDAO.insertBucket",vo);
	}

	// 전체 목록
	@Override
	public List<BucketVO> getBucketList(HashMap map, Criteria cri) {
		int offset = (cri.getPageNum() - 1) * cri.getAmount();
	    RowBounds rowBounds = new RowBounds(offset, cri.getAmount());
		return mybatis.selectList("BucketDAO.getBucketList", map, rowBounds);
	}

	// 업데이트
	@Override
	public void updateBucket(BucketVO vo) {
		System.out.println(vo.getListcode() + "업데이트 옴!!");
		mybatis.update("BucketDAO.updateBucket",vo);
		
	}

	// 버킷숫자세기
	@Override
	public BucketVO DiarySum(BucketVO vo) {
		// TODO Auto-generated method stub
		System.out.println("버킷리스트 숫자세기 : " + vo.getMemcode());
		BucketVO bvo = mybatis.selectOne("BucketDAO.DiarySum",vo);
		System.out.println("다오임플"+bvo.getAllsum());
		return bvo;
	}

	// 삭제
	@Override
	public void deleteBucket(BucketVO vo) {
		// TODO Auto-generated method stub
		mybatis.delete("BucketDAO.deleteBucket",vo);
		
	}
	
}
