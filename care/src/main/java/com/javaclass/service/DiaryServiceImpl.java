package com.javaclass.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclass.dao.DiaryDAO;
import com.javaclass.domain.Criteria;
import com.javaclass.domain.DiaryVO;

@Service("diaryService")
public class DiaryServiceImpl implements DiaryService {

	@Autowired
	private DiaryDAO diaryDAO;

	public void insertDiary(DiaryVO vo) {
		// System.out.println("인서트 서비스 옴 : " + vo.getNotetitle() + vo.getNotecontent() +
		// vo.getNotesun());
		diaryDAO.insertDiary(vo);
	}

	public void updateDiary(DiaryVO vo) {
		diaryDAO.updateDiary(vo);
	}

	public void deleteDiary(DiaryVO vo) {
		diaryDAO.deleteDiary(vo);
	}

	@Override
	public List<DiaryVO> getdiaryList(HashMap map, Criteria cri) {
		// TODO Auto-generated method stub
		return diaryDAO.getdiaryList(map, cri);
	}

	@Override
	public DiaryVO getDiary(DiaryVO vo) {
		return diaryDAO.getDiary(vo);

	}

	// 감정분류 (감정그래프) 인서트
	@Override
	public void insertEmotions(DiaryVO vo) {
		// TODO Auto-generated method stub
		System.out
				.println("감정분류 인서트 옴 : " + vo.getNotegood() + " 부정 : " + vo.getNotebad() + "코드 : " + vo.getNotecode());
		diaryDAO.insertEmotions(vo);

	}

	@Override
	public DiaryVO selectDiaryLately(DiaryVO vo) {
		// TODO Auto-generated method stub
		return diaryDAO.selectDiaryLately(vo);
	}

	// 감정분류 업데이트
	@Override
	public void updateEmotions(DiaryVO vo) {
		diaryDAO.updateEmotions(vo);

	}

	@Override
	public DiaryVO selectDiaryUpdate(DiaryVO vo) {
		// TODO Auto-generated method stub
		return diaryDAO.selectDiaryUpdate(vo);
	}

	@Override
	public void deleteEmotions(DiaryVO vo) {
		diaryDAO.deleteEmotions(vo);

	}

}