package com.community.dao;

//楼盘信息维护
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.community.db.DBConnection;
import com.community.model.Property;

public class PropertyDao extends BaseDao {
	// 增加
	public static int insertProperty(Connection con, Property property) throws Exception {
		String sql = "insert into tb_property values(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, property.getBlock());
		pstmt.setString(2, property.getBuilding());
		pstmt.setString(3, property.getFloor());
		pstmt.setString(4, property.getRoomNo());
		return pstmt.executeUpdate();
	}

	// 修改
	public static int update(Connection con, Property property) throws Exception {
		String sql = "update tb_property set building=?,floor=?,block=? where roomno=? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, property.getBuilding());
		pstmt.setString(2, property.getFloor());
		pstmt.setString(3, property.getBlock());
		pstmt.setString(4, property.getRoomNo());
		return pstmt.executeUpdate();
	}

	// 删除功能

	public static int delete(Connection con, String roomNo) throws Exception {
		String sql = "delete from tb_property where roomno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, roomNo);
		return pstmt.executeUpdate();
	}

	// 查询所有的楼盘信息
	public List<Property> queryPropertys() {
		List<Property> list = new LinkedList<Property>();
		String sql = "select * from tb_property where roomno=?";
		try {
			rst = query(sql);// 调用公用的方法得到的结果集
			while (rst.next()) {
				String block = rst.getString("block");// 根据列名读取该行列数据
				String building = rst.getString("building");
				String floor = rst.getString("floor");
				String roomNo = rst.getString("roomNo");
				// 创建实体对象，存储该行每一列的数据
				Property emp = new Property();
				emp.setBlock(block);
				emp.setBuilding(building);
				emp.setFloor(floor);
				emp.setRoomNo(roomNo);
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

	// 查询表信息
	public static ResultSet getRS(Connection conn, Property property) {
		ResultSet rst = null;
		PreparedStatement pst = null;
		String sql = "select * from tb_property";
		try {
			pst = conn.prepareStatement(sql);
			rst = pst.executeQuery();
		} catch (Exception evt) {
		}
		return rst;
	}

	/**
	 * 判断是否存在
	 * 
	 * @param con
	 * @param bookTypeId
	 * @return
	 * @throws Exception
	 */
	public static boolean existPropertyRoomNo(Connection con, String roomno) throws Exception {
		String sql = "select * from tb_property where roomno = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, roomno);
		ResultSet rs = pstmt.executeQuery();
		return rs.next();
	}

	/**
	 * 楼盘信息查询
	 * 
	 * @throws SQLException
	 */
	public static ResultSet queryRoomNo(Connection con, String roomNo) throws SQLException {
		String sql = "select * from tb_property";

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
