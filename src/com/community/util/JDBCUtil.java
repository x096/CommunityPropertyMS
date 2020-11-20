package com.community.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//主要功能是：封装通用的增删改查
public class JDBCUtil {
	// DML： 增删改
	private static int DML(Connection conn, String sql/* 有占位符？ */,
			Object... paras/* 数量跟占位符数目相同 */) {
		if (null == conn)
			return 0;

		PreparedStatement psmt = null;	//预编译SQL语句
		try {
			// 创建一个SQL执行对象PreparedStatement
			psmt = conn.prepareStatement(sql);
			// 使用Paras把占位符填满
			for (int i = 0; i < paras.length; i++) {
				psmt.setObject(i + 1, paras[i]);
			}

			// 执行SQL
			return psmt.executeUpdate();	//返回int值
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
	// 增，public
	public static int insert(Connection conn, String sql, Object... paras) {
		return DML(conn, sql, paras);
	}

	// 删，public
	public static int delete(Connection conn, String sql, Object... paras) {
		int res= DML(conn, sql, paras);
		return res;
	}

	// 改，public
	public static int update(Connection conn, String sql, Object... paras) {
		return DML(conn, sql, paras);
	}

	// DQL：查询【注意：只是简单的实现查询，可以改成泛型、类、List<List>等等方式实现】
	private static List<List<Object>> DQL(Connection conn, String sql) {
		if (null == conn)
			return null;

		List<List<Object>> arr = new ArrayList<List<Object>>();

		ResultSet rs = null;
		PreparedStatement psmt = null;
		try {
			// 获得SQL执行的对象
			psmt = conn.prepareStatement(sql);
			// 执行查询
			rs = psmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();	//列查询

			// 遍历结果集中的数据
			while (rs.next()) {
				List<Object> row_data = new ArrayList<Object>();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					String lable = rsmd.getColumnLabel(i + 1);
					Object obj = rs.getObject(lable);
					row_data.add(obj);
				}
				arr.add(row_data);
			}

			return arr;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (null != rs)
					rs.close();
				if (null != psmt)
					psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	// 查：public
	public static List<List<Object>> query(Connection conn, String sql) {
		return DQL(conn, sql);
	}

}
