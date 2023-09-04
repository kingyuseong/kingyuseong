 package com.javaclass.domain;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class LoginVO {
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
		System.out.println(memcode);
		this.memcode = memcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println(name);
		this.name = name;
	}
	public Date getMemdate() {
		return memdate;
	}
	public void setMemdate(Date memdate) {
		System.out.println(memdate);
		this.memdate = memdate;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		System.out.println(tel);
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		System.out.println(addr);
		this.addr = addr;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		System.out.println(pw);
		this.pw = pw;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getGrade() {
		System.out.println(grade);
		return grade;
	}
	public void setGrade(String grade) {
		System.out.println(grade);
		this.grade = grade;
	}
	public String getNick() {
		System.out.println(nick);
		return nick;
	}
	public void setNick(String nick) {
		System.out.println(nick);
		this.nick = nick;
	}
	
	
	
	
	
}
