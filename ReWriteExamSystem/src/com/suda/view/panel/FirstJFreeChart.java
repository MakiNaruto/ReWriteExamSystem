package com.suda.view.panel;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.suda.UserInterface.frame.ReadKnowledge;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstJFreeChart extends JPanel{
	private String args[];
	private int count;
	ReadKnowledge rk = new ReadKnowledge();
	 private String countnumber;
	private List<Integer> list = new ArrayList<Integer>();
	private int i = 0;
	public FirstJFreeChart() {
		 setLayout(new BorderLayout(0, 0));
		
		 JScrollPane scrollPane = new JScrollPane();  
		 add(scrollPane);
		 DefaultPieDataset dpd = new DefaultPieDataset();
		 String[] str = rk.ReadAll("select * from 所有题型");
		
//		 System.out.println(count);
		 for (int i = 0; i < str.length; i++) {
			 args = rk.Test("select *  from  "+str[i]+" ");
			 GetNumber(args);
//			 list.removeAll(list);
			 dpd.setValue(str[i],count);
		}
//		 System.out.println(str[0]);
//		 System.out.println(Arrays.deepToString(str));
//		 dpd.setValue("管理人员",25);
//		 dpd.setValue("市场人员",25);
//		 dpd.setValue("开发人员",45);
//		 dpd.setValue("其他人员",60);
		 //Create JFreeChart object 
		  //参数可以查看源码 
		 JFreeChart pieChart = ChartFactory.createPieChart("各题型题量统计",dpd,true,true,false);
		 ChartPanel cp = new ChartPanel(pieChart);
		 scrollPane.add(cp);
		 scrollPane.setViewportView(cp);


		 
	} 
	public void GetNumber(String[] args){
		
		for (count = 0; count < args.length; count++) {
			int k = Integer.parseInt(args[count]);
//			list.add(k);
		}
		
		countnumber = count+"";
	
	}


} 