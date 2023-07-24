package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.CardVO;
import model.rec.RefundVO;
import view.MyPageView;

public class RefundDAO {
	// 멤버변수 선언
	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.0.36:1521:orcl"; // ip:port:DB명
//	   private String url="jdbc:oracle:thin:@192.168.0.16:1521:orcl";		// ip:port:DB명
	private String id = "s5";
	private String pass = "s5";
//	   private String id ="ss";
//	   private String pass="ss";
	PreparedStatement ps = null;
	Statement stmt = null;
	RefundVO vo = null;
	RefundDAO dao = this;
	ArrayList list = null;
	MyPageView mview = null;

	// constructor
	public RefundDAO() throws Exception {
		connectDB();
	}

	// DB control method
	void connectDB() throws Exception {
		/*
		 * 1. 드라이버를 드라이버메니저에 등록 2. 연결 객체 얻어오기
		 */
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, pass);

	}

	public ArrayList refundItem(String refundItem) throws SQLException {
		String sql = "select g.gname, b.bcount from buy b, goods g where g.goodscode=b.goodscode and b.buycode=?";

		ps = conn.prepareStatement(sql);
		ps.setString(1, refundItem);
		ResultSet rs = ps.executeQuery();
		list = new ArrayList();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("gname"));
			temp.add(rs.getString("bcount"));
			list.add(temp);
		}

		ps.close();
		rs.close();
		return list;
	}

	public void refundAdd(RefundVO vo) throws SQLException {

		String sql = "insert into refund(refundcode, rfdate, buycode, rfreasoncode) values(seq_refund.nextval,sysdate,?,?)";
		ps = conn.prepareStatement(sql);

		ps.setString(1, vo.getBuycode());
		ps.setString(2, vo.getRfreasoncode());

		ps.executeUpdate();
		ps.close();

	}

	public void refundDelete(RefundVO vo) throws SQLException {
		String sql = "delete from buy where buycode = ?";
		ps = conn.prepareStatement(sql);

		ps.setString(1, vo.getBuycode());

		ps.executeUpdate();
		ps.close();
	}

}
