package com.community.view;
//人员信息管理
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

import com.community.dao.PersonDao;
import com.community.dao.PropertyDao;
import com.community.db.DBConnection;
import com.community.db.StringUtil;
import com.community.model.Person;

@SuppressWarnings("serial")
public class PersonMngDlg extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt4;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField txt;
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
	public PersonMngDlg() {
		setTitle("\u4EBA\u5458\u4FE1\u606F\u7BA1\u7406");
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
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u59D3\u540D", "\u6027\u522B", "\u8EAB\u4EFD\u8BC1\u53F7\u7801", "\u51FA\u751F\u65E5\u671F", "\u6237\u53E3\u5730\u5740"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(41);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(4).setPreferredWidth(225);
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
		panel1.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel1.setBounds(33, 29, 836, 123);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JButton query = new JButton("\u67E5\u8BE2");
		query.setBounds(700, 45, 110, 30);
		panel1.add(query);
		query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String idno = txt.getText();
				fillTable(idno);	
			}
		});
		query.setIcon(new ImageIcon(OwnerMngDlg.class.getResource("/images/search.png")));
		
		JLabel label_2_2 = new JLabel("\u59D3\u540D\uFF1A");
		label_2_2.setBounds(29, 34, 79, 15);
		panel1.add(label_2_2);
		
		JLabel label_2_1_1 = new JLabel("\u51FA\u751F\u65E5\u671F\uFF1A");
		label_2_1_1.setBounds(29, 78, 79, 15);
		panel1.add(label_2_1_1);
		
		textField = new JTextField();
		textField.setBounds(74, 29, 132, 24);
		panel1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 73, 225, 24);
		panel1.add(textField_1);
		
		JLabel label_2_2_1 = new JLabel("\u6027\u522B\uFF1A");
		label_2_2_1.setBounds(237, 34, 41, 15);
		panel1.add(label_2_2_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(269, 29, 66, 24);
		panel1.add(textField_3);
		
		JLabel label = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\u7801\uFF1A");
		label.setBounds(368, 34, 79, 15);
		panel1.add(label);
		
		txt = new JTextField();
		txt.setBounds(443, 29, 236, 24);
		panel1.add(txt);
		
		JLabel label_1_1_3 = new JLabel("\u6237\u53E3\u5730\u5740\uFF1A");
		label_1_1_3.setBounds(350, 78, 79, 15);
		panel1.add(label_1_1_3);
		
		textField_6 = new JTextField();
		textField_6.setBounds(410, 73, 262, 24);
		panel1.add(textField_6);
		
		JPanel panel3 = new JPanel();
		panel3.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel3.setBounds(31, 401, 838, 165);
		contentPane.add(panel3);
		panel3.setLayout(null);
		
		JLabel label_2 = new JLabel("\u59D3\u540D\uFF1A");
		label_2.setBounds(34, 37, 46, 15);
		panel3.add(label_2);
		
		txt1 = new JTextField();
		txt1.setBounds(76, 32, 132, 24);
		panel3.add(txt1);
		
		JLabel label_1_1 = new JLabel("\u6027\u522B\uFF1A");
		label_1_1.setBounds(257, 37, 46, 15);
		panel3.add(label_1_1);
		
		txt2 = new JTextField();
		txt2.setBounds(290, 32, 66, 24);
		panel3.add(txt2);
		
		JLabel label_2_1 = new JLabel("\u51FA\u751F\u65E5\u671F\uFF1A");
		label_2_1.setBounds(34, 91, 79, 15);
		panel3.add(label_2_1);
		
		txt4 = new JTextField();
		txt4.setBounds(96, 86, 209, 24);
		panel3.add(txt4);
		
		JLabel label_1_1_1 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\u7801\uFF1A");
		label_1_1_1.setBounds(401, 37, 79, 15);
		panel3.add(label_1_1_1);
		
		txt3 = new JTextField();
		txt3.setBounds(480, 32, 274, 24);
		panel3.add(txt3);
		
		JLabel label_1_1_2 = new JLabel("\u6237\u53E3\u5730\u5740\uFF1A");
		label_1_1_2.setBounds(376, 91, 60, 15);
		panel3.add(label_1_1_2);
		
		txt5 = new JTextField();
		txt5.setBounds(446, 86, 308, 24);
		panel3.add(txt5);
		this.fillTable(new Person());
	}
	
	/**
	 * 修改事件
	 */
	protected void updateActionPerformed(ActionEvent evt) {
		String name = this.txt1.getText();
		if(StringUtil.isEmpty(name)){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		
		String sex = this.txt2.getText();
		String idno = this.txt3.getText();
		String birthday = this.txt4.getText();
		String accountaddr = this.txt5.getText();
		if (StringUtil.isEmpty(sex)) {
			JOptionPane.showMessageDialog(null, "性别不能为空！");
			return ;
		}
		if (StringUtil.isEmpty(idno)) {
			JOptionPane.showMessageDialog(null, "身份证号码不能为空！");
			return ;
		}
		if (StringUtil.isEmpty(birthday)) {
			JOptionPane.showMessageDialog(null, "出生日期不能为空！");
			return ;
		}
		if (StringUtil.isEmpty(accountaddr)) {
			JOptionPane.showMessageDialog(null, "户口地址不能为空！");
			return ;
		}
		
		Person person = new Person(name, sex, idno, birthday, accountaddr) ;
		Connection con=null;
		try{
			con=DBConnection.getConn();
			int addNum=PersonDao.update(con, person);
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "人员信息修改成功！");
				resetValue();
				this.fillTable(new Person());
			}else{
				JOptionPane.showMessageDialog(null, "人员信息修改失败！");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "人员信息修改失败！！");
		}finally{
			try {
				DBConnection.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 删除事件
	 * @param de
	 */
	protected void deleteActionEvent(ActionEvent de) {
		String idno=txt3.getText();
		if(StringUtil.isEmpty(idno)){
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if(n==0){
			Connection con=null;
			try{
				con=DBConnection.getConn();
				int deleteNum=PersonDao.delete(con, idno);
				if(deleteNum==1){
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(new Person());
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
	 * 添加事件
	 * @param e
	 */
	protected void addActionPerformed(ActionEvent ae) {
		String name = this.txt1.getText();
		String sex = this.txt2.getText();
		String idno = this.txt3.getText();
		String birthday = this.txt4.getText();
		String accountaddr = this.txt5.getText();
		if(StringUtil.isEmpty(name)){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		
		if (StringUtil.isEmpty(sex)) {
			JOptionPane.showMessageDialog(null, "性别不能为空！");
			return ;
		}
		if (StringUtil.isEmpty(idno)) {
			JOptionPane.showMessageDialog(null, "身份证号码不能为空！");
			return ;
		}
		if (StringUtil.isEmpty(birthday)) {
			JOptionPane.showMessageDialog(null, "出生日期不能为空！");
			return ;
		}
		if (StringUtil.isEmpty(accountaddr)) {
			JOptionPane.showMessageDialog(null, "户口地址不能为空！");
			return ;
		}
		
		Person person = new Person(name, sex, idno, birthday, accountaddr) ;
		Connection con=null;
		try{
			con=DBConnection.getConn();
			int addNum=PersonDao.insert(con, person);
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "人员信息添加成功！");
				resetValue();
				this.fillTable(new Person());
			}else{
				JOptionPane.showMessageDialog(null, "人员信息添加失败！");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "人员信息添加失败！！");
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
		this.txt5.setText("");
	}

	/**
	 * 查询事件处理
	 * @param owner
	 */
	//Person(String name, String sex, String idno, String birthday, String accountaddr)
		private void searchActionPerformed(ActionEvent e) {
		String name = this.txt1.getText();
		String sex = this.txt2.getText();
		String idno = this.txt3.getText();
		String birthday = this.txt4.getText();
		String accountaddr = this.txt5.getText();
		Person person = new Person();
		person.setName(name);
		person.setSex(sex);
		person.setIdno(idno);
		person.setBirthday(birthday);
		person.setAccountaddr(accountaddr);
		this.fillTable(person);
		person = new Person(name, sex, idno, birthday, accountaddr);
		this.fillTable(person);
	
	}
	/**
	 * 填充表格
	 * @param owner
	 */
	private void fillTable(Person person) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);//清空表格
		Connection con = null;
		try {
			con = DBConnection.getConn();
			ResultSet rs=PersonDao.getRS(con,person);
			while (rs.next()) {
				Vector<String> v=new Vector<String>();
				v.add(rs.getString("name"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("idno"));
				v.add(rs.getString("birthday"));
				v.add(rs.getString("accountaddr"));
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
		String name = table.getValueAt(row, 0).toString();
		String sex = table.getValueAt(row, 1).toString();
		String idno = table.getValueAt(row, 2).toString();
		String birthday = table.getValueAt(row, 3).toString();
		String accountaddr = table.getValueAt(row, 4).toString();
		txt1.setText(name);
		txt2.setText(sex);
		txt3.setText(idno);
		txt4.setText(birthday);
		txt5.setText(accountaddr);
	}
	/**
	 * 模糊查询
	 * 
	 * @param roomNo
	 */
	protected void fillTable(String idno) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);// 清空表格
		Connection con = null;
		try {
			con = DBConnection.getConn();
			ResultSet rs = PersonDao.queryIdno(con, idno);
			
			ArrayList<Vector<String>> list = new ArrayList<>();
			
			while (rs.next()) {
				Vector<String> v = new Vector<String>();
				v.add(rs.getString("name"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("idno"));
				v.add(rs.getString("birthday"));
				v.add(rs.getString("accountaddr"));
				list.add(v);
			}
			
			list.forEach(v -> {
				if (v.get(2).equals(idno)) {
					dtm.addRow(v);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}
}
