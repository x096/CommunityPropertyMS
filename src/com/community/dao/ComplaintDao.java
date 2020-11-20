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
	//����
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
	
	//ɾ��
	public static int delete(Connection con,String complainant) throws SQLException {
		String sql="delete from tb_complaint where complainant=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, complainant);
		return pstmt.executeUpdate();
	}
						
	//�޸�
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
	
	//��ѯ����Ϣ
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
						
	//��ѯ��Ϣ
	public List<Complaint> getComplaint() {
		List<Complaint> list = new LinkedList<Complaint>();
		String sql = "select * from tb_complaint";
		try {
			rst=query(sql) ;//���ù��õķ����õ��Ľ����
			while (rst.next()) {
				String complainant = rst.getString("complainant");// ����������ȡ����������
				String roomno = rst.getString("roomno");
				String complainttime = rst.getString("complainttime");
				String matter = rst.getString("matter");
				String state = rst.getString("state");
				// ����ʵ����󣬴洢����ÿһ�е�����
				Complaint emp = new Complaint();
				emp.setComplainant(complainant);
				emp.setRoomno(roomno);
				emp.setComplainttime(complainttime);
				emp.setMatter(matter);
				emp.setState(state);
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
	 * ¥����Ϣ��ѯ
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
