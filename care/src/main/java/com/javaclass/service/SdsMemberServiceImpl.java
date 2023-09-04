package com.javaclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.dao.SdsMemberDAO;
import com.javaclass.dao.SdsMemberDAOImpl;
import com.javaclass.domain.SdsMemberVO;

@Service("sdsmemberService")
public class SdsMemberServiceImpl implements SdsMemberService {
	@Autowired
	private SdsMemberDAO sdsmemberDAO;
	
	@Autowired
	private SdsMemberDAOImpl sdsmemberdaoimpl;
	
	@Override
	public SdsMemberVO sdsidCheck_Login(SdsMemberVO vo) {
		return sdsmemberDAO.sdsIdCheck(vo);
	}
	
	@Override
	public SdsMemberVO sdsnickCheck_Login(SdsMemberVO vo) {
		return sdsmemberDAO.sdsNickCheck(vo);
	}
	
	@Override
	public void sdsMemberInsert(SdsMemberVO vo) {
		System.out.println("sdsMemberInsert service에서 소환");
		sdsmemberDAO.sdsMemberInsert(vo);
	}
	
	public void sdsmemberDelete(SdsMemberVO vo) {
		sdsmemberDAO.sdsmemberDelete(vo);
	}
	
	public List<SdsMemberVO> sdsconid(SdsMemberVO vo) {
		System.out.println("conid service에서 소환");
		return sdsmemberdaoimpl.sdsconid(vo);
	}
	
	public List<SdsMemberVO> sdsconpw(SdsMemberVO vo) {
		System.out.println("conpw service에서 소환");
		return sdsmemberdaoimpl.sdsconpw(vo);
	}
}
