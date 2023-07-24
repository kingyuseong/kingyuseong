
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.MainHomeVO;
import model.rec.MarketVO;

public class MainHomeDAO {
	Connection conn = null;
//   private String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.36:1521:orcl";
	String id = "s5";
	String pwd = "s5";
	PreparedStatement ps = null;
	Statement stmt = null;
	ArrayList list = null;

	// 생성자
	public MainHomeDAO() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id, pwd);
		System.out.println("DB연결 성공!");
	}

	public ArrayList homeAll(String text) throws Exception {
		String sql = "select p.pname, p.pavgtime, p.plevel, p.pcost, p.pprice, p.pprofit from plant p, pcategory c where p.pcategorycode = c.pcategorycode";

		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("pname"));
			temp.add(rs.getString("pavgtime"));
			temp.add(rs.getString("plevel"));
			temp.add(rs.getString("pcost"));
			temp.add(rs.getString("pprice"));
			temp.add(rs.getString("pprofit"));

			list.add(temp);

		}
		rs.close();
		stmt.close();
		return list;
	}

	public ArrayList homeSearch(int sel, String text) throws Exception {
		String[] selCol = { "식물", "과일", "채소" };
		// 여기서 무만 나오는게 아니라 채소 전부 다 나옴
		String sql = "select p.pname, p.pavgtime, p.plevel, p.pcost, p.pprice, p.pprofit from plant p, pcategory c where p.pcategorycode = c.pcategorycode and c.pcname='"
				+ selCol[sel] + "' and p.pname like '%" + text + "%'";

		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		list = new ArrayList();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("pname"));
			temp.add(rs.getString("pavgtime"));
			temp.add(rs.getString("plevel"));
			temp.add(rs.getString("pcost"));
			temp.add(rs.getString("pprice"));
			temp.add(rs.getString("pprofit"));

			list.add(temp);

		}
		rs.close();
		stmt.close();
		return list;
	}

}
