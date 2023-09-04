package com.javaclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.dao.ReserveDAO;
import com.javaclass.domain.ReserveVO;

@Service("ReserveService")
public class ReserveServiceImpl implements ReserveService {
    private final ReserveDAO reserveDAO;

    @Autowired
    public ReserveServiceImpl(ReserveDAO reserveDAO) {
        this.reserveDAO = reserveDAO;
    }
    //일정 출력 부분
    @Override
    public List<ReserveVO> getEventList(ReserveVO vo) {
        return reserveDAO.getEventList(vo);
    }
    
    //시작일정 중복체크 부분
    public ReserveVO dateCheck_start(ReserveVO vo) {
    	 return reserveDAO.dateCheck(vo);
     }
    
    
    //일정 입력 부분
    public void insertReserve(ReserveVO vo) {
    	reserveDAO.insertReserve(vo);
    }
    
    //일정 수정 부분
  	public void updateReserve(ReserveVO vo) {
  		reserveDAO.updateReserve(vo);
  	}

  	//일정 삭제 부분
  	public void deleteReserve(ReserveVO vo) {
  		reserveDAO.deleteReserve(vo);
  	}
	
  	//일정 중복 방지 부분
  	public boolean isDateAvailable(String startdate, String enddate, int sdsmemcode) {
        List<ReserveVO> existingEvents = reserveDAO.getEventsInRange(startdate, enddate, sdsmemcode);
        return existingEvents.isEmpty(); // 이미 일정이 있는 경우 false 반환
    }
}
