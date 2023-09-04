package com.javaclass.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.dao.SupportDAO;
import com.javaclass.domain.SupportVO;

@Service("supportService")
public class SupportServiceImpl implements SupportService{
	
	@Autowired
	private SupportDAO supportDAO;
		
	public List<SupportVO> getSupportList() {
		return supportDAO.getSupportList();
	}
	
	
	
}
