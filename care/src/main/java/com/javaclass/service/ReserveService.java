package com.javaclass.service;

import com.javaclass.domain.ReserveVO;

import java.util.List;

public interface ReserveService {
	//일정 출력 부분
    List<ReserveVO> getEventList(ReserveVO vo);
    
    //시작 일정 중복체크 부분
    public ReserveVO dateCheck_start(ReserveVO vo);
    
    //일정 입력 부분
    public void insertReserve(ReserveVO vo);
    
    //일정 수정 부분
    public void updateReserve(ReserveVO vo);

    //일정 삭제 부분
    public void deleteReserve(ReserveVO vo);
    
    //일정 중복 방지
    boolean isDateAvailable(String startdate, String enddate, int sdsmemcode);
}
