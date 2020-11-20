package com.community.view;
//ְλ����
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

import com.community.dao.PositionDao;
import com.community.dao.PropertyDao;
import com.community.db.DBConnection;
import com.community.db.StringUtil;
import com.community.model.Position;

@SuppressWarnings("serial")
public class PositionMngDlg extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JTable table;
	private JTextField txt;
	private JTextField textField_1;
	private JTextField txt2;
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
	public PositionMngDlg() {
		setTitle("\u804C\u4F4D\u7BA1\u7406");
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
				"\u804C\u4F4D\u540D\u79F0", "\u804C\u4F4D\u5907\u6CE8"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(335);
		scrollPane.setViewportView(table);
		
		JButton add = new JButton("\u589E\u52A0");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addActionPerformed(ae);
			}
		});
		add.setIcon(new ImageIcon(OwnerMngDlg.class.getResource("/images/add.png")));
		add.setBounds(51, 570, 110, 30);
		contentPane.add(add);
		
		JButton reset = new JButton("\u91CD\u7F6E");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		reset.setIcon(new ImageIcon(OwnerMngDlg.class.getResource("/images/reset.png")));
		reset.setBounds(203, 570, 110, 30);
		contentPane.add(reset);
		
		JButton update = new JButton("\u4FEE\u6539");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				updateActionPerformed(evt);
			}
		});
		update.setIcon(new ImageIcon(OwnerMngDlg.class.getResource("/images/modify.png")));
		update.setBounds(373, 570, 110, 30);
		contentPane.add(update);
		
		JButton delete = new JButton("\u5220\u9664");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent de) {
				deleteActionEvent(de);
			}
		});
		delete.setIcon(new ImageIcon(OwnerMngDlg.class.getResource("/images/delete.png")));
		delete.setBounds(536, 570, 110, 30);
		contentPane.add(delete);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel1.setBounds(33, 29, 644, 123);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JButton query = new JButton("\u67E5\u8BE2");
		query.setBounds(524, 50, 110, 30);
		panel1.add(query);
		query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String jobtitle = txt.getText();
				fillTable(jobtitle);	
			}
		});
		query.setIcon(new ImageIcon(OwnerMngDlg.class.getResource("/images/search.png")));
		
		JLabel label_2_2 = new JLabel("\u804C\u4F4D\u540D\u79F0\uFF1A");
		label_2_2.setBounds(33, 29, 79, 15);
		panel1.add(label_2_2);
		
		txt = new JTextField();
		txt.setBounds(108, 25, 134, 24);
		panel1.add(txt);
		
		JLabel label_2_2_1 = new JLabel("\u804C\u4F4D\u5907\u6CE8\uFF1A");
		label_2_2_1.setBounds(33, 58, 79, 15);
		panel1.add(label_2_2_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(108, 55, 359, 41);
		panel1.add(textField_1);
		
		JPanel panel3 = new JPanel();
		panel3.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel3.setBounds(31, 401, 646, 159);
		contentPane.add(panel3);
		panel3.setLayout(null);
		
		JLabel label_2 = new JLabel("\u804C\u4F4D\u540D\u79F0\uFF1A");
		label_2.setBounds(37, 29, 81, 15);
		panel3.add(label_2);
		
		txt1 = new JTextField();
		txt1.setBounds(115, 25, 163, 24);
		panel3.add(txt1);
		
		JLabel label_1_1 = new JLabel("\u804C\u4F4D\u5907\u6CE8\uFF1A");
		label_1_1.setBounds(37, 83, 81, 15);
		panel3.add(label_1_1);
		
		txt2 = new JTextField();
		txt2.setBounds(115, 80, 359, 41);
		panel3.add(txt2);
		this.fillTable(new Position());
	}
	
	/**
	 * �޸��¼�
	 * @param e
	 */
	protected void updateActionPerformed(ActionEvent evt) {
		String jobtitle = this.txt1.getText();
		if(StringUtil.isEmpty(jobtitle)){
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵļ�¼");
			return;
		}
		String positionnote = this.txt2.getText();
		if(StringUtil.isEmpty(positionnote)){
			JOptionPane.showMessageDialog(null, "ְλ��ע����Ϊ�գ�");
			return;
		}
		Position position = new Position(jobtitle,positionnote);
		Connection con=null;
		try{
			con=DBConnection.getConn();
			int addNum=PositionDao.update(con, position);
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "ְλ��Ϣ�޸ĳɹ���");
				resetValue();
				this.fillTable(new Position());
			}else{
				JOptionPane.showMessageDialog(null, "ְλ��Ϣ�޸�ʧ�ܣ�");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ְλ��Ϣ�޸�ʧ�ܣ���");
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
		String jobtitle=txt1.getText();
		if(StringUtil.isEmpty(jobtitle)){
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ���ļ�¼");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ���ü�¼��");
		if(n==0){
			Connection con=null;
			try{
				con=DBConnection.getConn();
				int deleteNum=PositionDao.delete(con, jobtitle);
				if(deleteNum==1){
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					this.resetValue();
					this.fillTable(new Position());
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
		String jobtitle = this.txt1.getText();
		String positionnote = this.txt2.getText();
		if(StringUtil.isEmpty(jobtitle)){
			JOptionPane.showMessageDialog(null, "ְλ���Ʋ���Ϊ�գ�");
			return;
		}
		if(StringUtil.isEmpty(positionnote)){
			JOptionPane.showMessageDialog(null, "ְλ��ע����Ϊ�գ�");
			return;
		}
		Position position = new Position(jobtitle, positionnote);
		Connection con=null;
		try{
			con=DBConnection.getConn();
			int addNum=PositionDao.insert(con, position);
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "ְλ��Ϣ��ӳɹ���");
				resetValue();
				this.fillTable(new Position());
			}else{
				JOptionPane.showMessageDialog(null, "ְλ��Ϣ���ʧ�ܣ�");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ְλ��Ϣ���ʧ�ܣ���");
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
	}

	/**
	 * ��ѯ�¼�����
	 * @param owner
	 */
		private void searchActionPerformed(ActionEvent e) {
		String jobtitle = this.txt1.getText();
		String positionnote = this.txt2.getText();
		Position position = new Position();
		position.setJobtitle(jobtitle);
		position.setPositionnote(positionnote);
		this.fillTable(position);
		position=new Position(jobtitle,positionnote);
		this.fillTable(position);
	
	}
	/**
	 * �����
	 * @param owner
	 */

	private void fillTable(Position position) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);//��ձ��
		Connection con = null;
		try {
			con = DBConnection.getConn();
			ResultSet rs=PositionDao.getRS(con,position);
			while (rs.next()) {
				Vector<String> v=new Vector<String>();
				v.add(rs.getString("jobtitle"));
				v.add(rs.getString("positionnote"));
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
		String jobtitle = table.getValueAt(row, 0).toString();
		String positionnote = table.getValueAt(row, 1).toString();
		txt1.setText(jobtitle);
		txt2.setText(positionnote);
	}
	/**
	 * ģ����ѯ
	 * 
	 * @param roomNo
	 */
	protected void fillTable(String jobtitle) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);// ��ձ��
		Connection con = null;
		try {
			con = DBConnection.getConn();
			ResultSet rs = PositionDao.queryJobtitle(con, jobtitle);
			
			ArrayList<Vector<String>> list = new ArrayList<>();
			
			while (rs.next()) {
				Vector<String> v = new Vector<String>();
				v.add(rs.getString("jobtitle"));
				v.add(rs.getString("positionnote"));
				list.add(v);
			}
			
			list.forEach(v -> {
				if (v.get(0).equals(jobtitle)) {
					dtm.addRow(v);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}
}
