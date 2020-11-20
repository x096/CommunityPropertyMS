package com.community.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.community.db.DBConnection;
import com.community.db.StringUtil;
import com.community.model.Complaint;

public class ComplaintDao extends BaseDao{
	//插入
	public static int insert(Connection con,Complaint complaint) throws Exception {
		String sql = "insert into tb_complaint values(?,?,?,?,?)";
		PreparedStatement pstmt =con.prepareStatement(sql);
		pstmt.setString(1, complaint.getComplainant());
		pstmt.setString(2, complaint.getRoomno());
		pstmt.setString(3, complaint.getComplainttime());
		pstmt.setString(4, complaint.getMatter());
		pstmt.setString(5, complaint.getState());
		return pstmt.executeUpdate();
	}
	
	//删除
	public static int delete(Connection con,String complainant) throws SQLException {
		String sql="delete from tb_complaint where complainant=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, complainant);
		return pstmt.executeUpdate();
	}
						
	//修改
	public static int update(Connection con,Complaint complaint) throws SQLException {
		String sql="update tb_complaint set roomno=?,complainttime=? ,matter=?,state=? where complainant=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, complaint.getRoomno());
		pstmt.setString(2, complaint.getComplainttime());
		pstmt.setString(3, complaint.getMatter());
		pstmt.setString(4, complaint.getState());
		pstmt.setString(5, complaint.getComplainant());
		return pstmt.executeUpdate();
	}
	
	//查询表信息
	public static ResultSet getRS(Connection conn,Complaint complaint){
		ResultSet rst =null;
		PreparedStatement pst = null;
		String sql = "select * from tb_complaint";
		try{
			 pst=conn.prepareStatement(sql);
			 rst=pst.executeQuery();
		}catch(Exception evt){
		}
		return rst;
	}
						
	//查询信息
	public List<Complaint> getComplaint() {
		List<Complaint> list = new LinkedList<Complaint>();
		String sql = "select * from tb_complaint";
		try {
			rst=query(sql) ;//调用公用的方法得到的结果集
			while (rst.next()) {
				String complainant = rst.getString("complainant");// 根据列名读取该行列数据
				String roomno = rst.getString("roomno");
				String complainttime = rst.getString("complainttime");
				String matter = rst.getString("matter");
				String state = rst.getString("state");
				// 创建实体对象，存储该行每一列的数据
				Complaint emp = new Complaint();
				emp.setComplainant(complainant);
				emp.setRoomno(roomno);
				emp.setComplainttime(complainttime);
				emp.setMatter(matter);
				emp.setState(state);
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
	public static ResultSet rst(Connection con,Complaint complaint)throws Exception{
		StringBuffer sb=new StringBuffer("select * from tb_complaint");
		if(StringUtil.isNotEmpty(complaint.getComplainant())){
			sb.append(" and complainant like '%"+complaint.getComplainant()+"%'");
		}
		if(StringUtil.isNotEmpty(complaint.getRoomno())){
			sb.append(" and roomno like '%"+complaint.getRoomno()+"%'");
		}
		if(StringUtil.isNotEmpty(complaint.getComplainttime())){
			sb.append(" and complainttime like '%"+complaint.getComplainttime()+"%'");
		}
		if(StringUtil.isNotEmpty(complaint.getMatter())){
			sb.append(" and matter like '%"+complaint.getMatter()+"%'");
		}
		if(StringUtil.isNotEmpty(complaint.getState())){
			sb.append(" and state like '%"+complaint.getState()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	/**
	 * 楼盘信息查询
	 * 
	 * @throws SQLException
	 */
	public static ResultSet queryComplainant(Connection con, String complainant) throws SQLException {
		String sql = "select * from tb_complaint";

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
