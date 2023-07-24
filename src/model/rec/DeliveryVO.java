package model.rec;

public class DeliveryVO {

	String ordernocode, devcode, odate, gname, bcount, dvncondition, ddate, dvname, dvtel, dvcompany;
	int membercode;

	public DeliveryVO() {

	}

	public DeliveryVO(int membercode, String ordernocode, String devcode, String odate, String gname, String bcount,
			String dvncondition, String ddate, String dvname, String dvtel, String dvcompany) {
		this.ordernocode = ordernocode;
		this.devcode = devcode;
		this.odate = odate;
		this.gname = gname;
		this.bcount = bcount;
		this.dvncondition = dvncondition;
		this.ddate = ddate;
		this.dvname = dvname;
		this.dvtel = dvtel;
		this.dvcompany = dvcompany;
		this.membercode = membercode;

	}

	public String getOrdernocode() {
		return ordernocode;
	}

	public void setOrdernocode(String ordernocode) {
		this.ordernocode = ordernocode;
	}

	public String getDevcode() {
		return devcode;
	}

	public void setDevcode(String devcode) {
		this.devcode = devcode;
	}

	public String getOdate() {
		return odate;
	}

	public void setOdate(String odate) {
		this.odate = odate;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getBcount() {
		return bcount;
	}

	public void setBcount(String bcount) {
		this.bcount = bcount;
	}

	public String getDvncondition() {
		return dvncondition;
	}

	public void setDvncondition(String dvncondition) {
		this.dvncondition = dvncondition;
	}

	public String getDdate() {
		return ddate;
	}

	public void setDdate(String ddate) {
		this.ddate = ddate;
	}

	public String getDvname() {
		return dvname;
	}

	public void setDvname(String dvname) {
		this.dvname = dvname;
	}

	public String getDvtel() {
		return dvtel;
	}

	public void setDvtel(String dvtel) {
		this.dvtel = dvtel;
	}

	public String getDvcompany() {
		return dvcompany;
	}

	public void setDvcompany(String dvcompany) {
		this.dvcompany = dvcompany;
	}

	public int getMembercode() {
		return membercode;
	}

	public void setMembercode(int membercode) {
		this.membercode = membercode;
	}

}