package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.rec.GardenVO;

public class GardenDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.0.36:1521:orcl";
	private String id = "s5";
	private String pass = "s5";
	PreparedStatement ps = null;
	Statement stmt = null;
	GardenVO vo = null;
	ArrayList<GardenVO> list = null;
	Connection conn = null;

	public GardenDAO() throws Exception {
		// TODO Auto-generated constructor stub
		Class.forName(driver);
		conn = DriverManager.getConnection(url, id, pass);
	}

	// 텃밭정보 메서드
	public ArrayList<GardenVO> getAllGardens() throws Exception {
		ArrayList<GardenVO> gardens = new ArrayList<>();

		String query = "SELECT gaddr, gprice, gsize FROM garden";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			GardenVO garden = new GardenVO();
			garden.setGaddr(rs.getString("gaddr"));
			garden.setGprice(rs.getString("gprice"));
			garden.setGsize(rs.getString("gsize"));
			gardens.add(garden);
		}

		rs.close();
		ps.close();

		return gardens;
	}

	// 텃밭예약 메서드
	public void insertBooking(GardenVO garden) throws Exception {
		String query = "INSERT INTO booking (bookingcode, bdate, bstart, bend, bcheck, membercode, gardencode) VALUES (seq_booking.nextval, sysdate, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, garden.getBstart());
		ps.setString(2, garden.getBend());
		ps.setString(3, garden.getBcheck());
		ps.setInt(4, garden.getMembercode());
		ps.setInt(5, garden.getGardencode());

		ps.executeUpdate();
		ps.close();
	}

}
