package com.suda.view.panel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;


class LimitedTextField extends JTextField { 
	//重写textfiled，使得其格式只能输入数字
	public LimitedTextField(final String str,final int i) { 
		this.addKeyListener(new KeyAdapter() { 
			public void keyTyped(KeyEvent e) { 
					int code = e.getKeyChar(); 
					if(str!=null){
						String key=str;
						if(key.indexOf(e.getKeyChar())<0){
							e.consume();
						}
					}
					if( code == KeyEvent.VK_BACK_SPACE) { 
					      e.isActionKey(); 
					} else if(getDocument().getLength() >=i) { 
						  e.consume(); 
					} 	
			} 
		}); 
	} 
} 

	
