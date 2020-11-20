package com.community.dao;

//¥����Ϣά��
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
	// ����
	public static int insertProperty(Connection con, Property property) throws Exception {
		String sql = "insert into tb_property values(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, property.getBlock());
		pstmt.setString(2, property.getBuilding());
		pstmt.setString(3, property.getFloor());
		pstmt.setString(4, property.getRoomNo());
		return pstmt.executeUpdate();
	}

	// �޸�
	public static int update(Connection con, Property property) throws Exception {
		String sql = "update tb_property set building=?,floor=?,block=? where roomno=? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, property.getBuilding());
		pstmt.setString(2, property.getFloor());
		pstmt.setString(3, property.getBlock());
		pstmt.setString(4, property.getRoomNo());
		return pstmt.executeUpdate();
	}

	// ɾ������

	public static int delete(Connection con, String roomNo) throws Exception {
		String sql = "delete from tb_property where roomno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, roomNo);
		return pstmt.executeUpdate();
	}

	// ��ѯ���е�¥����Ϣ
	public List<Property> queryPropertys() {
		List<Property> list = new LinkedList<Property>();
		String sql = "select * from tb_property where roomno=?";
		try {
			rst = query(sql);// ���ù��õķ����õ��Ľ����
			while (rst.next()) {
				String block = rst.getString("block");// ����������ȡ����������
				String building = rst.getString("building");
				String floor = rst.getString("floor");
				String roomNo = rst.getString("roomNo");
				// ����ʵ����󣬴洢����ÿһ�е�����
				Property emp = new Property();
				emp.setBlock(block);
				emp.setBuilding(building);
				emp.setFloor(floor);
				emp.setRoomNo(roomNo);
				// ��ʵ�������뼯����
				list.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ر��ͷ���Դ
			DBConnection.close(rst, pstmt, conn);
		}

		return list;
	}

	// ��ѯ����Ϣ
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
	 * �ж��Ƿ����
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
	 * ¥����Ϣ��ѯ
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
