package com.javaclass.dao;

import java.util.List;

import com.javaclass.domain.CategoryVO;
import com.javaclass.domain.ClinicVO;


public interface ClinicDAO {
    // 모든 자치구 이름 가져오기
    List<CategoryVO> getGooName(CategoryVO vo);

    // 동 이름 가져오기
    List<CategoryVO> getDongName(String reggooname);

    // 센터이름 가져오기
    List<ClinicVO> getClinic(String regname);
}
