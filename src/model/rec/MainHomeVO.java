package model.rec;

public class MainHomeVO {
	String pname, pavgtime, plevel, pcost, pprice, pprofit;

	public MainHomeVO() {

	}

	public MainHomeVO(String pname, String pavgtime, String plevel, String pcost, String pprice, String pprofit) {

		this.pavgtime = pavgtime;
		this.pcost = pcost;
		this.plevel = plevel;
		this.pname = pname;
		this.pprice = pprice;
		this.pprofit = pprofit;

	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPavgtime() {
		return pavgtime;
	}

	public void setPavgtime(String pavgtime) {
		this.pavgtime = pavgtime;
	}

	public String getPlevel() {
		return plevel;
	}

	public void setPlevel(String plevel) {
		this.plevel = plevel;
	}

	public String getPcost() {
		return pcost;
	}

	public void setPcost(String pcost) {
		this.pcost = pcost;
	}

	public String getPprice() {
		return pprice;
	}

	public void setPprice(String pprice) {
		this.pprice = pprice;
	}

	public String getPprofit() {
		return pprofit;
	}

	public void setPprofit(String pprofit) {
		this.pprofit = pprofit;
	}

}
