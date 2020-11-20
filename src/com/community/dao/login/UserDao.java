package com.community.dao.login;

import com.community.db.DBConnection;
import com.community.model.login.User;
import com.mysql.jdbc.JDBC4Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDao {
	
	//TODO锟斤拷锟斤拷锟斤拷锟捷匡拷   锟斤拷询锟斤拷锟斤拷
	public static User login(User user) {
		User resultUser = null;	//锟矫伙拷锟斤拷锟�
		Connection conn = DBConnection.getConn();
		String Sql = "select * from userlogin where userName = ? and userPwd = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(Sql);	//执锟斤拷Sql锟斤拷锟�
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserPwd());
			ResultSet rs = pstmt.executeQuery();	//执锟叫诧拷询 锟斤拷锟斤拷锟截斤拷锟斤拷锟�
			if(rs.next()) {		
				resultUser = new User();
				resultUser.setId(rs.getInt("id"));	//锟叫诧拷询
				resultUser.setUserName("userName");
				resultUser.setUserPwd("userPwd");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultUser;
	}
}
