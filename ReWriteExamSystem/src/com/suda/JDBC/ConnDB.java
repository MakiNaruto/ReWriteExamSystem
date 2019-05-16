package com.suda.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

public class ConnDB {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement stmt = null;

	public Connection getConnection(){
		try {
			// 加载数据库驱动类
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			String url = "jdbc:sqlserver://localhost:1433; DatabaseName = TiKu";
//			
			con = DriverManager.getConnection(url,"sa","123456");// 连接数据库
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//关闭方法
	public void closeAll(){
		try {
			if(rs!=null){
				rs.close();
				rs = null;
			}
			if(pstmt!=null){
				pstmt.close();
				pstmt = null;
			}
			if(con!=null){
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//创建增删改的公共方法
	public int getRows(String sql){
		int rows = 0;
		con = getConnection();
		try {
			pstmt = con.prepareStatement(sql);
//			if(temp!=null){
//				for(int i = 0;i<temp.size();i++){
//					pstmt.setObject(i+1, temp.get(i));
//				}
//			}
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return rows;
	}
	
	//创建查的公共方法
	public ResultSet getResult(String sql){
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
//			if(temp!=null){
//				for(int i=0;i<temp.size();i++){
//					pstmt.setObject(i+1, temp.get(i));
//				}
//			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}
