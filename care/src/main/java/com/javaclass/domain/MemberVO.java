package com.javaclass.domain;

import java.util.Date;

public class MemberVO {
	private int memcode;
	private String name;
	private Date memdate;
	private String tel;
	private String addr;
	private String id;
	private String pw;
	private String sex; 
	private String grade;
	private String nick;
	
	
	
	public int getMemcode() {
		return memcode;
	}

	public void setMemcode(int memcode) {
		this.memcode = memcode;
		System.out.println(memcode);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println(name);
	}
	
	public Date getMemdate() {
		return memdate;
	}

	public void setMemdate(Date memdate) {
		this.memdate = memdate;
		System.out.println(memdate);
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
		System.out.println(tel);
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
		System.out.println(addr);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		System.out.println(id);
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
		System.out.println(pw);
	}

	
	public String getSex() {
		return sex; 
	}
	 
	 public void setSex(String sex) {
		this.sex = sex;
		System.out.println(sex); 
	}
	
	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
		System.out.println(grade);
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
		System.out.println(nick);
	}

	
}
