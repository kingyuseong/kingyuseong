package com.javaclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.dao.SdsLoginDAO;
import com.javaclass.dao.SdsLoginDAOImpl;
import com.javaclass.domain.SdsLoginVO;

@Service("SdsLoginService")
public class SdsLoginServiceImpl implements SdsLoginService {
		
	@Autowired
	private SdsLoginDAO sdslogindao;
	
	@Autowired
	private SdsLoginDAOImpl sdslogindaoimpl;
	
	//로그인
	public SdsLoginVO sdsLogin(SdsLoginVO vo) {
		return sdslogindao.sdsLogin(vo);
	}
	
	//마이페이지 정보
	public List<SdsLoginVO> sdsList(SdsLoginVO vo) {
		System.out.println("sdsList에서 소환");
		return sdslogindaoimpl.sdsList(vo);
	}
	
	//회원정보 수정페이지
	public List<SdsLoginVO> sdsmemUp(SdsLoginVO vo) {
		System.out.println("sdsmemUp에서 소환");
		return sdslogindaoimpl.sdsmemUp(vo);
	}
	
	//상담사정보 수정할때 이용
	public void updatesdsmember(SdsLoginVO vo) {
		System.out.println("sdsService에서 소환");
		sdslogindao.updatesdsmember(vo);
	}
}
