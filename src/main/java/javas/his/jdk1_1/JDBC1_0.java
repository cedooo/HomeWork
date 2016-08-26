package javas.his.jdk1_1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 参考： http://www.oracle.com/technetwork/java/overview-141217.html
 * @author cedo
 * 
 */
public class JDBC1_0 {
	public static void main(String[] args) {
		//JDBC
		//-create connection, send sql, process result
		JDBC1_0.jdbcWithDriverManager();
		
	}
	public static void jdbcWithDriverManager(){
		String url = "jdbc:mysql://192.168.1.134:3306/";
		Connection conn = null;
		try {
			conn = java.sql.DriverManager.getConnection(url,"root", "dhcwg");
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select now() as time");
			while(rs.next()){
				String dbTime = rs.getString("time");
				System.out.println("db time = " + dbTime);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
