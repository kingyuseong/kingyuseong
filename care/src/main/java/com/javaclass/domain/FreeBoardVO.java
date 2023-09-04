package com.javaclass.domain;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FreeBoardVO {
	private int freecode;
	private String freetitle;
	private Date freedate;
	private String freecontent;
	private int memcode;
	private MemberVO member;
	private String freeimg;
	private String freeimgname;

	MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;

		if (!file.isEmpty()) {
			this.freeimgname = file.getOriginalFilename();

			// 실제 저장된 파일명 만들기
			UUID uuid = UUID.randomUUID();
			freeimg = uuid.toString() + "_" + freeimgname;

			// ************************************************
			File f = new File(
					"C:\\Users\\lee\\git\\youth-bridge\\care\\src\\main\\webapp\\resources\\images\\free\\" + freeimg);
			System.out.println(freeimg);
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

	public MemberVO getMember() {
		return member;
	}

	public void setMember(MemberVO member) {
		this.member = member;
	}

	public int getFreecode() {
		return freecode;
	}

	public void setFreecode(int freecode) {
		this.freecode = freecode;
	}

	public String getFreetitle() {
		return freetitle;
	}

	public void setFreetitle(String freetitle) {
		this.freetitle = freetitle;
	}

	public Date getFreedate() {
		return freedate;
	}

	public void setFreedate(Date freedate) {
		this.freedate = freedate;
	}

	public String getFreecontent() {
		return freecontent;
	}

	public void setFreecontent(String freecontent) {
		this.freecontent = freecontent;
	}

	public int getMemcode() {
		return memcode;
	}

	public void setMemcode(int memcode) {
		this.memcode = memcode;
	}

	public String getFreeimg() {
		System.out.println(freeimg);
		return freeimg;
	}

	public void setFreeimg(String freeimg) {
		this.freeimg = freeimg;
	}

	public String getFreeimgname() {
		System.out.println(freeimgname);
		return freeimgname;
	}

	public void setFreeimgname(String freeimgname) {
		this.freeimgname = freeimgname;
	}

}
