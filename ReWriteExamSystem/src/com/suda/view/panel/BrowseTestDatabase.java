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

public class BrowseTestDatabase extends JPanel {


	/**
	 * Launch the application.
	 */

//	private static JDBC jdbc;
	private String sql;
	private ResultSet set;
	private JTable table;
	private String newvalue;
	private JScrollPane scrollPane;
	private JPanel panel;
	private String[] args;
	private ConnDB jdbc = new ConnDB();
	Font f = new Font("楷体",Font.TRUETYPE_FONT,40);
	Color col = Color.BLUE;
	

	DefaultTableModel model=new DefaultTableModel(){  
        @Override  
        public boolean isCellEditable(int row,int column){
        	if (column==0) {
        		return false;
			}
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
	
	public BrowseTestDatabase(String sql) {
		this.list = new ArrayList<>();
//		super();
		this.sql=sql;
		//窗体的出现位置和大小
		setBounds(400, 100, 635, 524);
		setLayout(null);
		//设置窗体标题

//		setTitle("试卷生成系统");
//
//		//设置关闭响应,后台退出
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		//不能调节窗口大小
//		setResizable(false);
//		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
//		panel = new JPanel();
//		getContentPane().add(panel);
//		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 60, 538, 454);
		add(scrollPane);
		sql = "select * from 选择题 order by cast(id as int)";
		a1(model,sql);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		table.setRowHeight(30);
		ReadKnowledge rk = new ReadKnowledge();
		JComboBox comboBox = new JComboBox(rk.ReadAll("select * from  所有题型"));
		comboBox.setBounds(43, 23, 223, 21);
		add(comboBox);
		

		JComboBox comboBox_1 = new JComboBox(rk.ReadAll("select * from  学科"));
		comboBox_1.setBounds(358, 23, 102, 21);
		add(comboBox_1);
		
		JButton btnNewButton_3 = new JButton("筛选");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rows.removeAllElements();
				column.removeAllElements();
				table.clearSelection();
				String sql2 = "select * from "+comboBox.getSelectedItem()+
						" where 学科='"+comboBox_1.getSelectedItem()+"' order by cast(id as int)";
				jdbc = new  ConnDB();
				a1(model,sql2);
			}
		});
		btnNewButton_3.setBounds(488, 22, 93, 23);
		add(btnNewButton_3);
		
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				rows.removeAllElements();
				column.removeAllElements();
				table.clearSelection();
				String sql2 = "select * from "+comboBox.getSelectedItem()+" order by cast(id as int)";
				 if(e.getStateChange() == ItemEvent.SELECTED){
//					 JFrame f = new JFrame("Test Table Model");
					 	jdbc = new ConnDB();
//					 	ShowOnTable(sql2);
					 	a1(model,sql2);
//					 	Factory.getLoginDaoInstance().displayTable(model);
				 	}
				 
				 
				}
			});
	
		
		}
}
