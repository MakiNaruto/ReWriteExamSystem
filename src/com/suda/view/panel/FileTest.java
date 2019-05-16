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


public 	class FileTest extends JPanel {
	private ConnDB sql = new ConnDB();
	public FileTest(final InterFaceframe cf) {
		super();
		setLayout(null);
		
		final JButton btnItem = new JButton();
		btnItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cf.setTitle("试卷生成系统 V1.0->试题管理->添加选择题");
				cf.textHelp.setText("");
				cf.textHelp.setText("根据对应的信息添加问题，选择题型，选项内容，答案。");
				
				MultipleChoice mc = new MultipleChoice();
				cf.c.show(cf.show,"Page");
				cf.spPage.setViewportView(mc);

			}
		});
		
		btnItem.setMargin(new Insets(0, 0, 0, 0));
		btnItem.setIcon(SwingResourceManager.getIcon(FileTest.class, "/IMG/IMGitem1.png"));
		btnItem.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnItem.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnItem.setBounds(6, 0, 130, 40);
		btnItem.setText("添加选择题");
		add(btnItem);

		final JButton btnType = new JButton();
		btnType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cf.setTitle("试卷生成系统 V1.0->试题管理->添加判断题");
				cf.textHelp.setText("");
				cf.textHelp.setText("根据对应的信息添加问题，判断题型，答案在判断处勾选。");
				TureOrFalse tof = new TureOrFalse();
				cf.c.show(cf.show,"Page");
				cf.spPage.setViewportView(tof);
			}
		});
		
		btnType.setMargin(new Insets(0, 0, 0, 0));
		btnType.setIcon(SwingResourceManager.getIcon(FileTest.class, "/IMG/IMGtype.png"));
		btnType.setBounds(6, 40, 130, 40);
		btnType.setText("添加判断题");
		add(btnType);

		final JButton button_2 = new JButton();
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cf.setTitle("试卷生成系统 V1.0->试题管理->添加问答题");
				cf.textHelp.setText("");
				cf.textHelp.setText("问答题型，为统一录入，写入问题，答案即可。");
				EveryTest et = new  EveryTest();
				cf.c.show(cf.show,"Page");
				cf.spPage.setViewportView(et);
				
//				TureOrFalse tof = new TureOrFalse();
//				cf.show.add(tof,"Page");
//				cf.spPage.setViewportView(tof);
			}
		});
		
		button_2.setMargin(new Insets(0, 0, 0, 0));
		button_2.setIcon(SwingResourceManager.getIcon(FileTest.class, "/IMG/IMGHomeadd.png"));
		button_2.setText("添加问答题");
		button_2.setBounds(6, 80, 130, 40);
		add(button_2);

		final JButton btnProduct = new JButton();
		btnProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cf.setTitle("试卷生成系统 V1.0->试题管理->删除/修改题库");
				cf.textHelp.setText("");
				cf.textHelp.setText("对题库进行更改，查询，删除操作。\n"+"  （1）下拉列表里选择相应的内容，列表会进行刷新\n"+
				"  （2）删除时，选择要删除的行，点击删除。\n"+"  （3）双击想要更改的内容，进行更改即可。\n"+"（4）。选择科目后点击筛选按钮才会进行刷新\n");
				CheckTestDatabase ctd = new CheckTestDatabase("select * from 选择题 order by cast(题号 as int)");
				cf.c.show(cf.show,"Page");
				cf.spPage.setViewportView(ctd);
			}
		});
		
		btnProduct.setMargin(new Insets(0, 0, 0, 0));
		btnProduct.setIcon(SwingResourceManager.getIcon(FileTest.class, "/IMG/IMGproduct.png"));
		btnProduct.setText("删除/修改题库");
		btnProduct.setBounds(6, 120, 130, 40);
		add(btnProduct);

	}


}
