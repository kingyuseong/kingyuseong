package com.javaclass.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openkoreantext.processor.OpenKoreanTextProcessorJava;
import org.openkoreantext.processor.tokenizer.KoreanTokenizer;
import org.openkoreantext.processor.tokenizer.KoreanTokenizer.KoreanToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import scala.collection.immutable.Seq;

import com.javaclass.domain.Criteria;
import com.javaclass.domain.DiaryVO;
import com.javaclass.domain.PageVO;
import com.javaclass.service.DiaryService;

@Controller
public class DiaryController {

	@Autowired
	private DiaryService diaryService;

	// 일기장 전체 리스트 가져오기
	@RequestMapping(value = "/diary.do")
	public void getDiaryList(String searchCondition, String searchKeyword, Model model, DiaryVO vo, Criteria cri) throws IOException {
		System.out.println("일기장 리스트 옴!!!" + searchCondition + " " + searchKeyword + "");
		HashMap map = new HashMap();
		map.put("searchCondition", searchCondition);
		map.put("searchKeyword", searchKeyword);
		System.out.println("일기장  목록 회원코드 : "+vo.getMemcode());
		map.put("memcode",vo.getMemcode());

		model.addAttribute("deleteList", diaryService.getdiaryList(map, cri));
		model.addAttribute("pageMaker", new PageVO(cri, 123));
	}

	// 글 상세 조회
	@RequestMapping("/diary_see.do")
	public void getBoard(DiaryVO vo, Model model) {
		// System.out.println("글 상세 조회 옴!!" + " notecode글코드 :"+ vo.getNotecode() + "
		// memcode회원번호 " + vo.getMemcode());
		model.addAttribute("diary", diaryService.getDiary(vo)); // Model 정보 저장
	}

	// 일기장 등록
	@RequestMapping(value = "/insertDiary.do")
	public String inserDiary(DiaryVO vo, Model model) {
		// 일기장 인서트하러가는 곳
		diaryService.insertDiary(vo);

		String content = vo.getNotecontent();
		int mem = vo.getMemcode();

		// 긍정단어 부정단어 개수를 세기위한 변수
		int good = 0;
		int bad = 0;
		int mediocrity = 0;

		// json 파일 읽어옴
		JSONParser parser = new JSONParser();
		FileReader playerFile = null;
		JSONArray dateArray = null;

		ClassPathResource jsonFile = new ClassPathResource("SentiWord_info.json");

		try {
			playerFile = new FileReader(jsonFile.getFile());
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// json 파일 읽어옴
		try {
			dateArray = (JSONArray) parser.parse(playerFile);
		} catch (Exception e) {
			// TODO: handle exception
		}

		// https://github.com/open-korean-text/open-korean-text
		// KoNLPy를 이용한 단어전처리
		CharSequence normalized = OpenKoreanTextProcessorJava.normalize(content);
		Seq<KoreanTokenizer.KoreanToken> tokens = (Seq<KoreanToken>) OpenKoreanTextProcessorJava.tokenize(normalized);

		List<String> cleanWords = new ArrayList<>();

		for (KoreanToken token : scala.collection.JavaConverters.seqAsJavaList(tokens)) {
			// Noun 동사, Verb 명사, Adjective 형용사
			if (token.pos().toString().startsWith("Noun") || token.pos().toString().startsWith("Verb")
					|| token.pos().toString().startsWith("Adjective")) {
				cleanWords.add(token.text());
			}
		}
		// System.out.println(cleanWords);

		// 전처리된 단어와 json파일 비교해 긍정,부정 점수 매김
		for (int i = 0; i < cleanWords.size(); i++) {
			int sum = 0;
			for (int j = 0; j < dateArray.size(); j++) {

				JSONObject element = (JSONObject) dateArray.get(j);
				String word = (String) element.get("word");
				String word_root = (String) element.get("word_root");
				String polarity = (String) element.get("polarity");

				if (sum == 0) {
					if (word.contains(cleanWords.get(i)) || word_root.contains(cleanWords.get(i))) {
						// System.out.println(cleanWords.get(i) + " / " + word + " " + polarity);
						if (Integer.parseInt(polarity) > 0) {
							good++;
						} else if (Integer.parseInt(polarity) < 0) {
							bad++;
						} else {
							mediocrity++;
						}

						sum++;
					}
				}

			}
		}
		
		// 방금 저장된 글 번호 가져오기 위해서
		DiaryVO latestNoteCode = diaryService.selectDiaryLately(vo);
		System.out.println("글번호 가져옴 :" + latestNoteCode.getNotecode());
		vo.setNotecode(latestNoteCode.getNotecode());
		vo.setNotegood(good);
		vo.setNotebad(bad);
		
		diaryService.insertEmotions(vo);

		return "redirect:/diary.do?memcode=" + vo.getMemcode();
	}

	// 일기장 수정
	@RequestMapping("/updateDiary.do")
	public String updateDiary(@ModelAttribute("diary") DiaryVO vo) { // BoardVO board
		// System.out.println("일기장 수정하기 옴!!" + " notecode글코드 :" + vo.getNotecode() + "
		// memcode회원번호 " + vo.getMemcode());
		diaryService.updateDiary(vo);

		
		String content = vo.getNotecontent();
		int mem = vo.getMemcode();
		int notecode = vo.getNotecode();	// 감정그래프도 수정할려고

		// 긍정단어 부정단어 개수를 세기위한 변수
		int good = 0;
		int bad = 0;
		int mediocrity = 0;

		// json 파일 읽어옴
		JSONParser parser = new JSONParser();
		FileReader playerFile = null;
		JSONArray dateArray = null;

		ClassPathResource jsonFile = new ClassPathResource("SentiWord_info.json");

		try {
			playerFile = new FileReader(jsonFile.getFile());
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// json 파일 읽어옴
		try {
			dateArray = (JSONArray) parser.parse(playerFile);
		} catch (Exception e) {
			// TODO: handle exception
		}

		// https://github.com/open-korean-text/open-korean-text
		// KoNLPy를 이용한 단어전처리
		CharSequence normalized = OpenKoreanTextProcessorJava.normalize(content);
		Seq<KoreanTokenizer.KoreanToken> tokens = (Seq<KoreanToken>) OpenKoreanTextProcessorJava.tokenize(normalized);

		List<String> cleanWords = new ArrayList<>();

		for (KoreanToken token : scala.collection.JavaConverters.seqAsJavaList(tokens)) {
			// Noun 동사, Verb 명사, Adjective 형용사
			if (token.pos().toString().startsWith("Noun") || token.pos().toString().startsWith("Verb")
					|| token.pos().toString().startsWith("Adjective")) {
				cleanWords.add(token.text());
			}
		}
		// System.out.println(cleanWords);

		// 전처리된 단어와 json파일 비교해 긍정,부정 점수 매김
		for (int i = 0; i < cleanWords.size(); i++) {
			int sum = 0;
			for (int j = 0; j < dateArray.size(); j++) {

				JSONObject element = (JSONObject) dateArray.get(j);
				String word = (String) element.get("word");
				String word_root = (String) element.get("word_root");
				String polarity = (String) element.get("polarity");

				if (sum == 0) {
					if (word.contains(cleanWords.get(i)) || word_root.contains(cleanWords.get(i))) {
						// System.out.println(cleanWords.get(i) + " / " + word + " " + polarity);
						if (Integer.parseInt(polarity) > 0) {
							good++;
						} else if (Integer.parseInt(polarity) < 0) {
							bad++;
						} else {
							mediocrity++;
						}

						sum++;
					}
				}

			}
		}
		vo.setNotecode(notecode);
		vo.setNotegood(good);
		vo.setNotebad(bad);
		
		diaryService.updateEmotions(vo);

		return "redirect:/diary.do?memcode=" + vo.getMemcode();
	}

	// 일기장 삭제
	@RequestMapping("/deleteDiary.do")
	public String deleteDiary(DiaryVO vo) {
		System.out.println("일기장 삭제하기 옴!! 글번호notecode" + vo.getNotecode());
		diaryService.deleteEmotions(vo);
		diaryService.deleteDiary(vo);
		return "redirect:/diary.do?memcode="+ vo.getMemcode();
	}

}
