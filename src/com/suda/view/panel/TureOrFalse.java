package com.suda.view.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.suda.JDBC.ConnDB;
import com.suda.UserInterface.frame.ReadKnowledge;


public class TureOrFalse  extends JPanel{
	 private ConnDB sql = new ConnDB();
//	 private JDBC sql = new JDBC();
	 Font f = new Font("楷体",Font.TRUETYPE_FONT,16);
	 Color col = Color.BLUE;
	public TureOrFalse() {
		setLayout(null);
		
		String [] Choice = new String[5];
		
		JRadioButton R1 = new JRadioButton("√");
		R1.setSelected(true);
		R1.setBounds(311, 337, 57, 55);
		
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
		
		add(R1);
		add(R2);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(R1);
		buttonGroup.add(R2);
		
		
		JButton button1 = new JButton("添加到题库");
		button1.setBounds(297, 417, 113, 38);
		add(button1);
		
		JLabel label = new JLabel("正确答案");
		label.setBounds(163, 348, 93, 31);
		add(label);
		label.setFont(f);
		label.setForeground(col);
		
		JLabel lblNewLabel = new JLabel("输入问题");
		lblNewLabel.setBounds(38, 75, 128, 15);
		add(lblNewLabel);
		
		ReadKnowledge rk = new ReadKnowledge();
		JComboBox comboBox = new JComboBox(rk.ReadAll("select * from 知识点 "));
		comboBox.setBounds(150, 21, 140, 30);
		add(comboBox);
		
		JLabel label_1 = new JLabel("知识点");
		label_1.setBounds(38, 21, 68, 31);
		add(label_1);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(150, 75, 427, 256);
		add(editorPane);
		
		JLabel label_2 = new JLabel("学科");
		label_2.setBounds(342, 21, 45, 31);
		add(label_2);
		
		JComboBox comboBox_1 = new JComboBox(rk.ReadAll("select * from  学科"));
		comboBox_1.setBounds(397, 21, 140, 30);
		add(comboBox_1);
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (editorPane.getText().length()<1) {
					JOptionPane.showMessageDialog(null, "请输入问题", "错误", JOptionPane.ERROR_MESSAGE);
				} else {
					sql = new ConnDB();
					String SqlStatements;
					SqlStatements = "insert into 判断题(question,answer,knowledge,subject) values('"
							+ editorPane.getText() + "' , '"+Choice[0]+"','"+comboBox.getSelectedItem()+"','"+comboBox_1.getSelectedItem()+"' )";
					sql.getRows(SqlStatements);
					editorPane.setText(null);
//					comboBox.setSelectedIndex(0);
					JOptionPane.showMessageDialog(null, "添加成功", "成功", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
	
	}
}
