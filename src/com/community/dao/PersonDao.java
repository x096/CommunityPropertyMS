package com.community.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.community.db.DBConnection;
import com.community.db.StringUtil;
import com.community.model.Person;

public class PersonDao extends BaseDao {
	// 插入
	public static int insert(Connection con, Person person) throws Exception {
		String sql = "insert into person values(?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, person.getName());
		pstmt.setString(2, person.getSex());
		pstmt.setString(3, person.getIdno());
		pstmt.setString(4, person.getBirthday());
		pstmt.setString(5, person.getAccountaddr());
		return pstmt.executeUpdate();
	}

	// 删除
	public static int delete(Connection con, String idno) throws SQLException {
		String sql = "delete from person where idno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, idno);
		return pstmt.executeUpdate();
	}

	// 修改
	public static int update(Connection con, Person person) throws SQLException {
		String sql = "update person set name=?,sex=? ,birthday=?,accountaddr=? where idno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, person.getName());
		pstmt.setString(2, person.getSex());
		pstmt.setString(3, person.getBirthday());
		pstmt.setString(4, person.getAccountaddr());
		pstmt.setString(5, person.getIdno());
		return pstmt.executeUpdate();
	}

	// 查询表信息
	public static ResultSet getRS(Connection conn, Person person) {
		ResultSet rst = null;
		PreparedStatement pst = null;
		String sql = "select * from person";
		try {
			pst = conn.prepareStatement(sql);
			rst = pst.executeQuery();
		} catch (Exception evt) {
		}
		return rst;
	}

	// 查询信息
	public List<Person> getPerson() {
		List<Person> list = new LinkedList<Person>();
		String sql = "select * from person";
		try {
			rst = query(sql);// 调用公用的方法得到的结果集
			while (rst.next()) {
				String name = rst.getString("name");// 根据列名读取该行列数据
				String sex = rst.getString("sex");
				String idno = rst.getString("idno");
				String birthday = rst.getString("birthday");
				String accountaddr = rst.getString("accountaddr");
				// 创建实体对象，存储该行每一列的数据
				Person emp = new Person();
				emp.setName(name);
				emp.setSex(sex);
				emp.setIdno(idno);
				emp.setBirthday(birthday);
				emp.setAccountaddr(accountaddr);
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

	public static ResultSet rst(Connection con, Person person) throws Exception {
		StringBuffer sb = new StringBuffer("select * from person");
		if (StringUtil.isNotEmpty(person.getName())) {
			sb.append(" and name like '%" + person.getName() + "%'");
		}
		if (StringUtil.isNotEmpty(person.getSex())) {
			sb.append(" and sex like '%" + person.getSex() + "%'");
		}
		if (StringUtil.isNotEmpty(person.getIdno())) {
			sb.append(" and idno like '%" + person.getIdno() + "%'");
		}
		if (StringUtil.isNotEmpty(person.getBirthday())) {
			sb.append(" and birthday like '%" + person.getBirthday() + "%'");
		}
		if (StringUtil.isNotEmpty(person.getAccountaddr())) {
			sb.append(" and accountaddr like '%" + person.getAccountaddr() + "%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}

	/**
	 * 楼盘信息查询
	 * 
	 * @throws SQLException
	 */
	public static ResultSet queryIdno(Connection con, String idno) throws SQLException {
		String sql = "select * from person";

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
