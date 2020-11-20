package com.community.view.login;

import com.community.dao.login.UserInfoDao;
import com.community.model.login.Userinfo;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserInfo extends JFrame {

	private JPanel contentPane;
	private JTextField cn;
	private JTextField ca;
	private JTextField cz;
	private JTextField ct;
	private JTextField box;
	private JTextField idc;
	private JTextField name;
	private JTable table;

	/**
	 * �޸��û���Ϣ
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInfo frame = new UserInfo();
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
	public UserInfo() {
		setTitle("\u4E2A\u4EBA\u4FE1\u606F\u4FEE\u6539");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u516C\u53F8\u540D:");
		label.setBounds(38, 50, 72, 18);
		contentPane.add(label);
		
		/**
		 * �жϳ���
		 * int i = cn.getText().length();
				if(i>16 || i< 4)
					JOptionPane.showMessageDialog(null, "���Ȳ��淶");
		 */
		
		cn = new JTextField();
		cn.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				String name = cn.getText();
				int j = cn.getText().length();
				
				for(int i = 0;i<j;i++) {
					if(name.charAt(0)>'0' && name.charAt(0)<'9') {
						JOptionPane.showMessageDialog(null, "���ֿ�ͷ��֧�֣����������룡");
						cn.setText("");
						break;
					}else if(j>16 || j< 4) {
						JOptionPane.showMessageDialog(null, "�û���ֻ����4��16�ַ�֮�䣡");
						break;
					}
//					if(name.charAt(i)<'0' && name.charAt(i)>'9'||name.charAt(i)<'a' && name.charAt(i)>'z'||name.charAt(i)<'A' && name.charAt(i)>'Z') 
//					{
//						System.out.println(i+"��������");
////						JOptionPane.showMessageDialog(null, "�в�֧�ֵķ��ţ����������룡");
////						break;
//					}else {
//						JOptionPane.showMessageDialog(null, "�в�֧�ֵķ��ţ����������룡");
//						break;
//					}
				}
				
					
			}
		});
		cn.setBounds(112, 47, 139, 24);
		contentPane.add(cn);
		cn.setColumns(10);
		
		ca = new JTextField();
		ca.setColumns(10);
		ca.setBounds(112, 100, 204, 24);
		contentPane.add(ca);
		
		JLabel label_1 = new JLabel("\u516C\u53F8\u5730\u5740:");
		label_1.setBounds(38, 103, 72, 18);
		contentPane.add(label_1);
		
		cz = new JTextField();
		cz.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				int a = cz.getText().length();
				for(int i=0;i<a;i++) {
				if(a!=6)
				JOptionPane.showMessageDialog(null, "�ʱ��������������6λ�ʱ࣡");
				break;
				}
			}
		});
		cz.setColumns(10);
		cz.setBounds(112, 212, 78, 24);
		contentPane.add(cz);
		
		JLabel label_1_1 = new JLabel("\u516C\u53F8\u90AE\u7F16:");
		label_1_1.setBounds(38, 215, 72, 18);
		contentPane.add(label_1_1);
		
		JLabel label_2 = new JLabel("\u516C\u53F8\u7535\u8BDD:");
		label_2.setBounds(38, 162, 72, 18);
		contentPane.add(label_2);
		
		ct = new JTextField();
		ct.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				int c = ct.getText().length();
				for(int i=0;i<c;i++) {
				if(c>11) {
					JOptionPane.showMessageDialog(null, "�绰�����ʽ������������11λ���룡");
				}
				break;
				}
			}
		});
		ct.setColumns(10);
		ct.setBounds(112, 159, 139, 24);
		contentPane.add(ct);
		
		/**
		 * ������֤
		 * ��꽹���˳�
		 */
		box = new JTextField();
		box.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				boolean re = false;
				String b = box.getText();
				int j = box.getText().length();
				for(int i=0;i<j;i++) {
					if('@'==b.charAt(i)) {
						re = true;
						break;
					}
				}
				if(re==false)
					JOptionPane.showMessageDialog(null, "�����������������룡");
			}
		});
		box.setColumns(10);
		box.setBounds(437, 212, 241, 24);
		contentPane.add(box);
		
		JLabel label_1_1_1 = new JLabel("\u90AE\u7BB1\u5730\u5740:");
		label_1_1_1.setBounds(363, 215, 72, 18);
		contentPane.add(label_1_1_1);
		
		JLabel label_2_1 = new JLabel("\u6027\u522B:");
		label_2_1.setBounds(363, 162, 72, 18);
		contentPane.add(label_2_1);
		
		idc = new JTextField();
		idc.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				int a = idc.getText().length();
				for(int i=0;i<a;i++) {
				if(a!=18)
					JOptionPane.showMessageDialog(null, "���֤�������������룡");
					break;
				}
			}
		});
		idc.setColumns(10);
		idc.setBounds(437, 100, 241, 24);
		contentPane.add(idc);
		
		JLabel label_1_2 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7:");
		label_1_2.setBounds(363, 103, 72, 18);
		contentPane.add(label_1_2);
		
		JLabel label_3 = new JLabel("\u59D3\u540D:");
		label_3.setBounds(363, 50, 72, 18);
		contentPane.add(label_3);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(437, 47, 139, 24);
		contentPane.add(name);
		
		JComboBox sex = new JComboBox();
		sex.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		sex.setBounds(437, 159, 66, 24);
		contentPane.add(sex);
		
		JButton button = new JButton("\u4FDD\u5B58");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * �������ݵ����ݿ�
				 * ��֤�Ƿ�����ֵ
				 */
				Userinfo u = new Userinfo();
				
				
				u.setCompanyName(cn.getText());
				u.setCompanyAddress(ca.getText());
				u.setCompanyZip(cz.getText()); 
				u.setIdCade(idc.getText());
				u.setName(name.getText());
				u.setPostbox(box.getText());
				u.setSex((String)sex.getSelectedItem());
				
				//todo
				if(cn.getText() != null || cz.getText() != null ||ca.getText() != null ||idc.getText() != null ||box.getText() != null)
					JOptionPane.showMessageDialog(null, "��δ����");
				
				UserInfoDao ud = new UserInfoDao();
				int seruli = ud.getinsert(u);
				if(seruli > 1)
					System.out.println("���ʧ��");
				else 
					System.out.println("��ӳɹ�");
			}

		});
		button.setBounds(180, 317, 113, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.setBounds(437, 317, 113, 27);
		contentPane.add(button_1);
		
		table = new JTable();
		table.setBounds(64, 284, 1, 1);
		contentPane.add(table);
		
		this.setLocationRelativeTo(null);
		
		
	}
}
