package com.suda.excel;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;

/**
 * @author Javen
 * @Email zyw205@gmail.com
 * 
 */
public class StuService {
	/**
	 * 查询stu表中所有的数据
	 * @return 
	 */
	public static List<TestSetGet> getAllByDb(){
		List<TestSetGet> list=new ArrayList<TestSetGet>();
		try {
			DBhepler db=new DBhepler();
			String sql="select * from 选择题";
			ResultSet rs= db.Search(sql, null);
			while (rs.next()) {
				int id=rs.getInt("id");
				String question = rs.getString("question");
				String choice = rs.getString("choice");
				String answer = rs.getString("answer");
				String knowledge = rs.getString("knowledge");
				String subject = rs.getString("subject");
				
				System.out.println(id+" "+question+" "+choice+" "+answer+" "+knowledge+"  "+subject);
				list.add(new TestSetGet(id,question,choice,answer,knowledge,subject));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<TestSetGetAll> getTheOtherDb(String sql){
		List<TestSetGetAll> list=new ArrayList<TestSetGetAll>();
		try {
			DBhepler db=new DBhepler();
//			String sql="select * from 选择题";
			ResultSet rs= db.Search(sql, null);
			while (rs.next()) {
				int id=rs.getInt("id");
				String question = rs.getString("question");
				String answer = rs.getString("answer");
				String knowledge = rs.getString("knowledge");
				String subject = rs.getString("subject");
				
				System.out.println(id+" "+question+"  "+answer+" "+knowledge+"  "+subject);
				list.add(new TestSetGetAll(id,question,answer,knowledge,subject));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 查询指定目录中电子表格中所有的数据
	 * @param file 文件完整路径
	 * @return
	 */
	public static List<TestSetGet> getAllByExcel(String file){
		List<TestSetGet> list=new ArrayList<TestSetGet>();
		try {
			Workbook rwb=Workbook.getWorkbook(new File(file));
			Sheet rs=rwb.getSheet("Test Shee 1");//或者rwb.getSheet(0)
			int clos=rs.getColumns();//得到所有的列
			int rows=rs.getRows();//得到所有的行
			
//			System.out.println(clos+" rows:"+rows);
			for (int i = 1; i < rows; i++) {
				for (int j = 0; j < clos; j++) {
					//第一个是列数，第二个是行数
					String id=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
					String question=rs.getCell(j++, i).getContents();
					String choice=rs.getCell(j++, i).getContents();
					String answer=rs.getCell(j++, i).getContents();
					String knowledge=rs.getCell(j++, i).getContents();
					String subject=rs.getCell(j++, i).getContents();
					System.out.println(Integer.parseInt(id)+" "+question+" "+choice+" "+answer+" "+knowledge+"  "+subject);
					list.add(new TestSetGet(Integer.parseInt(id),question,choice,answer,knowledge,subject));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return list;
		
	}
	
	
	public static List<TestSetGetAll> getTheOtherExcel(String file){
		List<TestSetGetAll> list=new ArrayList<TestSetGetAll>();
		try {
			Workbook rwb=Workbook.getWorkbook(new File(file));
			Sheet rs=rwb.getSheet("Test Shee 1");//或者rwb.getSheet(0)
			int clos=rs.getColumns();//得到所有的列
			int rows=rs.getRows();//得到所有的行
			
//			System.out.println(clos+" rows:"+rows);
			for (int i = 1; i < rows; i++) {
				for (int j = 0; j < clos; j++) {
					//第一个是列数，第二个是行数
					String id=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
					String question=rs.getCell(j++, i).getContents();
					String answer=rs.getCell(j++, i).getContents();
					String knowledge=rs.getCell(j++, i).getContents();
					String subject=rs.getCell(j++, i).getContents();
					System.out.println(Integer.parseInt(id)+" "+question+" "+answer+" "+knowledge+"  "+subject);
					list.add(new TestSetGetAll(Integer.parseInt(id),question,answer,knowledge,subject));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return list;
		
	}
	/**
	 * 通过Id判断是否存在
	 * @param id
	 * @param tixing 
	 * @return
	 */
	public static boolean isExist(int id){
		try {
			DBhepler db=new DBhepler();
			ResultSet rs=db.Search("select * from 选择题 where id=?", new String[]{id+""});
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean OtherisExist(int id, String tixing){
		try {
			DBhepler db=new DBhepler();
			ResultSet rs=db.Search("select * from "+tixing+" where id=?", new String[]{id+""});
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static void main(String[] args) {
		/*List<StuEntity> all=getAllByDb();
		for (StuEntity stuEntity : all) {
			System.out.println(stuEntity.toString());
		}*/
		
		System.out.println(isExist(1));
		
	}


	
}
