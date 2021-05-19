package com.community.dao.login;

import com.community.model.login.property;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PropertyDao {

	/**
	 *
	 * @param conn
	 * @param pt
	 * @return
	 */
	public ResultSet getFangWu(Connection conn, property pt) {
		ResultSet rs = null;
		PreparedStatement pst = null;
		String sql = "select * from property1";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (SQLException e) {
		}
		return rs;
	}
	
	
	
	

	
}
