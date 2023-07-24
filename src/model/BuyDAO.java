package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.BuyVO;
import view.MyCardView;

public class BuyDAO<CartItem> {
	// 멤버변수 선언
	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.0.36:1521:orcl"; // ip:port:DB명
//      private String url="jdbc:oracle:thin:@192.168.0.16:1521:orcl";      // ip:port:DB명
	private String id = "s5";
	private String pass = "s5";
//      private String id ="ss";
//      private String pass="ss";
	PreparedStatement ps = null;
	Statement stmt = null;
	ArrayList list = null;
	BuyVO vo = null;
	BuyDAO dao = null;
	MyCardView mview = null;

//  constructor
	public BuyDAO() throws Exception {

		connectDB();
		vo = new BuyVO();
	}

//   DB  control method
	void connectDB() throws Exception {
		/*
		 * 1. 드라이버를 드라이버메니저에 등록 2. 연결 객체 얻어오기
		 */
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, pass);

	}

	// 카드정보 select
	public int getCardCode(String cardNo) throws SQLException {
		int cardCode = 0;
		String sql = "SELECT CARDCODE FROM CARD WHERE CNO = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, cardNo);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			cardCode = rs.getInt("CARDCODE");
		}

		rs.close();
		ps.close();

		return cardCode;
	}

	// 주문 insert
	public void orderInsert(BuyVO vo) throws SQLException {
		String sql = "insert into orderno (ordernocode, odate, cardcode) values (seq_orderno.nextval, sysdate, ?)";

		// 카드 코드 조회
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, vo.getCardcode());

		int cardcode = ps.executeUpdate();
		ps.close();

	}

//         // 하는중
//         // 구매 insert
//         public void buyInsert(int cardcode) throws SQLException {
////             String cartsql = "select ct.ccount, ct.goodscode, o.ordernocode from member m, card cd, cart ct, orderno o "
////                   + "where m.membercode = cd.membercode and m.membercode = ct.membercode and cd.cardcode=o.cardcode "
////                   + "and ct.membercode = ?";
//            String ordersql = "select ordernocode from orderno where cardcode = ?";
//             PreparedStatement orderps = conn.prepareStatement(ordersql);
//             orderps.setInt(1, cardcode);
//             ResultSet orderrs = orderps.executeQuery();
//            
//            String cartsql = "select ct.ccount, ct.goodscode, o.ordernocode from member m, card cd, cart ct, orderno o where m.membercode = cd.membercode and m.membercode = ct.membercode and cd.cardcode=o.cardcode and o.ordernocode=?";
//             PreparedStatement cartps = conn.prepareStatement(ordersql);
//             cartps.setInt(1, vo.getOrdernocode());
//             ResultSet cartrs = cartps.executeQuery();
//
//             String sql = "insert into buy (buycode, bcount, ordernocode, goodscode) values (seq_buy.nextval, ?, ?, ?)";
//             PreparedStatement ps = conn.prepareStatement(cartsql);
//
//             while (cartrs.next()) {
//                 String ccount = cartrs.getString("ccount");
//                int ordernocode = cartrs.getInt("ordernocode");
//                int goodscode = cartrs.getInt("goodscode");
//
//
//                 ps.setString(1, ccount);
//                 ps.setInt(2, ordernocode);
//                 ps.setInt(3, goodscode);
//                 ps.executeUpdate();
//             }
//
//         }

	// 구매 insert
	public void buyInsert(int cardcode, int membercode) throws SQLException {
		String ordersql = "SELECT ordernocode FROM orderno WHERE cardcode = ?";
		PreparedStatement orderps = conn.prepareStatement(ordersql);
		orderps.setInt(1, cardcode);
		ResultSet orderrs = orderps.executeQuery();

		int ordernocode = 0;
		if (orderrs.next()) {
			ordernocode = orderrs.getInt("ordernocode");
		}

		String cartsql = "SELECT ct.ccount, ct.goodscode FROM cart ct WHERE ct.membercode = ?";
		PreparedStatement cartps = conn.prepareStatement(cartsql);
		cartps.setInt(1, membercode);
		ResultSet cartrs = cartps.executeQuery();

		String sql = "INSERT INTO buy (buycode, bcount, ordernocode, goodscode) VALUES (seq_buy.nextval, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);

		while (cartrs.next()) {
			String ccount = cartrs.getString("ccount");
			int goodscode = cartrs.getInt("goodscode");

			ps.setString(1, ccount);
			ps.setInt(2, ordernocode);
			ps.setInt(3, goodscode);
			ps.executeUpdate();
		}

		// 리소스 정리
		orderrs.close();
		orderps.close();
		cartrs.close();
		cartps.close();
		ps.close();
	}

}