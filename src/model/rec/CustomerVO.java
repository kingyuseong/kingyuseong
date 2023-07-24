package model.rec;

public class CustomerVO {
	String id, pw, nick, name, jumin, tel, addr;

	int membercode, point;

	public CustomerVO(int membercode, String id, String pw, String nick, String name, String jumin, String tel,
			String addr, int point) {
		this.membercode = membercode;
		this.id = id;
		this.pw = pw;
		this.nick = nick;
		this.name = name;
		this.jumin = jumin;
		this.tel = tel;
		this.addr = addr;
		this.point = point;
	}

	public CustomerVO(int membercode, String pw, String nick, String tel, String addr) {
		this.membercode = membercode;
		this.pw = pw;
		this.nick = nick;
		this.tel = tel;
		this.addr = addr;

	}

	public CustomerVO() {
		// TODO Auto-generated constructor stub
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
		this.pw = pw;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getMembercode() {
		return membercode;
	}

	public void setMembercode(int membercode) {
		this.membercode = membercode;
	}

}
