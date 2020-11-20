package com.community.view;

//�շ���Ŀά��
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

import com.community.dao.PayServiceDao;
import com.community.dao.PropertyDao;
import com.community.db.DBConnection;
import com.community.db.StringUtil;
import com.community.model.PayService;

@SuppressWarnings("serial")
public class PayserviceMngDlg extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTable table;
	private JTextField txt;
	private JTextField textField_1;
	private JTextField textField_3;

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
	public PayserviceMngDlg() {
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
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u6536\u8D39\u9879\u7F16\u53F7",
				"\u6536\u8D39\u9879\u540D\u79F0", "\u6536\u8D39\u9879\u7C7B\u578B" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

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
		panel1.setBorder(
				new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel1.setBounds(33, 29, 644, 123);
		contentPane.add(panel1);
		panel1.setLayout(null);

		JButton query = new JButton("\u67E5\u8BE2");
		query.setBounds(524, 47, 110, 30);
		panel1.add(query);
		query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String payno = txt.getText();
				fillTable(payno);
			}
		});
		query.setIcon(new ImageIcon(OwnerMngDlg.class.getResource("/images/search.png")));

		JLabel label_2_2 = new JLabel("\u6536\u8D39\u9879\u7F16\u53F7\uFF1A");
		label_2_2.setBounds(46, 42, 79, 15);
		panel1.add(label_2_2);

		JLabel label_2_1_1 = new JLabel("\u6536\u8D39\u9879\u7C7B\u578B\uFF1A");
		label_2_1_1.setBounds(46, 71, 79, 15);
		panel1.add(label_2_1_1);

		txt = new JTextField();
		txt.setBounds(135, 37, 132, 24);
		panel1.add(txt);

		textField_1 = new JTextField();
		textField_1.setBounds(135, 66, 132, 24);
		panel1.add(textField_1);

		JLabel label_2_2_1 = new JLabel("\u6536\u8D39\u9879\u540D\u79F0\uFF1A");
		label_2_2_1.setBounds(294, 37, 96, 15);
		panel1.add(label_2_2_1);

		textField_3 = new JTextField();
		textField_3.setBounds(364, 33, 132, 24);
		panel1.add(textField_3);

		JPanel panel3 = new JPanel();
		panel3.setBorder(
				new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel3.setBounds(31, 401, 646, 165);
		contentPane.add(panel3);
		panel3.setLayout(null);

		JLabel label_2 = new JLabel("\u6536\u8D39\u9879\u7F16\u53F7\uFF1A");
		label_2.setBounds(69, 41, 100, 15);
		panel3.add(label_2);

		txt1 = new JTextField();
		txt1.setBounds(137, 32, 132, 24);
		panel3.add(txt1);

		JLabel label_1_1 = new JLabel("\u6536\u8D39\u9879\u540D\u79F0\uFF1A");
		label_1_1.setBounds(333, 41, 87, 15);
		panel3.add(label_1_1);

		txt2 = new JTextField();
		txt2.setBounds(412, 36, 162, 24);
		panel3.add(txt2);

		JLabel label_2_1 = new JLabel("\u6536\u8D39\u9879\u7C7B\u578B\uFF1A");
		label_2_1.setBounds(69, 97, 100, 15);
		panel3.add(label_2_1);

		txt3 = new JTextField();
		txt3.setBounds(137, 88, 132, 24);
		panel3.add(txt3);
		this.fillTable(new PayService());
	}

	/**
	 * �޸��¼�
	 * 
	 * @param e
	 */
	protected void updateActionPerformed(ActionEvent evt) {
		String payno = this.txt1.getText();
		if (StringUtil.isEmpty(payno)) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵļ�¼");
			return;
		}
		String payname = this.txt2.getText();
		String paytype = this.txt3.getText();
		if (StringUtil.isEmpty(payname)) {
			JOptionPane.showMessageDialog(null, "�շ������Ʋ���Ϊ�գ�");
			return;
		}
		if (StringUtil.isEmpty(paytype)) {
			JOptionPane.showMessageDialog(null, "�շ������Ͳ���Ϊ�գ�");
			return;
		}
		PayService payService = new PayService(payno, payname, paytype);
		Connection con = null;
		try {
			con = DBConnection.getConn();
			int addNum = PayServiceDao.update(con, payService);
			if (addNum == 1) {
				JOptionPane.showMessageDialog(null, "�շ���Ŀ�޸ĳɹ���");
				resetValue();
				this.fillTable(new PayService());
			} else {
				JOptionPane.showMessageDialog(null, "�շ���Ŀ�޸�ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "�շ���Ŀ�޸�ʧ�ܣ���");
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
		String payno = txt1.getText();
		if (StringUtil.isEmpty(payno)) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ���ļ�¼");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ���ü�¼��");
		if (n == 0) {
			Connection con = null;
			try {
				con = DBConnection.getConn();
				int deleteNum = PayServiceDao.delete(con, payno);
				if (deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					this.resetValue();
					this.fillTable(new PayService());
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
		String payno = this.txt1.getText();
		String payname = this.txt2.getText();
		String paytype = this.txt3.getText();
		if (StringUtil.isEmpty(payno)) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵļ�¼");
			return;
		}
		if (StringUtil.isEmpty(payname)) {
			JOptionPane.showMessageDialog(null, "�շ������Ʋ���Ϊ�գ�");
			return;
		}
		if (StringUtil.isEmpty(paytype)) {
			JOptionPane.showMessageDialog(null, "�շ������Ͳ���Ϊ�գ�");
			return;
		}
		PayService payService = new PayService(payno, payname, paytype);
		Connection con = null;
		try {
			con = DBConnection.getConn();
			int addNum = PayServiceDao.insert(con, payService);
			if (addNum == 1) {
				JOptionPane.showMessageDialog(null, "�շ���Ŀ��ӳɹ���");
				resetValue();
				this.fillTable(new PayService());
			} else {
				JOptionPane.showMessageDialog(null, "�շ���Ŀ���ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "�շ���Ŀ���ʧ�ܣ���");
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
	}

	/**
	 * ��ѯ�¼�����
	 * 
	 * @param owner
	 */
	private void searchActionPerformed(ActionEvent e) {
		String payno = this.txt1.getText();
		String payname = this.txt2.getText();
		String paytype = this.txt3.getText();
		PayService payService = new PayService();
		payService.setPayno(payno);
		payService.setPayname(payname);
		payService.setPaytype(paytype);
		this.fillTable(payService);
		payService = new PayService(payno, payname, paytype);
		this.fillTable(payService);

	}

	/**
	 * �����
	 * 
	 * @param owner
	 */

	private void fillTable(PayService payService) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);// ��ձ��
		Connection con = null;
		try {
			con = DBConnection.getConn();
			ResultSet rs = PayServiceDao.getRS(con, payService);
			while (rs.next()) {
				Vector<String> v = new Vector<String>();
				v.add(rs.getString("payno"));
				v.add(rs.getString("payname"));
				v.add(rs.getString("paytype"));
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
		String payno = table.getValueAt(row, 0).toString();
		String payname = table.getValueAt(row, 1).toString();
		String paytype = table.getValueAt(row, 2).toString();
		txt1.setText(payno);
		txt2.setText(payname);
		txt3.setText(paytype);
	}

	/**
	 * ģ����ѯ
	 * 
	 * @param roomNo
	 */
	protected void fillTable(String payno) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);// ��ձ��
		Connection con = null;
		try {
			con = DBConnection.getConn();
			ResultSet rs = PayServiceDao.queryPayno(con, payno);

			ArrayList<Vector<String>> list = new ArrayList<>();

			while (rs.next()) {
				Vector<String> v = new Vector<String>();
				v.add(rs.getString("payno"));
				v.add(rs.getString("payname"));
				v.add(rs.getString("paytype"));
				list.add(v);
			}

			list.forEach(v -> {
				if (v.get(0).equals(payno)) {
					dtm.addRow(v);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

}
