package com.community.view;
//业主信息维护
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.community.dao.OwnerDao;
import com.community.dao.PropertyDao;
import com.community.db.DBConnection;
import com.community.db.StringUtil;
import com.community.model.Owner;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;

@SuppressWarnings("serial")
public class OwnerMngDlg extends JFrame {

	/**
	 * Launch the application.
	 */
	private JPanel contentPane;
	private JTextArea txt;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTable table;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OwnerMngDlg frame = new OwnerMngDlg();
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
	public OwnerMngDlg() {
		setTitle("\u4E1A\u4E3B\u4FE1\u606F\u7EF4\u62A4");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 737, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 177, 644, 214);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u623F\u95F4\u7F16\u53F7", "\u4E1A\u4E3B\u7F16\u53F7", "\u4E1A\u4E3B\u59D3\u540D", "\u4E1A\u4E3B\u8054\u7CFB\u7535\u8BDD"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(3).setPreferredWidth(86);
		scrollPane.setViewportView(table);
		
		JButton add = new JButton("\u589E\u52A0");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addActionPerformed(e);
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
		reset.setBounds(202, 588, 110, 30);
		contentPane.add(reset);
		
		JButton update = new JButton("\u4FEE\u6539");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				updateActionPerformed(evt);
			}
		});
		update.setIcon(new ImageIcon(OwnerMngDlg.class.getResource("/images/modify.png")));
		update.setBounds(372, 588, 110, 30);
		contentPane.add(update);
		
		JButton delete = new JButton("\u5220\u9664");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent de) {
				ownerDeleteActionEvent(de);
			}
		});
		delete.setIcon(new ImageIcon(OwnerMngDlg.class.getResource("/images/delete.png")));
		delete.setBounds(535, 588, 110, 30);
		contentPane.add(delete);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel1.setBounds(33, 29, 644, 123);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JTextArea txtfield1 = new JTextArea();
		txtfield1.setBounds(78, 27, 45, 24);
		panel1.add(txtfield1);
		
		JButton query = new JButton("\u67E5\u8BE2");
		query.setBounds(524, 47, 110, 30);
		panel1.add(query);
		query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				String ownerNo = txt.getText();
				fillTable(ownerNo);
			}
		});
		query.setIcon(new ImageIcon(OwnerMngDlg.class.getResource("/images/search.png")));
		
		JLabel label = new JLabel("\u623F\u95F4\u7F16\u53F7\uFF1A");
		label.setBounds(20, 32, 67, 15);
		panel1.add(label);
		
		txt = new JTextArea();
		txt.setBounds(398, 27, 103, 24);
		panel1.add(txt);
		
		JLabel label_1 = new JLabel("\u4E1A\u4E3B\u7F16\u53F7\uFF1A");
		label_1.setBounds(340, 32, 67, 15);
		panel1.add(label_1);
		
		JLabel label_1_2 = new JLabel("\u4E1A\u4E3B\u59D3\u540D\uFF1A");
		label_1_2.setBounds(165, 32, 67, 15);
		panel1.add(label_1_2);
		
		JTextArea txtfield3 = new JTextArea();
		txtfield3.setBounds(223, 27, 107, 24);
		panel1.add(txtfield3);
		
		JLabel label_1_2_1 = new JLabel("\u4E1A\u4E3B\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		label_1_2_1.setBounds(108, 80, 103, 15);
		panel1.add(label_1_2_1);
		
		JTextArea txtfield4 = new JTextArea();
		txtfield4.setBounds(218, 75, 217, 24);
		panel1.add(txtfield4);
		
		JPanel panel3 = new JPanel();
		panel3.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel3.setBounds(31, 401, 646, 165);
		contentPane.add(panel3);
		panel3.setLayout(null);
		
		JLabel label_2 = new JLabel("\u623F\u95F4\u7F16\u53F7\uFF1A");
		label_2.setBounds(69, 41, 67, 15);
		panel3.add(label_2);
		
		txt1 = new JTextField();
		txt1.setBounds(143, 36, 132, 24);
		panel3.add(txt1);
		
		JLabel label_1_1 = new JLabel("\u4E1A\u4E3B\u7F16\u53F7\uFF1A");
		label_1_1.setBounds(310, 41, 92, 15);
		panel3.add(label_1_1);
		
		txt2 = new JTextField();
		txt2.setBounds(412, 36, 162, 24);
		panel3.add(txt2);
		
		JLabel label_2_1 = new JLabel("\u4E1A\u4E3B\u59D3\u540D\uFF1A");
		label_2_1.setBounds(69, 97, 67, 15);
		panel3.add(label_2_1);
		
		txt3 = new JTextField();
		txt3.setBounds(143, 92, 132, 24);
		panel3.add(txt3);
		
		JLabel label_1_1_1 = new JLabel("\u4E1A\u4E3B\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		label_1_1_1.setBounds(310, 97, 92, 15);
		panel3.add(label_1_1_1);
		
		txt4 = new JTextField();
		txt4.setBounds(412, 92, 162, 24);
		panel3.add(txt4);
		this.fillTable(new Owner());
		
	}

	/**
	 *
	 * @param evt
	 */
	protected void updateActionPerformed(ActionEvent evt) {
		String roomNo = this.txt2.getText();
		String ownerNo = this.txt1.getText();
		String ownerName = this.txt3.getText();
		String ownerPhone = this.txt4.getText();
		if (StringUtil.isEmpty(roomNo)) {
			JOptionPane.showMessageDialog(null, "房间编号不能为空！");
			return ;
		}
		if (StringUtil.isEmpty(ownerNo)) {
			JOptionPane.showMessageDialog(null, "业主编号不能为空！");
			return ;
		}
		if (StringUtil.isEmpty(ownerName)) {
			JOptionPane.showMessageDialog(null, "业主姓名不能为空！");
			return ;
		}
		if (StringUtil.isEmpty(ownerPhone)) {
			JOptionPane.showMessageDialog(null, "业主联系方式不能为空！");
			return ;
		}
		Owner owner = new Owner(roomNo, ownerNo,ownerName,ownerPhone);
		Connection con=null;
		try{
			con=DBConnection.getConn();
			int addNum=OwnerDao.update(con, owner);
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "业主信息修改成功！");
				resetValue();
				this.fillTable(new Owner());
			}else{
				JOptionPane.showMessageDialog(null, "业主信息修改失败！");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "业主信息修改失败！！");
		}
	}

	/**
	 * 删除事件
	 * @param de
	 */
	protected void ownerDeleteActionEvent(ActionEvent de) {
		String ownerNo=txt2.getText();
		if(StringUtil.isEmpty(ownerNo)){
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if(n==0){
			Connection con=null;
			try{
				con=DBConnection.getConn();
				int deleteNum=OwnerDao.delete(con, ownerNo);
				if(deleteNum==1){
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new Owner());
				}else{
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			}catch(Exception e){
				e.printStackTrace();
				
			}finally{
				try {
					DBConnection.closeCon(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	/**
	 *
	 * @param evt
	 */
	protected void addActionPerformed(ActionEvent evt) {
		String roomNo = this.txt1.getText();
		String ownerNo = this.txt2.getText();
		String ownerName = this.txt3.getText();
		String ownerPhone = this.txt4.getText();
		if (StringUtil.isEmpty(roomNo)) {
			JOptionPane.showMessageDialog(null, "房间编号不能为空！");
			return ;
		}
		if (StringUtil.isEmpty(ownerNo)) {
			JOptionPane.showMessageDialog(null, "业主编号不能为空！");
			return ;
		}
		if (StringUtil.isEmpty(ownerName)) {
			JOptionPane.showMessageDialog(null, "业主姓名不能为空！");
			return ;
		}
		if (StringUtil.isEmpty(ownerPhone)) {
			JOptionPane.showMessageDialog(null, "业主联系方式不能为空！");
			return ;
		}
		Owner owner = new Owner(roomNo, ownerNo,ownerName,ownerPhone);
		Connection con=null;
		try{
			con=DBConnection.getConn();
			int addNum=OwnerDao.insert(con, owner);
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "业主信息添加成功！");
				resetValue();
				this.fillTable(new Owner());
			}else{
				JOptionPane.showMessageDialog(null, "业主信息添加失败！");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "业主信息添加失败！！");
		}finally{
			try {
				DBConnection.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 重置事件处理
	 * @param e
	 */
	protected void resetValueActionPerformed(ActionEvent e) {
		this.resetValue();
	}


	/**
	 * 重置表单
	 */
	private void resetValue(){
		this.txt1.setText("");
		this.txt2.setText("");
		this.txt3.setText("");
		this.txt4.setText("");
	}

	/**
	 *
	 * @param ownerNo
	 */
	protected void fillTable(String ownerNo) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);// 清空表格
		Connection con = null;
		try {
			con = DBConnection.getConn();
			ResultSet rs = OwnerDao.queryOwnerNo(con, ownerNo);
			
			ArrayList<Vector<String>> list = new ArrayList<>();
			
			while (rs.next()) {
				Vector<String> v = new Vector<String>();
				v.add(rs.getString("roomNo"));
				v.add(rs.getString("ownerNo"));
				v.add(rs.getString("ownerName"));
				v.add(rs.getString("ownerPhone"));
				list.add(v);
			}
			
			list.forEach(v -> {
				if (v.get(1).equals(ownerNo)) {
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
	 * @param owner
	 */
	private void fillTable(Owner owner) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);//清空表格
		Connection con = null;
		try {
			con = DBConnection.getConn();
			ResultSet rs=OwnerDao.getRS(con,owner);
			while (rs.next()) {
				Vector<String> v=new Vector<String>();
				v.add(rs.getString("roomno"));
				v.add(rs.getString("ownerno"));
				v.add(rs.getString("ownername"));
				v.add(rs.getString("ownerphone"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		}
	}
	
	/**
	 * 表格点击事件
	 * @param e
	 */
	protected void tableMouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		String roomNo = table.getValueAt(row, 0).toString();
		String ownerNo = table.getValueAt(row, 1).toString();
		String ownerName = table.getValueAt(row, 2).toString();
		String ownerPhone = table.getValueAt(row, 3).toString();
		txt1.setText(roomNo);
		txt2.setText(ownerNo);
		txt3.setText(ownerName);
		txt4.setText(ownerPhone);
	}
}
