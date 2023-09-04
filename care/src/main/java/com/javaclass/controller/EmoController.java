package com.javaclass.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.javaclass.domain.EmoVO;
import com.javaclass.service.EmoService;

@Controller
public class EmoController {

	@Autowired
	private EmoService emoService;

	// 감정그래프 전체 리스트 가져오기
	@RequestMapping(value = "/emotions.do")
	public void getDiaryList(EmoVO vo, Model model) throws IOException {
		System.out.println("감정그래프  날짜 : "+vo.getNotedate() + "/ 사람토드 : " + vo.getMemcode());
		List<EmoVO> emoDate = emoService.getemoList(vo);
		model.addAttribute("EmoList", emoDate);

	}

	// 상세 조회
	@RequestMapping("/emotions_see.do")
	public void getBoard(EmoVO vo, Model model) {
		System.out.println(" 그래프 상세조회 날짜 :"+vo.getNotedate() + "/ 사람코드 : " + vo.getMemcode());
		
		vo.setNotedate(vo.getNotedate() + "-01");

		String noedate = vo.getNotedate().substring(0, 4) + "년 " + vo.getNotedate().substring(5, 7) + "월";

		System.out.println(" emoService / " + emoService.getEmo(vo));
		
		
		List<EmoVO> emoGraphDat = emoService.getEmo(vo);
		
		// 클릭시 넘어오는 버튼의 달력
		//System.out.println("notdate : "+vo.getNotedate());
		

		Gson gson = new Gson();
		JsonArray jArray = new JsonArray();

		// 그래프를 그리기 위해 데이터를 json 형식으로 만듬
		Iterator<EmoVO> it = emoGraphDat.iterator();
		while (it.hasNext()) {
			EmoVO emoVO = it.next();
			JsonObject object = new JsonObject();

			int good = emoVO.getNotegood();
			int bad = emoVO.getNotebad();
			String date = emoVO.getNotedate();

			object.addProperty("good", good);
			object.addProperty("bad", bad);
			object.addProperty("date", date);
			jArray.add(object);
		}
		String json = gson.toJson(jArray);
		System.out.println(json);

		model.addAttribute("emo", emoGraphDat); // Model 정보 저장
		model.addAttribute("noedate", noedate); // 변수 딱 하나만 보냄

	}

}