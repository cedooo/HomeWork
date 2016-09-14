package cedo.utils;

import java.sql.SQLException;
import static java.lang.System.out;

public class ConnectSqlServer2008Test {
	public static void main(String[] args) {
		java.sql.Connection conn = null;
		try {
			conn = connectionWithJtds();
            //conn = connectionWithMsjdbc();
			if(conn==null){
				return;
			}
			java.sql.Statement sta = conn.createStatement();
			java.sql.ResultSet rs = sta.executeQuery("select getdate() as dte");
			while (rs.next()) {
				out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	static public java.sql.Connection connectionWithJtds(){
		java.sql.Connection conn = null;
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			conn = java.sql.DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.134:1433;instance=cgnmobins",
					"sa", "dhcwg");
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	static public java.sql.Connection connectionWithMsjdbc(){
		java.sql.Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = java.sql.DriverManager.getConnection("jdbc:sqlserver://192.168.1.234:1433;DatabaseName=cgnmobins",
					"sa", "dhcwg");
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
