package com.javaclass.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaclass.domain.JobVO;



@Repository("jobDAO")
public class JobDAOImpl implements JobDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public List<JobVO> jobList(JobVO vo) {
		System.out.println("===> Mybatis jobList() 호출");
		List<JobVO> list = mybatis.selectList("JobDAO.jobList", vo);
		return list;
	}



}
