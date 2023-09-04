package com.javaclass.controller;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaclass.domain.BucketVO;
import com.javaclass.domain.Criteria;
import com.javaclass.domain.DiaryVO;
import com.javaclass.domain.PageVO;
import com.javaclass.service.BucketService;

@Controller
public class BucketController {

	@Autowired
	private BucketService bucketService;

	// 버킷리스트 목록
	@RequestMapping(value = "/bucket_list.do") // 버킷리스트는 전부 jsp에서 momcode 전부 다 보내줘야함
	public void getDiaryList(String searchCondition, String searchKeyword, Model model, BucketVO vo, Criteria cri)
			throws IOException {
		HashMap map = new HashMap();
		map.put("searchCondition", searchCondition);
		map.put("searchKeyword", searchKeyword);
		System.out.println("버킷리스트  사용자코드  : " + vo.getMemcode());
		map.put("memcode", vo.getMemcode());

		BucketVO bvo = bucketService.DiarySum(vo);
		System.out.println("컨트롤러" + bvo.getAllsum() + " / 달성" + bvo.getYessum());

		model.addAttribute("bucketList", bucketService.getBucketList(map, cri));
		model.addAttribute("pageMaker", new PageVO(cri, 123));
		model.addAttribute("bucketSum", bvo);
	}

	// 버킷리스트 입력
	@RequestMapping(value = "/inserBucket.do")
	public String inserBucket(BucketVO vo, Model model) {
		bucketService.insertBucket(vo);
		System.out.println("버킷리스트 인서트 : " + vo.getMemcode());

		return "redirect:/bucket_list.do?memcode="+vo.getMemcode();
	}

	// 버킷리스트 수정
	@RequestMapping("/updateBucket.do")
	public String updateDiary(@ModelAttribute("bucket") BucketVO vo) { // BoardVO board
		System.out.println(vo.getListcode() + " 업데이트 클래스");
		bucketService.updateBucket(vo);
		return "redirect:/bucket_list.do?memcode="+vo.getMemcode();
	}

	// 버킷 삭제
	@RequestMapping("/deleteBucket.do")
	public String deleteDiary(BucketVO vo) {
		bucketService.deleteBucket(vo);
		return "redirect:/bucket_list.do?memcode="+vo.getMemcode();
	}

}
