package javas.his.jdk1_4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import javas.his.jdk1_2.JDBC2_0;

/**
 * 参考： http://www.oracle.com/technetwork/java/overview-141217.html
 * 
 * @author cedo
 * 
 */
public class JDBC3_0 extends javas.his.jdk1_2.JDBC2_0{
	public static void main(String[] args) {
		//JDBC
		//-create connection, send sql, process result
		JDBC3_0.jdbcWithDriverManager();
		
		/**
		 * 推荐使用DataSource
		 */
		JDBC3_0.jdbcWithDataSource();
	}
	
	/**
	 * JNDI
	 * 抛出 javax.naming.NoInitialContextException :
	 * 需要在web服务器中配置 context.xml&web.xml
	 * @since JDK1.4
	 */
	public static void jdbcWithDataSource(){
		//? how to get the DataSource Object???
		/* 
		 * 一般使用web容器提供的数据源,也可能是 datasource对象或者数据库连接池
		 * eg. c3p0 ComboPooledDataSource ds = new ComboPooledDataSource();
		 * apache BasicDataSource ds = new BasicDataSource();
		 */
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
