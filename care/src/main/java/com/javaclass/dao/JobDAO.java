package com.javaclass.dao;

import java.util.List;

import com.javaclass.domain.JobVO;


public interface JobDAO {
	
	public List<JobVO> jobList(JobVO vo);
	
}