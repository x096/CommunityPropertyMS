package com.community.util;

import java.sql.*;

//加载驱动、获得连接、释放资源封装成类JDBCConn
public class JDBCConn {
	private final static String DRIVER = "com.mysql.jdbc.Driver";	//驱动
	private final static String DBNAME = "jdbc:mysql://127.0.0.1:3306/community?serverTimezone=GMT%2B8&useSSL=false";//URL及数据库名
	private final static String DBUSER = "root";//账户
	private final static String DBPWD = "p@ssW0rd";//密码

	//静态代码块
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	//获取连接
	public static Connection getConnection() {
		
		try {
			//创建连接对象
			return DriverManager.getConnection(DBNAME, DBUSER, DBPWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	//释放资源对象
	public static void release(Statement stmt, Connection conn) {
		try {
			if (null != stmt)
				stmt.close();

			if (null != conn)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

