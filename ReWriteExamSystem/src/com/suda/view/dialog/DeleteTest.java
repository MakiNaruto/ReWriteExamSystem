package com.suda.view.dialog;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.suda.JDBC.ConnDB;
import com.suda.UserInterface.frame.ReadKnowledge;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DeleteTest extends JDialog {
	private ConnDB sql = new ConnDB();
	private String SqlStatements;
	private ReadKnowledge rk  = new ReadKnowledge();
	/**
	 * Launch the application
	 * 
	 * @param args
	 */


	/**
	 * Create the dialog
	 */
	public DeleteTest() {
		super();
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("输入要删除的题型");
		label.setBounds(10, 42, 128, 22);
		getContentPane().add(label);
		
		JButton button_1 = new JButton("取消");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(261, 115, 96, 30);
		getContentPane().add(button_1);
		
		JComboBox comboBox = new JComboBox(rk.ReadAll("select * from  题型"));
		comboBox.setBounds(171, 43, 202, 30);
		getContentPane().add(comboBox);
		this.setModal(true);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 399) / 2, (d.height - 232) / 2, 399, 232);
		JButton button = new JButton("删除");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "确定要删除吗","标题",
						JOptionPane.OK_CANCEL_OPTION);
				if (i==0) {
					sql = new ConnDB();
					SqlStatements = "DROP TABLE  "+ comboBox.getSelectedItem() + " "
							+ "delete from 题型    where 题型='"+comboBox.getSelectedItem()+"'"
							+ "delete from 题型1 where 题型='"+comboBox.getSelectedItem()+"'"
							+ "delete from 所有题型  where 题型='"+comboBox.getSelectedItem()+"'";
					sql.getRows(SqlStatements);
					JOptionPane.showMessageDialog(null, "删除题型成功", "成功", JOptionPane.ERROR_MESSAGE);
					DeleteTest dt = new DeleteTest();
					dt.setVisible(true);
					dispose();
				} 
			}
		});
		button.setBounds(42, 115, 96, 30);
		getContentPane().add(button);
		
	

	}



}
