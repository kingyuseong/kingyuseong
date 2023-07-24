package model.rec;

public class BuyVO {

	int membercode, goodscode, ordernocode, buycode, cardcode, cartcode;
	String gname, gprice, bcount, odate, ccount, cname, cvc, cno;

	public BuyVO() {

	}

	public BuyVO(int membercode, int goodscode, int ordernocode, int buycode, int cardcode, int cartcode, String ccount,
			String gname, String gprice, String bcount, String odate, String cname, String cvc, String cno) {
		this.membercode = membercode;
		this.goodscode = goodscode;
		this.ordernocode = ordernocode;
		this.buycode = buycode;
		this.gname = gname;
		this.gprice = gprice;
		this.bcount = bcount;
		this.odate = odate;
		this.cardcode = cardcode;
		this.cartcode = cartcode;
		this.ccount = ccount;
		this.cname = cname;
		this.cvc = cvc;
		this.cno = cno;

	}

	public int getMembercode() {
		return membercode;
	}

	public void setMembercode(int membercode) {
		this.membercode = membercode;
	}

	public int getGoodscode() {
		return goodscode;
	}

	public void setGoodscode(int goodscode) {
		this.goodscode = goodscode;
	}

	public int getOrdernocode() {
		return ordernocode;
	}

	public void setOrdernocode(int ordernocode) {
		this.ordernocode = ordernocode;
	}

	public int getBuycode() {
		return buycode;
	}

	public void setBuycode(int buycode) {
		this.buycode = buycode;
	}

	public int getCardcode() {
		return cardcode;
	}

	public void setCardcode(int cardcode) {
		this.cardcode = cardcode;
	}

	public int getCartcode() {
		return cartcode;
	}

	public void setCartcode(int cartcode) {
		this.cartcode = cartcode;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGprice() {
		return gprice;
	}

	public void setGprice(String gprice) {
		this.gprice = gprice;
	}

	public String getBcount() {
		return bcount;
	}

	public void setBcount(String bcount) {
		this.bcount = bcount;
	}

	public String getOdate() {
		return odate;
	}

	public void setOdate(String odate) {
		this.odate = odate;
	}

	public String getCcount() {
		return ccount;
	}

	public void setCcount(String ccount) {
		this.ccount = ccount;
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

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

}