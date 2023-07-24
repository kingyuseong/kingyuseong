package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.CustomerVO;
import model.rec.MissionVO;

public class MissionDAO {
	Connection conn = null;
//  private String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.36:1521:orcl";
	String id = "s5";
	String pwd = "s5";
	CustomerVO cvo = null;
	PreparedStatement ps = null;
	Statement stmt = null;
	ArrayList list = null;

	public MissionDAO() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id, pwd);
		System.out.println("DB연결 성공!");
	}

	// 미션 전체 출력 메소드
	public ArrayList missionAll() throws Exception {
		String sql = "select mname, miname, mipoint from mcategory c, mission m"
				+ "where c.mcategorycode = m.mcategorycode";

		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		list = new ArrayList();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString(1));
			temp.add(rs.getString(2));
			temp.add(rs.getInt(3));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}

	// 미션 완료 메소드
	public ArrayList missionSearch(int sel, int code) throws Exception {
		String sql = "select m.miname, m.mipoint,l.mlfinish from mission m, mlist l, member b where m.missioncode = l.missioncode and b.membercode = l.membercode and l.mlfinish ='Y' and b.membercode = "
				+ code;

		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		list = new ArrayList();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("miname"));
			temp.add(rs.getString("mipoint"));
			list.add(temp);
		}

		rs.close();
		stmt.close();
		return list;
	}

	// 미션 미완료 메소드
	public ArrayList missionmiSearch(int sel, int code) throws Exception {
		String sql = "select m.miname, m.mipoint,l.mlfinish from mission m, mlist l, member b where m.missioncode = l.missioncode and b.membercode = l.membercode and l.mlfinish ='N' and b.membercode = "
				+ code;

		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		list = new ArrayList();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("miname"));
			temp.add(rs.getString("mipoint"));

			list.add(temp);
		}

		rs.close();
		stmt.close();
		return list;
	}

}
