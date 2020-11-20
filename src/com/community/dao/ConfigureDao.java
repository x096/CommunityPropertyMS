package com.community.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.community.db.DBConnection;
import com.community.db.StringUtil;
import com.community.model.Configure;

public class ConfigureDao extends BaseDao{
	//����
	public static int insert(Connection con,Configure configure) throws Exception {
		String sql = "insert into configure values(?,?,?,?)";
		PreparedStatement pstmt =con.prepareStatement(sql);
		pstmt.setString(1, configure.getId());
		pstmt.setString(2, configure.getName());
		pstmt.setString(3, configure.getPrice());
		pstmt.setString(4, configure.getServicelife());
		return pstmt.executeUpdate();
	}
			
	//ɾ��
	public static int delete(Connection con,String id) throws SQLException {
		String sql="delete from configure where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
						
	//�޸�
	public static int update(Connection con,Configure configure) throws SQLException {
		String sql="update configure set name=?,price=? ,servicelife=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, configure.getName());
		pstmt.setString(2, configure.getPrice());
		pstmt.setString(3, configure.getServicelife());
		pstmt.setString(4, configure.getId());
		return pstmt.executeUpdate();
	}
		
	//��ѯ����Ϣ
	public static ResultSet getRS(Connection conn,Configure configure){
		ResultSet rst =null;
		PreparedStatement pst = null;
		String sql = "select * from configure";
		try{
			 pst=conn.prepareStatement(sql);
			 rst=pst.executeQuery();
		}catch(Exception evt){
		}
		return rst;
	}
	
	//��ѯ��Ϣ
	public List<Configure> getConfigure() {
		List<Configure> list = new LinkedList<Configure>();
		String sql = "select * from configure";
		try {
			rst=query(sql) ;//���ù��õķ����õ��Ľ����
			while (rst.next()) {
				String id = rst.getString("id");// ����������ȡ����������
				String name = rst.getString("name");
				String price = rst.getString("price");
				String servicelife = rst.getString("servicelife");
				// ����ʵ����󣬴洢����ÿһ�е�����
				Configure emp = new Configure();
				emp.setId(id);
				emp.setName(name);
				emp.setPrice(price);
				emp.setServicelife(servicelife);
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

	public static ResultSet rst(Connection con,Configure configure)throws Exception{
		StringBuffer sb=new StringBuffer("select * from configure");
		if(StringUtil.isNotEmpty(configure.getId())){
			sb.append(" and name like '%"+configure.getId()+"%'");
		}
		if(StringUtil.isNotEmpty(configure.getName())){
			sb.append(" and name like '%"+configure.getName()+"%'");
		}
		if(StringUtil.isNotEmpty(configure.getPrice())){
			sb.append(" and name like '%"+configure.getPrice()+"%'");
		}
		if(StringUtil.isNotEmpty(configure.getServicelife())){
			sb.append(" and name like '%"+configure.getServicelife()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
}
