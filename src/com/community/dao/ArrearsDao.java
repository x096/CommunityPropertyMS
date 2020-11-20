package com.community.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.community.db.DBConnection;
import com.community.db.StringUtil;
import com.community.model.Arrears;

public class ArrearsDao extends BaseDao {
	// ����
	public static int insert(Connection con, Arrears arrears) throws Exception {
		String sql = "insert into arrears values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, arrears.getPayno());
		pstmt.setString(2, arrears.getPayname());
		pstmt.setString(3, arrears.getUnit());
		pstmt.setString(4, arrears.getTotal());
		pstmt.setString(5, arrears.getPaytype());
		pstmt.setString(6, arrears.getOwnername());
		pstmt.setString(7, arrears.getAddress());
		pstmt.setString(8, arrears.getTime());
		return pstmt.executeUpdate();
	}

	// ɾ��
	public static int delete(Connection con, String idno) throws SQLException {
		String sql = "delete from person where idno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, idno);
		return pstmt.executeUpdate();
	}

	// �޸�
	public static int update(Connection con, Arrears arrears) throws SQLException {
		String sql = "update person set payname=?,unit=? ,total=?,paytype=?,ownername=?,address=?,time=? where payno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, arrears.getPayname());
		pstmt.setString(2, arrears.getUnit());
		pstmt.setString(3, arrears.getTotal());
		pstmt.setString(4, arrears.getPaytype());
		pstmt.setString(5, arrears.getOwnername());
		pstmt.setString(6, arrears.getAddress());
		pstmt.setString(7, arrears.getTime());
		pstmt.setString(8, arrears.getPayno());
		return pstmt.executeUpdate();
	}

	// ��ѯ����Ϣ
	public static ResultSet getRS(Connection conn, Arrears arrears) {
		ResultSet rst = null;
		PreparedStatement pst = null;
		String sql = "select * from arrears";
		try {
			pst = conn.prepareStatement(sql);
			rst = pst.executeQuery();
		} catch (Exception evt) {
		}
		return rst;
	}

	// ��ѯ��Ϣ
	public List<Arrears> getArrears() {
		List<Arrears> list = new LinkedList<Arrears>();
		String sql = "select * from arrears";
		try {
			rst = query(sql);// ���ù��õķ����õ��Ľ����
			while (rst.next()) {
//Arrears(String payno, String payname, String unit, String total, String paytype, String ownername,String address, String time)
				String payno = rst.getString("payno");// ����������ȡ����������
				String payname = rst.getString("payname");
				String unit = rst.getString("unit");
				String total = rst.getString("total");
				String paytype = rst.getString("paytype");
				String ownername = rst.getString("ownername");
				String address = rst.getString("address");
				String time = rst.getString("time");
				// ����ʵ����󣬴洢����ÿһ�е�����
				Arrears emp = new Arrears();
				emp.setPayno(payno);
				emp.setPayname(payname);
				emp.setUnit(unit);
				emp.setTotal(total);
				emp.setPaytype(paytype);
				emp.setPaytype(ownername);
				emp.setPaytype(address);
				emp.setPaytype(time);
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
	 **/
	public static ResultSet rst(Connection con, Arrears arrears) throws Exception {
		StringBuffer sb = new StringBuffer("select * from arrears");
		if (StringUtil.isNotEmpty(arrears.getPayno())) {
			sb.append(" and name like '%" + arrears.getPayno() + "%'");
		}
		if (StringUtil.isNotEmpty(arrears.getPayname())) {
			sb.append(" and name like '%" + arrears.getPayname() + "%'");
		}
		if (StringUtil.isNotEmpty(arrears.getUnit())) {
			sb.append(" and name like '%" + arrears.getUnit() + "%'");
		}
		if (StringUtil.isNotEmpty(arrears.getTotal())) {
			sb.append(" and name like '%" + arrears.getTotal() + "%'");
		}
		if (StringUtil.isNotEmpty(arrears.getPaytype())) {
			sb.append(" and name like '%" + arrears.getPaytype() + "%'");
		}
		if (StringUtil.isNotEmpty(arrears.getOwnername())) {
			sb.append(" and name like '%" + arrears.getOwnername() + "%'");
		}
		if (StringUtil.isNotEmpty(arrears.getAddress())) {
			sb.append(" and name like '%" + arrears.getAddress() + "%'");
		}
		if (StringUtil.isNotEmpty(arrears.getTime())) {
			sb.append(" and name like '%" + arrears.getTime() + "%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}

	/**
	 * Ƿ��������Ϣ��ѯ
	 * 
	 * @throws SQLException
	 */
	public static ResultSet queryPayno(Connection con, String payno) throws SQLException {
		String sql = "select * from arrears";

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
