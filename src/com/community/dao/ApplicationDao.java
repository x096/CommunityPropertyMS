package com.community.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.community.db.DBConnection;
import com.community.db.StringUtil;
import com.community.model.Application;

public class ApplicationDao extends BaseDao{
	//插入
	public static int insert(Connection con, Application application) throws Exception {
		String sql = "insert into tb_application values(?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, application.getApplicant());
		pstmt.setString(2, application.getRoomno());
		pstmt.setString(3, application.getApplytime());
		pstmt.setString(4, application.getApplyprogram());
		pstmt.setString(5, application.getApplystate());
		return pstmt.executeUpdate();
	}

	// 删除
	public static int delete(Connection con, String applicant) throws SQLException {
		String sql = "delete from tb_application where applicant=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, applicant);
		return pstmt.executeUpdate();
	}

	// 修改
	public static int update(Connection con, Application application) throws SQLException {
		String sql = "update tb_application set roomno=?,applytime=? ,applyprogram=?,applystate=? where applicant=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, application.getRoomno());
		pstmt.setString(2, application.getApplytime());
		pstmt.setString(3, application.getApplyprogram());
		pstmt.setString(4, application.getApplystate());
		pstmt.setString(5, application.getApplicant());
		return pstmt.executeUpdate();
	}

	// 查询表信息
	public static ResultSet getRS(Connection conn) {
		ResultSet rst = null;
		PreparedStatement pst = null;
		String sql = "select * from tb_application";
		try {
			pst = conn.prepareStatement(sql);
			rst = pst.executeQuery();
		} catch (Exception evt) {
		}
		return rst;
	}

	// 查询信息
	public List<Application> getApplication() {
		List<Application> list = new LinkedList<Application>();
		String sql = "select * from tb_application";
		try {
			rst = query(sql);// 调用公用的方法得到的结果集
			while (rst.next()) {
				String applicant = rst.getString("applicant");// 根据列名读取该行列数据
				String roomno = rst.getString("roomno");
				String applytime = rst.getString("applytime");
				String applyprogram = rst.getString("applyprogram");
				String applystate = rst.getString("applystate");
				// 创建实体对象，存储该行每一列的数据
				Application emp = new Application();
				emp.setApplicant(applicant);
				emp.setRoomno(roomno);
				emp.setApplytime(applytime);
				emp.setApplyprogram(applyprogram);
				emp.setApplystate(applystate);
				// 将实体对象放入集合中
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭释放资源
			DBConnection.close(rst, pstmt, conn);
		}
		return list;
	}

	/**
	 * 查询
	 **/
	public static ResultSet rst(Connection con, Application application) throws Exception {
		StringBuffer sb = new StringBuffer("select * from tb_application");
		if (StringUtil.isNotEmpty(application.getApplicant())) {
			sb.append(" and payno like '%" + application.getApplicant() + "%'");
		}
		if (StringUtil.isNotEmpty(application.getRoomno())) {
			sb.append(" and payname like '%" + application.getRoomno() + "%'");
		}
		if (StringUtil.isNotEmpty(application.getApplytime())) {
			sb.append(" and paytype like '%" + application.getApplytime() + "%'");
		}
		if (StringUtil.isNotEmpty(application.getApplyprogram())) {
			sb.append(" and paytype like '%" + application.getApplyprogram() + "%'");
		}
		if (StringUtil.isNotEmpty(application.getApplystate())) {
			sb.append(" and paytype like '%" + application.getApplystate() + "%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	/**
	 * 楼盘信息查询
	 * 
	 * @throws SQLException
	 */
	public static ResultSet queryApplicant(Connection con, String applicant) throws SQLException {
		String sql = "select * from tb_application";

		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
