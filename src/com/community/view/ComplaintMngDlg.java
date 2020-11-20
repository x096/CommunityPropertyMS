package com.community.view;

//投诉管理
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.community.dao.ComplaintDao;
import com.community.dao.PropertyDao;
import com.community.db.DBConnection;
import com.community.db.StringUtil;
import com.community.model.Complaint;

@SuppressWarnings("serial")
public class ComplaintMngDlg extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt4;
	private JTable table;
	private JTextField txt;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField txt3;
	private JTextField txt5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayserviceMngDlg frame = new PayserviceMngDlg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ComplaintMngDlg() {
		setTitle("\u6295\u8BC9\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 904, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 177, 836, 214);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u6295\u8BC9\u4EBA", "\u6295\u8BC9\u4EBA\u623F\u95F4\u7F16\u53F7",
						"\u6295\u8BC9\u65F6\u95F4", "\u6295\u8BC9\u4E8B\u9879", "\u5904\u7406\u72B6\u6001" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(112);
		scrollPane.setViewportView(table);

		JButton add = new JButton("\u589E\u52A0");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addActionPerformed(ae);
			}
		});
		add.setIcon(new ImageIcon(OwnerMngDlg.class.getResource("/images/add.png")));
		add.setBounds(50, 588, 110, 30);
		contentPane.add(add);

		JButton reset = new JButton("\u91CD\u7F6E");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		reset.setIcon(new ImageIcon(OwnerMngDlg.class.getResource("/images/reset.png")));
		reset.setBounds(271, 588, 110, 30);
		contentPane.add(reset);

		JButton update = new JButton("\u4FEE\u6539");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				updateActionPerformed(evt);
			}
		});
		update.setIcon(new ImageIcon(OwnerMngDlg.class.getResource("/images/modify.png")));
		update.setBounds(511, 588, 110, 30);
		contentPane.add(update);

		JButton delete = new JButton("\u5220\u9664");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent de) {
				deleteActionEvent(de);
			}
		});
		delete.setIcon(new ImageIcon(OwnerMngDlg.class.getResource("/images/delete.png")));
		delete.setBounds(734, 588, 110, 30);
		contentPane.add(delete);

		JPanel panel1 = new JPanel();
		panel1.setBorder(
				new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel1.setBounds(33, 29, 836, 123);
		contentPane.add(panel1);
		panel1.setLayout(null);

		JButton query = new JButton("\u67E5\u8BE2");
		query.setBounds(700, 45, 110, 30);
		panel1.add(query);
		query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String complainant = txt.getText();
				fillTable(complainant);
			}
		});
		query.setIcon(new ImageIcon(OwnerMngDlg.class.getResource("/images/search.png")));

		JLabel label_2_2 = new JLabel("\u6295\u8BC9\u4EBA\uFF1A");
		label_2_2.setBounds(29, 32, 79, 15);
		panel1.add(label_2_2);

		JLabel label_2_1_1 = new JLabel("\u6295\u8BC9\u4E8B\u9879\uFF1A");
		label_2_1_1.setBounds(29, 78, 79, 15);
		panel1.add(label_2_1_1);

		txt = new JTextField();
		txt.setBounds(74, 27, 132, 24);
		panel1.add(txt);

		textField_1 = new JTextField();
		textField_1.setBounds(94, 73, 225, 24);
		panel1.add(textField_1);

		JLabel label_2_2_1 = new JLabel("\u6295\u8BC9\u4EBA\u623F\u95F4\u7F16\u53F7\uFF1A");
		label_2_2_1.setBounds(237, 32, 96, 15);
		panel1.add(label_2_2_1);

		textField_3 = new JTextField();
		textField_3.setBounds(332, 27, 132, 24);
		panel1.add(textField_3);

		JLabel label = new JLabel("\u6295\u8BC9\u65F6\u95F4\uFF1A");
		label.setBounds(489, 32, 79, 15);
		panel1.add(label);

		textField_2 = new JTextField();
		textField_2.setBounds(545, 27, 132, 24);
		panel1.add(textField_2);

		JLabel label_1_1_3 = new JLabel("\u5904\u7406\u72B6\u6001\uFF1A");
		label_1_1_3.setBounds(414, 78, 79, 15);
		panel1.add(label_1_1_3);

		textField_6 = new JTextField();
		textField_6.setBounds(476, 73, 149, 24);
		panel1.add(textField_6);

		JPanel panel3 = new JPanel();
		panel3.setBorder(
				new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel3.setBounds(31, 401, 838, 165);
		contentPane.add(panel3);
		panel3.setLayout(null);

		JLabel label_2 = new JLabel("\u6295\u8BC9\u4EBA\uFF1A");
		label_2.setBounds(48, 36, 100, 15);
		panel3.add(label_2);

		txt1 = new JTextField();
		txt1.setBounds(102, 32, 132, 24);
		panel3.add(txt1);

		JLabel label_1_1 = new JLabel("\u6295\u8BC9\u4EBA\u623F\u95F4\u7F16\u53F7\uFF1A");
		label_1_1.setBounds(295, 36, 118, 15);
		panel3.add(label_1_1);

		txt2 = new JTextField();
		txt2.setBounds(393, 32, 162, 24);
		panel3.add(txt2);

		JLabel label_2_1 = new JLabel("\u6295\u8BC9\u4E8B\u9879\uFF1A");
		label_2_1.setBounds(48, 92, 100, 15);
		panel3.add(label_2_1);

		txt4 = new JTextField();
		txt4.setBounds(102, 87, 209, 24);
		panel3.add(txt4);

		JLabel label_1_1_1 = new JLabel("\u6295\u8BC9\u65F6\u95F4\uFF1A");
		label_1_1_1.setBounds(583, 36, 79, 15);
		panel3.add(label_1_1_1);

		txt3 = new JTextField();
		txt3.setBounds(648, 32, 162, 24);
		panel3.add(txt3);

		JLabel label_1_1_2 = new JLabel("\u5904\u7406\u72B6\u6001\uFF1A");
		label_1_1_2.setBounds(422, 92, 60, 15);
		panel3.add(label_1_1_2);

		txt5 = new JTextField();
		txt5.setBounds(480, 87, 162, 24);
		panel3.add(txt5);
		this.fillTable(new Complaint());
	}

	/**
	 * 修改事件
	 */
	protected void updateActionPerformed(ActionEvent evt) {
		String complainant = this.txt1.getText();
		if (StringUtil.isEmpty(complainant)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}

		String roomno = this.txt2.getText();
		String complainttime = this.txt3.getText();
		String matter = this.txt4.getText();
		String state = this.txt5.getText();
		if (StringUtil.isEmpty(roomno)) {
			JOptionPane.showMessageDialog(null, "申请人房间编号不能为空！");
			return;
		}
		if (StringUtil.isEmpty(complainttime)) {
			JOptionPane.showMessageDialog(null, "申请时间不能为空！");
			return;
		}
		if (StringUtil.isEmpty(matter)) {
			JOptionPane.showMessageDialog(null, "维修项目不能为空！");
			return;
		}
		if (StringUtil.isEmpty(state)) {
			JOptionPane.showMessageDialog(null, "维修状态不能为空！");
			return;
		}

		Complaint complaint = new Complaint(complainant, roomno, complainttime, matter, state);
		Connection con = null;
		try {
			con = DBConnection.getConn();
			int addNum = ComplaintDao.update(con, complaint);
			if (addNum == 1) {
				JOptionPane.showMessageDialog(null, "维修申请项目修改成功！");
				resetValue();
				this.fillTable(new Complaint());
			} else {
				JOptionPane.showMessageDialog(null, "维修申请项目修改失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "维修申请项目修改失败！！");
		} finally {
			try {
				DBConnection.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 删除事件
	 * 
	 * @param de
	 */
	protected void deleteActionEvent(ActionEvent de) {
		String complainant = txt1.getText();
		if (StringUtil.isEmpty(complainant)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if (n == 0) {
			Connection con = null;
			try {
				con = DBConnection.getConn();
				int deleteNum = ComplaintDao.delete(con, complainant);
				if (deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new Complaint());
				} else {
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				try {
					DBConnection.closeCon(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 添加事件
	 * 
	 * @param e
	 */
	protected void addActionPerformed(ActionEvent ae) {
		String complainant = this.txt1.getText();
		String roomno = this.txt2.getText();
		String complainttime = this.txt3.getText();
		String matter = this.txt4.getText();
		String state = this.txt5.getText();
		if (StringUtil.isEmpty(complainant)) {
			JOptionPane.showMessageDialog(null, "投诉人不能为空！");
			return;
		}
		if (StringUtil.isEmpty(roomno)) {
			JOptionPane.showMessageDialog(null, "投诉人房间编号不能为空！");
			return;
		}
		if (StringUtil.isEmpty(complainttime)) {
			JOptionPane.showMessageDialog(null, "投诉时间不能为空！");
			return;
		}
		if (StringUtil.isEmpty(matter)) {
			JOptionPane.showMessageDialog(null, "投诉项目不能为空！");
			return;
		}
		if (StringUtil.isEmpty(state)) {
			JOptionPane.showMessageDialog(null, "投诉状态不能为空！");
			return;
		}
		Complaint complaint = new Complaint(complainant, roomno, complainttime, matter, state);
		Connection con = null;
		try {
			con = DBConnection.getConn();
			int addNum = ComplaintDao.insert(con, complaint);
			if (addNum == 1) {
				JOptionPane.showMessageDialog(null, "投诉事项添加成功！");
				resetValue();
				this.fillTable(new Complaint());
			} else {
				JOptionPane.showMessageDialog(null, "投诉事项添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "投诉事项添加失败！！");
		} finally {
			try {
				DBConnection.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 重置事件处理
	 * 
	 * @param e
	 */
	protected void resetValueActionPerformed(ActionEvent e) {
		this.resetValue();
	}

	/**
	 * 重置表单
	 */
	private void resetValue() {
		this.txt1.setText("");
		this.txt2.setText("");
		this.txt3.setText("");
		this.txt4.setText("");
		this.txt5.setText("");
	}

	/**
	 * 查询事件处理
	 * 
	 * @param owner
	 */
	private void searchActionPerformed(ActionEvent e) {
		String complainant = this.txt1.getText();
		String roomno = this.txt2.getText();
		String complainttime = this.txt3.getText();
		String matter = this.txt4.getText();
		String state = this.txt5.getText();
		Complaint complaint = new Complaint();
		complaint.setComplainant(complainant);
		complaint.setRoomno(roomno);
		complaint.setComplainttime(complainttime);
		complaint.setMatter(matter);
		complaint.setState(state);
		this.fillTable(complaint);
		complaint = new Complaint(complainant, roomno, complainttime, matter, state);
		this.fillTable(complaint);

	}

	/**
	 * 填充表格
	 * 
	 * @param owner
	 */

	private void fillTable(Complaint complaint) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);// 清空表格
		Connection con = null;
		try {
			con = DBConnection.getConn();
			ResultSet rs = ComplaintDao.getRS(con, complaint);
			while (rs.next()) {
				Vector<String> v = new Vector<String>();
				v.add(rs.getString("complainant"));
				v.add(rs.getString("roomno"));
				v.add(rs.getString("complainttime"));
				v.add(rs.getString("matter"));
				v.add(rs.getString("state"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	/**
	 * 表格点击事件
	 * 
	 * @param e
	 */
	protected void tableMouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		String complainant = table.getValueAt(row, 0).toString();
		String roomno = table.getValueAt(row, 1).toString();
		String complainttime = table.getValueAt(row, 2).toString();
		String matter = table.getValueAt(row, 3).toString();
		String state = table.getValueAt(row, 4).toString();
		txt1.setText(complainant);
		txt2.setText(roomno);
		txt3.setText(complainttime);
		txt4.setText(matter);
		txt5.setText(state);
	}
	/**
	 * 模糊查询
	 * 
	 * @param roomNo
	 */
	protected void fillTable(String complainant) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);// 清空表格
		Connection con = null;
		try {
			con = DBConnection.getConn();
			ResultSet rs = ComplaintDao.queryComplainant(con, complainant);
			
			ArrayList<Vector<String>> list = new ArrayList<>();
			
			while (rs.next()) {
				Vector<String> v = new Vector<String>();
				//Complaint(String complainant, String roomno, String complainttime, String matter, String state) 
				v.add(rs.getString("complainant"));
				v.add(rs.getString("roomno"));
				v.add(rs.getString("complainttime"));
				v.add(rs.getString("matter"));
				v.add(rs.getString("state"));
				list.add(v);
			}
			
			list.forEach(v -> {
				if (v.get(0).equals(complainant)) {
					dtm.addRow(v);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

}
