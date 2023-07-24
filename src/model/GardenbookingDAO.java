package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.GardenVO;

public class GardenbookingDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.0.36:1521:orcl";
	private String id = "s5";
	private String pass = "s5";
	PreparedStatement ps = null;
	Statement stmt = null;
	ArrayList<ArrayList<Object>> list = null;
	Connection conn = null;
	GardenVO vo = null;

	public GardenbookingDAO() throws Exception {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, pass);
	}

	// 수정된 메서드: 예약 내역 조회
	public ArrayList<ArrayList<String>> bookingSearch() throws Exception {
		String sql = "SELECT g.gaddr, b.bdate, b.bstart, b.bend, g.gprice from booking b, garden g where b.gardencode = g.gardencode";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList<ArrayList<String>> list = new ArrayList<>();

		while (rs.next()) {
			ArrayList<String> row = new ArrayList<>();
			row.add(rs.getString("gaddr"));
			row.add(rs.getString("bdate"));
			row.add(rs.getString("bstart"));
			row.add(rs.getString("bend"));

			// 14일치 대여료 계산
			int gPrice = rs.getInt("gprice");
			int totalPrice = gPrice * 90;
			row.add(Integer.toString(totalPrice));

			list.add(row);
		}

		rs.close();
		stmt.close();
		return list;
	}

	// 예약취소메서드
	public void cancelBooking(int selectedIndex) throws Exception {
		String selectBookingCodeSQL = "SELECT bookingcode FROM booking";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(selectBookingCodeSQL);
		ArrayList<Integer> bookingCodes = new ArrayList<>();

		while (rs.next()) {
			bookingCodes.add(rs.getInt("bookingcode"));
		}

		rs.close();
		stmt.close();

		if (selectedIndex >= 0 && selectedIndex < bookingCodes.size()) {
			int bookingCode = bookingCodes.get(selectedIndex);

			String deleteBookingSQL = "DELETE FROM booking WHERE bookingcode = ?";
			ps = conn.prepareStatement(deleteBookingSQL);
			ps.setInt(1, bookingCode);
			ps.executeUpdate();
			ps.close();

		}
	}
}
