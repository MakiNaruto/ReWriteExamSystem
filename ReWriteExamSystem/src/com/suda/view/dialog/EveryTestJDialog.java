package com.suda.view.dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.suda.JDBC.ConnDB;
import com.suda.UserInterface.frame.ReadKnowledge;
import javax.swing.JTextField;
public class EveryTestJDialog extends JDialog{
	private ConnDB sql = new ConnDB();
	 Font f = new Font("楷体",Font.TRUETYPE_FONT,16);
	 Color col = Color.BLUE;
	 private JTextField textField;
	 private JTextField textField_1;
	 private JTextField textField_2;
	 
	 public EveryTestJDialog() {
			getContentPane().setLayout(null);
			 JButton btnNewButton = new JButton("修改");
		        btnNewButton.setBounds(279, 419, 109, 40);
		        getContentPane().add(btnNewButton);
		        
		        
		        JLabel lblNewLabel = new JLabel("请选择题型");
		        lblNewLabel.setBounds(10, 33, 124, 30);
		        getContentPane().add(lblNewLabel);
		        
		        JLabel label = new JLabel("请输入问题");
		        label.setBounds(10, 130, 109, 30);
		        getContentPane().add(label);
		        
		        JLabel label_1 = new JLabel("请输入问题的答案");
		        label_1.setBounds(10, 271, 132, 30);
		        getContentPane().add(label_1);
		        
		        ReadKnowledge rk = new ReadKnowledge();
		        
		        JLabel label_2 = new JLabel("知识点");
		        label_2.setBounds(10, 73, 109, 31);
		        getContentPane().add(label_2);
		        
		        JEditorPane editorPane = new JEditorPane();
		        editorPane.setBounds(158, 130, 387, 114);
		        getContentPane().add(editorPane);
		        
		        JEditorPane editorPane_1 = new JEditorPane();
		        editorPane_1.setBounds(158, 271, 387, 114);
		        getContentPane().add(editorPane_1);
		        
		        JLabel label_3 = new JLabel("学科");
		        label_3.setBounds(354, 33, 46, 30);
		        getContentPane().add(label_3);
		        
		        textField = new JTextField();
		        textField.setBounds(158, 38, 130, 30);
		        getContentPane().add(textField);
		        textField.setColumns(10);
		        
		        textField_1 = new JTextField();
		        textField_1.setColumns(10);
		        textField_1.setBounds(410, 38, 130, 30);
		        getContentPane().add(textField_1);
		        
		        textField_2 = new JTextField();
		        textField_2.setColumns(10);
		        textField_2.setBounds(158, 78, 130, 30);
		        getContentPane().add(textField_2);
		        
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
		                    SqlStatements = "insert into "+"(问题,答案,知识点,学科) values('"
		                            + editorPane.getText() + "' , '"
		                            + editorPane_1.getText()+"','"+"' ,'"+"')";
		                    sql.getRows(SqlStatements);
		                    editorPane.setText(null);
		                    editorPane_1.setText(null);
		                    JOptionPane.showMessageDialog(null, "添加成功", "成功", JOptionPane.ERROR_MESSAGE);
		                }

		            }
		        });
		
			
	 }
}
