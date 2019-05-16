package com.suda.UserInterface.frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import org.jvnet.substance.skin.SubstanceEmeraldDuskLookAndFeel;
import org.jvnet.substance.skin.SubstanceMagmaLookAndFeel;
import org.jvnet.substance.skin.SubstanceNebulaLookAndFeel;
import org.jvnet.substance.skin.SubstanceRavenLookAndFeel;

import com.suda.view.dialog.InAndOut;
import com.suda.view.panel.BrowseTestDatabase;
import com.suda.view.panel.CheckTestDatabase;
import com.suda.view.panel.FileAdd;
import com.suda.view.panel.FileDelete;
import com.suda.view.panel.FileTest;
import com.suda.view.panel.FirstJFreeChart;
import com.suda.view.panel.MakeTestPaperKnowLedge;
import com.suda.view.panel.MakeTestPaperMain;
import com.suda.view.panel.Manual;
import com.suda.view.panel.forcopy;

public class InterFaceframe extends JFrame {
	
	public JPanel show= new JPanel();
	public final JScrollPane spPage = new JScrollPane();
	public CardLayout c = new CardLayout();
	FileTest ft = new FileTest(InterFaceframe.this);
	FileAdd fa = new FileAdd(InterFaceframe.this);
	FileDelete fd = new FileDelete(InterFaceframe.this);
	private JPanel contentPane;
	public JTextPane textHelp = new JTextPane();
//	final JMenu menClient = new JMenu();
	/**
	 * Launch the application.
	 */
	public static void main(String args[]) {
		JFrame.setDefaultLookAndFeelDecorated(true);
//		JDialog.setDefaultLookAndFeelDecorated(true);
		try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");   
        } catch (Exception e) {   
            System.out.println("Substance Raven Graphite failed to initialize");   
        }
      SwingUtilities.invokeLater(new Runnable() {   
      public void run() {   
    	  InterFaceframe dialog = new InterFaceframe();
    	  dialog.setVisible(true); 
      }   
  }); 

	}


	/**
	 * Create the frame.
	 */
	public InterFaceframe() {
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(150, 20, 1120, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		contentPane.setLayout(new BorderLayout(0, 0));
		JToolBar toolBar = new JToolBar();
		//将前面的竖线隐藏掉
		toolBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		setTitle("试卷生成系统 V1.0");
		textHelp.setText("欢迎来到试卷生成系统");
		
//		JButton btnNewButton = new JButton("欢     迎     界     面");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				setTitle("试卷生成系统 V1.0-");
//				textHelp.setText("欢迎来到试卷生成系统");
//				
//			}
//		});
//		btnNewButton.setMargin(new Insets(0, 0, 0, 0));
//		btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
//		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
//		btnNewButton.setIcon(SwingResourceManager.getIcon(InterFaceframe.class,
//				"/IMG/welcome.png"));
//		toolBar.add(btnNewButton);

		JButton main= new JButton("试  卷  随  机  生  成");
		main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("试卷生成系统 V1.0->试卷生成");
				textHelp.setText("试卷生成页面。\n"+"由于要出2份试卷，输入的题量应是对应题型题库数量的一半，如果为奇数向下取整。\n");
				MakeTestPaperMain mtp = new MakeTestPaperMain();
				c.show(show, "Page");
				spPage.setViewportView(mtp);
			}
		});
		main.setMargin(new Insets(0, 0, 0, 0));
		main.setVerticalTextPosition(SwingConstants.BOTTOM);
		main.setHorizontalTextPosition(SwingConstants.CENTER);
		main.setIcon(SwingResourceManager.getIcon(InterFaceframe.class,
				"/IMG/maketestpaper.png"));
		toolBar.add(main);
		
		
		//快捷测试，后期删掉
		JButton knowledge = new JButton("知 识 点 随 机 生 成");
		knowledge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTitle("试卷生成系统 V1.0->试卷生成");
				textHelp.setText("试卷生成页面。\n"+"由于要出2份试卷，输入的题量应是对应题型题库数量的一半，如果为奇数向下取整。\n");
				MakeTestPaperKnowLedge mtpk = new MakeTestPaperKnowLedge();
				c.show(show, "Page");
				spPage.setViewportView(mtpk);
			}
		});
		knowledge.setMargin(new Insets(0, 0, 0, 0));
		knowledge.setVerticalTextPosition(SwingConstants.BOTTOM);
		knowledge.setHorizontalTextPosition(SwingConstants.CENTER);
		knowledge.setIcon(SwingResourceManager.getIcon(InterFaceframe.class,
				"/IMG/maketestpaper.png"));
		toolBar.add(knowledge);
		
		
		//快捷测试，后期删掉
		JButton manual = new JButton("手    动    组     卷");
		manual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				setTitle("试卷生成系统 V1.0->试卷生成");
//				textHelp.setText("试卷生成页面。\n"+"由于要出2份试卷，输入的题量应是对应题型题库数量的一半，如果为奇数向下取整。\n");
				Manual  mtp = new Manual("select * from 选择题 order by cast(题号 as int)");
//				forcopy  mtp = new forcopy();
//				MakeTestPaperMain mtp = new MakeTestPaperMain();
				c.show(show, "Page");
				spPage.setViewportView(mtp);
			}
		});
		manual.setMargin(new Insets(0, 0, 0, 0));
		manual.setVerticalTextPosition(SwingConstants.BOTTOM);
		manual.setHorizontalTextPosition(SwingConstants.CENTER);
		manual.setIcon(SwingResourceManager.getIcon(InterFaceframe.class,
				"/IMG/maketestpaper.png"));
		toolBar.add(manual);
		
		JButton inandout = new JButton("导    入    导    出");
		inandout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InAndOut iao = new InAndOut();
				iao.setVisible(true);
			}
		});
		inandout.setMargin(new Insets(0, 0, 0, 0));
		inandout.setVerticalTextPosition(SwingConstants.BOTTOM);
		inandout.setHorizontalTextPosition(SwingConstants.CENTER);
		inandout.setIcon(SwingResourceManager.getIcon(InterFaceframe.class,
				"/IMG/maketestpaper.png"));
		toolBar.add(inandout);
		
		JButton btnNewButton_1 = new JButton("题     型     统     计");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textHelp.setText("对各个题型数量进行统计，以百分比图表显示");
				FirstJFreeChart mtp = new FirstJFreeChart();
				c.show(show, "Page");
				spPage.setViewportView(mtp);
			}
		});
		btnNewButton_1.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.setIcon(SwingResourceManager.getIcon(InterFaceframe.class,
				"/IMG/testcount.png"));
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("查     看     题     库");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textHelp.setText("仅提供了查询的功能\n"+"  （1）下拉列表里选择相应的内容，列表会进行刷新\n"+
						"  （2）筛选是从题型筛选的。\n"+"（3）。选择科目后点击筛选按钮才会进行刷新\n");
				BrowseTestDatabase btd = new BrowseTestDatabase("select * from 选择题 order by cast(题号 as int)");
//				CheckTestDatabase ctd = new CheckTestDatabase("select * from 选择题 order by cast(题号 as int)");
				c.show(show, "Page");
				spPage.setViewportView(btd);
			}
		});
		btnNewButton_2.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_2.setIcon(SwingResourceManager.getIcon(InterFaceframe.class,
				"/IMG/watchtest.png"));
		toolBar.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("退     出     系     统");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(-1);
			}
		});
		btnNewButton_3.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton_3.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_3.setIcon(SwingResourceManager.getIcon(InterFaceframe.class,
				"/IMG/exit.png"));
		toolBar.add(btnNewButton_3);
		

		JSplitPane splitPane = new JSplitPane();
		//调节分隔栏宽度
		splitPane.setDividerSize(10);
		//左右可调节隐藏
		splitPane.setOneTouchExpandable(true);
		//使左边的占据宽度为150
		splitPane.setDividerLocation(190);
		getContentPane().add(splitPane, BorderLayout.CENTER);
		contentPane.add(splitPane);
	//----------------------------布局----------------------------
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new BorderLayout());
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BorderLayout());
		scrollPane.setViewportView(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(new BorderLayout());
		panel_1.add(panel_2,BorderLayout.NORTH);
		
		JToggleButton btnTest = new JToggleButton("试题管理");
		panel_2.add(btnTest, BorderLayout.NORTH);
		
		
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		panel_2.add(p1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(new BorderLayout());
		panel_2.add(panel_3,new BorderLayout().SOUTH);
		
		JToggleButton btnAdd = new JToggleButton("添加知识点、题型、学科");
		panel_3.add(btnAdd, BorderLayout.NORTH);
		
		JPanel p2 = new JPanel();
		panel_3.add(p2);
		p2.setLayout(new BorderLayout());
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BorderLayout());
		
		JToggleButton FileDelete = new JToggleButton("删除知识点、题型、学科");
		panel_4.add(FileDelete, BorderLayout.NORTH);
		
		JPanel p3 = new JPanel();
		panel_4.add(p3);
		p3.setLayout(new BorderLayout());
		

		final JPanel panel_6 = new JPanel();
		panel_6.setPreferredSize(new Dimension(0, 200));
		panel_6.setLayout(new BorderLayout());
		panel.add(panel_6, BorderLayout.SOUTH);
		
		final JLabel help = new JLabel();
		help.setVerticalAlignment(SwingConstants.BOTTOM);
		help.setHorizontalAlignment(SwingConstants.LEFT);
		help.setForeground(Color.PINK);
		help.setFont(new Font("@BatangChe", Font.BOLD, 12));
		help.setVerticalTextPosition(SwingConstants.BOTTOM);
		help.setIcon(SwingResourceManager.getIcon(InterFaceframe.class,
				"/IMG/readme.png"));
		help.setText("小提示：");
		panel_6.add(help, BorderLayout.NORTH);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_6.add(scrollPane_1);
		
		scrollPane_1.setViewportView(textHelp);
		textHelp.setFont(new Font("", Font.PLAIN, 11));
		textHelp.setEditable(false);
		

		splitPane.setRightComponent(show);
		show.setLayout(c);
		
		spPage.setName("Page");
		show.add(spPage, spPage.getName());
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setName("Page");
		show.add(spPage, spPage.getName());
		
		JPanel panPic = new JPanel();
		show.add(panPic, "name_17678827713176");
		
		final JLabel label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setIcon(SwingResourceManager.getIcon(InterFaceframe.class,
				"/IMG/pic801.png"));
		panPic.add(label, BorderLayout.CENTER);

		spPage.setName("Page");
		show.add(spPage, spPage.getName());

		
		btnTest.setHorizontalAlignment(SwingConstants.LEFT);
		btnTest.setIcon(SwingResourceManager.getIcon(InterFaceframe.class,
				"/IMG/IMGu.png"));
		btnTest.setBackground(new Color(137, 192, 248));
		
		btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdd.setIcon(SwingResourceManager.getIcon(InterFaceframe.class,
				"/IMG/IMGu.png"));
		btnAdd.setBackground(new Color(137, 192, 248));
		
		FileDelete.setHorizontalAlignment(SwingConstants.LEFT);
		FileDelete.setIcon(SwingResourceManager.getIcon(InterFaceframe.class,
				"/IMG/IMGu.png"));
		FileDelete.setBackground(new Color(137, 192, 248));
//		FileDelete
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(new BorderLayout());
		panel_1.add(panel_5, BorderLayout.SOUTH);
	
		JPanel south = new JPanel();
		//不理解意思，抽空理解其含义，应该是根据加入的部件平均分配布局
		south.setLayout(new GridLayout(1, 0));
		south.setBorder(new BevelBorder(BevelBorder.LOWERED));
		south.setPreferredSize(new Dimension(0, 30));
		contentPane.add(south, BorderLayout.SOUTH);
		
		final JLabel labWelcome = new JLabel();
		labWelcome.setBackground(new Color(128, 128, 255));
		labWelcome.setBorder(new EtchedBorder(BevelBorder.RAISED, null, null));
		labWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		labWelcome.setForeground(Color.BLUE);
		labWelcome.setIcon(SwingResourceManager.getIcon(InterFaceframe.class,
				"/IMG/welcome.png"));
		labWelcome.setHorizontalTextPosition(SwingConstants.RIGHT);
		labWelcome.setText("欢迎使用试卷生成系统！");
		south.add(labWelcome);

		final JLabel labTime = new JLabel();
		labTime.setBorder(new BevelBorder(BevelBorder.LOWERED));
		labTime.setHorizontalAlignment(SwingConstants.RIGHT);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 EE ");
		labTime.setText(sdf.format(date));
		labTime.setHorizontalTextPosition(SwingConstants.RIGHT);
		labTime.setForeground(Color.RED);
		south.add(labTime);
		
		//---------------菜单栏------------------------------------
		
		final JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		final JMenu toolMenu = new JMenu();
		toolMenu.setText("工具");
		menuBar.add(toolMenu);
		
		final JMenuItem Iternet = new JMenuItem();
		Iternet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runtime run = Runtime.getRuntime();
				try {
					run.exec("cmd /E:ON /C start iexplore");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Iternet.setText("浏览器");
		toolMenu.add(Iternet);

		final JMenuItem miNote = new JMenuItem();
		miNote.addActionListener(new ActionListener() { // 记事本
					public void actionPerformed(ActionEvent e) {
						Runtime run = Runtime.getRuntime();
						try {
							run.exec("cmd /E:ON /C start notepad");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
		miNote.setText("记事本");
		toolMenu.add(miNote);

		final JMenuItem miCalc = new JMenuItem();
		miCalc.addActionListener(new ActionListener() {// 计算器
					public void actionPerformed(ActionEvent e) {
						Runtime run = Runtime.getRuntime();
						try {
							run.exec("cmd /E:ON /C start calc");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
		miCalc.setText("计算器");
		toolMenu.add(miCalc);

		final JMenuItem miOsk = new JMenuItem();
		miOsk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runtime run = Runtime.getRuntime();
				try {
					run.exec("cmd /E:ON /C start osk");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		miOsk.setText("软键盘");
		toolMenu.add(miOsk);
		
		final JMenu look = new JMenu();
		look.setText("皮肤");
		menuBar.add(look);
		
		final JMenuItem emeraldduskMenuItem = new JMenuItem();
		emeraldduskMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager
							.setLookAndFeel(new SubstanceEmeraldDuskLookAndFeel());
				} catch (UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(InterFaceframe.this);
			}
		});
		emeraldduskMenuItem.setText("EmeraldDusk");
		look.add(emeraldduskMenuItem);

		final JMenuItem magmaMenuItem = new JMenuItem();
		magmaMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(new SubstanceMagmaLookAndFeel());
				} catch (UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(InterFaceframe.this);
			}
		});
		magmaMenuItem.setText("Magma");
		look.add(magmaMenuItem);

		final JMenuItem brickwallMenuItem = new JMenuItem();
		look.add(brickwallMenuItem);
		brickwallMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(new SubstanceNebulaLookAndFeel());
				} catch (UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(InterFaceframe.this);
			}
		});
		brickwallMenuItem.setText("Nebula");

		final JMenuItem ravenMenuItem = new JMenuItem();
		look.add(ravenMenuItem);
		ravenMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UIManager.setLookAndFeel(new SubstanceRavenLookAndFeel());
				} catch (UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(InterFaceframe.this);
			}
		});
		ravenMenuItem.setText("Raven");


		final JMenuItem nimbusMenuItem = new JMenuItem();
		nimbusMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				SwingUtilities.updateComponentTreeUI(InterFaceframe.this);
			}
		});
		nimbusMenuItem.setText("Nimbus");
		look.add(nimbusMenuItem);

		btnTest.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setTitle("试卷生成系统 V1.0->试题管理");
				textHelp.setText("");
				textHelp.setText("对选择题，判断题，应用题等等试题的添加");
				if (btnTest.isSelected()) {
					btnTest.setIcon(SwingResourceManager.getIcon(
							InterFaceframe.class, "/IMG/IMGunselec.png"));
					ft.setPreferredSize(new Dimension(130, panel_1.getHeight()
							- btnTest.getHeight() * 5));
					p1.add(ft, BorderLayout.CENTER);
				} else {
					setTitle("试卷生成系统 V1.0");
					btnTest.setIcon(SwingResourceManager.getIcon(
							InterFaceframe.class, "/IMG/IMGu.png"));
					p1.removeAll();
				}
				scrollPane.setViewportView(panel_1);
			}
		});
		
		btnAdd.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setTitle("试卷生成系统 V1.0->添加题型、知识点、科目");
				textHelp.setText("");
				textHelp.setText("添加题型，知识点，以及科目。");
				if (btnAdd.isSelected()) {
					btnAdd.setIcon(SwingResourceManager.getIcon(
							InterFaceframe.class, "/IMG/IMGunselec.png"));
					fa.setPreferredSize(new Dimension(130, panel_1.getHeight()
							- btnAdd.getHeight() * 5));
					p2.add(fa, BorderLayout.CENTER);
				} else {
					setTitle("试卷生成系统 V1.0");
					btnAdd.setIcon(SwingResourceManager.getIcon(
							InterFaceframe.class, "/IMG/IMGu.png"));
					p2.removeAll();
				}
				scrollPane.setViewportView(panel_1);
			}
		});
		
		FileDelete.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setTitle("试卷生成系统 V1.0->删除题型、知识点、科目");
				textHelp.setText("");
				textHelp.setText("删除题型，知识点，以及科目。");
				if (FileDelete.isSelected()) {
					FileDelete.setIcon(SwingResourceManager.getIcon(
							InterFaceframe.class, "/IMG/IMGunselec.png"));
					fd.setPreferredSize(new Dimension(130, panel_1.getHeight()
							- FileDelete.getHeight() * 5));
					p3.add(fd, BorderLayout.CENTER);
				} else {
					setTitle("试卷生成系统 V1.0");
					FileDelete.setIcon(SwingResourceManager.getIcon(
							InterFaceframe.class, "/IMG/IMGu.png"));
					p3.removeAll();
				}
				scrollPane.setViewportView(panel_1);
			}
		});


	}
}
