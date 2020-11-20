package com.community.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.community.db.DBConnection;
import com.community.db.StringUtil;
import com.community.model.ParkingLot;

public class ParkingLotDao extends BaseDao {
	// ����
	public static int insert(Connection con, ParkingLot parkingLot) throws Exception {
		String sql = "insert into tb_parkinglot values(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, parkingLot.getPlno());
		pstmt.setString(2, parkingLot.getOwnerno());
		pstmt.setString(3, parkingLot.getPltype());
		pstmt.setString(4, parkingLot.getPlstate());
		return pstmt.executeUpdate();
	}

	// ɾ��
	public static int delete(Connection con, String plno) throws SQLException {
		String sql = "delete from tb_parkinglot where plno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, plno);
		return pstmt.executeUpdate();
	}

	// �޸�

	public static int update(Connection con, ParkingLot parkingLot) throws SQLException {
		String sql = "update tb_parkinglot set ownerno=?,pltype=? ,plstate =? where plno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, parkingLot.getOwnerno());
		pstmt.setString(2, parkingLot.getPltype());
		pstmt.setString(3, parkingLot.getPlstate());
		pstmt.setString(4, parkingLot.getPlno());

		return pstmt.executeUpdate();
	}

	// ��ѯ����Ϣ
	public static ResultSet getRS(Connection conn, ParkingLot parkingLot) {
		ResultSet rst = null;
		PreparedStatement pst = null;
		String sql = "select * from tb_parkinglot";

		try {
			pst = conn.prepareStatement(sql);
			rst = pst.executeQuery();
		} catch (Exception evt) {
		}
		return rst;
	}

	// ��ѯ��Ϣ

	public List<ParkingLot> getParkingLot() {
		List<ParkingLot> list = new LinkedList<ParkingLot>();
		String sql = "select * from tb_parkinglot";
		try {
			rst = query(sql);// ���ù��õķ����õ��Ľ����
			while (rst.next()) {
				String plno = rst.getString("plno");// ����������ȡ����������
				String ownerno = rst.getString("ownerno");
				String pltype = rst.getString("pltype");
				String plstate = rst.getString("plstate");
				// ����ʵ����󣬴洢����ÿһ�е�����
				ParkingLot emp = new ParkingLot();
				emp.setPlno(plno);
				emp.setOwnerno(ownerno);
				emp.setPltype(pltype);
				emp.setPlstate(plstate);
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

	public static ResultSet rst(Connection con, ParkingLot parkingLot) throws Exception {
		StringBuffer sb = new StringBuffer("select * from tb_parkinglot");
		if (StringUtil.isNotEmpty(parkingLot.getPlno())) {
			sb.append(" and plno like '%" + parkingLot.getPlno() + "%'");
		}
		if (StringUtil.isNotEmpty(parkingLot.getOwnerno())) {
			sb.append(" and ownerno like '%" + parkingLot.getOwnerno() + "%'");
		}
		if (StringUtil.isNotEmpty(parkingLot.getPltype())) {
			sb.append(" and pltype like '%" + parkingLot.getPltype() + "%'");
		}
		if (StringUtil.isNotEmpty(parkingLot.getPlstate())) {
			sb.append(" and plstate like '%" + parkingLot.getPlstate() + "%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}

	/**
	 * ��λ��Ϣ��ѯ
	 * 
	 * @throws SQLException
	 */
	public static ResultSet queryPlno(Connection con, String plno) throws SQLException {
		String sql = "select * from tb_parkinglot";

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
