package com.suda.view.panel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.html.HTMLEditorKit.Parser;

import com.suda.JDBC.ConnDB;
import com.suda.UserInterface.frame.ReadKnowledge;
import com.suda.view.dialog.FileSelect;


public class MakeTestPaperKnowLedge extends JPanel {


	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	 private  int Pointer = 0 ;
	 Font f = new Font("楷体",Font.TRUETYPE_FONT,40);
	 Color col = Color.BLUE;
	 private int i = 1;
	 private int thevaluereturn;
	 private int count;
	 private String countnumber;
	 private String countnumber2;
	 private String countnumber3;
	 private String countnumber4;
	 private String countnumber5;
	 private int text1;
	 private int text2;
	 private int text3;
	 private int text4;
	 private int text5;
	 private int f1;
	 private int out = 0;
	 private int outIndex = 0;
	 private String catalog;
	 private JTextField textField1;
	 private JTextField textField2;
	 private JTextField textField3;
	 private JTextField textField4;
	 private JTextField textField5;
	 private JTextField textField6;
	 
	 private Map map1 = new HashMap();
	 private Map map2 = new HashMap();
	 private Map map3 = new HashMap();
	 private Map map4 = new HashMap();
	 private Map map5 = new HashMap();
	 private HashSet hs;

	 private ResultSet rs1;
	 private String zid_[] = new String[100000];
	 private List<Integer> list = new ArrayList<Integer>();
	 private String args[];
	 private int zid2=0;
	 private JComboBox comboBox;
	 private JComboBox comboBox2;
	 private JComboBox comboBox3;
	 private JComboBox comboBox4;
	 private JComboBox comboBox5;
	 private FileWriter fileWriter1 ;
	 private FileWriter fileWriter2 ;
	 private ConnDB jdbc = new ConnDB();
	 private StringBuffer stringBuffer1 = new StringBuffer();
	 private StringBuffer stringBuffer2 = new StringBuffer();
	 private File file1 = new File("");
	 private File file2 = new File("");
	 JFileChooser jfc = new JFileChooser();// 文件选择器 
	 private JTextField txtTest;
	 
	 private JTextField score_1;
	 private JTextField score_2;
	 private JTextField score_3;
	 private JTextField score_4;
	 private JTextField score_5;
	 private int countscore1;
	 private int countscore2;
	 private int countscore3;
	 private int countscore4;
	 private int countscore5;
	 
	 
	 private JLabel lblNewLabel_2;
	 private JLabel label_10;
	 private JLabel label_11;
	 private JLabel label_12;
	 private JLabel label_13;
	public MakeTestPaperKnowLedge() {
		//窗体的出现位置和大小
//		setBounds(400, 100, 635, 524);
//		//设置窗体标题
//		setTitle("试卷生成系统");
//		//设置关闭响应,后台退出
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		//不能调节窗口大小
//		setResizable(false);
//		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
//
//		final JPanel panel = new JPanel();
//		panel.setLayout(null);
//		getContentPane().add(panel);
//		
		textField1 = new LimitedTextField("0123456789",3);
		textField1.setText("1");
		textField1.setBounds(310, 116, 100, 30);
		add(textField1);
		textField1.setColumns(10);
		
		
		textField2 = new LimitedTextField("0123456789",3);
		textField2.setText("1");
		textField2.setColumns(10);
		textField2.setBounds(310, 191, 100, 30);
		add(textField2);
		
		textField3 = new LimitedTextField("0123456789",3);
		textField3.setText("0");
		textField3.setColumns(10);
		textField3.setBounds(310, 261, 100, 30);
		add(textField3);
		
		
		textField4 = new LimitedTextField("0123456789",3);
		textField4.setText("0");
		textField4.setColumns(10);
		textField4.setBounds(310, 331, 100, 30);
		add(textField4);
		
		textField5 = new LimitedTextField("0123456789",3);
		textField5.setText("0");
		textField5.setColumns(10);
		textField5.setBounds(310, 401, 100, 30);
		add(textField5);
		
		
		setLayout(null);
		JLabel lblNewLabel_3 = new JLabel("选择题");
		lblNewLabel_3.setBounds(36, 120, 54, 21);
		add(lblNewLabel_3);
		
		JLabel label_1 = new JLabel("题库数量");
		label_1.setBounds(202, 70, 48, 15);
		add(label_1);
		
		
		ReadKnowledge rk = new ReadKnowledge();
		
		
		
		JLabel lblNewLabel = new JLabel("题型");
		lblNewLabel.setBounds(36, 70, 54, 21);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("选择出题数量");
		lblNewLabel_1.setBounds(310, 70, 72, 15);
		add(lblNewLabel_1);
		

		comboBox2 = new JComboBox(rk.ReadAll("select * from  题型1"));
		comboBox2.setBounds(36, 190, 100, 30);
		add(comboBox2);
		
		comboBox3 = new JComboBox(rk.ReadAll("select * from  题型1"));
		comboBox3.setBounds(36, 260, 100, 30);
		add(comboBox3);
		
		comboBox4 = new JComboBox(rk.ReadAll("select * from  题型1"));
		comboBox4.setBounds(36, 330, 100, 30);
		add(comboBox4);

		comboBox5 = new JComboBox(rk.ReadAll("select * from  题型1"));
		comboBox5.setBounds(36, 400, 100, 30);
		add(comboBox5);
		
		JLabel label_7 = new JLabel("请选择你要生成试卷的科目");
		label_7.setBounds(100, 10, 150, 23);
		add(label_7);
		
		comboBox = new JComboBox(rk.ReadAll("select * from  知识点"));
		comboBox.setBounds(310, 6, 100, 30);
		add(comboBox);

//		String sql2 = "select * from "+comboBox.getSelectedItem()+
//				" where 学科='"+comboBox_1.getSelectedItem()+"' order by cast(id as int)";
//		args = rk.Test("select id  from 选择题 ", "select id  from 选择题");
		args = rk.Test("select id  from 选择题  where knowledge='"+comboBox.getSelectedItem()+"'");
		GetNumber(args);
		countnumber2 = countnumber;
		countnumber3 = countnumber;
		countnumber4 = countnumber;
		countnumber5 = countnumber;
//		System.out.println("-------------------"+count+"----------countnumber:"+countnumber);
		JLabel label_2 = new JLabel(countnumber);
		label_2.setBounds(202, 123, 24, 15);
		add(label_2);


		textField1.getDocument().addDocumentListener(new DocumentListener() {
			
			int num = Integer.parseInt(countnumber)/2;
			
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try {
					text1 = Integer.parseInt(textField1.getText());
//					System.out.println(num);
					if(text1>num){
						JOptionPane.showMessageDialog(null, "所选的数据超出了题库的范围");
					}
				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "请输入数字");
					shuaxin();
				}

			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		

		args = rk.Test("select id  from "+comboBox2.getSelectedItem()+" where knowledge='"+comboBox.getSelectedItem()+"'");
		GetNumber(args);
		JLabel label_3 = new JLabel(countnumber);
		label_3.setBounds(202, 198, 24, 15);
		add(label_3);
		textField2.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				
				int num = 0;
				//判断是不是选择题的值
				if (Pointer==0) {
					 num = Integer.parseInt(countnumber)/2;
				}else{
					 num = Integer.parseInt(countnumber2)/2;
				}
//				Pointer++;
				// TODO Auto-generated method stub
				text2 = Integer.parseInt(textField2.getText());
				if(text2>num){
					JOptionPane.showMessageDialog(null, "所选的数据超出了题库的范围");
					shuaxin();
					
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
//		args = rk.Test("select id  from "+comboBox3.getSelectedItem()+"", "select id  from "+comboBox3.getSelectedItem()+"");
//		args = rk.Test("select id  from "+comboBox3.getSelectedItem()+" where 学科='"+comboBox.getSelectedItem()+"' "
//				, "select id  from "+comboBox3.getSelectedItem()+" where 学科='"+comboBox.getSelectedItem()+"'");
//		GetNumber(args);
		JLabel label_4 = new JLabel(countnumber);
		label_4.setBounds(202, 268, 24, 15);
		add(label_4);
		textField3.getDocument().addDocumentListener(new DocumentListener() {
			
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				int num = 0;
				if (Pointer==0) {
					 num = Integer.parseInt(countnumber)/2;
				}else{
					 num = Integer.parseInt(countnumber3)/2;
				}
//				Pointer++;
				text3 = Integer.parseInt(textField3.getText());
//				System.out.println(num);
				if(text3>num){
					JOptionPane.showMessageDialog(null, "所选的数据超出了题库的范围");
					shuaxin();
					
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
//		args = rk.Test("select id  from "+comboBox4.getSelectedItem()+"", "select id  from "+comboBox4.getSelectedItem()+"");
//		args = rk.Test("select id  from "+comboBox4.getSelectedItem()+" where 学科='"+comboBox.getSelectedItem()+"' "
//				, "select id  from "+comboBox4.getSelectedItem()+" where 学科='"+comboBox.getSelectedItem()+"'");
//		GetNumber(args);
		JLabel label_5 = new JLabel(countnumber);
		label_5.setBounds(202, 338, 24, 15);
		add(label_5);
		textField4.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				int num = 0;
				if (Pointer==0) {
					 num = Integer.parseInt(countnumber)/2;
				}else{
					 num = Integer.parseInt(countnumber4)/2;
				}
//				Pointer++;
				text4 = Integer.parseInt(textField4.getText());
				if(text4>num){
					JOptionPane.showMessageDialog(null, "所选的数据超出了题库的范围");
//					textField4.setText("0");
					
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
//		args = rk.Test("select id  from "+comboBox5.getSelectedItem()+"", "select id  from "+comboBox5.getSelectedItem()+"");
//		args = rk.Test("select id  from "+comboBox5.getSelectedItem()+" where 学科='"+comboBox.getSelectedItem()+"' "
//				, "select id  from "+comboBox5.getSelectedItem()+" where 学科='"+comboBox.getSelectedItem()+"'");
//		GetNumber(args);
		JLabel label_6 = new JLabel(countnumber);
		label_6.setBounds(202, 408, 24, 15);
		add(label_6);
		textField5.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				int num = 0;
				if (Pointer==0) {
					 num = Integer.parseInt(countnumber)/2;
				}else{
					 num = Integer.parseInt(countnumber5)/2;
				}
//				Pointer++;
				text5 = Integer.parseInt(textField5.getText());
//				System.out.println(num);
				if(text5>num){
					JOptionPane.showMessageDialog(null, "所选的数据超出了题库的范围");
					shuaxin();
					
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		comboBox2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				 if(e.getStateChange() == ItemEvent.SELECTED){
					 args = rk.Test("select id  from "+comboBox2.getSelectedItem()+" where knowledge='"+comboBox.getSelectedItem()+"'");
//					 args = rk.Test("select id  from "+comboBox2.getSelectedItem()+"", "select id  from "+comboBox2.getSelectedItem()+"");
					 GetNumber(args);
					 label_3.setText(countnumber);
					 //全局值，用于判断输入的值是否大于题库的一半
					 countnumber2 = countnumber;
					 Pointer++;
				 	}

			}
		});
	

		
		comboBox3.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				 if(e.getStateChange() == ItemEvent.SELECTED){
						args = rk.Test("select id  from "+comboBox3.getSelectedItem()+" where knowledge='"+comboBox.getSelectedItem()+"'");
//					 args = rk.Test("select id  from "+comboBox3.getSelectedItem()+"", "select id  from "+comboBox3.getSelectedItem()+"");
					 GetNumber(args);
					 label_4.setText(countnumber);
					 countnumber3 = countnumber;
					 Pointer++;
				 	}
			}
		});
		
		comboBox4.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				 if(e.getStateChange() == ItemEvent.SELECTED){
						args = rk.Test("select id  from "+comboBox4.getSelectedItem()+" where knowledge ='"+comboBox.getSelectedItem()+"'");
//					 args = rk.Test("select id  from "+comboBox4.getSelectedItem()+"", "select id  from "+comboBox4.getSelectedItem()+"");
					 GetNumber(args);
					 label_5.setText(countnumber);
					 countnumber4 = countnumber;
					 Pointer++;
				 	}
			}
		});
		
		comboBox5.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				 if(e.getStateChange() == ItemEvent.SELECTED){
					 args = rk.Test("select id  from "+comboBox5.getSelectedItem()+" where knowledge ='"+comboBox.getSelectedItem()+"'");
//					 args = rk.Test("select id  from "+comboBox5.getSelectedItem()+"", "select id  from "+comboBox5.getSelectedItem()+"");
					 GetNumber(args);
					 label_6.setText(countnumber);
					 countnumber5 = countnumber;
					 Pointer++;
				 	}
			}
		});
		
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				args = rk.Test("select id  from "+lblNewLabel_3.getText()+" where knowledge='"+comboBox.getSelectedItem()+"'");
				GetNumber(args);
				label_2.setText(countnumber);
				
				args = rk.Test("select id  from "+comboBox2.getSelectedItem()+" where knowledge='"+comboBox.getSelectedItem()+"'");
				GetNumber(args);
				countnumber2 = countnumber ;
				label_3.setText(countnumber2);
				
				args = rk.Test("select id  from "+comboBox3.getSelectedItem()+" where knowledge='"+comboBox.getSelectedItem()+"' ");
				GetNumber(args);
				countnumber3 = countnumber ;
				label_4.setText(countnumber3);
				
				args = rk.Test("select id  from "+comboBox4.getSelectedItem()+" where knowledge='"+comboBox.getSelectedItem()+"' ");
				GetNumber(args);
				countnumber4 = countnumber ;
				label_5.setText(countnumber4);
				
				args = rk.Test("select id  from "+comboBox5.getSelectedItem()+" where knowledge='"+comboBox.getSelectedItem()+"' ");
				GetNumber(args);
				countnumber5 = countnumber ;
				label_6.setText(countnumber5);
				
			}
		});
		
		textField6 = new JTextField();
		textField6.setText("D:\\");
		textField6.setBounds(100, 473, 80, 30);
		add(textField6);
		textField6.setColumns(10);
		

		JLabel label = new JLabel("生成目录");
		label.setBounds(36, 478, 54, 19);
		add(label);
		
		
		JButton btnNewButton = new JButton("生成试卷");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				catalog = textField6.getText();
				text1 = Integer.parseInt(textField1.getText());
				text2 = Integer.parseInt(textField2.getText());
				text3 = Integer.parseInt(textField3.getText());
				text4 = Integer.parseInt(textField4.getText());
				text5 = Integer.parseInt(textField5.getText());
				if (text1==0&&text2==0&&text3==0&&text4==0&&text5==0) {
					JOptionPane.showMessageDialog(null, "输入错误", "输入错误", JOptionPane.ERROR_MESSAGE);
				}else{
					stringBuffer1 = new StringBuffer();
				    file1 = new File(catalog +"\\"+txtTest.getText()+"(A卷).doc");
				    file2 = new File(catalog +"\\"+txtTest.getText()+"(B卷).doc");
					if (!file1.exists()) {
						try {
							file1.createNewFile();
						} catch (IOException e1) {
	
							e1.printStackTrace();
						}
					}
					if (!file2.exists()) {
						try {
							file2.createNewFile();
						} catch (IOException e1) {
	
							e1.printStackTrace();
						}
					}
					fileWriter1 = null;
					try {
						fileWriter1 = new FileWriter(file1);
						fileWriter2 = new FileWriter(file2);
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					
					stringBuffer1.append("<html><head></head><body bgcolor='#ffffff'><center><H2>苏州大学应用技术学院</h2>"
							+ "</center><br><center>班级________  姓名________  学号_______ </center></html>");
//					stringBuffer1.append("<html><H3>题型</h3></html>");
					stringBuffer1.append("<table border=1><tr>");
					
					stringBuffer2.append("<html><head></head><body bgcolor='#ffffff'><center><H2>苏州大学应用技术学院</h2>"
							+ "</center><br><center>班级________  姓名________  学号_______ </center></html>");
//					stringBuffer2.append("<html><H3>题型</h3></html>");
					stringBuffer2.append("<table border=1><tr>");
					if (text1!=0) {
						//遍历combobox对应的数据库的id，放入数组中。
//						System.out.println("---------------");
//						args = rk.Test("select id  from 选择题", "select id  from 选择题");
						list.removeAll(list);
						args = rk.Test("select id  from 选择题 where knowledge='"+comboBox.getSelectedItem()+"' ");
						//textfiled获取的数值传给变量
						
						f1 = text1;
						String sql1 = "select question,choice  from 选择题  where knowledge='"+comboBox.getSelectedItem()+"' ";
						hs = new HashSet();
						AddInBufferChoice(sql1);
					}
					if (text2!=0) {
						list.removeAll(list);
						args = rk.Test("select id  from "+comboBox2.getSelectedItem()+"  where knowledge='"+comboBox.getSelectedItem()+"'");
						f1 = text2;
						String sql2 = "select question  from "+comboBox2.getSelectedItem()+"  where knowledge='"+comboBox.getSelectedItem()+"'";
						hs = new HashSet();
//						stringBuffer1.append("<h2>"+comboBox2.getSelectedItem()+"(共"+count+"题，每题4分，共"+count*4+"分)</h2>");
//						stringBuffer2.append("<h2>"+comboBox2.getSelectedItem()+"(共"+count+"题，每题4分，共"+count*4+"分)</h2>");
						AddInBuffer(sql2);
						AddInBuffer2();
					}
					if (text3!=0) {
						list.removeAll(list);
						args = rk.Test("select id  from "+comboBox3.getSelectedItem()+"  where knowledge='"+comboBox.getSelectedItem()+"'");
						f1 = text3;
						String sql3 = "select question  from "+comboBox3.getSelectedItem()+"  where knowledge='"+comboBox.getSelectedItem()+"'";
						hs = new HashSet();
//						stringBuffer1.append("<h2>"+comboBox3.getSelectedItem()+"</h2>");
//						stringBuffer2.append("<h2>"+comboBox3.getSelectedItem()+"</h2>");
						AddInBuffer(sql3);
						AddInBuffer3();
					}
					if (text4!=0) {
						list.removeAll(list);
						args = rk.Test("select id  from "+comboBox4.getSelectedItem()+"  where knowledge='"+comboBox.getSelectedItem()+"'");
						f1 = text4;
						String sql4 = "select question  from "+comboBox4.getSelectedItem()+"  where knowledge='"+comboBox.getSelectedItem()+"'";
						hs = new HashSet();
//						stringBuffer1.append("<h2>"+comboBox4.getSelectedItem()+"</h2>");
//						stringBuffer2.append("<h2>"+comboBox4.getSelectedItem()+"</h2>");
						AddInBuffer(sql4);
						AddInBuffer4();
					}
					if (text5!=0) {
						list.removeAll(list);
						args = rk.Test("select id  from "+comboBox5.getSelectedItem()+"  where knowledge='"+comboBox.getSelectedItem()+"'");
						f1 = text5;
						String sql5 = "select question  from "+comboBox5.getSelectedItem()+"  where knowledge='"+comboBox.getSelectedItem()+"'";
						hs = new HashSet();
//						stringBuffer1.append("<h2>"+comboBox5.getSelectedItem()+"</h2>");
//						stringBuffer2.append("<h2>"+comboBox5.getSelectedItem()+"</h2>");
						AddInBuffer(sql5);
						AddInBuffer5();
					}
				
					MakeTestPaper();
					
				}

			}
		});
		btnNewButton.setBounds(468, 473, 107, 29);
		add(btnNewButton);
		
		
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
	                textField6.setText(f.getAbsolutePath());  
	                
	            }
			}
		});
		btnNewButton_1.setBounds(188, 472, 82, 30);
		add(btnNewButton_1);
		
		txtTest = new JTextField();
		txtTest.setText("test");
		txtTest.setBounds(344, 473, 100, 30);
		add(txtTest);
		txtTest.setColumns(10);
		
		JLabel label_8 = new JLabel("文件名");
		label_8.setBounds(286, 480, 48, 15);
		add(label_8);
		
		score_1 = new JTextField();
		score_1.setText("3");
		score_1.setColumns(10);
		score_1.setBounds(489, 116, 100, 30);
		add(score_1);
		
		JLabel label_9 = new JLabel("设置题型分值");
		label_9.setBounds(489, 70, 72, 15);
		add(label_9);
		
		score_2 = new JTextField();
		score_2.setText("3");
		score_2.setColumns(10);
		score_2.setBounds(489, 191, 100, 30);
		add(score_2);
		
		score_3 = new JTextField();
		score_3.setText("0");
		score_3.setColumns(10);
		score_3.setBounds(489, 261, 100, 30);
		add(score_3);
		
		score_4 = new JTextField();
		score_4.setText("0");
		score_4.setColumns(10);
		score_4.setBounds(489, 331, 100, 30);
		add(score_4);
		
		score_5 = new JTextField();
		score_5.setText("0");
		score_5.setColumns(10);
		score_5.setBounds(489, 401, 100, 30);
		add(score_5);
		
		lblNewLabel_2 = new JLabel("分");
		lblNewLabel_2.setBounds(599, 123, 54, 15);
		add(lblNewLabel_2);
		
		label_10 = new JLabel("分");
		label_10.setBounds(599, 198, 54, 15);
		add(label_10);
		
		label_11 = new JLabel("分");
		label_11.setBounds(599, 268, 54, 15);
		add(label_11);
		
		label_12 = new JLabel("分");
		label_12.setBounds(599, 338, 54, 15);
		add(label_12);
		
		label_13 = new JLabel("分");
		label_13.setBounds(599, 408, 54, 15);
		add(label_13);



	}
	
	//生成从题库中遍历的id，抽取随机数
	public void GetNumber(String[] args){
		
		for (count = 0; count < args.length; count++) {
			int k = Integer.parseInt(args[count]);
			list.add(k);
		}
		
		countnumber = count+"";
	
	}
	public void GetNumber2(){
		try {
			Random ran = new Random();
			//将最外值设为 从数组长度取得的随机值
			outIndex = ran.nextInt(list.size());
			//从list中得到取得的随机值
			out = list.get(outIndex);
			//从list移除该值并输出该值
			list.remove(outIndex);
//			System.out.println(out);
		} catch (Exception e) {
			// TODO: handle exception
			thevaluereturn = JOptionPane.showConfirmDialog(null, "提示信息","标题",
					JOptionPane.OK_CANCEL_OPTION);
		}
		
	}
	public void AddInBufferChoice(String sql1){
       rs1=jdbc.getResult(sql1);
       try {
    	   		
				while(rs1.next()){
					hs.add(rs1.getString(2));
				}
				Collection conCollection = hs;
				Iterator iterator1 = conCollection.iterator();
				
				int i=0;
				while(iterator1.hasNext()){
					map1.put(i, iterator1.next().toString()); 
					i++;
				}

				if(i<f1){
					JOptionPane.showMessageDialog(null, "没有这么多相应题目1", "连接错误", JOptionPane.ERROR_MESSAGE);
					shuaxin();
				}
				
				for(int j=1;j<=f1;j++){						
				 zid_[zid2]=map1.get(j).toString();
				 zid2++;
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
       

			jdbc = new ConnDB();
			GetNumber(args);
			countscore1 = Integer.parseInt(score_1.getText());
//			System.out.println("-----------"+list.toString());
			stringBuffer1.append("<h2>选择题(共"+textField1.getText()+"题，每题"+score_1.getText()+"分，共"+text1*countscore1+"分)</h2>");
			for(int u=1;u<=zid2;u++){
				
				GetNumber2();
				String sql2 = "select question,choice  from 选择题  where id ="+out+" and knowledge='"+comboBox.getSelectedItem()+"'";
				rs1 = jdbc.getResult(sql2);//从数据库读取所有id值，取其中的值赋给这个id
				try {
					while(rs1.next()){
						stringBuffer1.append("</h3><br><Left>"+u+".</Left>"+rs1.getString(1)+""
								+ "<br>"+rs1.getString(2)+"");												
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
					}
				
				}
			
			stringBuffer2.append("<h2>选择题(共"+textField1.getText()+"题，每题"+score_1.getText()+"分，共"+text1*countscore1+"分)</h2>");
			for(int u=1;u<=zid2;u++){
				
				GetNumber2();
				String sql2 = "select question,choice  from 选择题  where id ="+out+" and knowledge='"+comboBox.getSelectedItem()+"'";
				rs1 = jdbc.getResult(sql2);//从数据库读取所有id值，取其中的值赋给这个id
				try {
					while(rs1.next()){
						stringBuffer2.append("</h3><br><Left>"+u+".</Left>"+rs1.getString(1)+""
								+ "<br>"+rs1.getString(2)+"");												
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
					}
				
				}


	}
	
	public void AddInBuffer(String str1){
		   zid2=0;
	       rs1=jdbc.getResult(str1);
	       try {
					while(rs1.next()){
						hs.add(rs1.getString(1));
					}
					Collection conCollection = hs;
					Iterator iterator1 = conCollection.iterator();
					
					int i=0;
					while(iterator1.hasNext()){
						map1.put(i, iterator1.next().toString()); 
						i++;
					}

					if(i<f1){
						JOptionPane.showMessageDialog(null, "没有这么多相应题目1", "连接错误", JOptionPane.ERROR_MESSAGE);
						shuaxin();
					}
					
					for(int j=1;j<=f1;j++){						
					 zid_[zid2]=map1.get(j).toString();
					 zid2++;
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
 
				jdbc = new ConnDB();

		}
	
	public void  AddInBuffer2(){
		GetNumber(args);
		countscore2 = Integer.parseInt(score_2.getText());
		stringBuffer1.append("<h2>"+comboBox2.getSelectedItem()+"(共"+textField2.getText()+"题，每题"+countscore2+"分，共"+text2*countscore2+"分)</h2>");
		stringBuffer2.append("<h2>"+comboBox2.getSelectedItem()+"(共"+textField2.getText()+"题，每题"+countscore2+"分，共"+text2*countscore2+"分)</h2>");
		for(int u=1;u<=zid2;u++){
			GetNumber2();
//			select question  from "+comboBox2.getSelectedItem()+"  where id ="+out+" and 学科='"+comboBox.getSelectedItem()+"'
			String sql2 = "select question  from "+comboBox2.getSelectedItem()+
					"  where id ="+out+" and knowledge='"+comboBox.getSelectedItem()+"'";
			rs1 = jdbc.getResult(sql2);//从数据库读取所有id值，取其中的值赋给这个id
			try {
				while(rs1.next()){
					stringBuffer1.append("</h3><br><Left>"+u+".</Left>"+rs1.getString(1)+"");												
				}
				
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		
		
		for(int u=1;u<=zid2;u++){
			GetNumber2();
			String sql2 = "select  question  from "+comboBox2.getSelectedItem()+
					"  where id ="+out+"  and knowledge='"+comboBox.getSelectedItem()+"'";
			rs1 = jdbc.getResult(sql2);//从数据库读取所有id值，取其中的值赋给这个id
			try {
				while(rs1.next()){
					stringBuffer2.append("</h3><br><Left>"+u+".</Left>"+rs1.getString(1)+"");												
				}
				
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		
	}
	
	public void  AddInBuffer3(){
		GetNumber(args);
		countscore3 = Integer.parseInt(score_3.getText());
		stringBuffer1.append("<h2>"+comboBox3.getSelectedItem()+"(共"+textField3.getText()+"题，每题"+countscore3+"分，共"+text3*countscore3+"分)</h2>");
		stringBuffer2.append("<h2>"+comboBox3.getSelectedItem()+"(共"+textField3.getText()+"题，每题"+countscore3+"分，共"+text3*countscore3+"分)</h2>");
		
		for(int u=1;u<=zid2;u++){
			GetNumber2();
			String sql2 = "select question  from "+comboBox3.getSelectedItem()+
					"  where id ="+out+" and knowledge='"+comboBox.getSelectedItem()+"'";
			rs1 = jdbc.getResult(sql2);//从数据库读取所有id值，取其中的值赋给这个id
			try {
				while(rs1.next()){
					stringBuffer1.append("</h3><br><Left>"+u+".</Left>"+rs1.getString(1)+"");												
				}
				
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		for(int u=1;u<=zid2;u++){
			GetNumber2();
			String sql2 = "select question  from "+comboBox3.getSelectedItem()+
					"  where id ="+out+" and knowledge='"+comboBox.getSelectedItem()+"'";
			rs1 = jdbc.getResult(sql2);//从数据库读取所有id值，取其中的值赋给这个id
			try {
				while(rs1.next()){
					stringBuffer2.append("</h3><br><Left>"+u+".</Left>"+rs1.getString(1)+"");												
				}
				
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		
	}
	public void  AddInBuffer4(){
		GetNumber(args);
		countscore4 = Integer.parseInt(score_4.getText());
		stringBuffer1.append("<h2>"+comboBox4.getSelectedItem()+"(共"+textField4.getText()+"题，每题"+countscore4+"分，共"+text4*countscore4+"分)</h2>");
		stringBuffer2.append("<h2>"+comboBox4.getSelectedItem()+"(共"+textField4.getText()+"题，每题"+countscore4+"分，共"+text4*countscore4+"分)</h2>");
		
		for(int u=1;u<=zid2;u++){
			GetNumber2();
			String sql2 = "select question  from "+comboBox4.getSelectedItem()+
					"  where id ="+out+"and knowledge='"+comboBox.getSelectedItem()+"'";
			rs1 = jdbc.getResult(sql2);//从数据库读取所有id值，取其中的值赋给这个id
			try {
				while(rs1.next()){
					stringBuffer1.append("</h3><br><Left>"+u+".</Left>"+rs1.getString(1)+"");												
				}
				
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		for(int u=1;u<=zid2;u++){
			GetNumber2();
			String sql2 = "select question  from "+comboBox4.getSelectedItem()+
					"  where id ="+out+"and knowledge='"+comboBox.getSelectedItem()+"'";
			rs1 = jdbc.getResult(sql2);//从数据库读取所有id值，取其中的值赋给这个id
			try {
				while(rs1.next()){
					stringBuffer2.append("</h3><br><Left>"+u+".</Left>"+rs1.getString(1)+"");												
				}
				
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		
	}
	public void  AddInBuffer5(){
		GetNumber(args);
		countscore5 = Integer.parseInt(score_5.getText());
		stringBuffer1.append("<h2>"+comboBox5.getSelectedItem()+"(共"+textField5.getText()+"题，每题"+countscore5+"分，共"+text5*countscore5+"分)</h2>");
		stringBuffer2.append("<h2>"+comboBox5.getSelectedItem()+"(共"+textField5.getText()+"题，每题"+countscore5+"分，共"+text5*countscore5+"分)</h2>");
		for(int u=1;u<=zid2;u++){
			GetNumber2();
			String sql2 = "select question  from "+comboBox5.getSelectedItem()+
					"  where id ="+out+" and knowledge='"+comboBox.getSelectedItem()+"'";
			rs1 = jdbc.getResult(sql2);//从数据库读取所有id值，取其中的值赋给这个id
			try {
				while(rs1.next()){
					stringBuffer1.append("</h3><br><Left>"+u+".</Left>"+rs1.getString(1)+"");												
				}
				
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		for(int u=1;u<=zid2;u++){
			GetNumber2();
			String sql2 = "select question  from "+comboBox5.getSelectedItem()+
					"  where id ="+out+"and knowledge='"+comboBox.getSelectedItem()+"'";
			rs1 = jdbc.getResult(sql2);//从数据库读取所有id值，取其中的值赋给这个id
			try {
				while(rs1.next()){
					stringBuffer2.append("</h3><br><Left>"+u+".</Left>"+rs1.getString(1)+"");												
				}
				
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		
	}
	
	public void MakeTestPaper(){
		stringBuffer1.append("</table></center></body></html>");
		stringBuffer2.append("</table></center></body></html>");
		try {
			
			fileWriter1.write(stringBuffer1.toString());
			fileWriter2.write(stringBuffer2.toString());
			fileWriter1.close();
			fileWriter2.close();
			JOptionPane.showMessageDialog(null,"生成已成功！");
			shuaxin();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	 public void shuaxin(){
		 MakeTestPaperKnowLedge mtp = new MakeTestPaperKnowLedge();
		 mtp.setVisible(true);
		 setVisible(false);
	 }
}
