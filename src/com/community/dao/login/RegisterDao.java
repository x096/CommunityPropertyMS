package com.community.dao.login;

import com.community.db.DBConnection;
import com.community.model.login.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RegisterDao {

	//锟斤拷询
	public static User query(User user, String Sql) {
		User resultUser = null;	//锟矫伙拷锟斤拷锟�
		Connection conn = DBConnection.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(Sql);	//执锟斤拷Sql锟斤拷锟�
//			pstmt.setString(1, user.getUserName());
//			pstmt.setString(2, user.getUserPwd());
			ResultSet rs = pstmt.executeQuery();	//执锟叫诧拷询 锟斤拷锟斤拷锟截斤拷锟斤拷锟�
			if(rs.next()) {		
				resultUser = new User();
				resultUser.setId(rs.getInt("id"));	//锟叫诧拷询
				resultUser.setUserName("userName");
				resultUser.setUserPwd("userPwd");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultUser;
	}
	
	//锟斤拷锟�
	public static int insert(User user,String Sql) {
		Connection conn =DBConnection.getConn();
		try {
			Statement stmt  = conn.prepareCall(Sql);
			return stmt.executeUpdate(Sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
//	public static void main(String[] args) {
//		String Sql = "insert INTO userlogin\r\n" + 
//				" VALUES (null,'2','b')";
//		insert(null, Sql);
//	}
}
