package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.CustomerVO;

public class CustomerDAO extends Exception {

	// 멤버변수 선언
	int membercode;
	String Id;
	String Pw;
	String Nick;
	String Name;
	String Jumin;
	String Tel;
	String Addr;
	int Point;

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

	// constructor
	public CustomerDAO() throws Exception {
		connectDB();
	}

	void connectDB() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id, pass);
	}

	public ArrayList login(String id, String pw) throws Exception {
		int res = 0;
		/*
		 * 1. sql 작성하기 ( insert 문 작성 : 멤버필드를 변수로 지정하여 ) 2. sql 전송객체 얻어오기 (
		 * PreparedStatement가 더 적합할 듯 ) 3. sql 전송 ( 전송전에 ?로 지정 ) 4. 닫기 ( Connection은 닫으면
		 * 안됨 )
		 */

		String sql = "SELECT membercode, id, pw, nick, point FROM member WHERE id = ? AND pw = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);

		ResultSet rs = ps.executeQuery();
		list = new ArrayList();
		// 계정을 찾으면 res값에 0이 아닌 계정 코드를 담아주기 - [JIN]
		if (rs.next()) {
//			ArrayList temp = new ArrayList();
			list.add(rs.getInt("membercode"));
			list.add(rs.getString("id"));
			list.add(rs.getString("pw"));
			list.add(rs.getString("nick"));
			list.add(rs.getString("point"));
//			vo.setMembercode(rs.getInt("membercode"));
//			vo.setId(rs.getString("id"));
//			vo.setPw(rs.getString("pw"));
//			vo.setNick(rs.getString("nick"));
//			vo.setPoint(rs.getString("point"));
//			list.add(temp);
		}

		rs.close();
		ps.close();

		return list;
	}

	public CustomerVO info(int code) throws Exception {
		/*
		 * 1. sql 작성하기 ( update 문 작성 : 멤버필드를 변수로 지정하여 ) 2. sql 전송객체 얻어오기 (
		 * PreparedStatement가 더 적합할 듯 ) 3. sql 전송 ( 전송전에 ?로 지정 ) 4. 닫기 ( Connection은 닫으면
		 * 안됨 )
		 */

		CustomerVO res = null;
		String sql = "SELECT membercode, id, pw, nick, name, jumin, tel, tel, point FROM member WHERE MEMBERCODE = "
				+ code;

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		// 로그인 성공시
		if (rs.next()) {
			int membercode = rs.getInt("membercode");
			String id = rs.getString("id");
			String pw = rs.getString("pw");
			String nick = rs.getString("nick");
			String name = rs.getString("name");
			String jumin = rs.getString("jumin");
			String tel = rs.getString("tel");
			String addr = rs.getString("addr");
			int point = rs.getInt("point");

			// CustomerVO 타입으로 모든 정보 담아주기
			res = new CustomerVO(membercode, id, pw, nick, name, jumin, tel, addr, point);
		}
		stmt.close();
		rs.close();

		return res;
	}

	// 정보 출력 메소드
	public ArrayList<CustomerVO> custFind(int code) throws Exception {
		ArrayList<CustomerVO> list = new ArrayList<CustomerVO>();

		String sql = "SELECT pw, nick, tel, addr FROM member WHERE membercode =" + code;

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			CustomerVO vo = new CustomerVO();
			vo.setPw(rs.getString(1));
			vo.setNick(rs.getString(2));
			vo.setTel(rs.getString(3));
			vo.setAddr(rs.getString(4));

			list.add(vo);
		}
		stmt.close();
		rs.close();

		return list;
	}

	// 정보 수정
	public void updateInfo(CustomerVO vo) throws Exception {
		String sql = "UPDATE member SET pw =?, nick =?, tel =?, addr =? WHERE membercode = " + vo.getMembercode();

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, vo.getPw());
		ps.setString(2, vo.getNick());
		ps.setString(3, vo.getTel());
		ps.setString(4, vo.getAddr());
//			ps.setInt(5, vo.getMembercode());

		ps.executeUpdate();

		ps.close();

	}

	public ArrayList custAll() throws SQLException {
		String sql = "select membercode, id, pw, nick, name, jumin, tel, addr, point from member";
		list = new ArrayList();
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getInt("membercode"));
			temp.add(rs.getString("id"));
			temp.add(rs.getString("pw"));
			temp.add(rs.getString("nick"));
			temp.add(rs.getString("name"));
			temp.add(rs.getString("jumin"));
			temp.add(rs.getString("tel"));
			temp.add(rs.getString("addr"));
			temp.add(rs.getString("point"));

			list.add(temp);

		}
		rs.close();
		stmt.close();
		return list;

	}

	public CustomerVO loginug(int pk, String id, String nick, String point) throws Exception {

		String sql = "select membercode from member where id =? and pw = ? and nick =? and point = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ps.setInt(2, pk);
		ps.setString(3, nick);
		ps.setString(4, point);
		ResultSet rs = ps.executeQuery();

		CustomerVO vo = new CustomerVO();

		while (rs.next()) {
			vo.setId(rs.getString("membercode"));

		}
		return vo;

	}

}
