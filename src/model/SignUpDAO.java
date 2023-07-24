package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.SignUpVO;

public class SignUpDAO {
	// 회원가입 DAO
	public SignUpDAO() throws Exception {
		connectDB();

	}

	Connection conn = null;
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.36:1521:orcl";
	String id = "s5";
	String pass = "s5";

	void connectDB() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id, pass);

	}

	PreparedStatement ps = null;
	Statement stmt = null;
	ArrayList list = null;

	// 아이디 중복확인
	public String checkId(String id) throws Exception {
		String memId = null;
		String sql = "select ID from member where ID = '" + id + "'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		if (rs.next()) {
			memId = rs.getString("ID");

		}

		rs.close();

		return memId;
	}

	// 닉네임 중복확인
	public String checkNick(String nick) throws Exception {
		String memnick = null;
		String sql = "select nick from member where nick = '" + nick + "'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		if (rs.next()) {
			memnick = rs.getString("Nick");
		}

		rs.close();
		return memnick;
	}

	// 비밀번호 확인
	public String checkPass(String pass) throws Exception {
		String mempass = null;
		String sql = "select pw from member where pw = '" + pass + "'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		if (rs.next()) {
			mempass = rs.getString("Pass");
		}

		rs.close();
		return mempass;
	}

	// 회원가입
	public void join(SignUpVO vo) throws Exception {

		String sql = "insert into member(membercode, id, pw, nick, name, jumin, tel, addr, point) "
				+ "values(seq_member.nextval, ?, ?, ?, ?, ?, ?, ?, 0)";

		PreparedStatement ps = conn.prepareStatement(sql);
		String nick = vo.getNick();
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPw());
		ps.setString(3, vo.getNick());
		ps.setString(4, vo.getName());
		ps.setString(5, vo.getJumin());
		ps.setString(6, vo.getTel());
		ps.setString(7, vo.getAddr());

		ps.executeUpdate();

		ps.close();
	}
}
