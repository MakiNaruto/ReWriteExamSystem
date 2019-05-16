package com.suda.excel;

import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.suda.JDBC.ConnDB;
import com.suda.UserInterface.frame.ReadKnowledge;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;


public class ExcelToDb extends JDialog {
	private ConnDB sql = new ConnDB();
	private String SqlStatements;
	private JTextField textField;
	JFileChooser jfc = new JFileChooser();// 文件选择器 
	private String catalog;
	private ReadKnowledge rk  = new ReadKnowledge();
	private List<TestSetGet> listExcel;
	private List<TestSetGetAll> listExcel2;
	/**
	 * Launch the application
	 * 
	 * @param args
	 */


	/**
	 * Create the dialog
	 */
	public ExcelToDb() {
		super();
		getContentPane().setLayout(null);
		
		JLabel label_1 = new JLabel("选择文件");
		label_1.setBounds(21, 70, 77, 18);
		getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(134, 67, 179, 26);
		getContentPane().add(textField);
		
		JLabel label = new JLabel("选择导入的题型");
		label.setBounds(21, 133, 99, 26);
		getContentPane().add(label);
		
		JComboBox comboBox = new JComboBox(rk.ReadAll("select * from  所有题型"));
		comboBox.setBounds(134, 136, 179, 26);
		getContentPane().add(comboBox);
		this.setModal(true);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width - 399) / 2, (d.height - 232) / 2, 503, 327);
		
		
		jfc.setCurrentDirectory(new File("d://"));// 文件选择器的初始目录定为d盘  
		JButton button = new JButton("浏览...");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jfc.setFileSelectionMode(0);// 设定只能选择到文件  
	            int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句  
	            if (state == 1) {  
	                return;// 撤销则返回  
	            } else {  
	                File f = jfc.getSelectedFile();// f为选择到的文件  
	                textField.setText(f.getAbsolutePath());  
	            }
			}
		});
		button.setBounds(348, 67, 93, 26);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("导入");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				catalog = textField.getText();
				String TestType = comboBox.getSelectedItem().toString();
				System.out.println(TestType);
				if (TestType.equals("选择题")) {
//					System.out.println("--------------11111111111");
					listExcel=StuService.getAllByExcel(catalog);

					DBhepler db=new DBhepler();
					
					for (TestSetGet stuEntity : listExcel) {
						int id=stuEntity.getId();
						if (!StuService.isExist(id)) {
							//锟斤拷锟斤拷锟节撅拷锟斤拷锟?
							String sql="insert into 选择题 (question,choice,answer,knowledge,subject) values(?,?,?,?,?)";
							String[] str=new String[]{stuEntity.getQuestion(),stuEntity.getChoice(),stuEntity.getAnswer(),stuEntity.getKnowledge(),
									stuEntity.getSubject()+""};
							db.AddU(sql, str);
						}else {
							//锟斤拷锟节就革拷锟斤拷
							String sql="update 选择题 set question=?, choice=?, answer=?, knowledge=?, subject=? where id=?";
							String[] str=new String[]{stuEntity.getQuestion(),stuEntity.getChoice(),stuEntity.getAnswer(),stuEntity.getKnowledge(),
									stuEntity.getSubject()+"",id+""};
							db.AddU(sql, str);
						}
					}
					
				}else{
					System.out.println("--------------22222222222");
					String Tixing = comboBox.getSelectedItem().toString();
					listExcel2 = StuService.getTheOtherExcel(catalog);

					DBhepler db=new DBhepler();
					
					for (TestSetGetAll stuEntity : listExcel2) {
						int id=stuEntity.getId();
						if (!StuService.OtherisExist(id,Tixing)) {
							//锟斤拷锟斤拷锟节撅拷锟斤拷锟?
							String sql="insert into "+comboBox.getSelectedItem()+" (question,answer,knowledge,subject) values(?,?,?,?)";
							String[] str=new String[]{stuEntity.getQuestion(),stuEntity.getAnswer(),
									stuEntity.getKnowledge(),stuEntity.getSubject()+""};
							db.AddU(sql, str);
						}else {
							//锟斤拷锟节就革拷锟斤拷
							String sql="update "+comboBox.getSelectedItem()+" set question=?, answer=?, knowledge=?, subject=? where id=?";
							String[] str=new String[]{stuEntity.getQuestion(),stuEntity.getAnswer(),
									stuEntity.getKnowledge(),stuEntity.getSubject()+"",id+""};
							db.AddU(sql, str);
						}
					}
				}

				
				
			}
		});
		button_1.setBounds(165, 205, 107, 37);
		getContentPane().add(button_1);
		


	}
}
