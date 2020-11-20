package com.community.view;

//
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

import com.community.dao.ApplicationDao;
import com.community.dao.PropertyDao;
import com.community.db.DBConnection;
import com.community.db.StringUtil;
import com.community.model.Application;

@SuppressWarnings("serial")
public class ApplicationMngDlg extends JFrame {

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
	public ApplicationMngDlg() {
		setTitle("\u7EF4\u4FEE\u7533\u8BF7\u7BA1\u7406");
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
				new String[] { "\u7EF4\u4FEE\u72B6", "\u7EF4\u4FEE\u9879\u76EE", "\u7533\u8BF7\u65F6\u95F4",
						"\u7EF4\u4FEE\u9879\u76EE", "\u7EF4\u4FEE\u72B6\u6001" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
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
		query.addActionListener(l -> {
			String applicant = txt.getText();
			fillTable(applicant);
		});
		
		query.setIcon(new ImageIcon(OwnerMngDlg.class.getResource("/images/search.png")));

		JLabel label_2_2 = new JLabel("\u7533\u8BF7\u4EBA\uFF1A");
		label_2_2.setBounds(29, 32, 79, 15);
		panel1.add(label_2_2);

		JLabel label_2_1_1 = new JLabel("\u7EF4\u4FEE\u9879\u76EE\uFF1A");
		label_2_1_1.setBounds(29, 78, 79, 15);
		panel1.add(label_2_1_1);

		txt = new JTextField();
		txt.setBounds(74, 27, 132, 24);
		panel1.add(txt);

		textField_1 = new JTextField();
		textField_1.setBounds(94, 73, 225, 24);
		panel1.add(textField_1);

		JLabel label_2_2_1 = new JLabel("\u7533\u8BF7\u4EBA\u623F\u95F4\u7F16\u53F7\uFF1A");
		label_2_2_1.setBounds(237, 32, 96, 15);
		panel1.add(label_2_2_1);

		textField_3 = new JTextField();
		textField_3.setBounds(332, 27, 132, 24);
		panel1.add(textField_3);

		JLabel label = new JLabel("\u7533\u8BF7\u65F6\u95F4\uFF1A");
		label.setBounds(489, 32, 79, 15);
		panel1.add(label);

		textField_2 = new JTextField();
		textField_2.setBounds(545, 27, 132, 24);
		panel1.add(textField_2);

		JLabel label_1_1_3 = new JLabel("\u7EF4\u4FEE\u72B6\u6001\uFF1A");
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

		JLabel label_2 = new JLabel("\u7533\u8BF7\u4EBA\uFF1A");
		label_2.setBounds(48, 36, 100, 15);
		panel3.add(label_2);

		txt1 = new JTextField();
		txt1.setBounds(102, 32, 132, 24);
		panel3.add(txt1);

		JLabel label_1_1 = new JLabel("\u7533\u8BF7\u4EBA\u623F\u95F4\u7F16\u53F7\uFF1A");
		label_1_1.setBounds(295, 36, 118, 15);
		panel3.add(label_1_1);

		txt2 = new JTextField();
		txt2.setBounds(393, 32, 162, 24);
		panel3.add(txt2);

		JLabel label_2_1 = new JLabel("\u7EF4\u4FEE\u9879\u76EE\uFF1A");
		label_2_1.setBounds(48, 92, 100, 15);
		panel3.add(label_2_1);

		txt4 = new JTextField();
		txt4.setBounds(102, 87, 209, 24);
		panel3.add(txt4);

		JLabel label_1_1_1 = new JLabel("\u7533\u8BF7\u65F6\u95F4\uFF1A");
		label_1_1_1.setBounds(583, 36, 79, 15);
		panel3.add(label_1_1_1);

		txt3 = new JTextField();
		txt3.setBounds(648, 32, 162, 24);
		panel3.add(txt3);

		JLabel label_1_1_2 = new JLabel("\u7EF4\u4FEE\u72B6\u6001\uFF1A");
		label_1_1_2.setBounds(422, 92, 60, 15);
		panel3.add(label_1_1_2);

		txt5 = new JTextField();
		txt5.setBounds(480, 87, 162, 24);
		panel3.add(txt5);
		this.fillTable(new Application());
	}

	/**
	 * �޸��¼�
	 */
	protected void updateActionPerformed(ActionEvent evt) {
		String applicant = this.txt1.getText();
		if (StringUtil.isEmpty(applicant)) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵļ�¼");
			return;
		}
		String roomno = this.txt2.getText();
		String applytime = this.txt3.getText();
		String applyprogram = this.txt4.getText();
		String applystate = this.txt5.getText();
		if (StringUtil.isEmpty(roomno)) {
			JOptionPane.showMessageDialog(null, "�����˷����Ų���Ϊ�գ�");
			return;
		}
		if (StringUtil.isEmpty(applytime)) {
			JOptionPane.showMessageDialog(null, "����ʱ�䲻��Ϊ�գ�");
			return;
		}
		if (StringUtil.isEmpty(applyprogram)) {
			JOptionPane.showMessageDialog(null, "ά����Ŀ����Ϊ�գ�");
			return;
		}
		if (StringUtil.isEmpty(applystate)) {
			JOptionPane.showMessageDialog(null, "ά��״̬����Ϊ�գ�");
			return;
		}
		Application application = new Application(applicant, roomno, applytime, applyprogram, applystate);
		Connection con = null;
		try {
			con = DBConnection.getConn();
			int addNum = ApplicationDao.update(con, application);
			if (addNum == 1) {
				JOptionPane.showMessageDialog(null, "ά��������Ŀ�޸ĳɹ���");
				resetValue();
				this.fillTable(new Application());
			} else {
				JOptionPane.showMessageDialog(null, "ά��������Ŀ�޸�ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ά��������Ŀ�޸�ʧ�ܣ���");
		} finally {
			try {
				DBConnection.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ɾ���¼�
	 * 
	 * @param de
	 */
	protected void deleteActionEvent(ActionEvent de) {
		String applicant = txt1.getText();
		if (StringUtil.isEmpty(applicant)) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ���ļ�¼");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ���ü�¼��");
		if (n == 0) {
			Connection con = null;
			try {
				con = DBConnection.getConn();
				int deleteNum = ApplicationDao.delete(con, applicant);
				if (deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					this.resetValue();
					this.fillTable(new Application());
				} else {
					JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
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
	 * ����¼�
	 * 
	 * @param e
	 */
	protected void addActionPerformed(ActionEvent ae) {
		String applicant = this.txt1.getText();
		String roomno = this.txt2.getText();
		String applytime = this.txt3.getText();
		String applyprogram = this.txt4.getText();
		String applystate = this.txt5.getText();
		if (StringUtil.isEmpty(applicant)) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵļ�¼");
			return;
		}
		if (StringUtil.isEmpty(roomno)) {
			JOptionPane.showMessageDialog(null, "�����˷����Ų���Ϊ�գ�");
			return;
		}
		if (StringUtil.isEmpty(applytime)) {
			JOptionPane.showMessageDialog(null, "����ʱ�䲻��Ϊ�գ�");
			return;
		}
		if (StringUtil.isEmpty(applyprogram)) {
			JOptionPane.showMessageDialog(null, "ά����Ŀ����Ϊ�գ�");
			return;
		}
		if (StringUtil.isEmpty(applystate)) {
			JOptionPane.showMessageDialog(null, "ά��״̬����Ϊ�գ�");
			return;
		}
		Application application = new Application(applicant, roomno, applytime, applyprogram, applystate);
		Connection con = null;
		try {
			con = DBConnection.getConn();
			int addNum = ApplicationDao.insert(con, application);
			if (addNum == 1) {
				JOptionPane.showMessageDialog(null, "ά��������Ŀ��ӳɹ���");
				resetValue();
				this.fillTable(new Application());
			} else {
				JOptionPane.showMessageDialog(null, "ά��������Ŀ���ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ά��������Ŀ���ʧ�ܣ���");
		} finally {
			try {
				DBConnection.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * �����¼�����
	 * 
	 * @param e
	 */
	protected void resetValueActionPerformed(ActionEvent e) {
		this.resetValue();
	}

	/**
	 * ���ñ�
	 */
	private void resetValue() {
		this.txt1.setText("");
		this.txt2.setText("");
		this.txt3.setText("");
		this.txt4.setText("");
		this.txt5.setText("");
	}

	/**
	 * ��ѯ�¼�����
	 * 
	 * @param owner
	 */
	private void searchActionPerformed(ActionEvent e) {
		String applicant = this.txt1.getText();
		String roomno = this.txt2.getText();
		String applytime = this.txt3.getText();
		String applyprogram = this.txt4.getText();
		String applystate = this.txt5.getText();
//		Application application = new Application();
//		application.setApplicant(applicant);
//		application.setRoomno(roomno);
//		application.setApplytime(applytime);
//		application.setApplyprogram(applyprogram);
//		application.setApplystate(applystate);
//		this.fillTable(application);
		Application application = new Application(applicant, roomno, applytime, applyprogram, applystate);
		this.fillTable(application);

	}

	/**
	 * �����
	 * 
	 * @param owner
	 */

	private void fillTable(Application application) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);// ��ձ��
		Connection con = null;
		try {
			con = DBConnection.getConn();
			ResultSet rs = ApplicationDao.getRS(con);
			
			System.out.println(rs.next());
			
			while (rs.next()) {
//				application.getApplicant()
				
				Vector<String> v = new Vector<String>();
				v.add(rs.getString("applicant"));
				v.add(rs.getString("roomno"));
				v.add(rs.getString("applytime"));
				v.add(rs.getString("applyprogram"));
				v.add(rs.getString("applystate"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	/**
	 * ������¼�
	 * 
	 * @param e
	 */
	protected void tableMouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		String applicant = table.getValueAt(row, 0).toString();
		String roomno = table.getValueAt(row, 1).toString();
		String applytime = table.getValueAt(row, 2).toString();
		String applyprogram = table.getValueAt(row, 3).toString();
		String applystate = table.getValueAt(row, 4).toString();
		txt1.setText(applicant);
		txt2.setText(roomno);
		txt3.setText(applytime);
		txt4.setText(applyprogram);
		txt5.setText(applystate);
	}
	/**
	 * ģ����ѯ
	 * 
	 * @param roomNo
	 */
	protected void fillTable(String applicant) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);// ��ձ��
		Connection con = null;
		try {
			con = DBConnection.getConn();
			ResultSet rs = ApplicationDao.queryApplicant(con, applicant);
			
			ArrayList<Vector<String>> list = new ArrayList<>();
			
			while (rs.next()) {
				//Application(String applicant, String roomno, String applytime, String applyprogram, String applystate)
				Vector<String> v = new Vector<String>();
				v.add(rs.getString("applicant"));
				v.add(rs.getString("roomno"));
				v.add(rs.getString("applytime"));
				v.add(rs.getString("applyprogram"));
				v.add(rs.getString("applystate"));
				list.add(v);
			}
			
			list.forEach(v -> {
				if (v.get(0).equals(applicant)) {
					dtm.addRow(v);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}
}
