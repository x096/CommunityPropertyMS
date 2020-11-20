package com.community.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.community.db.DBConnection;

//数据库操作的父类
public class BaseDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rst;
	
	//增删改封装成一个公用方法
	public boolean insertUpdateDelete(String sql,Object...objects) {
		conn = DBConnection.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			if (objects!=null) {
				for (int i = 0; i < objects.length; i++) {
					pstmt.setObject(i=1, objects[i]);
				}
			}
			int result = pstmt.executeUpdate();
			return result>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(rst, pstmt, conn);
		}
		return false;
				
	}
	
	//查询封装为一个公用的方法
	public ResultSet query(String sql,Object...objects) {
		conn = DBConnection.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			if (objects != null) {
				for (int i = 0; i < objects.length; i++) {
					pstmt.setObject(i+1, objects[i]);
				}
			}
			rst=pstmt.executeQuery();//执行查询
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//不关闭资源
		return rst;
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
			ResultSetMetaData rsmd = rs.getMetaData();

			// 遍历结果集中的数据
			while (rs.next()) {
				List<Object> row_data = new ArrayList<Object>();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					String lable = rsmd.getColumnLabel(i+1);
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

	//查：public
	public static List<List<Object>> query(Connection conn, String sql) {
		return DQL(conn, sql);
	}

}
