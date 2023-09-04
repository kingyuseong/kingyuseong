package com.javaclass.service;

import java.util.List;

import com.javaclass.domain.SdsMemberVO;

public interface SdsMemberService {
	public SdsMemberVO sdsidCheck_Login(SdsMemberVO vo);
	public SdsMemberVO sdsnickCheck_Login(SdsMemberVO vo);
	public List<SdsMemberVO> sdsconid(SdsMemberVO vo);
	public List<SdsMemberVO> sdsconpw(SdsMemberVO vo);
	public void sdsMemberInsert(SdsMemberVO vo);
	public void sdsmemberDelete(SdsMemberVO vo);
}
