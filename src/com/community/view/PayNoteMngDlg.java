package com.community.view;

//�շѵ�λ��
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.community.dao.PayNoteDao;
import com.community.dao.PropertyDao;
import com.community.db.DBConnection;
import com.community.db.StringUtil;
import com.community.model.PayNote;

@SuppressWarnings("serial")
public class PayNoteMngDlg extends JFrame {

	/**
	 * Launch the application.
	 */
	private JPanel contentPane;
	private JTable table;
	private JTextField txt1;
	private JTextField txt3;
	private JTextField txt2;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt6;
	private JTextField txt7;

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
	public PayNoteMngDlg() {
		setTitle("\u6536\u8D39\u5355\u7EF4\u62A4");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1002, 691);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 179, 931, 214);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u6536\u8D39\u5355\u7F16\u53F7", "\u6536\u8D39\u9879\u76EE\u540D\u79F0", "\u5355\u4EF7",
						"\u603B\u4EF7", "\u6536\u8D39\u9879\u7C7B\u578B", "\u4E1A\u4E3B\u59D3\u540D",
						"\u623F\u5C4B\u5730\u5740" }) {
			boolean[] columnEditables = new boolean[] { true, false, true, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(86);
		table.getColumnModel().getColumn(2).setPreferredWidth(45);
		table.getColumnModel().getColumn(3).setPreferredWidth(42);
		scrollPane.setViewportView(table);

		JButton add = new JButton("\u589E\u52A0");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addActionPerformed(e);
			}
		});
		add.setIcon(new ImageIcon(OwnerMngDlg.class.getResource("/images/add.png")));
		add.setBounds(101, 601, 110, 30);
		contentPane.add(add);

		JButton reset = new JButton("\u91CD\u7F6E");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		reset.setIcon(new ImageIcon(OwnerMngDlg.class.getResource("/images/reset.png")));
		reset.setBounds(315, 601, 110, 30);
		contentPane.add(reset);

		JButton update = new JButton("\u4FEE\u6539");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				updateActionPerformed(evt);
			}
		});
		update.setIcon(new ImageIcon(OwnerMngDlg.class.getResource("/images/modify.png")));
		update.setBounds(565, 601, 110, 30);
		contentPane.add(update);

		JButton delete = new JButton("\u5220\u9664");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent de) {
				ownerDeleteActionEvent(de);
			}
		});
		delete.setIcon(new ImageIcon(OwnerMngDlg.class.getResource("/images/delete.png")));
		delete.setBounds(792, 601, 110, 30);
		contentPane.add(delete);

		JPanel panel1 = new JPanel();
		panel1.setBorder(
				new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel1.setBounds(33, 29, 931, 123);
		contentPane.add(panel1);
		panel1.setLayout(null);

		JTextArea txt = new JTextArea();
		txt.setBounds(88, 27, 110, 24);
		panel1.add(txt);

		JButton query = new JButton("\u67E5\u8BE2");
		query.setBounds(793, 46, 110, 30);
		panel1.add(query);
		query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String pnoteno = txt.getText();
				fillTable(pnoteno);	
			}
		});
		query.setIcon(new ImageIcon(OwnerMngDlg.class.getResource("/images/search.png")));

		JLabel label = new JLabel("\u6536\u8D39\u5355\u7F16\u53F7\uFF1A");
		label.setBounds(20, 32, 89, 15);
		panel1.add(label);

		JTextArea txtfield2 = new JTextArea();
		txtfield2.setBounds(321, 27, 110, 24);
		panel1.add(txtfield2);

		JLabel label_1 = new JLabel("\u6536\u8D39\u9879\u76EE\u540D\u79F0\uFF1A");
		label_1.setBounds(238, 32, 89, 15);
		panel1.add(label_1);

		JLabel label_1_2 = new JLabel("\u5355\u4EF7\uFF1A");
		label_1_2.setBounds(488, 32, 43, 15);
		panel1.add(label_1_2);

		JTextArea txtfield3 = new JTextArea();
		txtfield3.setBounds(525, 27, 68, 24);
		panel1.add(txtfield3);

		JLabel label_1_2_1 = new JLabel("\u623F\u5C4B\u5730\u5740\uFF1A");
		label_1_2_1.setBounds(467, 80, 103, 15);
		panel1.add(label_1_2_1);

		JTextArea txtfield4 = new JTextArea();
		txtfield4.setBounds(524, 75, 217, 24);
		panel1.add(txtfield4);

		JLabel label_3 = new JLabel("\u603B\u4EF7\uFF1A");
		label_3.setBounds(632, 32, 43, 15);
		panel1.add(label_3);

		JTextArea txtfield3_1 = new JTextArea();
		txtfield3_1.setBounds(674, 27, 68, 24);
		panel1.add(txtfield3_1);

		JLabel label_4 = new JLabel("\u6536\u8D39\u9879\u7C7B\u578B\uFF1A");
		label_4.setBounds(20, 80, 89, 15);
		panel1.add(label_4);

		JTextArea txtfield1_1 = new JTextArea();
		txtfield1_1.setBounds(88, 75, 110, 24);
		panel1.add(txtfield1_1);

		JTextArea txtfield2_1 = new JTextArea();
		txtfield2_1.setBounds(321, 75, 110, 24);
		panel1.add(txtfield2_1);

		JLabel label_1_3 = new JLabel("\u4E1A\u4E3B\u59D3\u540D\uFF1A");
		label_1_3.setBounds(259, 80, 68, 15);
		panel1.add(label_1_3);

		JPanel panel3 = new JPanel();
		panel3.setBorder(
				new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel3.setBounds(31, 401, 933, 165);
		contentPane.add(panel3);
		panel3.setLayout(null);

		JLabel label_2 = new JLabel("\u6536\u8D39\u5355\u7F16\u53F7\uFF1A");
		label_2.setBounds(32, 42, 89, 15);
		panel3.add(label_2);

		JLabel label_4_1 = new JLabel("\u6536\u8D39\u9879\u7C7B\u578B\uFF1A");
		label_4_1.setBounds(32, 90, 89, 15);
		panel3.add(label_4_1);

		txt1 = new JTextField();
		txt1.setBounds(100, 37, 110, 24);
		panel3.add(txt1);

		txt5 = new JTextField();
		txt5.setBounds(100, 85, 110, 24);
		panel3.add(txt5);

		JLabel label_1_1 = new JLabel("\u6536\u8D39\u9879\u76EE\u540D\u79F0\uFF1A");
		label_1_1.setBounds(295, 38, 89, 15);
		panel3.add(label_1_1);

		JLabel label_1_3_1 = new JLabel("\u4E1A\u4E3B\u59D3\u540D\uFF1A");
		label_1_3_1.setBounds(316, 86, 68, 15);
		panel3.add(label_1_3_1);

		txt2 = new JTextField();
		txt2.setBounds(378, 33, 110, 24);
		panel3.add(txt2);

		txt6 = new JTextField();
		txt6.setBounds(378, 81, 110, 24);
		panel3.add(txt6);

		JLabel label_1_2_2 = new JLabel("\u5355\u4EF7\uFF1A");
		label_1_2_2.setBounds(587, 38, 43, 15);
		panel3.add(label_1_2_2);

		JLabel label_1_2_1_1 = new JLabel("\u623F\u5C4B\u5730\u5740\uFF1A");
		label_1_2_1_1.setBounds(566, 86, 103, 15);
		panel3.add(label_1_2_1_1);

		txt3 = new JTextField();
		txt3.setBounds(624, 33, 68, 24);
		panel3.add(txt3);

		txt7 = new JTextField();
		txt7.setBounds(623, 81, 217, 24);
		panel3.add(txt7);

		txt4 = new JTextField();
		txt4.setBounds(773, 33, 68, 24);
		panel3.add(txt4);

		JLabel label_3_1 = new JLabel("\u603B\u4EF7\uFF1A");
		label_3_1.setBounds(731, 38, 43, 15);
		panel3.add(label_3_1);
		this.fillTable(new PayNote());

	}

	/**
	 * �޸��¼�
	 * 
	 * @param e
	 */
	protected void updateActionPerformed(ActionEvent evt) {
		String pnoteno = this.txt1.getText();
		String payname = this.txt2.getText();
		String unit = this.txt3.getText();
		String total = this.txt4.getText();
		String paytype = this.txt5.getText();
		String ownerName = this.txt6.getText();
		String address = this.txt7.getText();

		if (StringUtil.isEmpty(pnoteno)) {
			JOptionPane.showMessageDialog(null, "�շѵ���Ų���Ϊ�գ�");
			return;
		}
		if (StringUtil.isEmpty(payname)) {
			JOptionPane.showMessageDialog(null, "�շ���Ŀ���Ʋ���Ϊ�գ�");
			return;
		}
		if (StringUtil.isEmpty(unit)) {
			JOptionPane.showMessageDialog(null, "���۲���Ϊ�գ�");
			return;
		}
		if (StringUtil.isEmpty(total)) {
			JOptionPane.showMessageDialog(null, "�ܼ۲���Ϊ�գ�");
			return;
		}
		if (StringUtil.isEmpty(paytype)) {
			JOptionPane.showMessageDialog(null, "�շ���Ŀ���Ͳ���Ϊ�գ�");
			return;
		}
		if (StringUtil.isEmpty(ownerName)) {
			JOptionPane.showMessageDialog(null, "ҵ����������Ϊ�գ�");
			return;
		}
		if (StringUtil.isEmpty(address)) {
			JOptionPane.showMessageDialog(null, "���ݵ�ַ����Ϊ�գ�");
			return;
		}
		PayNote payNote = new PayNote(pnoteno, payname, unit, total, paytype, ownerName, address);
		Connection con = null;
		try {
			con = DBConnection.getConn();
			int addNum = PayNoteDao.update(con, payNote);
			if (addNum == 1) {
				JOptionPane.showMessageDialog(null, "�շѵ���Ϣ�޸ĳɹ���");
				resetValue();
				this.fillTable(new PayNote());
			} else {
				JOptionPane.showMessageDialog(null, "�շѵ���Ϣ�޸�ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "�շѵ���Ϣ�޸�ʧ�ܣ���");
		}
	}

	/**
	 * ɾ���¼�
	 * 
	 * @param de
	 */
	protected void ownerDeleteActionEvent(ActionEvent de) {
		String pnoteno = txt1.getText();
		if (StringUtil.isEmpty(pnoteno)) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ���ļ�¼");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ���ü�¼��");
		if (n == 0) {
			Connection con = null;
			try {
				con = DBConnection.getConn();
				int deleteNum = PayNoteDao.delete(con, pnoteno);
				if (deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					this.resetValue();
					this.fillTable(new PayNote());
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
	protected void addActionPerformed(ActionEvent evt) {
		String pnoteno = this.txt1.getText();
		String payname = this.txt2.getText();
		String unit = this.txt3.getText();
		String total = this.txt4.getText();
		String paytype = this.txt5.getText();
		String ownerName = this.txt6.getText();
		String address = this.txt7.getText();

		if (StringUtil.isEmpty(pnoteno)) {
			JOptionPane.showMessageDialog(null, "�շѵ���Ų���Ϊ�գ�");
			return;
		}
		if (StringUtil.isEmpty(payname)) {
			JOptionPane.showMessageDialog(null, "�շ���Ŀ���Ʋ���Ϊ�գ�");
			return;
		}
		if (StringUtil.isEmpty(unit)) {
			JOptionPane.showMessageDialog(null, "���۲���Ϊ�գ�");
			return;
		}
		if (StringUtil.isEmpty(total)) {
			JOptionPane.showMessageDialog(null, "�ܼ۲���Ϊ�գ�");
			return;
		}
		if (StringUtil.isEmpty(paytype)) {
			JOptionPane.showMessageDialog(null, "�շ���Ŀ���Ͳ���Ϊ�գ�");
			return;
		}
		if (StringUtil.isEmpty(ownerName)) {
			JOptionPane.showMessageDialog(null, "ҵ����������Ϊ�գ�");
			return;
		}
		if (StringUtil.isEmpty(address)) {
			JOptionPane.showMessageDialog(null, "���ݵ�ַ����Ϊ�գ�");
			return;
		}
		PayNote payNote = new PayNote(pnoteno, payname, unit, total, paytype, ownerName, address);
		Connection con = null;
		try {
			con = DBConnection.getConn();
			int addNum = PayNoteDao.insert(con, payNote);
			if (addNum == 1) {
				JOptionPane.showMessageDialog(null, "�շѵ���Ϣ��ӳɹ���");
				resetValue();
				this.fillTable(new PayNote());
			} else {
				JOptionPane.showMessageDialog(null, "�շѵ���Ϣ���ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "�շѵ���Ϣ���ʧ�ܣ���");
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
		this.txt6.setText("");
		this.txt7.setText("");
	}

	/**
	 * ��ѯ�¼�����
	 * 
	 * @param owner
	 */
	private void ownerSearchActionPerformed(ActionEvent e) {
		String pnoteno = this.txt1.getText();
		String payname = this.txt2.getText();
		String unit = this.txt3.getText();
		String total = this.txt4.getText();
		String paytype = this.txt5.getText();
		String ownerName = this.txt6.getText();
		String address = this.txt7.getText();
		PayNote payNote = new PayNote();
		payNote.setPnoteno(pnoteno);
		payNote.setPayname(payname);
		payNote.setUnit(unit);
		payNote.setTotal(total);
		payNote.setPaytype(paytype);
		payNote.setOwnerName(ownerName);
		payNote.setAddress(address);
		this.fillTable(payNote);
		payNote = new PayNote(pnoteno, payname, unit, total, paytype, ownerName, address);
		this.fillTable(payNote);

	}

	/**
	 * �����
	 * 
	 * @param owner
	 */
	private void fillTable(PayNote payNote) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);// ��ձ��
		Connection con = null;
		try {
			con = DBConnection.getConn();
			ResultSet rs = PayNoteDao.getRS(con, payNote);
			while (rs.next()) {

				Vector<String> v = new Vector<String>();
				v.add(rs.getString("pnoteno"));
				v.add(rs.getString("payname"));
				v.add(rs.getString("unit"));
				v.add(rs.getString("total"));
				v.add(rs.getString("paytype"));
				v.add(rs.getString("ownerName"));
				v.add(rs.getString("address"));
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
		String pnoteno = table.getValueAt(row, 0).toString();
		String payname = table.getValueAt(row, 1).toString();
		String unit = table.getValueAt(row, 2).toString();
		String total = table.getValueAt(row, 3).toString();
		String paytype = table.getValueAt(row, 4).toString();
		String ownerName = table.getValueAt(row, 5).toString();
		String address = table.getValueAt(row, 6).toString();
		txt1.setText(pnoteno);
		txt2.setText(payname);
		txt3.setText(unit);
		txt4.setText(total);
		txt5.setText(paytype);
		txt6.setText(ownerName);
		txt7.setText(address);
	}

	/**
	 * ģ����ѯ
	 * 
	 * @param roomNo
	 */
	protected void fillTable(String pnoteno) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);// ��ձ��
		Connection con = null;
		try {
			con = DBConnection.getConn();
			ResultSet rs = PayNoteDao.queryPnoteno(con, pnoteno);

			ArrayList<Vector<String>> list = new ArrayList<>();

			while (rs.next()) {
				Vector<String> v = new Vector<String>();
				v.add(rs.getString("pnoteno"));
				v.add(rs.getString("unit"));
				v.add(rs.getString("total"));
				v.add(rs.getString("paytype"));
				v.add(rs.getString("ownerName"));
				v.add(rs.getString("address"));
				list.add(v);
			}

			list.forEach(v -> {
				if (v.get(0).equals(pnoteno)) {
					dtm.addRow(v);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}
}
