package com.javaclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.dao.ClinicDAO;
import com.javaclass.domain.CategoryVO;
import com.javaclass.domain.ClinicVO;


@Service("clinicService")
public class ClinicServiceImpl implements ClinicService {

	 @Autowired
	    private ClinicDAO clinicDAO;

	   //구 카테고리
	    @Override
	    public List<CategoryVO> getGooName(CategoryVO vo) {
	        return clinicDAO.getGooName(vo);
	    }
	    
	    //동 카테고리
	    @Override
	    public List<CategoryVO> getDongName(String reggooname) {
	        return clinicDAO.getDongName(reggooname);
	    }

		@Override
		public List<ClinicVO> getClinic(String regname) {
			return clinicDAO.getClinic(regname);
		}
	}