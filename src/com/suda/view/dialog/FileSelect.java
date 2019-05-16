package com.suda.view.dialog;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FileSelect extends JDialog {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	JFileChooser jfc = new JFileChooser();// 文件选择器 
	private JTextField textField_1;
	

	/**
	 * Create the frame.
	 */
	public FileSelect() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 399) / 2, (d.height - 232) / 2, 450, 300);
		
		textField_1 = new JTextField();
		textField_1.setBounds(111, 79, 145, 26);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("目录");
		lblNewLabel.setBounds(26, 82, 54, 20);
		getContentPane().add(lblNewLabel);
		jfc.setCurrentDirectory(new File("d://"));// 文件选择器的初始目录定为d盘  
		JButton btnNewButton_1 = new JButton("浏览 ...");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jfc.setFileSelectionMode(1);// 设定只能选择到文件夹  
	            int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句  
	            if (state == 1) {  
	                return;  
	            } else {  
	                File f = jfc.getSelectedFile();// f为选择到的目录  
	                textField_1.setText(f.getAbsolutePath());  
	            }
			}
		});
		btnNewButton_1.setBounds(292, 78, 98, 27);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(151, 179, 93, 23);
		getContentPane().add(btnNewButton_2);

	

	}
}
