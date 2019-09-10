//package cn.tedu.nybike.util;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Properties;
//
//import org.apache.commons.dbcp.BasicDataSource;
//
//public class DBUtils {
//	private static BasicDataSource dataSource;
//	static {
//		dataSource = new BasicDataSource();
//		//读取数据
//		Properties prop = new Properties();
//		InputStream ips = 
//				DBUtils.class.getClassLoader()
//				.getResourceAsStream("jdbc.properties");
//		try {
//			prop.load(ips);
//		String driver = prop.getProperty("driver");
//		String url = prop.getProperty("url");
//		String username = prop.getProperty("username");
//		String password = prop.getProperty("password");
//		String initSize = prop.getProperty("initSize");
//		String maxSize = prop.getProperty("maxSize");
//		dataSource.setDriverClassName(driver);
//		dataSource.setUrl(url);
//		dataSource.setUsername(username);
//		dataSource.setPassword(password);
//		dataSource.setInitialSize(Integer.parseInt(initSize));
//		dataSource.setMaxActive(Integer.parseInt(maxSize));
//		
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static Connection getConn() 
//			throws SQLException {
//		return dataSource.getConnection();
//	}
//	
//	public static void close(Connection conn,
//			PreparedStatement ps,ResultSet rs) {
//		if(rs!=null) {
//			try {
//				rs.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}finally {
//				rs=null;
//			}
//		}
//		
//		if(ps!=null) {
//			try {
//				ps.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}finally {
//				ps=null;
//			}
//		}
//		
//		if(conn!=null) {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}finally {
//				conn=null;
//			}
//		}
//	}
//	
//	
//	
//}
//
//
//
//
//
//
