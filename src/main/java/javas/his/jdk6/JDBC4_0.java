package javas.his.jdk6;

import java.sql.SQLException;

/**
 * Created by cedo on 2016/9/9.
 */
public class JDBC4_0 {
    public static void main(String[] args){
        JDBC4_0.autoLoadDriverClass();
    }

    public static void autoLoadDriverClass(){
        java.sql.Connection conn = null;
        try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = java.sql.DriverManager.getConnection("jdbc:sqlserver://192.168.1.234:1433;DatabaseName=cgnmobins",
                    "sa", "dhcwg");

            java.sql.Statement sta = conn.createStatement();
            java.sql.ResultSet rs = sta.executeQuery("select getdate() as dte");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        }  catch (java.sql.SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
