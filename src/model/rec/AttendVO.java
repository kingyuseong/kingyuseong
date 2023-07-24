package model.rec;

public class AttendVO {
	String adate;
	int attendcode, apoint, membercode;

	public AttendVO() {

	}

	public AttendVO(String adate, int apoint, int attendcode, int membercode) {
		this.attendcode = attendcode;
		this.adate = adate;
		this.apoint = apoint;

	}

	public String getAdate() {
		return adate;
	}

	public void setAdate(String adate) {
		this.adate = adate;
	}

	public int getAttendcode() {
		return attendcode;
	}

	public void setAttendcode(int attendcode) {
		this.attendcode = attendcode;
	}

	public int getApoint() {
		return apoint;
	}

	public void setApoint(int apoint) {
		this.apoint = apoint;
	}

	public int getMembercode() {
		return membercode;
	}

	public void setMembercode(int membercode) {
		this.membercode = membercode;
	}

}
