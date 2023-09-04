package com.javaclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.dao.JobDAOImpl;
import com.javaclass.domain.JobVO;


@Service("jobService")
public class JobServiceImpl implements JobService {
	
	@Autowired
	private JobDAOImpl jobDAO;
	
	@Override
	public List<JobVO> jobList(JobVO vo) {
		System.out.println(vo);
		return jobDAO.jobList(vo);
	}
}
