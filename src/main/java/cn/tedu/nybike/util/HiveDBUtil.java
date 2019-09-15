package cn.tedu.nybike.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HiveDBUtil {
    private static  Logger logger = LoggerFactory.getLogger(HiveDBUtil.class);;
    private static String url="jdbc:hive2://192.168.56.101:10000/nybike";
    private static String user="root";
    private static String password="root";
//    注册驱动
//    使用静态代码块/静态初始化器，用于初始化静态变量，当类在加载完成之后就立刻执行
    static{
    try {
        //此处用于注册hive 的jdbc驱动
        Class.forName("org.apache.hive.jdbc.HiveDriver");

    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}
    /**
     * 获取hive连接
     * @return 连接对象
     */
    public static Connection getHiveConnection() throws SQLException {
        logger.info("加载驱动中......");
        return DriverManager.getConnection(url,user,password);
    }

    public static void main(String[] args) throws SQLException {
        Connection con=HiveDBUtil.getHiveConnection();
        logger.info("加载驱动成功，驱动信息为："+con);
    }
}
