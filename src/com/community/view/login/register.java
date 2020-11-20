package com.community.view.login;

import com.community.dao.login.RegisterDao;
import com.community.model.login.User;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class register extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField userPwd1;
	private JPasswordField userPwd2;

	/**
	 * �û�ע��
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
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
	public register() {
		setTitle("\u6CE8\u518C\u65B0\u7528\u6237");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //�ӽ���һ�㲻���ùر�
		setBounds(100, 100, 569, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u65B0\u7528\u6237\u6CE8\u518C");
		label.setFont(new Font("����", Font.BOLD, 22));
		label.setBounds(208, 25, 149, 55);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8BBE\u7F6E\u8D26\u53F7\uFF1A");
		label_1.setBounds(55, 112, 98, 18);
		contentPane.add(label_1);
		
		JLabel label_1_1 = new JLabel("\u8F93\u5165\u5BC6\u7801\uFF1A");
		label_1_1.setBounds(55, 162, 98, 18);
		contentPane.add(label_1_1);
		
		JLabel label_1_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_1_2.setBounds(55, 212, 98, 18);
		contentPane.add(label_1_2);
		
		/**
		 * ע���¼�����
		 * 
		 */
		JButton ok = new JButton("\u6CE8\u518C");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Sql1 = "select * from userlogin where userName ="+"'"+userName.getText()+"'";
				RegisterDao rd = new RegisterDao();
				User a = rd.query(null, Sql1);
				
				//�ǿ���ʾ
				if(userName.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"�˻�����Ϊ�գ�");
				}else if(a != null) {
					JOptionPane.showMessageDialog(null, "�˻��ѱ�ע��");
				}else if(userPwd2.getText().equals(userPwd1.getText())) {
						String Sql2 = "insert INTO userlogin VALUES (null,'"+userName.getText()+"','"+userPwd1.getText()+"')";
						rd.insert(null, Sql2);
						JOptionPane.showMessageDialog(null, "�˻�ע��ɹ���");
						
				}else {
					System.out.println(userPwd1.getText()+"\t"+userPwd2.getText());
					JOptionPane.showMessageDialog(null,"���벻һ�£�");
				}
					
				

				
			}
		});
		ok.setBounds(229, 283, 113, 27);
		contentPane.add(ok);
		
		JButton reset = new JButton("\u91CD\u7F6E");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userName.setText("");
				userPwd1.setText("");
				userPwd2.setText("");
			}
		});
		reset.setBounds(68, 283, 113, 27);
		contentPane.add(reset);
		
		userName = new JTextField();
		userName.setBounds(167, 109, 228, 24);
		contentPane.add(userName);
		userName.setColumns(10);
		
		userPwd1 = new JPasswordField();
		userPwd1.setBounds(167, 159, 228, 24);
		contentPane.add(userPwd1);
		
		userPwd2 = new JPasswordField();
		userPwd2.setBounds(167, 209, 228, 24);
		contentPane.add(userPwd2);
		
		JButton btFan = new JButton("\u8FD4\u56DE\u767B\u5F55");
		btFan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login().setVisible(true);
				
			}
		});
		btFan.setBounds(389, 283, 113, 27);
		contentPane.add(btFan);
		
		this.setLocationRelativeTo(null);
	}
}
