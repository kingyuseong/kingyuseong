package com.javaclass.service;

import java.util.List;

import com.javaclass.domain.CategoryVO;
import com.javaclass.domain.ClinicVO;

public interface ClinicService {
	public List<CategoryVO> getGooName(CategoryVO vo);
	public List<CategoryVO> getDongName(String reggooname);
	public List<ClinicVO> getClinic(String regname);
}
