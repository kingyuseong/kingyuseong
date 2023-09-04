package com.javaclass.domain;

public class SdsReserveVO {
	private int srcode;
	private String sctitle;
	private String sdsstartdate;
	private String sdsenddate;
	private int sdsmemcode;

	public int getSrcode() {
		System.out.println("getmrcode"+srcode);
		return srcode;
	}

	public void setSrcode(int srcode) {
		this.srcode = srcode;
	}

	public String getSctitle() {
		return sctitle;
	}

	public void setSctitle(String sctitle) {
		this.sctitle = sctitle;
	}

	public String getSdsstartdate() {
		return sdsstartdate;
	}

	public void setSdsstartdate(String sdsstartdate) {
		this.sdsstartdate = sdsstartdate;
	}

	public String getSdsenddate() {
		return sdsenddate;
	}

	public void setSdsenddate(String sdsenddate) {
		this.sdsenddate = sdsenddate;
	}

	public int getSdsmemcode() {
		return sdsmemcode;
	}

	public void setSdsmemcode(int sdsmemcode) {
		this.sdsmemcode = sdsmemcode;
	}

}
