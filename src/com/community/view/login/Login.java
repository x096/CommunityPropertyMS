package com.community.view.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.community.dao.login.UserDao;
import com.community.model.login.User;
import com.community.view.MainFrame;
import com.community.view.login.*;

public class Login extends JFrame {

    private JPanel contentPane;
    private JTextField userName;
    private JPasswordField userPwd;

    /**
     * �û���¼
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Login frame = new Login();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Login() {
        setTitle("\u7528\u6237\u767B\u5F55\u754C\u9762");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 570, 388);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel("\u7269\u4E1A\u7BA1\u7406\u7CFB\u7EDF");
        label.setFont(new Font("����", Font.BOLD, 26));
        label.setBounds(193, 36, 233, 42);
        contentPane.add(label);

        JLabel label_1 = new JLabel("\u8D26\u6237\uFF1A");
        label_1.setBounds(137, 123, 72, 18);
        contentPane.add(label_1);

        userName = new JTextField();
        userName.setBounds(225, 117, 169, 24);
        contentPane.add(userName);
        userName.setColumns(10);

        JLabel label_2 = new JLabel("\u5BC6\u7801\uFF1A");
        label_2.setBounds(137, 194, 72, 18);
        contentPane.add(label_2);

        userPwd = new JPasswordField();
        userPwd.setBounds(225, 188, 169, 24);
        contentPane.add(userPwd);

        /**
         * ��¼�¼�����
         * �������������´���
         */
        JButton ok = new JButton("\u767B\u5F55");
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TODOʵ�ֵ�¼��ť�Ĺ���
                String name = userName.getText();
                String pwd = new String(userPwd.getText());

                User user = new User(name, pwd);    //���θ����췽�� ʵ�ָ�ֵ
                UserDao userDao = null;
                User currentUser = userDao.login(user);    //���ս��
                if (currentUser != null) {
                    JOptionPane.showMessageDialog(null, "��¼�ɹ�");
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                    dispose();
                } else if (userName.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "�˻�����Ϊ�գ�");
                } else {
                    JOptionPane.showMessageDialog(null, "�û������������");
                }

            }
        });
        ok.setBounds(245, 261, 113, 27);
        contentPane.add(ok);

        //����
        JButton reset = new JButton("\u91CD\u7F6E");
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userName.setText("");
                userPwd.setText("");
            }
        });
        reset.setBounds(412, 261, 113, 27);
        contentPane.add(reset);
        /**
         * ��ת����
         * dispose()�ͷŴ���
         * new register().setVisible(true); ʵ������������ʾ
         */
        JButton register = new JButton("\u6CE8\u518C\u65B0\u7528\u6237");
        register.addActionListener(e -> {
			dispose();
			new register().setVisible(true);
		});
        register.setBounds(58, 261, 134, 27);
        contentPane.add(register);
        this.setLocationRelativeTo(null);
    }
}
