package com.community.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//��Ҫ�����ǣ���װͨ�õ���ɾ�Ĳ�
public class JDBCUtil {
	// DML�� ��ɾ��
	private static int DML(Connection conn, String sql/* ��ռλ���� */,
			Object... paras/* ������ռλ����Ŀ��ͬ */) {
		if (null == conn)
			return 0;

		PreparedStatement psmt = null;	//Ԥ����SQL���
		try {
			// ����һ��SQLִ�ж���PreparedStatement
			psmt = conn.prepareStatement(sql);
			// ʹ��Paras��ռλ������
			for (int i = 0; i < paras.length; i++) {
				psmt.setObject(i + 1, paras[i]);
			}

			// ִ��SQL
			return psmt.executeUpdate();	//����intֵ
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
	// ����public
	public static int insert(Connection conn, String sql, Object... paras) {
		return DML(conn, sql, paras);
	}

	// ɾ��public
	public static int delete(Connection conn, String sql, Object... paras) {
		int res= DML(conn, sql, paras);
		return res;
	}

	// �ģ�public
	public static int update(Connection conn, String sql, Object... paras) {
		return DML(conn, sql, paras);
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
			ResultSetMetaData rsmd = rs.getMetaData();	//�в�ѯ

			// ����������е�����
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

	// �飺public
	public static List<List<Object>> query(Connection conn, String sql) {
		return DQL(conn, sql);
	}

}
