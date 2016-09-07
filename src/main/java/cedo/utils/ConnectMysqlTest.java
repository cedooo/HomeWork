package cedo.utils;

import java.sql.SQLException;

public class ConnectMysqlTest {
	public static void main(String[] args) {
		java.sql.Connection conn = null;
		try {
			conn = java.sql.DriverManager.getConnection("jdbc:mysql://192.168.1.134:3306/cedo_fvsd_29s", "root", "dhcwg");
			java.sql.Statement sta = conn.createStatement();
			java.sql.ResultSet rs = sta.executeQuery("select now() as dt");
			while(rs.next()){
				String dt = rs.getString(1);
				System.out.println(dt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
