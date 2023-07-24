package model.rec;

public class MarketVO {
	String smname, smprice, smcontent, smdate, smflnish, smimage, bmname, bmprice, bmcontent, bmdate, bmflnish;
	int bmarketcode, membercode, plantcode, smarketcode;

	public MarketVO(String smnaem, String smprice, String smcontent, String smdate, String smflnish, String smimage,
			int smarketcode, int membercode, int plantcode) {
		this.smname = smnaem;
		this.smprice = smprice;
		this.smcontent = smcontent;
		this.smdate = smdate;
		this.smflnish = smflnish;
		this.smimage = smimage;
		this.smarketcode = smarketcode;
		this.membercode = membercode;
		this.plantcode = plantcode;
		// TODO Auto-generated constructor stub
	}

	public MarketVO(String smimage) {
		this.smimage = smimage;
	}

	public MarketVO(String bmname, String bmprice, String bmcontent, String bmdate, String bmflnish, int bmarketcode,
			int membercode, int plantcode) {

		this.bmname = bmname;
		this.bmprice = bmprice;
		this.bmcontent = bmcontent;
		this.bmdate = bmdate;
		this.bmflnish = bmflnish;
		this.bmarketcode = bmarketcode;
		this.membercode = membercode;
		this.plantcode = plantcode;

// TODO Auto-generated constructor stub
	}

	public MarketVO() {

	}

	public MarketVO(String smname, String smprice, String smcontent, int smarketcode) {
		this.smname = smname;
		this.smprice = smprice;
		this.smcontent = smcontent;
		this.smarketcode = smarketcode;

		// TODO Auto-generated constructor stub
	}

	public String getSmname() {
		return smname;
	}

	public void setSmname(String smname) {
		this.smname = smname;
	}

	public String getSmprice() {
		return smprice;
	}

	public void setSmprice(String smprice) {
		this.smprice = smprice;
	}

	public String getSmcontent() {
		return smcontent;
	}

	public void setSmcontent(String smcontent) {
		this.smcontent = smcontent;
	}

	public String getSmdate() {
		return smdate;
	}

	public void setSmdate(String smdate) {
		this.smdate = smdate;
	}

	public String getSmflnish() {
		return smflnish;
	}

	public void setSmflnish(String smflnish) {
		this.smflnish = smflnish;
	}

	public String getSmimage() {
		return smimage;
	}

	public void setSmimage(String smimage) {
		this.smimage = smimage;
	}

	public String getBmname() {
		return bmname;
	}

	public void setBmname(String bmname) {
		this.bmname = bmname;
	}

	public String getBmprice() {
		return bmprice;
	}

	public void setBmprice(String bmprice) {
		this.bmprice = bmprice;
	}

	public String getBmcontent() {
		return bmcontent;
	}

	public void setBmcontent(String bmcontent) {
		this.bmcontent = bmcontent;
	}

	public String getBmdate() {
		return bmdate;
	}

	public void setBmdate(String bmdate) {
		this.bmdate = bmdate;
	}

	public String getBmflnish() {
		return bmflnish;
	}

	public void setBmflnish(String bmflnish) {
		this.bmflnish = bmflnish;
	}

	public int getBmarketcode() {
		return bmarketcode;
	}

	public void setBmarketcode(int bmarketcode) {
		this.bmarketcode = bmarketcode;
	}

	public int getMembercode() {
		return membercode;
	}

	public void setMembercode(int membercode) {
		this.membercode = membercode;
	}

	public int getPlantcode() {
		return plantcode;
	}

	public void setPlantcode(int plantcode) {
		this.plantcode = plantcode;
	}

	public int getSmarketcode() {
		return smarketcode;
	}

	public void setSmarketcode(int smarketcode) {
		this.smarketcode = smarketcode;
	}
}