package com.javaclass.domain;

import java.util.Date;

//VO(Value Object)

public class DiaryVO {

	private int notecode; // 일기번호
	private int memcode;	// 회원번호
	private String notetitle; //일기 제목
	private String notesun; // 일기 날씨
	private String notecontent; // 일기 내용
	private Date notedate; // 일기 날짜
	private int notegood;	// 감정 긍저엉
	private int notebad;		// 감정 부정어
	private int noteemocode;	// 감전분류코드
	
	
	
	public int getNoteemocode() {
		return noteemocode;
	}
	public void setNoteemocode(int noteemocode) {
		this.noteemocode = noteemocode;
	}
	public int getNotecode() {
		return notecode;
	}
	public void setNotecode(int notecode) {
		this.notecode = notecode;
	}
	public int getMemcode() {
		return memcode;
	}
	public void setMemcode(int memcode) {
		this.memcode = memcode;
	}
	public String getNotetitle() {
		return notetitle;
	}
	public void setNotetitle(String notetitle) {
		this.notetitle = notetitle;
	}
	public String getNotesun() {
		return notesun;
	}
	public void setNotesun(String notesun) {
		this.notesun = notesun;
	}
	public String getNotecontent() {
		return notecontent;
	}
	public void setNotecontent(String notecontent) {
		this.notecontent = notecontent;
	}
	public Date getNotedate() {
		return notedate;
	}
	public void setNotedate(Date notedate) {
		this.notedate = notedate;
	}
	
	//감정그래프 
	public int getNotegood() {
		return notegood;
	}
	public void setNotegood(int notegood) {
		this.notegood = notegood;
	}
	public int getNotebad() {
		return notebad;
	}
	public void setNotebad(int notebad) {
		this.notebad = notebad;
	}
	
}