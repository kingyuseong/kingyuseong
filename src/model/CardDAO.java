package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;

import model.rec.CardVO;
import view.MyCardView;

public class CardDAO {
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
	CardVO vo = null;
	ArrayList list = null;
	MyCardView mcview = null;

	// constructor
	public CardDAO() throws Exception {
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

	public void cardAdd(CardVO vo) throws SQLException {

		String sql = "insert into card(CARDCODE, CNO, CNAME, CVC, CDATE, MEMBERCODE, CPW) values(seq_card.nextval,?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql);

		ps.setString(1, vo.getCno());
		ps.setString(2, vo.getCname());
		ps.setString(3, vo.getCvc());
		ps.setString(4, vo.getCdate());
		ps.setInt(5, vo.getMembercode());
		ps.setString(6, vo.getCpw());

		ps.executeUpdate();
		ps.close();

	}

	public ArrayList cardAll(int membercode) throws SQLException {

		String sql = "select c.cname, c.cno, c.cdate from card c, member m where m.membercode = c.membercode and m.membercode = ?";
		list = new ArrayList();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, membercode);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("cname"));
			temp.add(rs.getString("cno"));
			temp.add(rs.getString("cdate"));

			list.add(temp);

		}

		rs.close();
		ps.close();
		return list;

	}

	public void deleteCard(String cNum) throws SQLException {

		String sql = "delete from card where cno= ?";
		ps = conn.prepareStatement(sql);

		ps.setString(1, cNum);

		ps.executeUpdate();
		ps.close();
	}

	public ArrayList myCardAllCname(int membercode) throws SQLException {
		String sql = "select DISTINCT cname from card where membercode = ?";
		ArrayList cardList = new ArrayList();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, membercode);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String myCards = rs.getString("cname");
			cardList.add(myCards);
		}

		rs.close();
		ps.close();
		return cardList;
	}

	public ArrayList myCardAllCno(String cname) throws SQLException {
		String sql = "SELECT cno FROM card WHERE cname = ?";
		ArrayList cardList = new ArrayList();
		ps = conn.prepareStatement(sql);
		ps.setString(1, cname);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String myCards = rs.getString("cno");
			cardList.add(myCards);
		}

		rs.close();
		ps.close();
		return cardList;
	}

	public boolean myCardCheck(String cardName, String cardNo, String password) throws SQLException {
		String sql = "SELECT cpw FROM card WHERE cname = ? and cno = ? ";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, cardName);
			ps.setString(2, cardNo);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					String cpw = rs.getString("cpw");
					return cpw.equals(password);
				}
			}
		}
		return false; // 카드 정보가 없을 경우
	}

}
