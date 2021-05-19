package com.community.dao.login;

import com.community.db.DBConnection;
import com.community.model.login.User;
import com.mysql.jdbc.JDBC4Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDao {
	
	public static User login(User user) {
		User resultUser = null;
		Connection conn = DBConnection.getConn();
		String Sql = "select * from userlogin where userName = ? and userPwd = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(Sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserPwd());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {		
				resultUser = new User();
				resultUser.setId(rs.getInt("id"));
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
