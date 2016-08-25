package j8s.his.jdk1_1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * 参考： http://www.oracle.com/technetwork/java/overview-141217.html
 * @author cedo
 * 
 */
public class JDBC {
	public static void main(String[] args) {
		//JDBC
		//-create connection, send sql, process result
		JDBC.jdbcWithDriverManager();
		
		/**
		 * 推荐使用DataSource
		 */
		JDBC.jdbcWithDataSource();
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
	/**
	 * JNDI
	 * 抛出 javax.naming.NoInitialContextException :
	 * 需要在web服务器中配置 context.xml&web.xml
	 * @since JDK1.4
	 */
	public static void jdbcWithDataSource(){
		//? how to get the DataSource Object???
		Context ctx;

		DataSource ds;
		Connection conn = null;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("jdbc/ds/dhcwg");
			
			conn = ds.getConnection();
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
