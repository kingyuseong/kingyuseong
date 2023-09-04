package com.javaclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.dao.MemberDAO;
import com.javaclass.dao.MemberDAOImpl;
import com.javaclass.domain.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private MemberDAOImpl memberdaoimpl;

	public MemberVO idCheck_Login(MemberVO vo) {
		return memberDAO.idCheck(vo);
	}

	public MemberVO nickCheck_Login(MemberVO vo) {
		return memberDAO.nickCheck(vo);
	}

	public void memberInsert(MemberVO vo) {
		memberDAO.memberInsert(vo);
	}

	public void memberDelete(MemberVO vo) {
		memberDAO.memberDelete(vo);
	}

	public List<MemberVO> conid(MemberVO vo) {
		System.out.println("conid service에서 소환");
		return memberdaoimpl.conid(vo);
	}

	public List<MemberVO> conpw(MemberVO vo) {
		System.out.println("conpw service에서 소환");
		return memberdaoimpl.conpw(vo);
	}

	@Override
	public MemberVO getMemberById(String id) {
		return memberDAO.getMemberById(id);
	}
}
