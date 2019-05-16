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

public class CheckTestDatabase extends JPanel {


	/**
	 * Launch the application.
	 */
//	private static ConnDB jdbc;
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
			return true;
            
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
	
	public CheckTestDatabase(String sql) {
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
		scrollPane.setBounds(43, 60, 538, 313);
		add(scrollPane);
//		sql = "select * from 选择题 order by cast(id as int)";
		sql = "select id as 编号,question as 问题,choice as 选项,answer as 答案,knowledge as 知识点,subject as 学科 "
				+ "from 选择题 order by cast(id as int)";
		a1(model,sql);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		table.setRowHeight(30);
		
		JButton btnNewButton = new JButton("删除");
		btnNewButton.setBounds(85, 436, 93, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.setBounds(259, 436, 93, 23);
		add(btnNewButton_1);
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
		btnNewButton_3.setBounds(488, 22, 93, 23);
		add(btnNewButton_3);
		

		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()==-1)
				{
					JOptionPane.showMessageDialog(null, "请选择要删除的题目!");
				}
				else{
					Object wl;
					int row = 0;
					row = table.getSelectedRow();
					wl = table.getValueAt(row, 0);
//					System.out.println(wl);
//					wl=rowData[table.getSelectedRow()][0];
					if(wl==null)
					{
						JOptionPane.showMessageDialog(null, "您选择的是没有数剧的那一行·！");
					}
					else
					{
						int i = JOptionPane.showConfirmDialog(null, "确定要删除吗","标题",
								JOptionPane.OK_CANCEL_OPTION);
						if (i==0) {
							jdbc = new ConnDB();
							String sql2 = "delete from  "+comboBox.getSelectedItem()+"  where id='"+wl;
//							System.out.println(sql2);
							jdbc.getRows("delete from  "+comboBox.getSelectedItem()+"  where id='"+wl+"'");
							rows.removeAllElements();
							column.removeAllElements();
							table.clearSelection();
							JOptionPane.showMessageDialog(null, "删除成功", "成功", JOptionPane.YES_OPTION);
							a1(model,"select * from "+comboBox.getSelectedItem()+" order by cast(id as int) ");
							
						}

		
					}
				}
			}
		});
		
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
//				rows.removeAllElements();
//				column.removeAllElements();
//				table.clearSelection();
//				sql = "select id as 编号,question as 问题,choice as 选项,answer as 答案,knowledge as 知识点,subject as 学科 "
//						+ "from 选择题 order by cast(id as int)";
//				String sql2 = "select * from "+comboBox.getSelectedItem()+" order by cast(id as int)";
//				 if(e.getStateChange() == ItemEvent.SELECTED){
////					 JFrame f = new JFrame("Test Table Model");
//					 	jdbc = new ConnDB();
////					 	ShowOnTable(sql2);
//					 	a1(model,sql2);
////					 	Factory.getLoginDaoInstance().displayTable(model);
//				 	}
//				 
				 
					if(e.getStateChange() == ItemEvent.SELECTED){
						rows.removeAllElements();
						column.removeAllElements();
						table.clearSelection();
						if (comboBox.getSelectedItem().equals("选择题")) {
//							select id as 编号,question as 问题,answer as 答案,knowledge as 知识点,subject as 学科
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
		//优化任务
//		table.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				if (e.getClickCount() == 2
//						&& e.getButton() == MouseEvent.BUTTON1) {
//					int row = table.getSelectedRow();
//					String Question = model.getValueAt(row, 1).toString();
//					String Answer = model.getValueAt(row, 2).toString();
// 				    String Knowledge = model.getValueAt(row, 3).toString();
//					if (comboBox.getSelectedItem().toString().equals("判断题")) {
//						String Test = comboBox.getSelectedItem().toString();
//						String Subject = comboBox_1.getSelectedItem().toString();
//						TureOrFalseJDialog tof = new TureOrFalseJDialog(Question,Answer,Test,Subject
//								,CheckTestDatabase.this);
//						tof.setModal(true);
//						tof.setVisible(true);
//					}
//					if (comboBox.getSelectedItem().toString().equals("选择题")) {
//						String SelectAnswer = model.getValueAt(row, 4).toString();
////						MultipleChoiceJDialog mc = new MultipleChoiceJDialog(Question,Answer);
////						mc.setModal(true);
////						mc.setVisible(true);
//						
//					}
//					
//				}
//			}
//		});
		
		table.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				if(table.getSelectedRow()!=-1){
					Object wl;
					int row = 0;
					row = table.getSelectedRow();
					wl = table.getValueAt(row, 0);
//					wl=rowData[table.getSelectedRow()][0];
					if(wl==null)
					{
						JOptionPane.showMessageDialog(null, "您选择的是没有数剧的那一行·！");
					}
					else
					{	
						String tixing = (String) comboBox.getSelectedItem();
						String sql3 ;
						if(tixing.equals("选择题")){
							sql3 = "update "+comboBox.getSelectedItem()+" set question='" + table.getValueAt(row, 1) + "',choice='"
									+ table.getValueAt(row, 2) + "',answer='" 
									+ table.getValueAt(row, 3)  + "',knowledge='" 
									+ table.getValueAt(row, 4)  +"',subject='" 
									+ table.getValueAt(row, 5)  + "' where id='"
									+ wl + "'";
						}
						else {
							sql3 = "update "+comboBox.getSelectedItem()+" set question='" + table.getValueAt(row, 1) + "',answer='"
									+ table.getValueAt(row, 2) + "',knowledge='" 
									+ table.getValueAt(row, 3)  + "',subject='" 
									+ table.getValueAt(row, 4)  + "' where id='"
									+ wl + "'";
						}
						jdbc = new ConnDB();
						
//						System.out.println(sql3);
						jdbc.getRows(sql3);

						
					}
				}
			}
		});
		
		
		}
}
