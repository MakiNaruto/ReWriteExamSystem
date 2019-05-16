package com.suda.view.dialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.suda.JDBC.ConnDB;
import com.suda.UserInterface.frame.ReadKnowledge;
import com.suda.view.panel.CheckTestDatabase;
import javax.swing.JTextField;


public class TureOrFalseJDialog  extends JDialog{
	
	private ConnDB sql = new ConnDB();
	 Font f = new Font("楷体",Font.TRUETYPE_FONT,16);
	 Color col = Color.BLUE;
	 private JTextField textField;
	 private JTextField textField_1;
	public TureOrFalseJDialog(String question, String answer, String test, String subject, CheckTestDatabase checkTestDatabase) {
		getContentPane().setLayout(null);
		
		String [] Choice = new String[5];
		
		JRadioButton R1 = new JRadioButton("√");
		R1.setSelected(true);
		R1.setBounds(311, 337, 57, 55);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
//		setBounds((d.width - 399) / 2, (d.height - 232) / 2, 399, 232);
		setBounds(400, 100, 700, 500);
		
		
		R1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Choice[0] = "√";
			}
		});
		
		JRadioButton R2 = new JRadioButton("×");
		R2.setBounds(447, 337, 57, 55);
		R2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Choice[0] = "×";
			}
		});
		
		
		getContentPane().add(R1);
		getContentPane().add(R2);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(R1);
		buttonGroup.add(R2);
		
		if (answer.equals("√")) {
			R1.setSelected(true);
			System.out.println("-----------");
		}else {
			R2.setSelected(true);
		}
		
		JButton button1 = new JButton("修改");
		button1.setBounds(297, 417, 113, 38);
		getContentPane().add(button1);
		
		JLabel label = new JLabel("正确答案");
		label.setBounds(163, 348, 93, 31);
		getContentPane().add(label);
		label.setFont(f);
		label.setForeground(col);
		
		JLabel lblNewLabel = new JLabel("输入问题");
		lblNewLabel.setBounds(38, 75, 128, 15);
		getContentPane().add(lblNewLabel);
		
		ReadKnowledge rk = new ReadKnowledge();
		
		JLabel label_1 = new JLabel("知识点");
		label_1.setBounds(38, 21, 68, 31);
		getContentPane().add(label_1);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setToolTipText("");
		editorPane.setBounds(150, 75, 427, 256);
		getContentPane().add(editorPane);
		editorPane.setText(question);
		
		JLabel label_2 = new JLabel("学科");
		label_2.setBounds(342, 21, 45, 31);
		getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setBounds(150, 26, 150, 25);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(423, 26, 150, 25);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (editorPane.getText().length()<1) {
					JOptionPane.showMessageDialog(null, "请输入问题", "错误", JOptionPane.ERROR_MESSAGE);
				} else {
					sql = new ConnDB();
					String SqlStatements;
					SqlStatements = "insert into 判断题(question,answer,knowledge,subject) values('"
							+ editorPane.getText() + "' , '"+Choice[0]+"','"+"','"+"' )";
					sql.getRows(SqlStatements);
					editorPane.setText(null);
//				    comboBox.setSelectedIndex(0);
//					String sql3 = "update "+" set 问题='" +  "',答案='"+  "',知识点='" +  
//							"',选项='"+ "',学科='"+  "' where 题号='"+  "'";
					JOptionPane.showMessageDialog(null, "添加成功", "成功", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
	
	}
}
