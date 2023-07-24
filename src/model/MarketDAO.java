package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.rec.MarketVO;

public class MarketDAO {
	Connection conn = null;
//  private String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.36:1521:orcl";
	String id = "s5";
	String pwd = "s5";
	PreparedStatement ps = null;
	Statement stmt = null;
	ArrayList list = null;
	MarketDAO dao = null;
	MarketVO vo = null;

	// 생성자
	public MarketDAO() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id, pwd);
		System.out.println("DB연결 성공!");
	}

	public ArrayList smarketSearch(int sel, String text) throws Exception {

		String sql = "select s.smname, s.smprice, s.smcontent, m.NICK , s.smdate, s.smfinish from smarket s, member m where m.membercode = s.membercode and smname like '%"
				+ text + "%'";

		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		list = new ArrayList();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("smname"));
			temp.add(rs.getString("smprice"));
			temp.add(rs.getString("smcontent"));
			temp.add(rs.getString("NICK"));
			temp.add(rs.getString("smdate"));
			temp.add(rs.getString("smfinish"));

			list.add(temp);
		}

		rs.close();
		stmt.close();
		return list;
	}

	public ArrayList bmarketSearch(String text) throws Exception {

		String sql = "select s.bmname, s.bmprice, s.bmcontent, m.NICK , s.bmdate, s.bmfinish from bmarket s, member m where m.membercode = s.membercode and bmname like '%"
				+ text + "%'";

		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		list = new ArrayList();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("bmname"));
			temp.add(rs.getString("bmprice"));
			temp.add(rs.getString("bmcontent"));
			temp.add(rs.getString("NICK"));
			temp.add(rs.getString("bmdate"));
			temp.add(rs.getString("bmfinish"));

			list.add(temp);
		}

		rs.close();
		stmt.close();
		return list;
	}

	public void bmregist(MarketVO vo) throws Exception {
		String sql = "Insert into bmarket (bmarketcode,bmname,bmprice,bmcontent,bmdate,bmfinish,membercode,plantcode) values (seq_bmarket.nextval,?,?,?,sysdate,'N',?,?)";

		ps = conn.prepareStatement(sql);

		ps.setString(1, vo.getBmname());
		ps.setString(2, vo.getBmprice());
		ps.setString(3, vo.getBmcontent());
		ps.setInt(4, vo.getMembercode());
		ps.setInt(5, vo.getPlantcode());

		int rowNum;
		rowNum = ps.executeUpdate();

		ps.close();

	}

	public void smregist(MarketVO vo) throws Exception {
		String sql = "Insert into smarket (smarketcode,smname,smprice,smcontent,smdate,SMFINISH,membercode,plantcode) values (seq_smarket.nextval,?,?,?,sysdate,'N',?,?)";

		ps = conn.prepareStatement(sql);

		ps.setString(1, vo.getSmname());
		ps.setString(2, vo.getSmprice());
		ps.setString(3, vo.getSmcontent());
		ps.setInt(4, vo.getMembercode());
		ps.setInt(5, vo.getPlantcode());

		int rowNum;
		rowNum = ps.executeUpdate();

		ps.close();

	}

	public ArrayList listSelect(int sel, int code) throws Exception {

		String sql = "select s.smname, s.smprice, s.smcontent, s.smdate from smarket s, member m where s.membercode = m.membercode and m.membercode ="
				+ code;

		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		list = new ArrayList();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("smname"));
			temp.add(rs.getString("smcontent"));
			temp.add(rs.getString("smprice"));
			temp.add(rs.getString("smdate"));

			list.add(temp);

		}

		rs.close();
		stmt.close();
		return list;

	}

	public ArrayList marketSelect(int sel, int code) throws Exception {

		String sql = "select b.bmname, b.bmprice, b.bmcontent, b.bmdate from bmarket b, member m where b.membercode = m.membercode and m.membercode = "
				+ code;

		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		list = new ArrayList();
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("bmname"));
			temp.add(rs.getString("bmcontent"));
			temp.add(rs.getString("bmprice"));
			temp.add(rs.getString("bmdate"));

			list.add(temp);

		}

		rs.close();
		stmt.close();
		return list;

	}

	public MarketVO smgetInfo(String smname) throws Exception {
		String sql = "select smname, smprice, smcontent, smimage from smarket where smname=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, smname);
		ResultSet rs = ps.executeQuery();
		MarketVO vo = new MarketVO();

		while (rs.next()) {
			vo.setSmname(rs.getString("smname"));
			vo.setSmcontent(rs.getString("smcontent"));
			vo.setSmimage(rs.getString("smimage"));
			vo.setSmprice(rs.getString("smprice"));

		}
		ps.close();
		rs.close();

		return vo;

	}

	public MarketVO bmgetInfo(String bmname) throws Exception {
		String sql = "select bmname, bmprice, bmcontent from bmarket where bmname=?";

		ps = conn.prepareStatement(sql);
		ps.setString(1, bmname);
		ResultSet rs = ps.executeQuery();
		MarketVO vo = new MarketVO();

		while (rs.next()) {
			vo.setBmname(rs.getString("bmname"));
			vo.setBmprice(rs.getString("bmprice"));
			vo.setBmcontent(rs.getString("bmcontent"));
		}
		ps.close();
		rs.close();

		return vo;
	}

	public MarketVO bmupInfo(String bmname) throws Exception {
		String sql = "select bmarketcode,bmname, bmprice, bmcontent from bmarket where bmname=?";

		ps = conn.prepareStatement(sql);
		ps.setString(1, bmname);
		ResultSet rs = ps.executeQuery();
		MarketVO vo = new MarketVO();

		while (rs.next()) {
			vo.setBmarketcode(rs.getInt("bmarketcode"));
			vo.setBmname(rs.getString("bmname"));
			vo.setBmprice(rs.getString("bmprice"));
			vo.setBmcontent(rs.getString("bmcontent"));
		}
		ps.close();
		rs.close();

		return vo;

	}

	public MarketVO smupInfo(String smname) throws Exception {
		String sql = "select smarketcode,smname, smprice, smcontent, smimage from smarket where smname=?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, smname);
		ResultSet rs = ps.executeQuery();
		MarketVO vo = new MarketVO();

		while (rs.next()) {
			vo.setSmarketcode(rs.getInt("smarketcode"));
			vo.setSmname(rs.getString("smname"));
			vo.setSmcontent(rs.getString("smcontent"));
			vo.setSmimage(rs.getString("smimage"));
			vo.setSmprice(rs.getString("smprice"));

		}
		ps.close();
		rs.close();

		return vo;

	}

	public void smupdate(MarketVO vo) throws Exception {
		String sql = "update smarket set smname=?, smprice=?, smcontent=? where membercode =" + vo.getMembercode()
				+ "and smarketcode= " + vo.getSmarketcode();

		ps = conn.prepareStatement(sql);

		ps.setString(1, vo.getSmname());
		ps.setString(2, vo.getSmprice());
		ps.setString(3, vo.getSmcontent());

		ps.executeUpdate();

		ps.close();
	}

	public void bmupdate(MarketVO vo) throws Exception {
		String sql = "update bmarket set bmname=?, bmprice=?, bmcontent=? where membercode = " + vo.getMembercode()
				+ "and bmarketcode = " + vo.getBmarketcode();

		ps = conn.prepareStatement(sql);
		ps.setString(1, vo.getBmname());
		ps.setString(2, vo.getBmprice());
		ps.setString(3, vo.getBmcontent());

		ps.executeUpdate();

		ps.close();
	}

	// 장터판매건수 카운트
	public int smcount(int membercode) throws Exception {
		String sql = "select count(SMARKETCODE) from smarket where membercode = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, membercode);
		ResultSet rs = ps.executeQuery();

		int count = 0;
		if (rs.next()) {
			count = rs.getInt(1);
		}
		return count;
	}

	// 장터구매건수 카운트
	public int bmcount(int membercode) throws Exception {
		String sql = "select count(BMARKETCODE) from bmarket where membercode = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, membercode);
		ResultSet rs = ps.executeQuery();

		int count = 0;
		if (rs.next()) {
			count = rs.getInt(1);
		}
		return count;
	}
}
