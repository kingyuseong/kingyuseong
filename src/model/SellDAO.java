package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.SellVO;

public class SellDAO {
	Connection conn = null;
	String url = "jdbc:oracle:thin:@192.168.0.36:1521:orcl";
	String id = "s5";
	String pwd = "s5";
	PreparedStatement ps = null;
	Statement stmt = null;
	ArrayList list = null;
	SellVO vo;
	SellDAO dao;

	public SellDAO() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id, pwd);
		dao = this;
	}

	// 상품 전체 출력 메소드
	public ArrayList goodsAll() throws Exception {
		String sql = "select c.gcname, g.gname, g.gprice from goods g, gcategory c "
				+ "where g.gcategorycode = c.gcategorycode";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		list = new ArrayList();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString(1));
			temp.add(rs.getString(2));
			temp.add(rs.getString(3));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}

	// 상품 전체 + 키워드 검색 메소드
	public ArrayList goodsAllSearch(String text) throws Exception {
		String sql = "select c.gcname, g.gname, g.gprice from goods g, gcategory c "
				+ "where g.gcategorycode = c.gcategorycode and gname like '%" + text + "%'";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		list = new ArrayList();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString(1));
			temp.add(rs.getString(2));
			temp.add(rs.getString(3));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}

	// 카테고리로 검색 메소드
	public ArrayList goodsByCategory(String category) throws Exception {
		String sql = "select c.gcname, g.gname, g.gprice from goods g, gcategory c "
				+ "where g.gcategorycode = c.gcategorycode and c.gcname = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, category);
		ResultSet rs = stmt.executeQuery();
		list = new ArrayList();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString(1));
			temp.add(rs.getString(2));
			temp.add(rs.getString(3));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}

	// 카테고리 + 키워드 검색 메소드
	public ArrayList goodsByCategorySearch(String category, String text) throws Exception {
		String sql = "select c.gcname, g.gname, g.gprice from goods g, gcategory c "
				+ "where g.gcategorycode = c.gcategorycode and c.gcname = ? and g.gname like '%" + text + "%'";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, category);
		ResultSet rs = stmt.executeQuery();
		list = new ArrayList();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString(1));
			temp.add(rs.getString(2));
			temp.add(rs.getString(3));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}

	// 후기 전체 가져오기
	public ArrayList reviewAll() throws Exception {
		String sql = "select g.gname, r.rstar, r.rcontent, r.rdate from goods g, review r, buy b"
				+ " where r.buycode = b.buycode and b.goodscode = g.goodscode";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		list = new ArrayList();

		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("gname"));
			temp.add(rs.getString("rstar"));
			temp.add(rs.getString("rcontent"));
			temp.add(rs.getString("rdate"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}

	// 후기 검색 매소드
	public ArrayList reviewSearch(String text) throws Exception {
		String sql = "select g.gname, r.rstar, r.rcontent, r.rdate from goods g, review r, buy b"
				+ " where r.buycode = b.buycode and b.goodscode = g.goodscode and gname like '%" + text + "%'";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		list = new ArrayList();
		while (rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("gname"));
			temp.add(rs.getString("rstar"));
			temp.add(rs.getString("rcontent"));
			temp.add(rs.getString("rdate"));
			list.add(temp);
		}
		rs.close();
		stmt.close();
		return list;
	}

	// 후기 작성 매소드
	public void reviewAdd(SellVO vo) throws Exception {
		String sql = "insert into review(REVIEWCODE, RSTAR, RCONTENT, RDATE, BUYCODE) values(seq_review.nextval, ?, ?, sysdate, ?)";
		ps = conn.prepareStatement(sql);

		ps.setString(1, vo.getRstar());
		ps.setString(2, vo.getRcontent());
		ps.setString(3, vo.getBuycode());

		ps.executeUpdate();
		ps.close();

	}

	// 후기 작성 여부 확인 매소드
	public boolean hasReview(String buycode) {
		boolean hasReview = false;
		try {
			// 후기 조회 SQL 실행
			String sql = "SELECT * FROM review WHERE buycode = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buycode);
			ResultSet rs = pstmt.executeQuery();

			// 후기가 조회되면 hasReview를 true로 설정
			if (rs.next()) {
				hasReview = true;
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return hasReview;
	}

	// 장바구니 가져오기
	public ArrayList<SellVO> cartMain(int memberCode) throws Exception {
		String sql = "select g.gname, c.ccount, g.gprice from goods g, cart c where g.goodscode = c.goodscode and c.membercode=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, memberCode);
		ResultSet rs = stmt.executeQuery();
		ArrayList<SellVO> list = new ArrayList();

		while (rs.next()) {
			SellVO vo = new SellVO();
			vo.setGname(rs.getString("gname"));
			vo.setCcount(rs.getString("ccount"));
			vo.setGprice(rs.getString("gprice"));
			list.add(vo);
		}
		rs.close();
		stmt.close();
		return list;
	}

	// gname으로 goodscode 끌어오는 매소드
	public int getGoodsCodeByGname(String gname) throws Exception {
		String sql = "SELECT goodscode FROM goods WHERE gname = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, gname);
		ResultSet rs = stmt.executeQuery();
		int goodscode = -1; // 기본값 설정

		if (rs.next()) {
			goodscode = rs.getInt("goodscode");
		}

		rs.close();
		stmt.close();

		return goodscode;
	}

	// 장바구니 추가 메소드
	public int cartAdd(SellVO vo, int goodscode) throws Exception {
		// goodscode 값이 존재하는지 확인
		String checkSql = "SELECT COUNT(*) FROM goods WHERE goodscode = ?";
		PreparedStatement checkStmt = conn.prepareStatement(checkSql);
		checkStmt.setInt(1, goodscode);
		ResultSet checkResult = checkStmt.executeQuery();
		checkResult.next();
		int count = checkResult.getInt(1);

		if (count == 0) {
			// 해당 goodscode가 존재하지 않는 경우, 오류 처리 또는 사용자에게 알림
			throw new Exception("Invalid goodscode: " + goodscode);
		}

		checkResult.close();
		checkStmt.close();

		// cart 테이블에 데이터 삽입
		String insertSql = "INSERT INTO cart(cartcode, ccount, membercode, goodscode) VALUES(?, ?, ?, ?)";
		PreparedStatement insertStmt = conn.prepareStatement(insertSql);
		insertStmt.setInt(1, getCartCode());
		insertStmt.setString(2, vo.getCcount());
		insertStmt.setInt(3, vo.getMembercode());
		insertStmt.setInt(4, goodscode);
		insertStmt.executeUpdate();
		insertStmt.close();

		// 새로 추가된 cart의 goodscode 값을 반환
		String selectSql = "SELECT goodscode FROM cart WHERE cartcode = ?";
		PreparedStatement selectStmt = conn.prepareStatement(selectSql);
		selectStmt.setInt(1, getCartCode());
		ResultSet selectResult = selectStmt.executeQuery();
		int addedGoodscode = -1; // 기본값 설정

		if (selectResult.next()) {
			addedGoodscode = selectResult.getInt("goodscode");
		}

		selectResult.close();
		selectStmt.close();

		return addedGoodscode;

	}

	// 시퀀스번호 가져오는 매서드
	public int getCartCode() throws Exception {
		String selectSql = "SELECT seq_cart.nextval FROM dual";
		PreparedStatement selectStmt = conn.prepareStatement(selectSql);
		ResultSet selectResult = selectStmt.executeQuery();
		int cartCode = -1; // 기본값 설정

		if (selectResult.next()) {
			cartCode = selectResult.getInt(1);
		}

		selectResult.close();
		selectStmt.close();

		return cartCode;
	}

	// 장바구니 삭제 메소드
	public void cartDelete(int memberCode) throws Exception {
		String sql = "DELETE FROM cart WHERE membercode =" + memberCode;
		PreparedStatement pstmt = conn.prepareStatement(sql);

		int rowNum = pstmt.executeUpdate();
		pstmt.close();
	}

	// 상품 상세정보 매소드
	public SellVO getInfo(String gname) throws Exception {
		String sql = "select gname, gimage, gprice, gcontent from goods where gname =?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, gname);
		ResultSet rs = ps.executeQuery();
		SellVO vo = new SellVO();

		while (rs.next()) {
			vo.setGname(rs.getString(1));
			vo.setGimage(rs.getString(2));
			vo.setGprice(rs.getString(3));
			vo.setGcontent(rs.getString(4));
		}
		ps.close();
		rs.close();
		return vo;
	}

	// 구매건수 카운트
	public int ordercount(int membercode) throws Exception {
		String sql = "select count(ordernocode) from orderno o, card c, member b where c.cardcode = o.cardcode and c.membercode = b.membercode and b.membercode=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, membercode);
		ResultSet rs = ps.executeQuery();

		int count = 0;
		if (rs.next()) {
			count = rs.getInt(1);
		}
		return count;
	}

	// 후기작성건수 카운트
	public int reviewcount(int membercode) throws Exception {
		String sql = "select count(reviewcode) from review r, buy b, orderno o,  card c, member m where r.buycode = b.buycode and b.ordernocode = o.ordernocode and o.cardcode = c.cardcode and  c.membercode = m.membercode and m.membercode = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, membercode);
		ResultSet rs = ps.executeQuery();

		int count = 0;
		if (rs.next()) {
			count = rs.getInt(1);
			System.out.println(1);
		}
		return count;
	}

}