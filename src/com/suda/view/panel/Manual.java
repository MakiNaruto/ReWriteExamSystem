package com.suda.view.panel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.suda.JDBC.ConnDB;
import com.suda.UserInterface.frame.ReadKnowledge;
import com.suda.view.dialog.MultipleChoiceJDialog;
import com.suda.view.dialog.TureOrFalseJDialog;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Manual extends JPanel {


	/**
	 * Launch the application.
	 */
//	private static JDBC jdbc;
	private String sql;
	private ResultSet set;
	private JTable table;
	private JTable table2;
	private JTable table3;
	private String newvalue;
	private JScrollPane scrollPane;
	private JPanel panel;
	private String[] args;
	private ConnDB jdbc = new ConnDB();
	Font f = new Font("楷体",Font.TRUETYPE_FONT,40);
	Color col = Color.BLUE;
	JFileChooser jfc = new JFileChooser();// 文件选择器 
	DefaultTableModel model=new DefaultTableModel(){  
        @Override  
        public boolean isCellEditable(int row,int column){
        	if (column==0) {
        		return false;
			}
			return false;
        }  
    };
    
    DefaultTableModel model1 = new DefaultTableModel(){  
        @Override  
        public boolean isCellEditable(int row,int column){
        
			return false;
        }  
    };
	/*
	 * 		
			  */
	/**
	 * Create the frame.
	 */
	public List <String> list;
	List temp = new ArrayList();

	
	public void a1(DefaultTableModel dtm,String sql){

		ResultSet rst = jdbc.getResult(sql);
		try {
			ResultSetMetaData rsmd = rst.getMetaData();
			int rsmdi = rsmd.getColumnCount();
			for (int i = 1; i <= rsmdi; i++) {
				column.addElement(rsmd.getColumnLabel(i));
			}
			while (rst.next()) {
				Vector<Object> temp = new Vector<Object>();
				for (int j = 1; j <= rsmdi; j++) {
					temp.addElement(rst.getObject(j));
				}
				rows.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			jdbc.closeAll();
		}
		dtm.setDataVector(rows, column);
	}

	Vector<Object> rows = new Vector<Object>();
	Vector<Object> column = new Vector<Object>();
	private JTextField textField;
	private JTextField textField_1;
	private String catalog;
	private StringBuffer stringBuffer1 = new StringBuffer();
	private File file1 = new File("");
	private FileWriter fileWriter1 ;
	public Manual(String sql) {
		this.list = new ArrayList<>();
//		super();
		this.sql=sql;
		//窗体的出现位置和大小
		setBounds(400, 100, 859, 524);
		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 54, 348, 410);
		add(scrollPane);
		sql = "select id as 编号,question as 问题,choice as 选项,answer as 答案,knowledge as 知识点,subject as 学科 "
				+ "from 选择题 order by cast(id as int)";
		a1(model,sql);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		table.setRowHeight(30);
		

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(490, 25, 348, 200);
		add(scrollPane_1);
		
		Vector columnNames =  new Vector();
		columnNames.add("问题");
		columnNames.add("选项");
		columnNames.add("答案");

		Vector rowData = new Vector();
		Vector data = new Vector();

		//使用DefaultTableModel构建表格
		DefaultTableModel tableModel = new DefaultTableModel(data,columnNames);
		table2 = new JTable(tableModel);
		scrollPane_1.setViewportView(table2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(490, 266, 348, 198);
		add(scrollPane_2);
		
		Vector columnNames1 =  new Vector();
		columnNames1.add("问题");
		columnNames1.add("答案");

		Vector rowData1 = new Vector();
		Vector data1 = new Vector();

		//使用DefaultTableModel构建表格
		DefaultTableModel tableModel1 = new DefaultTableModel(data1,columnNames1);
		table3 = new JTable(tableModel1);
		scrollPane_2.setViewportView(table3);
		
		ReadKnowledge rk = new ReadKnowledge();
		JComboBox comboBox = new JComboBox(rk.ReadAll("select * from  所有题型"));
		comboBox.setBounds(20, 23, 102, 21);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(rk.ReadAll("select * from  学科"));
		comboBox_1.setBounds(149, 23, 102, 21);
		add(comboBox_1);
		
		JButton btnNewButton_3 = new JButton("筛选");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rows.removeAllElements();
				column.removeAllElements();
				table.clearSelection();
				if (comboBox.getSelectedItem().equals("选择题")) {
//					select id as 编号,question as 问题,answer as 答案,knowledge as 知识点,subject as 学科
					String sql2 = "select id as 编号,question as 问题,choice as 选项,answer as 答案,knowledge as 知识点,subject as 学科 from "+comboBox.getSelectedItem()+
							" where subject='"+comboBox_1.getSelectedItem()+"' order by cast(id as int)";
					jdbc = new ConnDB();
				 	a1(model,sql2);
				}else {
					String sql2 = "select id as 编号,question as 问题,answer as 答案,knowledge as 知识点,subject as 学科 from "+comboBox.getSelectedItem()+
							" where subject='"+comboBox_1.getSelectedItem()+"' order by cast(id as int)";
					jdbc = new ConnDB();
				 	a1(model,sql2);
				}
			}
		});
		btnNewButton_3.setBounds(275, 22, 93, 23);
		add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("←");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table2.getSelectedRow()!=-1){	
					if(table2.getSelectedRow()==-1)
					{
						JOptionPane.showMessageDialog(null, "请选择要添加的题目!");
					}
					else{
						Object wl1;
						int row = 0;
						row = table2.getSelectedRow();
						wl1 = table2.getValueAt(row, 1);
						if(wl1==null)
						{
							JOptionPane.showMessageDialog(null, "您选择的是没有数剧的那一行·！");
						}
						else
						{
							tableModel.removeRow(row);
						}
					}
				}else{
					if(table3.getSelectedRow()==-1)
					{
						JOptionPane.showMessageDialog(null, "请选择要添加的题目!");
					}
					else{
						Object wl1;
						int row = 0;
						row = table3.getSelectedRow();
						wl1 = table3.getValueAt(row, 1);
						if(wl1==null)
						{
							JOptionPane.showMessageDialog(null, "您选择的是没有数剧的那一行·！");
						}
						else
						{
							tableModel1.removeRow(row);
						}
					}
				}
			}
		});
		btnNewButton.setBounds(396, 263, 73, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("→");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("选择题")){
					if(table.getSelectedRow()==-1)
					{
						JOptionPane.showMessageDialog(null, "请选择要添加的题目!");
					}
					else{
						Object wl1,wl2,wl3;
						int row = 0;
						row = table.getSelectedRow();
						Vector rowData = new Vector(); 
						wl1 = table.getValueAt(row, 1);
						wl2 = table.getValueAt(row, 2);
						wl3 = table.getValueAt(row, 3);
	//					System.out.println(wl);
	//					wl=rowData[table.getSelectedRow()][0];
						if(wl1==null)
						{
							JOptionPane.showMessageDialog(null, "您选择的是没有数剧的那一行·！");
						}
						else
						{
							rowData.clear();
							rowData.add(wl1);
							rowData.add(wl2);
							rowData.add(wl3);
							data.add(rowData);
							tableModel.setDataVector(data, columnNames);
							table2.setModel(tableModel);	 
						}
					}
				}else{
					if(table.getSelectedRow()==-1)
					{
						JOptionPane.showMessageDialog(null, "请选择要添加的题目!");
					}
					else{
						Object wl1,wl2;
						int row = 0;
						row = table.getSelectedRow();
						Vector rowData1 = new Vector(); 
						wl1 = table.getValueAt(row, 1);
						wl2 = table.getValueAt(row, 2);
	//					System.out.println(wl);
	//					wl=rowData[table.getSelectedRow()][0];
						if(wl1==null)
						{
							JOptionPane.showMessageDialog(null, "您选择的是没有数剧的那一行·！");
						}
						else
						{
							rowData1.clear();
							rowData1.add(wl1);
							rowData1.add(wl2);
							data1.add(rowData1);
							tableModel1.setDataVector(data1, columnNames1);
							table3.setModel(tableModel1);	 
						}
					}
					
				}
				
			}
		});
		btnNewButton_1.setBounds(396, 140, 73, 23);
		add(btnNewButton_1);	
		
		JButton btnNewButton_2 = new JButton("生成试卷");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				catalog = textField.getText();
				stringBuffer1 = new StringBuffer();
			    file1 = new File(catalog +"\\"+textField_1.getText()+".doc");
			    if (!file1.exists()) {
					try {
						file1.createNewFile();
					} catch (IOException e1) {

						e1.printStackTrace();
					}
				}

				fileWriter1 = null;
				try {
					fileWriter1 = new FileWriter(file1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				stringBuffer1.append("<html><head></head><body bgcolor='#ffffff'><center><H2>苏州大学应用技术学院</h2>"
						+ "</center><br><center>班级________  姓名________  学号_______ </center></html>");
//				stringBuffer1.append("<html><H3>题型</h3></html>");
				stringBuffer1.append("<table border=1><tr>");
				stringBuffer1.append("<h2>选择题(共"+tableModel.getRowCount()+"题，每题5分，共10分)</h2>");
				String value1,value2,value3;
				if (tableModel.getRowCount()>=0) {
					for (int i = 0; i < tableModel.getRowCount(); i++) {
						int j = i + 1;
						value1 = table2.getValueAt(i, 0).toString();
						value2 = table2.getValueAt(i, 1).toString();
						value3 = table2.getValueAt(i, 2).toString();
						stringBuffer1.append("</h3><br><Left>"+j+".</Left>"+value1+""
								+ "<br>"+value2+"");
					}
				}
				
				stringBuffer1.append("<h2>其他题(共"+tableModel1.getRowCount()+"题，每题5分，共10分)</h2>");
				if (tableModel1.getRowCount()>=0) {
					for (int i = 0; i < tableModel1.getRowCount(); i++) {
						int j = i + 1;
						value1 = table3.getValueAt(i, 0).toString();
						value2 = table3.getValueAt(i, 1).toString();
						stringBuffer1.append("</h3><br><Left>"+j+".</Left>"+value1+"  ");
					}
				}
				stringBuffer1.append("</table></center></body></html>");
				try {
					fileWriter1.write(stringBuffer1.toString());
					fileWriter1.close();
					JOptionPane.showMessageDialog(null,"生成已成功！");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_2.setBounds(747, 474, 91, 30);
		add(btnNewButton_2);
		
		JLabel label = new JLabel("生成目录");
		label.setBounds(306, 480, 54, 19);
		add(label);
		
		textField = new JTextField();
		textField.setText("D:\\");
		textField.setColumns(10);
		textField.setBounds(376, 475, 80, 30);
		add(textField);
		
		JButton button = new JButton("浏览 ...");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jfc.setFileSelectionMode(1);// 设定只能选择到文件夹  
	            int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句  
	            if (state == 1) {  
	                return;  
	            } else {  
	                File f = jfc.getSelectedFile();// f为选择到的目录  
	                textField.setText(f.getAbsolutePath());  
	                
	            }
			}
		});
		button.setBounds(482, 474, 82, 30);
		add(button);
		
		JLabel label_1 = new JLabel("文件名");
		label_1.setBounds(574, 482, 48, 15);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setText("test");
		textField_1.setColumns(10);
		textField_1.setBounds(632, 474, 100, 30);
		add(textField_1);
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					rows.removeAllElements();
					column.removeAllElements();
					table.clearSelection();
					if (comboBox.getSelectedItem().equals("选择题")) {
//						select id as 编号,question as 问题,answer as 答案,knowledge as 知识点,subject as 学科
						String sql2 = "select id as 编号,question as 问题,choice as 选项,answer as 答案,knowledge as 知识点,subject as 学科"
								+ " from "+comboBox.getSelectedItem()+" order by cast(id as int)";
						jdbc = new ConnDB();
					 	a1(model,sql2);
					}else {
						String sql2 = "select id as 编号,question as 问题,answer as 答案,knowledge as 知识点,subject as 学科"
								+ " from "+comboBox.getSelectedItem()+" order by cast(id as int)";
						jdbc = new ConnDB();
					 	a1(model,sql2);
					}

				
				 	}
	 
				}
			});
	
		
		}
}
