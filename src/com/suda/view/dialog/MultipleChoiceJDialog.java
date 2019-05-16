package com.suda.view.dialog;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.suda.JDBC.ConnDB;
import com.suda.UserInterface.frame.ReadKnowledge;
public class MultipleChoiceJDialog extends JDialog{
	
	private ConnDB sql = new ConnDB();
	 Font f = new Font("楷体",Font.TRUETYPE_FONT,16);
	 Color col = Color.BLUE;
	 private JTextField textField_1;
	 private JTextField textField_2;
	 private JTextField textField_3;
	 private JTextField textField_4;
	public MultipleChoiceJDialog() {
		setLayout(null);
		
		String [] Choice = new String[5];
		Choice[0] = "A";
		JRadioButton R1 = new JRadioButton("A");
		R1.setSelected(true);
		R1.setBounds(114, 286, 39, 31);
		add(R1);
		R1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Choice[0] = "A";
			}
		});
		
		JRadioButton R2 = new JRadioButton("B");
		R2.setBounds(114, 319, 39, 31);
		add(R2);
		R2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Choice[0] = "B";
			}
		});
		
		
		JRadioButton R3 = new JRadioButton("C");
		R3.setBounds(114, 352, 39, 31);
		add(R3);
		R3.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Choice[0] = "C";
			}
		});
		
		JRadioButton R4 = new JRadioButton("D");
		R4.setBounds(114, 385, 39, 31);
		add(R4);
		R4.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Choice[0] = "D";
			}
		});
		
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(R1);
		buttonGroup.add(R2);
		buttonGroup.add(R3);
		buttonGroup.add(R4);
		

		
		JLabel label = new JLabel("正确答案");
		label.setBounds(32, 285, 74, 31);
		add(label);
		label.setFont(f);
		label.setForeground(col);
		
		JLabel label_1 = new JLabel("知识点");
		label_1.setBounds(42, 24, 74, 31);
		add(label_1);

		ReadKnowledge rk = new ReadKnowledge();
		JComboBox comboBox = new JComboBox(rk.ReadAll("select * from 知识点 "));
		comboBox.setBounds(159, 24, 140, 30);
		add(comboBox);
			
		JLabel label_3 = new JLabel("学科");
		label_3.setBounds(348, 24, 57, 31);
		add(label_3);
		
		JComboBox comboBox_1 = new JComboBox(rk.ReadAll("select * from  学科"));
		comboBox_1.setBounds(428, 24, 140, 30);
		add(comboBox_1);
		
		JLabel label_2 = new JLabel("问题");
		label_2.setBounds(42, 82, 109, 31);
		add(label_2);
		

		
		textField_1 = new JTextField();
		textField_1.setBounds(159, 291, 401, 21);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(159, 324, 401, 21);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(159, 357, 401, 21);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(159, 390, 401, 21);
		add(textField_4);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(158, 92, 399, 174);
		add(editorPane);
		
		JButton button1 = new JButton("添加到题库");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_1.getText().length()<1||textField_2.getText().length()<1
						||textField_3.getText().length()<1||textField_4.getText().length()<1
						||editorPane.getText().length()<1) {
					JOptionPane.showMessageDialog(null, "填写不能为空!");
				}else{
					sql = new ConnDB();
					String SqlStatements;
					SqlStatements = "insert into 选择题(question,choice,answer,knowledge,subject) values('"
							+ editorPane.getText() + "','A：" 
							+ textField_1.getText() + "     B：" + textField_2.getText() + "       C：" 
							+ textField_3.getText() + "     D：" + textField_4.getText() + "','" 
							+ Choice[0] + "','" + comboBox.getSelectedItem() + "','" + comboBox_1.getSelectedItem() + "')";
					sql.getRows(SqlStatements);
					JOptionPane.showMessageDialog(null, "添加成功", "成功", JOptionPane.ERROR_MESSAGE);
					editorPane.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
					
				}
				
				
			}
		});
		button1.setBounds(296, 442, 109, 38);
		add(button1);
		

	}

}
