package com.suda.view.panel;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.suda.JDBC.ConnDB;
import com.suda.UserInterface.frame.InterFaceframe;
import com.suda.UserInterface.frame.SwingResourceManager;
import com.suda.view.dialog.DeleteKnowledge;
import com.suda.view.dialog.DeleteSubject;
import com.suda.view.dialog.DeleteTest;


public 	class FileDelete extends JPanel {
	private ConnDB sql = new ConnDB();
	public FileDelete(final InterFaceframe cf) {
		super();
		setLayout(null);
		
		final JButton btnItem = new JButton();
		btnItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DeleteKnowledge ak = new DeleteKnowledge();
			ak.setVisible(true);
			}
		});
		
		btnItem.setMargin(new Insets(0, 0, 0, 0));
		btnItem.setIcon(SwingResourceManager.getIcon(FileDelete.class, "/IMG/IMGitem1.png"));
		btnItem.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnItem.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnItem.setBounds(6, 0, 130, 40);
		btnItem.setText("删除知识点");
		add(btnItem);

		final JButton btnType = new JButton();
		btnType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteTest at = new DeleteTest();
				at.setVisible(true);
			}
		});
		
		btnType.setMargin(new Insets(0, 0, 0, 0));
		btnType.setIcon(SwingResourceManager.getIcon(FileDelete.class, "/IMG/IMGtype.png"));
		btnType.setBounds(6, 40, 130, 40);
		btnType.setText("删除题型  ");
		add(btnType);

		final JButton button_2 = new JButton();
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteSubject as = new DeleteSubject();
				as.setVisible(true);
			}
		});
		
		button_2.setMargin(new Insets(0, 0, 0, 0));
		button_2.setIcon(SwingResourceManager.getIcon(FileDelete.class, "/IMG/IMGHomeadd.png"));
		button_2.setText("删除科目");
		button_2.setBounds(6, 80, 130, 40);
		add(button_2);

		
		//
	}


}
