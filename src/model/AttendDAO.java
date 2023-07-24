package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.AttendVO;
import model.rec.CustomerVO;

public class AttendDAO {
	Connection conn = null;
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.36:1521:orcl";
	String id = "s5";
	String pass = "s5";
	PreparedStatement ps = null;
	Statement stmt = null;
	ArrayList list = null;
	CustomerVO vo = null;
	ResultSet rs = null;

	public AttendDAO() throws Exception {
		connectDB();
	}

	void connectDB() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id, pass);
	}

	// 포인트 쌓기

	public void attcheck(AttendVO vo) throws Exception {

		String sql = "INSERT INTO attend (attendcode, adate, apoint, membercode) "
				+ "VALUES (seq_attend.nextval, SYSDATE, ?, ?)";

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setInt(1, vo.getApoint());
		ps.setInt(2, vo.getMembercode());

		int rowNum;
		ps.executeUpdate();

		ps.close();

	}

	// 출석체크 클릭시 기존 포인트에서 추가
	public void updateInfo(AttendVO vo) throws Exception {
		String sql = "UPDATE member SET point = point + (SELECT a.apoint FROM attend a WHERE a.membercode = member.membercode)"
				+ "WHERE Membercode = ?";

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setInt(1, vo.getMembercode());
//		ps.setInt(2, cvo.getMembercode());

		ps.executeUpdate();
		System.out.println(vo);
		ps.close();

	}

	// 출석체크를 한 후 데이터 제거
	public int attDelete(int mcode) throws Exception {
		String sql = "delete from attend where membercode =?";
		ps = conn.prepareStatement(sql);

		ps.setInt(1, mcode);

		int rowNum = ps.executeUpdate();
		return rowNum;
	}

}
