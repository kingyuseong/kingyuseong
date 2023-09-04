package com.javaclass.service;

import java.util.List;

import com.javaclass.domain.JobVO;

public interface JobService {

	// 글 목록 조회
	List<JobVO> jobList(JobVO vo);

}
