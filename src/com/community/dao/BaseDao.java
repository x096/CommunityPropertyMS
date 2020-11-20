package com.community.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.community.db.DBConnection;

//���ݿ�����ĸ���
public class BaseDao {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rst;
	
	//��ɾ�ķ�װ��һ�����÷���
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
	
	//��ѯ��װΪһ�����õķ���
	public ResultSet query(String sql,Object...objects) {
		conn = DBConnection.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			if (objects != null) {
				for (int i = 0; i < objects.length; i++) {
					pstmt.setObject(i+1, objects[i]);
				}
			}
			rst=pstmt.executeQuery();//ִ�в�ѯ
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//���ر���Դ
		return rst;
	}
	

	// DQL����ѯ��ע�⣺ֻ�Ǽ򵥵�ʵ�ֲ�ѯ�����Ըĳɷ��͡��ࡢList<List>�ȵȷ�ʽʵ�֡�
	private static List<List<Object>> DQL(Connection conn, String sql) {
		if (null == conn)
			return null;

		List<List<Object>> arr = new ArrayList<List<Object>>();

		ResultSet rs = null;
		PreparedStatement psmt = null;
		try {
			// ���SQLִ�еĶ���
			psmt = conn.prepareStatement(sql);
			// ִ�в�ѯ
			rs = psmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			// ����������е�����
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

	//�飺public
	public static List<List<Object>> query(Connection conn, String sql) {
		return DQL(conn, sql);
	}

}
