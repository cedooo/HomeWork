package cn.com.dhcc.adam.homework.c3p0test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Test {
	public static void main(String[] args){
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} 
		//loads the jdbc driver            
		cpds.setJdbcUrl( "jdbc:mysql://127.0.0.1:3306/myserver" );
		cpds.setUser("root");                                  
		cpds.setPassword("root");                                  
			
		// the settings below are optional -- c3p0 can work with defaults
		cpds.setMinPoolSize(3);                                     
		cpds.setAcquireIncrement(3);
		cpds.setMaxPoolSize(8);
		cpds.setMaxStatements(180);
		
		Connection conn = null;
		try {
			conn = cpds.getConnection();
			Statement statement = conn.createStatement();
			String sql = "select * from jfdevins";
			ResultSet rs = statement.executeQuery(sql );
			while(rs.next()){
				System.out.println(rs.getString("insname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		try {
			Thread.sleep(600*1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			  System.err.println("num_connections: "      + cpds.getNumConnectionsDefaultUser());
			  System.err.println("num_busy_connections: " + cpds.getNumBusyConnectionsDefaultUser());
			  System.err.println("num_idle_connections: " + cpds.getNumIdleConnectionsDefaultUser());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cpds.close();
		}
	}
}
