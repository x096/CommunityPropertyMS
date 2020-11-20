package com.community.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.community.db.DBConnection;
import com.community.db.StringUtil;
import com.community.model.Owner;;

public class OwnerDao extends BaseDao {
	// ����һ��ҵ����Ϣ
	public static int insert(Connection con, Owner owner) throws Exception {
		String sql = "insert into tb_owner values(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, owner.getOwnerNo());
		pstmt.setString(2, owner.getRoomNo());
		pstmt.setString(3, owner.getOwnerName());
		pstmt.setString(4, owner.getOwnerPhone());
		return pstmt.executeUpdate();
	}

	// ɾ����Ϣ
	public static int delete(Connection con, String ownerNo) throws SQLException {
		String sql = "delete from tb_owner where ownerno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, ownerNo);
		return pstmt.executeUpdate();
	}

	// �޸���Ϣ
	public static int update(Connection con, Owner owner) throws SQLException {
		String sql = "update tb_owner set roomno=?,ownerName=?,ownerPhone=? where ownerno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, owner.getRoomNo());
		pstmt.setString(2, owner.getOwnerName());
		pstmt.setString(3, owner.getOwnerPhone());
		pstmt.setString(4, owner.getOwnerNo());
		return pstmt.executeUpdate();
	}

	// ��ѯ����Ϣ
	public static ResultSet getRS(Connection conn, Owner owner) {
		ResultSet rst = null;
		PreparedStatement pst = null;
		String sql = "select * from tb_owner";

		try {
			pst = conn.prepareStatement(sql);
			rst = pst.executeQuery();
		} catch (Exception evt) {
		}
		return rst;
	}

	// ��ѯ�û���Ϣ
	public List<Owner> getOwners() {
		List<Owner> list = new LinkedList<Owner>();
		String sql = "select * from tb_owner";
		try {
			rst = query(sql);// ���ù��õķ����õ��Ľ����
			while (rst.next()) {
				String ownerNo = rst.getString("ownerNo");// ����������ȡ����������
				String roomNo = rst.getString("roomNo");
				String ownerName = rst.getString("ownerName");
				String OwnerPhone = rst.getString("OwnerPhone");
				// ����ʵ����󣬴洢����ÿһ�е�����
				Owner emp = new Owner();
				emp.setOwnerNo(ownerNo);
				emp.setRoomNo(roomNo);
				emp.setOwnerName(ownerName);
				emp.setOwnerPhone(OwnerPhone);
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

	/**
	 * ��ѯ
	 * 
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 *
	 **/

	public static ResultSet rst(Connection con, Owner owner) throws Exception {
		StringBuffer sb = new StringBuffer("select * from tb_owner");
		if (StringUtil.isNotEmpty(owner.getOwnerNo())) {
			sb.append(" and ownerNo like '%" + owner.getOwnerNo() + "%'");
		}
		if (StringUtil.isNotEmpty(owner.getRoomNo())) {
			sb.append(" and roomNo like '%" + owner.getRoomNo() + "%'");
		}
		if (StringUtil.isNotEmpty(owner.getOwnerName())) {
			sb.append(" and ownerName like '%" + owner.getOwnerName() + "%'");
		}
		if (StringUtil.isNotEmpty(owner.getOwnerPhone())) {
			sb.append(" and ownerPhone like '%" + owner.getOwnerPhone() + "%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}

	/**
	 * ҵ����Ϣ��ѯ
	 * 
	 * @throws SQLException
	 */
	public static ResultSet queryOwnerNo(Connection con, String ownerNo) throws SQLException {
		String sql = "select * from tb_owner";

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