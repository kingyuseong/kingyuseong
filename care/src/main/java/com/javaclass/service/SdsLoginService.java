package com.javaclass.service;

import java.util.List;

import com.javaclass.domain.LoginVO;
import com.javaclass.domain.SdsLoginVO;

public interface SdsLoginService {
		//로그인
		public SdsLoginVO sdsLogin(SdsLoginVO vo);
		//마이페이지
		public List<SdsLoginVO> sdsList(SdsLoginVO vo);
		//정보수정창
		public List<SdsLoginVO> sdsmemUp(SdsLoginVO vo);
		//정보수정update
		public void updatesdsmember(SdsLoginVO vo);
}
