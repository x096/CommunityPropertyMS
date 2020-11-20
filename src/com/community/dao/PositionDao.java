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
	//插入
	public static int insert(Connection con,Position position) throws Exception {
		String sql = "insert into position values(?,?)";
		PreparedStatement pstmt =con.prepareStatement(sql);
		pstmt.setString(1, position.getJobtitle());
		pstmt.setString(2, position.getPositionnote());
		return pstmt.executeUpdate();
	}

	//删除
	public static int delete(Connection con,String jobtitle) throws SQLException {
		String sql="delete from position where jobtitle=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, jobtitle);
		return pstmt.executeUpdate();
	}
					
	//修改
	public static int update(Connection con,Position position) throws SQLException {
		String sql="update position set positionnote=? where jobtitle=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, position.getPositionnote());
		pstmt.setString(2, position.getJobtitle());
		return pstmt.executeUpdate();
	}
	
	//查询表信息
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
					
	//查询信息
	public List<Position> getPayService() {
		List<Position> list = new LinkedList<Position>();
		String sql = "select * from position";
		try {
			rst=query(sql) ;//调用公用的方法得到的结果集
			while (rst.next()) {
				String jobtitle = rst.getString("jobtitle");// 根据列名读取该行列数据
				String positionnote = rst.getString("positionnote");
				// 创建实体对象，存储该行每一列的数据
				Position emp = new Position();
				emp.setJobtitle(jobtitle);
				emp.setPositionnote(positionnote);
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
	 * 楼盘信息查询
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
