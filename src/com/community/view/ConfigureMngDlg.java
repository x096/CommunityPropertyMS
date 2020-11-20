package com.community.view;
//��ѯ����
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
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

import com.community.dao.ConfigureDao;
import com.community.db.DBConnection;
import com.community.db.StringUtil;
import com.community.model.Configure;

public class ConfigureMngDlg extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField txt4;
	private JTextField textField_4;
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
	@SuppressWarnings("serial")
	public ConfigureMngDlg() {
		setTitle("\u6536\u8D39\u9879\u76EE\u7EF4\u62A4");
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
				"\u7F16\u53F7", "\u914D\u7F6E\u540D\u79F0", "\u4EF7\u683C", "\u4F7F\u7528\u671F\u9650"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(2).setPreferredWidth(74);
		table.getColumnModel().getColumn(3).setPreferredWidth(118);
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
				deleteActionEvent(de);
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
		
		JButton query = new JButton("\u67E5\u8BE2");
		query.setBounds(524, 47, 110, 30);
		panel1.add(query);
		query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				searchActionPerformed(ae);
			}
		});
		query.setIcon(new ImageIcon(OwnerMngDlg.class.getResource("/images/search.png")));
		
		JLabel label_2_2 = new JLabel("\u7F16\u53F7\uFF1A");
		label_2_2.setBounds(46, 42, 79, 15);
		panel1.add(label_2_2);
		
		JLabel label_2_1_1 = new JLabel("\u4EF7\u683C\uFF1A");
		label_2_1_1.setBounds(46, 73, 79, 15);
		panel1.add(label_2_1_1);
		
		textField = new JTextField();
		textField.setBounds(135, 37, 132, 24);
		panel1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(135, 68, 132, 24);
		panel1.add(textField_1);
		
		JLabel label_2_2_1 = new JLabel("\u914D\u7F6E\u540D\u79F0\uFF1A");
		label_2_2_1.setBounds(294, 37, 96, 15);
		panel1.add(label_2_2_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(364, 33, 132, 24);
		panel1.add(textField_3);
		
		JLabel label_1_1_2 = new JLabel("\u4F7F\u7528\u671F\u9650\uFF1A");
		label_1_1_2.setBounds(294, 73, 87, 15);
		panel1.add(label_1_1_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(364, 68, 132, 24);
		panel1.add(textField_4);
		
		JPanel panel3 = new JPanel();
		panel3.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel3.setBounds(31, 401, 646, 165);
		contentPane.add(panel3);
		panel3.setLayout(null);
		
		JLabel label_2 = new JLabel("\u7F16\u53F7\uFF1A");
		label_2.setBounds(69, 41, 100, 15);
		panel3.add(label_2);
		
		txt1 = new JTextField();
		txt1.setBounds(137, 32, 132, 24);
		panel3.add(txt1);
		
		JLabel label_1_1 = new JLabel("\u914D\u7F6E\u540D\u79F0\uFF1A");
		label_1_1.setBounds(333, 41, 87, 15);
		panel3.add(label_1_1);
		
		txt2 = new JTextField();
		txt2.setBounds(412, 36, 162, 24);
		panel3.add(txt2);
		
		JLabel label_2_1 = new JLabel("\u4EF7\u683C\uFF1A");
		label_2_1.setBounds(69, 97, 100, 15);
		panel3.add(label_2_1);
		
		txt3 = new JTextField();
		txt3.setBounds(137, 88, 132, 24);
		panel3.add(txt3);
		
		JLabel label_1_1_1 = new JLabel("\u4F7F\u7528\u671F\u9650\uFF1A");
		label_1_1_1.setBounds(333, 93, 87, 15);
		panel3.add(label_1_1_1);
		
		txt4 = new JTextField();
		txt4.setBounds(412, 88, 162, 24);
		panel3.add(txt4);
		this.fillTable(new Configure());
	}
	
	/**
	 * �޸��¼�
	 * @param e
	 */
	protected void updateActionPerformed(ActionEvent evt) {
		String id = this.txt1.getText();
		String name = this.txt2.getText();
		String price = this.txt3.getText();
		String servicelife = this.txt4.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵļ�¼");
			return;
		}
		if (StringUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(null, "�����������Ʋ���Ϊ�գ�");
			return ;
		}
		if (StringUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "�۸���Ϊ�գ�");
			return ;
		}
		if (StringUtil.isEmpty(servicelife)) {
			JOptionPane.showMessageDialog(null, "ʹ�����޲���Ϊ�գ�");
			return ;
		}
		Configure configure = new Configure(id, name, price, servicelife);
		Connection con=null;
		try{
			con=DBConnection.getConn();
			int addNum=ConfigureDao.update(con, configure);
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "������Ϣ�޸ĳɹ���");
				resetValue();
				this.fillTable(new Configure());
			}else{
				JOptionPane.showMessageDialog(null, "������Ϣ�޸�ʧ�ܣ�");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "������Ϣ�޸�ʧ�ܣ���");
		}finally{
			try {
				DBConnection.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ɾ���¼�
	 * @param de
	 */
	protected void deleteActionEvent(ActionEvent de) {
		String id=txt1.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ���ļ�¼");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ���ü�¼��");
		if(n==0){
			Connection con=null;
			try{
				con=DBConnection.getConn();
				int deleteNum=ConfigureDao.delete(con, id);
				if(deleteNum==1){
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					this.resetValue();
					this.fillTable(new Configure());
				}else{
					JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
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
	 * ����¼�
	 * @param e
	 */
	protected void addActionPerformed(ActionEvent ae) {
		String id = this.txt1.getText();
		String name = this.txt2.getText();
		String price = this.txt3.getText();
		String servicelife = this.txt4.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵļ�¼");
			return;
		}
		if (StringUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(null, "�����������Ʋ���Ϊ�գ�");
			return ;
		}
		if (StringUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "�۸���Ϊ�գ�");
			return ;
		}
		if (StringUtil.isEmpty(servicelife)) {
			JOptionPane.showMessageDialog(null, "ʹ�����޲���Ϊ�գ�");
			return ;
		}
		Configure configure = new Configure(id, name, price, servicelife);
		Connection con=null;
		try{
			con=DBConnection.getConn();
			int addNum=ConfigureDao.insert(con, configure);
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "������Ϣ��ӳɹ���");
				resetValue();
				this.fillTable(new Configure());
			}else{
				JOptionPane.showMessageDialog(null, "������Ϣ���ʧ�ܣ�");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "������Ϣ���ʧ�ܣ���");
		}finally{
			try {
				DBConnection.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * �����¼�����
	 * @param e
	 */
	protected void resetValueActionPerformed(ActionEvent e) {
		this.resetValue();
	}
	
	
	/**
	 * ���ñ�
	 */
	private void resetValue(){
		this.txt1.setText("");
		this.txt2.setText("");
		this.txt3.setText("");
		this.txt4.setText("");
	}

	/**
	 * ��ѯ�¼�����
	 * @param owner
	 */
		private void searchActionPerformed(ActionEvent e) {
		String id = this.txt1.getText();
		String name = this.txt2.getText();
		String price = this.txt3.getText();
		String servicelife = this.txt4.getText();
		Configure configure = new Configure();
		configure.setId(id);
		configure.setName(name);
		configure.setPrice(price);
		configure.setServicelife(servicelife);
		this.fillTable(configure);
		configure=new Configure(id, name, price, servicelife);
		this.fillTable(configure);
	
	}
	/**
	 * �����
	 * @param owner
	 */

	private void fillTable(Configure Configure) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);//��ձ��
		Connection con = null;
		try {
			con = DBConnection.getConn();
			ResultSet rs=ConfigureDao.getRS(con,Configure);
			while (rs.next()) {
				Vector<String> v=new Vector<String>();
				v.add(rs.getString("id"));
				v.add(rs.getString("name"));
				v.add(rs.getString("price"));
				v.add(rs.getString("servicelife"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		}
	}
	
	/**
	 * ������¼�
	 * @param e
	 */	
	protected void tableMouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		String id = table.getValueAt(row, 0).toString();
		String name = table.getValueAt(row, 1).toString();
		String price = table.getValueAt(row, 2).toString();
		String servicelife = table.getValueAt(row, 3).toString();
		txt1.setText(id);
		txt2.setText(name);
		txt3.setText(price);
		txt4.setText(servicelife);
	}

}
