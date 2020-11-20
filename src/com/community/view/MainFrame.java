package com.community.view;
//Ö÷½çÃæ
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\\u52FF\u52A8\\\u4F5C\u4E1A\\\u5C0F\u7EC4\\\u56FE\u6807.png"));
		setTitle("\u5C0F\u533A\u7269\u4E1A\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 460);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u57FA\u672C\u4FE1\u606F\u7EF4\u62A4");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u697C\u76D8\u4FE1\u606F\u7EF4\u62A4");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PropertyMngDlg pmdlg = new PropertyMngDlg();
				pmdlg.setVisible(true);
				
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u4E1A\u4E3B\u4FE1\u606F\u7EF4\u62A4");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OwnerMngDlg omdlg = new OwnerMngDlg();
				omdlg.setVisible(true);
			}
		});
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u8F66\u4F4D\u4FE1\u606F\u7EF4\u62A4");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParkingLotMngDlg pldlg = new ParkingLotMngDlg();
				pldlg.setVisible(true);
			}
		});
		menu.add(menuItem_2);
		
		JMenu menu_1 = new JMenu("\u8D22\u52A1\u7BA1\u7406");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("\u6536\u8D39\u9879\u76EE\u7EF4\u62A4");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PayserviceMngDlg psdlg = new PayserviceMngDlg();
				psdlg.setVisible(true);
			}
		});
		menu_1.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u6536\u8D39\u5355\u7EF4\u62A4");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PayNoteMngDlg pndlg = new PayNoteMngDlg();
				pndlg.setVisible(true);
			}
		});
		menu_1.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("\u6B20\u8D39\u63D0\u9192");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrearsMngDlg pndlg = new ArrearsMngDlg();
				pndlg.setVisible(true);
			}
		});
		menu_1.add(menuItem_5);
		
		JMenu menu_2 = new JMenu("\u5BA2\u670D\u7BA1\u7406");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_6 = new JMenuItem("\u7EF4\u4FEE\u7533\u8BF7\u7BA1\u7406");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicationMngDlg amdlg = new ApplicationMngDlg();
				amdlg.setVisible(true);
				
			}
		});
		menu_2.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("\u4F4F\u6237\u6295\u8BC9\u7BA1\u7406");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComplaintMngDlg cmdlg = new ComplaintMngDlg();
				cmdlg.setVisible(true);
			}
		});
		menu_2.add(menuItem_7);
		
		JMenu menu_3 = new JMenu("\u4EBA\u5458\u4FE1\u606F\u7EF4\u62A4");
		menuBar.add(menu_3);
		
		JMenuItem menuItem_8 = new JMenuItem("\u804C\u4F4D\u7BA1\u7406");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PositionMngDlg pmdlg = new PositionMngDlg();
				pmdlg.setVisible(true);
			}
		});
		menu_3.add(menuItem_8);
		
		JMenuItem menuItem_9 = new JMenuItem("\u4EBA\u5458\u7BA1\u7406");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonMngDlg psmdlg = new PersonMngDlg();
				psmdlg.setVisible(true);
			}
		});
		menu_3.add(menuItem_9);
		
		JMenu menu_4 = new JMenu("\u767B\u5F55");
		menuBar.add(menu_4);

		JMenu menu_5 = new JMenu("\u7BA1\u7406\u5458\u8D26\u53F7\u767B\u5F55");
		menuBar.add(menu_5);

		JMenu menu_6 = new JMenu("\u914D\u7F6E\u67E5\u8BE2");
		menuBar.add(menu_6);
		
		JMenuItem menuItem_10 = new JMenuItem("\u67E5\u8BE2\u4FEE\u6539\u914D\u7F6E");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfigureMngDlg cfmdlg = new ConfigureMngDlg();
				cfmdlg.setVisible(true);
				// TabLayout
			}
		});
		menu_6.add(menuItem_10);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
