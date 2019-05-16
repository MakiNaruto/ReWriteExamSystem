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


public class DeleteKnowledge extends JDialog {
	private ConnDB sql = new ConnDB();
	private String SqlStatements;
	ReadKnowledge rk  = new ReadKnowledge();
	/**
	 * Launch the application
	 * 
	 * @param args
	 */


	/**
	 * Create the dialog
	 */
	public DeleteKnowledge() {
		super();
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("输入要删除的知识点");
		label.setBounds(10, 42, 128, 22);
		getContentPane().add(label);
		
		
		JButton button_1 = new JButton("取消");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(249, 115, 96, 30);
		getContentPane().add(button_1);
		
		JComboBox comboBox = new JComboBox(rk.ReadAll("select * from 知识点 "));
		comboBox.setBounds(172, 34, 201, 30);
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
					SqlStatements = "DELETE FROM 知识点 WHERE 知识点 = '"+comboBox.getSelectedItem()+"'";
					sql.getRows(SqlStatements);
					JOptionPane.showMessageDialog(null, "删除成功", "成功", JOptionPane.ERROR_MESSAGE);
					DeleteKnowledge dk = new DeleteKnowledge();
					dk.setVisible(true);
					dispose();
				} 
			}
		});
		button.setBounds(44, 115, 96, 30);
		getContentPane().add(button);

	}



}
