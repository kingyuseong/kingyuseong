package model.rec;

public class CardVO {

	String cno, cname, cvc, cdate, cpw;
	int membercode;

	public CardVO() {

	}

	public CardVO(int membercode, String cno, String cname, String cvc, String cdate, String cpw) {
		this.cno = cno;
		this.cname = cname;
		this.cvc = cvc;
		this.cdate = cdate;
		this.membercode = membercode;
		this.cpw = cpw;

	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public String getCpw() {
		return cpw;
	}

	public void setCpw(String cpw) {
		this.cpw = cpw;
	}

	public int getMembercode() {
		return membercode;
	}

	public void setMembercode(int membercode) {
		this.membercode = membercode;
	}

}
