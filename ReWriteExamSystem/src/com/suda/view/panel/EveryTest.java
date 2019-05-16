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
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.suda.JDBC.ConnDB;
import com.suda.UserInterface.frame.ReadKnowledge;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSplitPane;
public class EveryTest extends JPanel{
	private ConnDB sql = new ConnDB();
	 Font f = new Font("楷体",Font.TRUETYPE_FONT,16);
	 Color col = Color.BLUE;
	
	 public EveryTest() {
			setLayout(null);
			 JButton btnNewButton = new JButton("添加到题库");
		        btnNewButton.setBounds(210, 422, 109, 40);
		        add(btnNewButton);
		        
		        
		        JLabel lblNewLabel = new JLabel("请选择题型");
		        lblNewLabel.setBounds(10, 33, 176, 30);
		        add(lblNewLabel);
		        
		        JLabel label = new JLabel("请输入问题");
		        label.setBounds(10, 130, 161, 30);
		        add(label);
		        
		        JLabel label_1 = new JLabel("请输入问题的答案");
		        label_1.setBounds(10, 271, 161, 30);
		        add(label_1);
		        
		        ReadKnowledge rk = new ReadKnowledge();
		        JComboBox comboBox = new JComboBox(rk.ReadAll("select * from  题型"));
		        comboBox.setBounds(158, 33, 140, 30);
		        add(comboBox);
		        
		        JLabel label_2 = new JLabel("知识点");
		        label_2.setBounds(10, 73, 109, 31);
		        add(label_2);
		        
		        JComboBox comboBox_1 = new JComboBox(rk.ReadAll("select * from 知识点 "));
		        comboBox_1.setBounds(158, 73, 140, 30);
		        add(comboBox_1);
		        
		        JEditorPane editorPane = new JEditorPane();
		        editorPane.setBounds(158, 130, 387, 114);
		        add(editorPane);
		        
		        JEditorPane editorPane_1 = new JEditorPane();
		        editorPane_1.setBounds(158, 271, 387, 114);
		        add(editorPane_1);
		        
		        JLabel label_3 = new JLabel("学科");
		        label_3.setBounds(354, 33, 46, 30);
		        add(label_3);
		        
		        JComboBox comboBox_2 = new JComboBox(rk.ReadAll("select * from  学科"));
		        comboBox_2.setBounds(410, 33, 140, 30);
		        add(comboBox_2);
		        
		        btnNewButton.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                if (editorPane.getText().length() < 1 ) {
		                    JOptionPane.showMessageDialog(null, "请输入问题", "错误", JOptionPane.ERROR_MESSAGE);
		                } else if(editorPane_1.getText().length() < 1 ){
		                    JOptionPane.showMessageDialog(null, "请输入问题的答案", "错误", JOptionPane.ERROR_MESSAGE);
		                }
		                else{
		                    sql = new ConnDB();
		                    String SqlStatements;
		                    SqlStatements = "insert into "+comboBox.getSelectedItem()+"(question,answer,knowledge,subject) values('"
		                            + editorPane.getText() + "' , '"
		                            + editorPane_1.getText()+"','"+comboBox_1.getSelectedItem()+"' ,'"+comboBox_2.getSelectedItem()+"')";
		                    sql.getRows(SqlStatements);
		                    JOptionPane.showMessageDialog(null, "添加成功", "成功", JOptionPane.ERROR_MESSAGE);
		                    editorPane.setText(null);
		                    editorPane_1.setText(null);

		                }

		            }
		        });
		
			
	 }
}
