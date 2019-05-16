package com.suda.view.dialog;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.suda.JDBC.ConnDB;
import com.suda.excel.DbToExcel;
import com.suda.excel.ExcelToDb;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class InAndOut extends JDialog {
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
	public InAndOut() {
		super();
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 86, 128, 22);
		getContentPane().add(label);
		
		JButton btnNewButton = new JButton("Excel导入到数据库");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcelToDb etd = new ExcelToDb();
				etd.setVisible(true);
				dispose();
				
			}
		});
		
		btnNewButton.setBounds(148, 49, 197, 46);
		getContentPane().add(btnNewButton);
		JButton btnNewButton_1 = new JButton("数据库导出到Excel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DbToExcel dte = new DbToExcel();
				dte.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(148, 178, 197, 46);
		getContentPane().add(btnNewButton_1);
		this.setModal(true);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 399) / 2, (d.height - 232) / 2, 503, 327);

	}
}
