package com.suda.excel;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.suda.JDBC.ConnDB;
import com.suda.UserInterface.frame.ReadKnowledge;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;


public class DbToExcel extends JDialog {
	private ConnDB sql = new ConnDB();
	private String SqlStatements;
	private JTextField textField;
	JFileChooser jfc = new JFileChooser();// 文件选择器 
	private String catalog;
	private ReadKnowledge rk  = new ReadKnowledge();
	/**
	 * Launch the application
	 * 
	 * @param args
	 */


	/**
	 * Create the dialog
	 */
	public DbToExcel() {
		super();
		getContentPane().setLayout(null);
		
		JLabel label_1 = new JLabel("选择生成目录");
		label_1.setBounds(29, 70, 77, 18);
		getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(134, 67, 179, 26);
		getContentPane().add(textField);
		
		
		JLabel label = new JLabel("选择出入的题型");
		label.setBounds(29, 131, 99, 26);
		getContentPane().add(label);
		
		JComboBox comboBox = new JComboBox(rk.ReadAll("select * from  所有题型"));
		comboBox.setBounds(134, 134, 179, 26);
		getContentPane().add(comboBox);
		this.setModal(true);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 399) / 2, (d.height - 232) / 2, 503, 327);
		jfc.setCurrentDirectory(new File("d://"));// 文件选择器的初始目录定为d盘  
		JButton button = new JButton("浏览...");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jfc.setFileSelectionMode(1);// 设定只能选择到文件夹  
	            int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句  
	            if (state == 1) {  
	                return;  
	            } else {  
	                File f = jfc.getSelectedFile();// f为选择到的目录  
	                String path = f.toString();
	                System.out.println(path);
	                String reallypath = path.substring(path.length()-1, path.length());
	                System.out.println(reallypath);
	                if(reallypath.equals("\\")){
	                	path = path + "book2.xls";
//	                	System.out.println(path);
//	                	System.out.println("1233123");
	                }else{
	                	path = path + "\\book2.xls";
//	                	System.out.println(path);
//	                	System.out.println("1111111111");
	                }
	                textField.setText(path);  
	            } 
			}
		});
		button.setBounds(348, 67, 93, 26);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("导出");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				catalog = textField.getText();
				try {
					WritableWorkbook wwb = null;
				
					   // 创建可写入的Excel工作簿
//					catalog+"\\asdasdsa.doc"
					   String fileName = catalog;
					   File file=new File(fileName);
					   if (!file.exists()) {
						   file.createNewFile();
					   }
					   //以fileName为文件名来创建一个Workbook
					   wwb = Workbook.createWorkbook(file);

					   // 创建工作表
					   WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
					   if(comboBox.getSelectedItem().equals("选择题")){
						   //查询数据库中所有的数据
						   List<TestSetGet> list= StuService.getAllByDb();
						   //要插入到的Excel表格的行号，默认从0开始
						   Label labelId= new Label(0, 0, "编号(id)");//表示第
						   Label labelQuestion= new Label(1, 0, "问题(question)");
						   Label labelChoice= new Label(2, 0, "选项(choice)");
						   Label labelAnswer= new Label(3, 0, "答案(answer)");
						   Label labelKnowledge= new Label(4, 0, "知识点(knowledge)");  
						   Label labelSubject= new Label(5, 0, "学科(subject)");
						   
						   ws.addCell(labelId);
						   ws.addCell(labelQuestion);
						   ws.addCell(labelChoice);
						   ws.addCell(labelAnswer);
						   ws.addCell(labelKnowledge);
						   ws.addCell(labelSubject);
						   
						   for (int i = 0; i < list.size(); i++) {
							   
							   Label labelId_i= new Label(0, i+1, list.get(i).getId()+"");
							   Label labelQuestion_i= new Label(1, i+1, list.get(i).getQuestion());
							   Label labelChoice_i= new Label(2, i+1, list.get(i).getChoice());
							   Label labelAnswer_i= new Label(3, i+1, list.get(i).getAnswer());							   
							   Label labelKnowledge_i= new Label(4, i+1, list.get(i).getKnowledge()+"");							   
							   Label labelSubject_i= new Label(5, i+1, list.get(i).getSubject()+"");
							   
							   ws.addCell(labelId_i);
							   ws.addCell(labelQuestion_i);
							   ws.addCell(labelChoice_i);
							   ws.addCell(labelAnswer_i);
							   ws.addCell(labelKnowledge_i);
							   ws.addCell(labelSubject_i);
						   }
						 
						
					   }else{
						   List<TestSetGetAll> list= StuService.getTheOtherDb("select * from "+comboBox.getSelectedItem());
						   //要插入到的Excel表格的行号，默认从0开始
						   Label labelId= new Label(0, 0, "编号(id)");//表示第
						   Label labelQuestion= new Label(1, 0, "问题(question)");
						   Label labelAnswer= new Label(2, 0, "答案(answer)");
						   Label labelKnowledge= new Label(3, 0, "知识点(knowledge)");
						   Label labelSubject= new Label(4, 0, "学科(subject)");
						   
						   ws.addCell(labelId);
						   ws.addCell(labelQuestion);
						   ws.addCell(labelAnswer);
						   ws.addCell(labelKnowledge);
						   ws.addCell(labelSubject);
						   
						   for (int i = 0; i < list.size(); i++) {
							   
							   Label labelId_i= new Label(0, i+1, list.get(i).getId()+"");
							   Label labelQuestion_i= new Label(1, i+1, list.get(i).getQuestion());
							   Label labelAnswer_i= new Label(2, i+1, list.get(i).getAnswer());
							   Label labelKnowledge_i= new Label(3, i+1, list.get(i).getKnowledge()+"");
							   Label labelSubject_i= new Label(4, i+1, list.get(i).getSubject()+"");
							   
							   ws.addCell(labelId_i);
							   ws.addCell(labelQuestion_i);
							   ws.addCell(labelAnswer_i);
							   ws.addCell(labelKnowledge_i);
							   ws.addCell(labelSubject_i);
						   }
					   }
					   
					   //写进文档
					   wwb.write();
					  // 关闭Excel工作簿对象
					   wwb.close();
					  
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		button_1.setBounds(173, 205, 107, 37);
		getContentPane().add(button_1);


	}
}
