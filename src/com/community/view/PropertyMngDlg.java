package com.community.view;

//楼盘信息维护
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.community.dao.PropertyDao;
import com.community.db.DBConnection;
import com.community.db.StringUtil;
import com.community.model.Property;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;

@SuppressWarnings("serial")
public class PropertyMngDlg extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txt11;
	private JTextField buildingTxt;
	private JTextField txt33;
	private JTextField txt;
	private JTextField txt1;
	private JTextField txt3;
	private JTextField txt2;
	private JTextField txt4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PropertyMngDlg frame = new PropertyMngDlg();
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
	public PropertyMngDlg() {
		setTitle("\u697C\u76D8\u4FE1\u606F\u7EF4\u62A4");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 737, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 126, 654, 217);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);

			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u533A", "\u680B", "\u5C42", "\u623F\u95F4\u7F16\u53F7" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		JButton add = new JButton("\u589E\u52A0");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				propertyActionPerformed(e);
			}
		});
		add.setIcon(new ImageIcon("E:\\JavaProgram\\community\\src\\images\\add.png"));
		add.setFont(new Font("宋体", Font.PLAIN, 18));
		add.setBounds(54, 570, 111, 30);
		contentPane.add(add);

		JButton update = new JButton("\u4FEE\u6539");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bookUpdateActionPerformed(evt);
			}
		});
		update.setIcon(new ImageIcon("E:\\JavaProgram\\community\\src\\images\\modify.png"));
		update.setFont(new Font("宋体", Font.PLAIN, 18));
		update.setBounds(381, 570, 111, 30);
		contentPane.add(update);

		JButton delete = new JButton("\u5220\u9664");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				propertyDeleteActionEvent(evt);
			}
		});
		delete.setIcon(new ImageIcon("E:\\JavaProgram\\community\\src\\images\\delete.png"));
		delete.setFont(new Font("宋体", Font.PLAIN, 18));
		delete.setBounds(548, 570, 111, 30);
		contentPane.add(delete);

		JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel1.setBounds(10, 23, 654, 93);
		contentPane.add(panel1);
		panel1.setLayout(null);

		JLabel label = new JLabel("\u533A\uFF1A");
		label.setBounds(24, 27, 37, 56);
		panel1.add(label);
		label.setFont(new Font("宋体", Font.PLAIN, 18));

		txt11 = new JTextField();
		txt11.setBounds(57, 43, 66, 21);
		panel1.add(txt11);
		txt11.setColumns(10);

		JButton query = new JButton("\u67E5\u8BE2");
		query.setBounds(509, 40, 105, 31);
		panel1.add(query);
		query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String roomNo = txt.getText();
				fillTable(roomNo);	
			}

		});
		query.setIcon(new ImageIcon("E:\\JavaProgram\\community\\src\\images\\search.png"));
		query.setFont(new Font("宋体", Font.PLAIN, 18));

		JLabel label_1 = new JLabel("\u680B\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(138, 27, 37, 56);
		panel1.add(label_1);

		buildingTxt = new JTextField();
		buildingTxt.setColumns(10);
		buildingTxt.setBounds(171, 43, 66, 21);
		panel1.add(buildingTxt);

		JLabel label_2 = new JLabel("\u5C42\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_2.setBounds(260, 27, 37, 56);
		panel1.add(label_2);

		txt33 = new JTextField();
		txt33.setColumns(10);
		txt33.setBounds(293, 43, 66, 21);
		panel1.add(txt33);

		JLabel label_3 = new JLabel("\u623F\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 18));
		label_3.setBounds(377, 27, 37, 56);
		panel1.add(label_3);

		txt = new JTextField();
		txt.setColumns(10);
		txt.setBounds(410, 43, 66, 21);
		panel1.add(txt);

		JPanel panel3 = new JPanel();
		panel3.setBorder(
				new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel3.setBounds(23, 368, 654, 174);
		contentPane.add(panel3);

		JLabel label_4 = new JLabel("\u533A\uFF1A");
		label_4.setBounds(103, 22, 37, 22);
		label_4.setFont(new Font("宋体", Font.PLAIN, 18));

		txt1 = new JTextField();
		txt1.setBounds(145, 22, 128, 21);
		txt1.setColumns(10);

		JLabel label_1_1 = new JLabel("\u680B\uFF1A");
		label_1_1.setBounds(335, 22, 37, 22);
		label_1_1.setFont(new Font("宋体", Font.PLAIN, 18));

		txt3 = new JTextField();
		txt3.setBounds(145, 93, 128, 21);
		txt3.setColumns(10);

		JLabel label_2_1 = new JLabel("\u5C42\uFF1A");
		label_2_1.setBounds(103, 93, 37, 22);
		label_2_1.setFont(new Font("宋体", Font.PLAIN, 18));

		txt2 = new JTextField();
		txt2.setBounds(371, 22, 143, 21);
		txt2.setColumns(10);

		JLabel label_3_1 = new JLabel("\u623F\uFF1A");
		label_3_1.setBounds(335, 93, 37, 22);
		label_3_1.setFont(new Font("宋体", Font.PLAIN, 18));

		txt4 = new JTextField();
		txt4.setBounds(371, 93, 143, 21);
		txt4.setColumns(10);
		panel3.setLayout(null);
		panel3.add(label_4);
		panel3.add(txt1);
		panel3.add(label_1_1);
		panel3.add(txt3);
		panel3.add(label_2_1);
		panel3.add(txt2);
		panel3.add(label_3_1);
		panel3.add(txt4);

		JButton reset = new JButton("\u91CD\u7F6E");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		reset.setIcon(new ImageIcon(PropertyMngDlg.class.getResource("/images/reset.png")));
		reset.setFont(new Font("宋体", Font.PLAIN, 18));
		reset.setBounds(215, 569, 108, 32);
		contentPane.add(reset);
		this.fillTable(new Property());
	}

	/**
	 * 模糊查询
	 * 
	 * @param roomNo
	 */
	protected void fillTable(String roomNo) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);// 清空表格
		Connection con = null;
		try {
			con = DBConnection.getConn();
			ResultSet rs = PropertyDao.queryRoomNo(con, roomNo);
			
			ArrayList<Vector<String>> list = new ArrayList<>();
			
			while (rs.next()) {
				Vector<String> v = new Vector<String>();
				v.add(rs.getString("block"));
				v.add(rs.getString("building"));
				v.add(rs.getString("floor"));
				v.add(rs.getString("roomno"));
				list.add(v);
			}
			
			list.forEach(v -> {
				if (v.get(3).equals(roomNo)) {
					dtm.addRow(v);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	/**
	 * 填充表格
	 * 
	 * @param property
	 */
	private void fillTable(Property property) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);// 清空表格
		Connection con = null;
		try {
			con = DBConnection.getConn();

			ResultSet rs = PropertyDao.getRS(con, property);
			while (rs.next()) {
				Vector<String> v = new Vector<String>();
				v.add(rs.getString("block"));
				v.add(rs.getString("building"));
				v.add(rs.getString("floor"));
				v.add(rs.getString("roomno"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	/**
	 * 重置表单
	 */
	private void resetValue() {
		this.txt1.setText("");
		this.txt2.setText("");
		this.txt3.setText("");
		this.txt4.setText("");
	}

	/**
	 * 表格点击事件
	 * 
	 * @param e
	 */
	protected void tableMouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		String block = table.getValueAt(row, 0).toString();
		String building = table.getValueAt(row, 1).toString();
		String floor = table.getValueAt(row, 2).toString();
		String roomno = table.getValueAt(row, 3).toString();
		txt1.setText(block);
		txt2.setText(building);
		txt3.setText(floor);
		txt4.setText(roomno);
	}


	/**
	 *
	 * @param evt
	 */
	protected void propertyActionPerformed(ActionEvent evt) {
		String block = this.txt1.getText();
		String building = this.txt2.getText();
		String floor = this.txt4.getText();
		String roomNo = this.txt3.getText();
		if (StringUtil.isEmpty(block)) {
			JOptionPane.showMessageDialog(null, "区号不能为空！");
			return;
		}
		if (StringUtil.isEmpty(building)) {
			JOptionPane.showMessageDialog(null, "楼栋不能为空！");
			return;
		}
		if (StringUtil.isEmpty(floor)) {
			JOptionPane.showMessageDialog(null, "层数不能为空！");
			return;
		}
		if (StringUtil.isEmpty(roomNo)) {
			JOptionPane.showMessageDialog(null, "房间编号不能为空！");
			return;
		}
		Property property = new Property(block, building, floor, roomNo);
		Connection con = null;
		try {
			con = DBConnection.getConn();
			int addNum = PropertyDao.insertProperty(con, property);
			if (addNum == 1) {
				JOptionPane.showMessageDialog(null, "楼盘信息添加成功！");
				resetValue();
				this.fillTable(new Property());
			} else {
				JOptionPane.showMessageDialog(null, "楼盘信息添加失败！");

			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "楼盘信息添加失败！");

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
	 *
	 * @param evt
	 */
	private void bookUpdateActionPerformed(ActionEvent evt) {
		String block = this.txt1.getText();
		String building = this.txt2.getText();
		String floor = this.txt3.getText();
		String roomNo = this.txt4.getText();

		if (StringUtil.isEmpty(block)) {
			JOptionPane.showMessageDialog(null, "区号不能为空！");
			return;
		}
		if (StringUtil.isEmpty(building)) {
			JOptionPane.showMessageDialog(null, "楼栋不能为空！");
			return;
		}
		if (StringUtil.isEmpty(floor)) {
			JOptionPane.showMessageDialog(null, "层数不能为空！");
			return;
		}
		if (StringUtil.isEmpty(roomNo)) {
			JOptionPane.showMessageDialog(null, "房间编号不能为空！");
			return;
		}
		Property property = new Property(block, building, floor, roomNo);
		Connection con = null;
		try {
			con = DBConnection.getConn();
			int addNum = PropertyDao.update(con, property);
			if (addNum == 1) {
				JOptionPane.showMessageDialog(null, "楼盘信息修改成功！");
				resetValue();
			} else {
				JOptionPane.showMessageDialog(null, "楼盘信息修改失败！");

			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "楼盘信息修改失败！");

		}
	}

	/**
	 * 楼盘信息删除事件处理
	 * 
	 * @param evt
	 */
	private void propertyDeleteActionEvent(ActionEvent evt) {
		String roomno = txt4.getText();
		if (StringUtil.isEmpty(roomno)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if (n == 0) {
			Connection con = null;
			try {
				con = DBConnection.getConn();
				int deleteNum = PropertyDao.delete(con, roomno);
				if (deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new Property());
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

}
