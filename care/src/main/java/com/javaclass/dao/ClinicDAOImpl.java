package com.javaclass.dao;

import java.util.List;

import javax.swing.plaf.synth.Region;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaclass.domain.CategoryVO;
import com.javaclass.domain.ClinicVO;

@Repository
public class ClinicDAOImpl implements ClinicDAO {

    @Autowired
    private SqlSessionTemplate mybatis;

   

    @Override
    public List<CategoryVO> getGooName(CategoryVO vo) {
        System.out.println("===> Mybatis getGooName() 호출");
         List<CategoryVO> list = mybatis.selectList("ClinicDAO.getGooName",vo);
         return list;
    }

    @Override
    public List<CategoryVO> getDongName(String reggooname) {
        System.out.println("===> Mybatis getRegion() 호출");
         List<CategoryVO> list = mybatis.selectList("ClinicDAO.getDongName", reggooname);
         return list;
    }

	@Override
	public List<ClinicVO> getClinic(String regname) {
		System.out.println("==> Mybatis getClinic()");
		List<ClinicVO> list = mybatis.selectList("ClinicDAO.getClinic",regname);
		return list;
	}

}
