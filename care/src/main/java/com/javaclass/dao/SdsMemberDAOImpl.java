package com.javaclass.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaclass.domain.SdsMemberVO;

@Repository("SdsMemberDAO")
public class SdsMemberDAOImpl implements SdsMemberDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public SdsMemberVO sdsIdCheck(SdsMemberVO vo) {
		System.out.println("===>  SdsMemberMapper sdsIdCheck() 호출");
		return mybatis.selectOne("SdsMemberDAO.sdsIdCheck", vo);
	}
	
	@Override
	public SdsMemberVO sdsNickCheck(SdsMemberVO vo) {
		System.out.println("===>  SdsMemberMapper sdsNickCheck() 호출");
		return mybatis.selectOne("SdsMemberDAO.sdsNickCheck", vo);
	}
	
	public void sdsMemberInsert(SdsMemberVO vo) {
		System.out.println("===>  SdsMemberMapper sdsMemberInsert() 호출");
		mybatis.insert("SdsMemberDAO.sdsMemberInsert", vo);
	}
	
	public void sdsmemberDelete(SdsMemberVO vo) {
		System.out.println("===>  SdsMemberMapper sdsmemberDelete() 호출");
		mybatis.insert("SdsMemberDAO.sdsmemberDelete", vo);
	}
	
	public List<SdsMemberVO> sdsconid(SdsMemberVO vo) {
		System.out.println("===>  sdsMemberMapper sdsconid() 호출");
		List<SdsMemberVO> list =mybatis.selectList("SdsMemberDAO.sdsconid", vo);
		return list;
	}
	
	public List<SdsMemberVO> sdsconpw(SdsMemberVO vo) {
		System.out.println("===>  sdsMemberMapper conpw() 호출");
		List<SdsMemberVO> list =mybatis.selectList("SdsMemberDAO.sdsconpw", vo);
		return list;
	}
}
