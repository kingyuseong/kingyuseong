package model.rec;

public class SellVO {
	String buycode, gname, gprice, gcontent, gimage, gcategorycode, gcname, cartcode, ccount, reviewcode, rstar,
			rcontent, rdate;
	int membercode, goodscode;

	public SellVO() {

	}

	public SellVO(String gname, String gprice, String gcontent, String gimage, String gcategorycode, String gcname,
			String cartcode, String ccount, int membercode, int goodscode, String rstar, String rcontent, String rdate,
			String buycode) {
		this.gname = gname;
		this.gprice = gprice;
		this.gcontent = gcontent;
		this.gimage = gimage;
		this.gcategorycode = gcategorycode;
		this.gcname = gcname;
		this.cartcode = cartcode;
		this.ccount = ccount;
		this.membercode = membercode;
		this.goodscode = goodscode;
		this.rstar = rstar;
		this.rcontent = rcontent;
		this.rdate = rdate;
		this.buycode = buycode;

	}

	public SellVO(String gname, String ccount, String gprice) {
		this.gname = gname;
		this.ccount = ccount;
		this.gprice = gprice;
	}

	public SellVO(String gname, String gimage, String gprice, String gcontent) {
		this.gname = gname;
		this.gimage = gimage;
		this.gprice = gprice;
		this.gcontent = gcontent;
	}

//   public SellVO(String gname, String rstar, String rcontent, String rdate) {
//      this.gname = gname;

//   }

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

	public String getGcontent() {
		return gcontent;
	}

	public void setGcontent(String gcontent) {
		this.gcontent = gcontent;
	}

	public String getGimage() {
		return gimage;
	}

	public void setGimage(String gimage) {
		this.gimage = gimage;
	}

	public String getGcategorycode() {
		return gcategorycode;
	}

	public void setGcategorycode(String gcategorycode) {
		this.gcategorycode = gcategorycode;
	}

	public String getGcname() {
		return gcname;
	}

	public void setGcname(String gcname) {
		this.gcname = gcname;
	}

	public String getCartcode() {
		return cartcode;
	}

	public void setCartcode(String cartcode) {
		this.cartcode = cartcode;
	}

	public String getCcount() {
		return ccount;
	}

	public void setCcount(String ccount) {
		this.ccount = ccount;
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

	public String getReviewcode() {
		return reviewcode;
	}

	public void setReviewcode(String reviewcode) {
		this.reviewcode = reviewcode;
	}

	public String getRstar() {
		return rstar;
	}

	public void setRstar(String rstar) {
		this.rstar = rstar;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getBuycode() {
		return buycode;
	}

	public void setBuycode(String buycode) {
		this.buycode = buycode;
	}

}