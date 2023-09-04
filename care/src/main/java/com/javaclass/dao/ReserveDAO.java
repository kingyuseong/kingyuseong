package com.javaclass.dao;

import com.javaclass.domain.ReserveVO;

import java.util.List;

public interface ReserveDAO {
	// 풀캘린더에 일정 나오는 부분
    List<ReserveVO> getEventList(ReserveVO vo);
    
    // 시작일정 중복체크
    ReserveVO dateCheck(ReserveVO vo);
    
    
    // 일정 입력 부분
    public void insertReserve(ReserveVO vo);
    
    // 일정 수정 부분
    public void updateReserve(ReserveVO vo);
    
    // 일정 삭제 부분
    public void deleteReserve(ReserveVO vo);
    
    // 일정 중복 방지 부분
    List<ReserveVO> getEventsInRange(String startdate, String enddate, int sdsmemcode);
}
