package com.community.view.login;

import java.awt.Component;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.community.dao.login.PropertyDao;
import com.community.db.DBConnection;
import com.community.model.login.property;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserQueries extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table_1;
	private JScrollPane Fangtable;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private UserQueries frame;
			public void run() {
				try {
					frame = new UserQueries();
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
	public UserQueries() {
		setTitle("\u7528\u6237\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		/**
		 * 锟斤拷询锟斤拷钮锟铰硷拷
		 */
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * 锟斤拷锟斤拷锟斤拷锟斤拷穹椒锟�
				 *
				 */
				filltable(new property());

			}
		});

		Fangtable = new JScrollPane();
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton button_1 = new JButton("\u6DFB\u52A0");
		
		JButton button_1_1 = new JButton("\u4FEE\u6539");
		
		JButton button_2 = new JButton("\u5220\u9664");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(181)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(114, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(button_2, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(22, Short.MAX_VALUE)
							.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(button_1_1, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)))
					.addGap(18)
					.addComponent(Fangtable, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
					.addGap(52))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(button))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(button_1)
							.addGap(69)
							.addComponent(button_1_1)
							.addGap(62)
							.addComponent(button_2))
						.addComponent(Fangtable, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE))
					.addGap(21))
		);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"\u623F", "\u5C42", "\u680B", "\u533A"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		Fangtable.setViewportView(table_1);
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {button_1, button_1_1, button_2});
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {button_1, button_1_1, button_2});
		contentPane.setLayout(gl_contentPane);
		
		
		
	}
	

	/**
	 * 锟斤拷始锟斤拷锟斤拷锟�
	 * 锟斤拷锟斤拷锟�
	 * 锟斤拷锟斤拷锟捷匡拷锟饺★拷锟斤拷锟�
	 *
	 */
	private void filltable(property pp) {
		DefaultTableModel dtm = (DefaultTableModel) table_1.getModel();
		dtm.setRowCount(0);
		Connection conn = null;
		try {
			conn = DBConnection.getConn();
			PropertyDao pd = new PropertyDao();
			ResultSet rt = pd.getFangWu(conn, pp);
			while(rt.next())
			{
				Vector v = new Vector();
				v.add(rt.getString("fang"));
				v.add(rt.getString("cheng"));
				v.add(rt.getString("dong"));
				v.add(rt.getString("qu"));
				dtm.addRow(v);
			}

		} catch (Exception e) {
		}




	}
}
