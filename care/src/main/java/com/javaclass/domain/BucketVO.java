package com.javaclass.domain;

import java.util.Date;

public class BucketVO {
	int listcode;		//버킷리스트코드
	String listtitle;	//제목
	String listgoal;	//달성여부
	Date listdate;		//등록일
	Date listgoaldate;	//달성날짜
	int memcode;		//회원코드
	int allsum;	// 전체
	int yessum;	// 달성
	
	public int getListcode() {
		return listcode;
	}
	public void setListcode(int listcode) {
		this.listcode = listcode;
	}
	public String getListtitle() {
		return listtitle;
	}
	public void setListtitle(String listtitle) {
		this.listtitle = listtitle;
	}
	public String getListgoal() {
		return listgoal;
	}
	public void setListgoal(String listgoal) {
		this.listgoal = listgoal;
	}
	public Date getListdate() {
		return listdate;
	}
	public void setListdate(Date listdate) {
		this.listdate = listdate;
	}
	public Date getListgoaldate() {
		return listgoaldate;
	}
	public void setListgoaldate(Date listgoaldate) {
		this.listgoaldate = listgoaldate;
	}
	public int getMemcode() {
		return memcode;
	}
	public void setMemcode(int memcode) {
		this.memcode = memcode;
	}

	public int getAllsum() {
		return allsum;
	}
	public void setAllsum(int allsum) {
		this.allsum = allsum;
	}
	public int getYessum() {
		return yessum;
	}
	public void setYessum(int yessum) {
		this.yessum = yessum;
	}
	
	
	
}
