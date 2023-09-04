package com.javaclass.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

public class SdsMemberVO {
	private int sdsmemcode;
	private String sdsname;
	private Date sdsdate;
	private String sdstel;
	private String sdsaddr;
	private String sdscheck;
	private String sdscard;
	private String sdsid;
	private String sdspw;
	private String sdssex;
	private String sdsnick;
	private String sdsimg; // 파일명
	private String sdsimgname; // 저장된 파일 이름 경로

	MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;

		if (!file.isEmpty()) {
			this.sdsimgname = file.getOriginalFilename();

			// 실제 저장된 파일명 만들기
			UUID uuid = UUID.randomUUID();
			sdsimg = uuid.toString() + "_" + sdsimgname;

			// ************************************************
			File f = new File(
					"C:\\Users\\lee\\git\\youth-bridge\\care\\src\\main\\webapp\\resources\\images\\sds\\" + sdsimg);
			System.out.println(sdsimg);
			try {
				file.transferTo(f);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public int getSdsmemcode() {
		return sdsmemcode;
	}

	public void setSdsmemcode(int sdsmemcode) {
		this.sdsmemcode = sdsmemcode;
		System.out.println(sdsmemcode);
	}

	public String getSdsname() {
		return sdsname;
	}

	public void setSdsname(String sdsname) {
		this.sdsname = sdsname;
		System.out.println(sdsname);
	}

	public Date getSdsdate() {
		return sdsdate;
	}

	public void setSdsdate(Date sdsdate) {
		this.sdsdate = sdsdate;
		System.out.println(sdsdate);
	}

	public String getSdstel() {
		return sdstel;
	}

	public void setSdstel(String sdstel) {
		this.sdstel = sdstel;
		System.out.println(sdstel);
	}

	public String getSdsaddr() {
		return sdsaddr;
	}

	public void setSdsaddr(String sdsaddr) {
		this.sdsaddr = sdsaddr;
		System.out.println(sdsaddr);
	}

	public String getSdscheck() {
		return sdscheck;
	}

	public void setSdscheck(String sdscheck) {
		this.sdscheck = sdscheck;
		System.out.println(sdscheck);
	}

	public String getSdscard() {
		return sdscard;
	}

	public void setSdscard(String sdscard) {
		this.sdscard = sdscard;
		System.out.println(sdscard);
	}

	public String getSdsid() {
		return sdsid;
	}

	public void setSdsid(String sdsid) {
		this.sdsid = sdsid;
		System.out.println(sdsid);
	}

	public String getSdspw() {
		return sdspw;
	}

	public void setSdspw(String sdspw) {
		this.sdspw = sdspw;
		System.out.println(sdspw);
	}

	public String getSdssex() {
		return sdssex;
	}

	public void setSdssex(String sdssex) {
		this.sdssex = sdssex;
		System.out.println(sdssex);
	}

	public String getSdsnick() {
		return sdsnick;
	}

	public void setSdsnick(String sdsnick) {
		this.sdsnick = sdsnick;
		System.out.println(sdsnick);
	}

	public String getSdsimg() {
		System.out.println(sdsimg);
		return sdsimg;
	}

	public void setSdsimg(String sdsimg) {
		this.sdsimg = sdsimg;
		System.out.println(sdsimg);
	}

	public String getSdsimgname() {
		System.out.println(sdsimgname);
		return sdsimgname;
	}

	public void setSdsimgname(String sdsimgname) {
		this.sdsimgname = sdsimgname;
		System.out.println(sdsimgname);
	}

}