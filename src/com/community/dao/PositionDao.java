package com.community.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.community.db.DBConnection;
import com.community.db.StringUtil;
import com.community.model.Position;

public class PositionDao extends BaseDao{
	//����
	public static int insert(Connection con,Position position) throws Exception {
		String sql = "insert into position values(?,?)";
		PreparedStatement pstmt =con.prepareStatement(sql);
		pstmt.setString(1, position.getJobtitle());
		pstmt.setString(2, position.getPositionnote());
		return pstmt.executeUpdate();
	}

	//ɾ��
	public static int delete(Connection con,String jobtitle) throws SQLException {
		String sql="delete from position where jobtitle=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, jobtitle);
		return pstmt.executeUpdate();
	}
					
	//�޸�
	public static int update(Connection con,Position position) throws SQLException {
		String sql="update position set positionnote=? where jobtitle=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, position.getPositionnote());
		pstmt.setString(2, position.getJobtitle());
		return pstmt.executeUpdate();
	}
	
	//��ѯ����Ϣ
	public static ResultSet getRS(Connection conn,Position position){
		ResultSet rst =null;
		PreparedStatement pst = null;
		String sql = "select * from position";
		try{
			 pst=conn.prepareStatement(sql);
			 rst=pst.executeQuery();
		}catch(Exception evt){
		}
		return rst;
	}
					
	//��ѯ��Ϣ
	public List<Position> getPayService() {
		List<Position> list = new LinkedList<Position>();
		String sql = "select * from position";
		try {
			rst=query(sql) ;//���ù��õķ����õ��Ľ����
			while (rst.next()) {
				String jobtitle = rst.getString("jobtitle");// ����������ȡ����������
				String positionnote = rst.getString("positionnote");
				// ����ʵ����󣬴洢����ÿһ�е�����
				Position emp = new Position();
				emp.setJobtitle(jobtitle);
				emp.setPositionnote(positionnote);
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
	public static ResultSet rst(Connection con,Position position)throws Exception{
		StringBuffer sb=new StringBuffer("select * from position");
		if(StringUtil.isNotEmpty(position.getJobtitle())){
			sb.append(" and jobtitle like '%"+position.getJobtitle()+"%'");
		}
		if(StringUtil.isNotEmpty(position.getPositionnote())){
			sb.append(" and positionnote like '%"+position.getPositionnote()+"%'");
		}
		
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	/**
	 * ¥����Ϣ��ѯ
	 * 
	 * @throws SQLException
	 */
	public static ResultSet queryJobtitle(Connection con, String jobtitle) throws SQLException {
		String sql = "select * from position";

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
