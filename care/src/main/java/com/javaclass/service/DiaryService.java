package com.javaclass.service;

import java.util.List;
import java.util.HashMap;

import com.javaclass.domain.Criteria;
import com.javaclass.domain.DiaryVO;

public interface DiaryService {
	// 일기등록
	void insertDiary(DiaryVO vo);

	// 일기 수정
	void updateDiary(DiaryVO vo);

	// 일기 삭제
	void deleteDiary(DiaryVO vo);

	// 일기 전체 조회
	List<DiaryVO> getdiaryList(HashMap map, Criteria cri);

	// 일기 상세보기
	public DiaryVO getDiary(DiaryVO vo);

	// 감정분류 (감정그래프) 인서트
	void insertEmotions(DiaryVO vo);

	public DiaryVO selectDiaryLately(DiaryVO vo);

	// 감전분류 업데이트
	void updateEmotions(DiaryVO vo);

	DiaryVO selectDiaryUpdate(DiaryVO vo);

	// 감정분ㄹ 삭제
	void deleteEmotions(DiaryVO vo);

	

}
