package com.suda.view.panel;

import java.awt.Panel;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class forcopy extends Panel {
	private DefaultTableModel tableModel = null;
	private JTable table = null;
	private JScrollPane scrollPane = null;
	private Vector rowData = null;
	private Vector columnNames = null;
	private Vector data = null;
	private JButton button = null;
	private JPanel panel = new JPanel();
	private JPanel panel2 = new JPanel();
	JFrame frame = null;
	Container contentPane = null;
	private JScrollPane scrollPane_1;
	
	public forcopy(){
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		//设置表头字段名称
				columnNames = new Vector();
				for(int i=0;i<4;i++){
					columnNames.add("第" +(i+1) + "列");
				}
				
				rowData = new Vector();
				data = new Vector();
				
				//开始表中的数据是1,2,3,4
				rowData.add("1");
				rowData.add("2");
				rowData.add("3");
				rowData.add("4");
				data.add(rowData);
				
				//使用DefaultTableModel构建表格
				tableModel = new DefaultTableModel(data,columnNames);
				table = new JTable(tableModel);
				scrollPane_1 = new JScrollPane(table);
				scrollPane_1.setBounds(0, 43, 450, 257);
				panel2.setLayout(null);
				frame = new JFrame("JTableUpdate");
				panel = new JPanel();
				panel.setBounds(179, 5, 91, 33);
		 
				
				button = new JButton("更新数据");
				panel.add(button);
				
				//把带按钮的panel和带表格的scrollPane加到panel2中
				panel2.add(panel);
				panel2.add(scrollPane_1);
				
				
				contentPane = frame.getContentPane();
				//添加有更新按钮和表格进入contentPane
				contentPane.add(panel2);
				frame.pack();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
