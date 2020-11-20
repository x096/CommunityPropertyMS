package com.community.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.community.db.DBConnection;
import com.community.model.PayNote;

//收费单维护
public class PayNoteDao  extends BaseDao{
	// 增加
	public static int insert(Connection con,PayNote payNote) throws Exception {
		String sql = "insert into tb_paynote values(?,?,?,?,?,?,?)";
		PreparedStatement pstmt =con.prepareStatement(sql);
		pstmt.setString(1, payNote.getPnoteno());
		pstmt.setString(2, payNote.getPayname());
		pstmt.setString(3, payNote.getUnit());
		pstmt.setString(4, payNote.getTotal());
		pstmt.setString(5, payNote.getPaytype());
		pstmt.setString(6, payNote.getOwnerName());
		pstmt.setString(7, payNote.getAddress());
		return pstmt.executeUpdate();
	}

	// 修改
	public static int update(Connection con,PayNote payNote)throws Exception {
		String sql = "update tb_paynote set payname=?,unit=?,total=?,paytype=?,ownerName=? ,address=? where pnoteno=? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, payNote.getPayname());
		pstmt.setString(2, payNote.getUnit());
		pstmt.setString(3, payNote.getTotal());
		pstmt.setString(4, payNote.getPaytype());
		pstmt.setString(5, payNote.getOwnerName());
		pstmt.setString(6, payNote.getAddress());
		pstmt.setString(7, payNote.getPnoteno());
		return pstmt.executeUpdate();
	}
		

	// 删除功能
	public static int delete(Connection con,String pnoteno)throws Exception{
		String sql="delete from tb_paynote where pnoteno=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, pnoteno);
		return pstmt.executeUpdate();
	}

	// 查询所有的楼盘信息
	public List<PayNote> queryPayNote() {
		List<PayNote> list = new LinkedList<PayNote>();
		String sql = "select * from tb_paynote";
		try {
			rst=query(sql) ;//调用公用的方法得到的结果集
			while (rst.next()) {
				String pnoteno = rst.getString("pnoteno");// 根据列名读取该行列数据
				String payname = rst.getString("payname");
				String unit = rst.getString("unit");
				String total = rst.getString("total");
				String paytype = rst.getString("paytype");
				String ownerName = rst.getString("ownerName");
				String address = rst.getString("address");
				// 创建实体对象，存储该行每一列的数据
				PayNote emp = new PayNote();
				emp.setPnoteno(pnoteno);
				emp.setPayname(payname);
				emp.setUnit(unit);
				emp.setTotal(total);
				emp.setPaytype(paytype);
				emp.setOwnerName(ownerName);
				emp.setAddress(address);
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
	 * 判断是否存在
	 */
	public boolean existpnoteno(Connection con,String pnoteno)throws Exception{
		String sql="select * from tb_property where roomno=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, pnoteno);
		ResultSet rs=pstmt.executeQuery();
		return rs.next();
	}

//查询表信息
	public static ResultSet getRS(Connection con, PayNote payNote) {
		ResultSet rst =null;
		PreparedStatement pst = null;
		String sql = "select * from tb_paynote";
		try{
			pst=con.prepareStatement(sql);
			rst=pst.executeQuery();
		}catch(Exception evt){
	}
	return rst;
	}
	/**
	 * 收费单信息查询
	 * 
	 * @throws SQLException
	 */
	public static ResultSet queryPnoteno(Connection con, String pnoteno) throws SQLException {
		String sql = "select * from tb_paynote";

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
