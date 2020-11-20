package com.community.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//负责数据库的连接和断开释放资源
public class DBConnection {
	//驱动的类名
	private static final String DRIVERNAME = "com.mysql.jdbc.Driver";
	//URL连接哪个电脑上的数据库
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/community?serverTimezone=GMT%2B8&useSSL=false";
	//账号
	private static final String NAME = "root";
	//密码
	private static final String PWD = "p@ssW0rd";
	
	//1.加载驱动
	static {
		try {
			Class.forName(DRIVERNAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//2.获取连接并且返回给调用者(因为是工具类，所以一般是静态的)
	public static Connection getConn() {
		try {
			Connection conn = DriverManager.getConnection(URL, NAME, PWD);
			return conn;//返回获取的连接对象
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//3.释放资源的方法(第一个是查询，第二三个是增删改查)
	public static void close(ResultSet rst,PreparedStatement pstmt,Connection conn) {
		try {
			if(rst!=null)
				rst.close();
			if(pstmt!=null)
				pstmt.close();
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 关闭数据库连接
	 * @param con
	 * @throws Exception
	 */
	public static void closeCon(Connection con)throws Exception{
		if(con!=null){
			con.close();
		}
	}
	public static int insert(Connection conn, String sql, Object... paras) {
		return DML(conn, sql, paras);
	}

	private static int DML(Connection conn, String sql/* 有占位符？ */,
			Object... paras/* 数量跟占位符数目相同 */) {
		if (null == conn)
			return 0;

		PreparedStatement psmt = null;
		try {
			// 创建一个SQL执行对象PreparedStatement
			psmt = conn.prepareStatement(sql);
			// 使用Paras把占位符填满
			for (int i = 0; i < paras.length; i++) {
				psmt.setObject(i + 1, paras[i]);
			}

			// 执行SQL
			return psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != psmt) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
}
