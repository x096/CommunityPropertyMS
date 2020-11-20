package com.community.dao.login;

import com.community.db.DBConnection;
import com.community.model.login.Userinfo;

import java.sql.Connection;

public class UserInfoDao {
	
	public int getinsert(Userinfo ui) {
//		Userinfo ui = new Userinfo();
		
		System.out.println(""+ui.getCompanyAddress()+ui .getCompanyName());

		String sql = "INSERT into userinfo VALUES (null,'"+ui.getCompanyName()+"','"+ui.getCompanyAddress()+"','"+ui.getCompanyZip()+"','"+ui.getIdCade()+"','"+ui.getName()+"','"+ui.getPostbox()+"','"+ui.getSex()+"'); ";
		Connection conn = DBConnection.getConn();

		int resuilt = DBConnection.insert(conn, sql);
//		int resuilt = JDBCUtil.insert(conn, sql, ui.getCompanyName(),ui.getCompanyAddress(),ui.getCompanyZip(),ui.getIdCade(),ui.getName(),ui.getPostbox(),ui.getSex());
		
		return resuilt;
	}
}
