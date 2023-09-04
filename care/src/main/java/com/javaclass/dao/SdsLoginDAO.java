package com.javaclass.dao;

import java.util.List;

import com.javaclass.domain.SdsLoginVO;

public interface SdsLoginDAO {
		public SdsLoginVO sdsLogin(SdsLoginVO vo);

		public List<SdsLoginVO> sdsList(SdsLoginVO vo);

		public List<SdsLoginVO> sdsmemUp(SdsLoginVO vo);

		public void updatesdsmember(SdsLoginVO vo);
}
