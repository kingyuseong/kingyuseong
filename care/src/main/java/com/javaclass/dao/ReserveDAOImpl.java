package com.javaclass.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaclass.domain.ReserveVO;

@Repository
public class ReserveDAOImpl implements ReserveDAO {
    private final SqlSession sqlSession;
    
    @Autowired
    public ReserveDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    
    @Autowired
	private SqlSessionTemplate mybatis;
    
    //일정 출력부분
    @Override
    public List<ReserveVO> getEventList(ReserveVO vo) {
        return sqlSession.selectList("ReserveDAO.getEventList", vo);
    }
    
    //일정 입력부분
    public void insertReserve(ReserveVO vo) {
    	System.out.println("===>  ReserveMapper insertReserve() 호출");
    	mybatis.insert("ReserveDAO.insertReserve", vo);
    }
    
    //일정 수정부분
    public void updateReserve(ReserveVO vo) {
    	System.out.println("===>  ReserveMapper updateReserve() 호출");
    	mybatis.update("ReserveDAO.updateReserve", vo);
    }

    //일정 삭제부분
    public void deleteReserve(ReserveVO vo) {
    	System.out.println("===>  ReserveMapper deleteReserve() 호출");
    	mybatis.delete("ReserveDAO.deleteReserve", vo);
    }
    
    //시작일정 중복 확인 부분
    public ReserveVO dateCheck(ReserveVO vo) {
    	System.out.println("===>  ReserveMapper dateCheck() 호출");
    	return mybatis.selectOne("ReserveDAO.dateCheck", vo);
    }
    
    //일정 중복 방지부분
    public List<ReserveVO> getEventsInRange(String startdate, String enddate, int sdsmemcode) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("startdate", startdate);
        parameters.put("enddate", enddate);
        parameters.put("sdsmemcode", sdsmemcode);
        return sqlSession.selectList("ReserveDAO.getEventsInRange", parameters);
    }
}
