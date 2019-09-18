package cn.tedu.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HiveDBUtil {

	private static String url="jdbc:hive2://192.168.56.101:10000/nybike";
	private static String user="root";
	private static String password="root";
	
	static{
		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取hive链接的方法
	 * @throws SQLException 
	 * @return：连接对象
	 */
	public static Connection getHiveConn() throws SQLException{
		return DriverManager.getConnection(url, user, password);
	}
	
	/*public static void main(String[] args) throws SQLException {
		Connection conn=HiveDBUtil.getHiveConn();
		System.out.println(conn);
	}*/
}
