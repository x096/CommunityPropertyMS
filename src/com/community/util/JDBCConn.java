package com.community.util;

import java.sql.*;

//����������������ӡ��ͷ���Դ��װ����JDBCConn
public class JDBCConn {
	private final static String DRIVER = "com.mysql.jdbc.Driver";	//����
	private final static String DBNAME = "jdbc:mysql://127.0.0.1:3306/community?serverTimezone=GMT%2B8&useSSL=false";//URL�����ݿ���
	private final static String DBUSER = "root";//�˻�
	private final static String DBPWD = "p@ssW0rd";//����

	//��̬�����
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	//��ȡ����
	public static Connection getConnection() {
		
		try {
			//�������Ӷ���
			return DriverManager.getConnection(DBNAME, DBUSER, DBPWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	//�ͷ���Դ����
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

