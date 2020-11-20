package com.community.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//�������ݿ�����ӺͶϿ��ͷ���Դ
public class DBConnection {
	//����������
	private static final String DRIVERNAME = "com.mysql.jdbc.Driver";
	//URL�����ĸ������ϵ����ݿ�
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/community?serverTimezone=GMT%2B8&useSSL=false";
	//�˺�
	private static final String NAME = "root";
	//����
	private static final String PWD = "p@ssW0rd";
	
	//1.��������
	static {
		try {
			Class.forName(DRIVERNAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//2.��ȡ���Ӳ��ҷ��ظ�������(��Ϊ�ǹ����࣬����һ���Ǿ�̬��)
	public static Connection getConn() {
		try {
			Connection conn = DriverManager.getConnection(URL, NAME, PWD);
			return conn;//���ػ�ȡ�����Ӷ���
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//3.�ͷ���Դ�ķ���(��һ���ǲ�ѯ���ڶ���������ɾ�Ĳ�)
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
	 * �ر����ݿ�����
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

	private static int DML(Connection conn, String sql/* ��ռλ���� */,
			Object... paras/* ������ռλ����Ŀ��ͬ */) {
		if (null == conn)
			return 0;

		PreparedStatement psmt = null;
		try {
			// ����һ��SQLִ�ж���PreparedStatement
			psmt = conn.prepareStatement(sql);
			// ʹ��Paras��ռλ������
			for (int i = 0; i < paras.length; i++) {
				psmt.setObject(i + 1, paras[i]);
			}

			// ִ��SQL
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
