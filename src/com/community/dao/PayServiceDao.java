package com.community.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.community.db.DBConnection;
import com.community.db.StringUtil;
import com.community.model.PayService;

public class PayServiceDao  extends BaseDao{
	//插入
	public static int insert(Connection con,PayService payService) throws Exception {
		String sql = "insert into tb_payservice values(?,?,?)";
		PreparedStatement pstmt =con.prepareStatement(sql);
		pstmt.setString(1, payService.getPayno());
		pstmt.setString(2, payService.getPayname());
		pstmt.setString(3, payService.getPaytype());
		return pstmt.executeUpdate();
	}

	//删除
	public static int delete(Connection con,String payno) throws SQLException {
		String sql="delete from tb_payservice where payno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, payno);
		return pstmt.executeUpdate();
	}
				
	//修改
	public static int update(Connection con,PayService payService) throws SQLException {
		String sql="update tb_payservice set payname=?,paytype=? where payno=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, payService.getPayname());
		pstmt.setString(2, payService.getPaytype());
		pstmt.setString(3, payService.getPayno());
		return pstmt.executeUpdate();
	}
	//查询表信息
	public static ResultSet getRS(Connection conn,PayService payService){
		ResultSet rst =null;
		PreparedStatement pst = null;
		String sql = "select * from tb_payservice";
		try{
			 pst=conn.prepareStatement(sql);
			 rst=pst.executeQuery();
		}catch(Exception evt){
		}
		return rst;
	}
				
	//查询信息
	public List<PayService> getPayService() {
		List<PayService> list = new LinkedList<PayService>();
		String sql = "select * from tb_payservice";
		try {
			rst=query(sql) ;//调用公用的方法得到的结果集
			while (rst.next()) {
				String payno = rst.getString("payno");// 根据列名读取该行列数据
				String payname = rst.getString("payname");
				String paytype = rst.getString("paytype");
				// 创建实体对象，存储该行每一列的数据
				PayService emp = new PayService();
				emp.setPayno(payno);
				emp.setPayname(payname);
				emp.setPaytype(paytype);
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
	public static ResultSet rst(Connection con,PayService payService)throws Exception{
		StringBuffer sb=new StringBuffer("select * from tb_payservice");
		if(StringUtil.isNotEmpty(payService.getPayno())){
			sb.append(" and payno like '%"+payService.getPayno()+"%'");
		}
		if(StringUtil.isNotEmpty(payService.getPayname())){
			sb.append(" and payname like '%"+payService.getPayname()+"%'");
		}
		if(StringUtil.isNotEmpty(payService.getPaytype())){
			sb.append(" and paytype like '%"+payService.getPaytype()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	/**
	 * 收费项目信息查询
	 * 
	 * @throws SQLException
	 */
	public static ResultSet queryPayno(Connection con, String payno) throws SQLException {
		String sql = "select * from tb_payservice";

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
