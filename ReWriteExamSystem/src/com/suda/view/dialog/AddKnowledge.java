package com.suda.view.dialog;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.suda.JDBC.ConnDB;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AddKnowledge extends JDialog {
	private JTextField textField;
	private ConnDB sql = new ConnDB();
	private String SqlStatements;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */


	/**
	 * Create the dialog
	 */
	public AddKnowledge() {
		super();
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("输入要添加的知识点");
		label.setBounds(10, 42, 128, 22);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(155, 39, 218, 30);
		getContentPane().add(textField);
		
		
		JButton button_1 = new JButton("取消");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(223, 115, 96, 30);
		getContentPane().add(button_1);
		this.setModal(true);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 399) / 2, (d.height - 232) / 2, 399, 232);

		JButton button = new JButton("添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().trim().length()<1) {
					JOptionPane.showMessageDialog(null, "请输入知识点", "错误", JOptionPane.ERROR_MESSAGE);
				}
				else{
					sql = new ConnDB();
					SqlStatements = "insert into 知识点(知识点) values('"
							+ textField.getText() + "' )";
					sql.getRows(SqlStatements);
					textField.setText(null);
					JOptionPane.showMessageDialog(null, "添加成功", "成功", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		button.setBounds(55, 115, 96, 30);
		getContentPane().add(button);

	}



}
