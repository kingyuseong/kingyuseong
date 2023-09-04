package com.javaclass.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaclass.domain.MemberVO;

@Repository("MemberDAO")
public class MemberDAOImpl implements MemberDAO {
		
		@Autowired
		private SqlSessionTemplate mybatis;

		@Override
		public MemberVO idCheck(MemberVO vo) {
			System.out.println("===>  MemberMapper idCheck() 호출");
			return mybatis.selectOne("MemberDAO.idCheck", vo);
		}
		
		@Override
		public MemberVO nickCheck(MemberVO vo) {
			System.out.println("===>  MemberMapper nickCheck() 호출");
			return mybatis.selectOne("MemberDAO.nickCheck", vo);
		}
		
		public void memberInsert(MemberVO vo) {
			System.out.println("===>  MemberMapper memberInsert() 호출");
			mybatis.insert("MemberDAO.memberInsert", vo);
		}
		
		public void memberDelete(MemberVO vo) {
			System.out.println("===>  MemberMapper memberDelete() 호출");
			mybatis.delete("MemberDAO.memberDelete", vo);
		}
		
		public List<MemberVO> conid(MemberVO vo) {
			System.out.println("===>  MemberMapper conid() 호출");
			List<MemberVO> list =mybatis.selectList("MemberDAO.conid", vo);
			return list;
		}
		
		public List<MemberVO> conpw(MemberVO vo) {
			System.out.println("===>  MemberMapper conpw() 호출");
			List<MemberVO> list =mybatis.selectList("MemberDAO.conpw", vo);
			return list;
		}
		
		@Override
	       public MemberVO getMemberById(String id) {
	           System.out.println("===>  MemberMapper getMemberById() 호출");
	           return mybatis.selectOne("MemberDAO.getMemberById", id);
	       }
}
