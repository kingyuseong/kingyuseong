package com.javaclass.domain;

public class ReserveVO {
	private int sdsmemcode;
	private int mrcode;
	private int memcode;
	private String mctitle;
	private String mccate;
	private String startdate;
	private String enddate;
	private String color;
	private String nick;

	public int getMrcode() {
		System.out.println("getmrcode" + mrcode);
		return mrcode;
	}

	public void setMrcode(int mrcode) {
		System.out.println("setmrcode" + mrcode);
		this.mrcode = mrcode;
	}

	public int getMemcode() {
		System.out.println("getmemcode" + memcode);
		return memcode;
	}

	public void setMemcode(int memcode) {
		System.out.println("setmemcode" + memcode);
		this.memcode = memcode;
	}

	public String getMctitle() {
		System.out.println("getmctitle" + mctitle);
		return mctitle;
	}

	public void setMctitle(String mctitle) {
		System.out.println("setmctitle" + mctitle);
		this.mctitle = mctitle;
	}

	public String getMccate() {
		System.out.println("getmccate" + mccate);
		return mccate;
	}

	public void setMccate(String mccate) {
		System.out.println("setmccate" + mccate);
		this.mccate = mccate;
	}

	public String getStartdate() {
		System.out.println("getstartdate" + startdate);
		return startdate;
	}

	public void setStartdate(String startdate) {
		System.out.println("setstartdate" + startdate);
		this.startdate = startdate;
	}

	public String getEnddate() {
		System.out.println("getenddate" + enddate);
		return enddate;
	}

	public void setEnddate(String enddate) {
		System.out.println("setenddate" + enddate);
		this.enddate = enddate;
	}

	public int getSdsmemcode() {
		System.out.println("getsdsmemcode" + sdsmemcode);
		return sdsmemcode;
	}

	public void setSdsmemcode(int sdsmemcode) {
		System.out.println("setsdsmemcode" + sdsmemcode);
		this.sdsmemcode = sdsmemcode;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		System.out.println("nick" + nick);
		this.nick = nick;
	}

}