package com.javaclass.domain;

import java.util.Date;

public class EmoVO {
	private int noteemocode;	// 감정분류코드
	private int notegood;		// 긍정어
	private int notebad;		// 부정어
	private int notecode;		// 일기장코드
	private String notedate;		// 일기장 저장 날짜	(감정분류 기분이 일기장이라 감정분류 페이지에서 버튼을 일기장 저장 월 기분으로 하기 위해 저장함)
	private int memcode;		// 회원번호
	
	public int getNoteemocode() {
		return noteemocode;
	}
	public void setNoteemocode(int noteemocode) {
		this.noteemocode = noteemocode;
	}
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
	public int getNotecode() {
		return notecode;
	}
	public void setNotecode(int notecode) {
		this.notecode = notecode;
	}
	public String getNotedate() {
		return notedate;
	}
	public void setNotedate(String notedate) {
		this.notedate = notedate;
	}
	public int getMemcode() {
		return memcode;
	}
	public void setMemcode(int memcode) {
		this.memcode = memcode;
	}
	
}
