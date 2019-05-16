package com.suda.excel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBhepler {

	Connection con = null;
	ResultSet res = null;

	public void DataBase() {
		try {
			// 加载数据库驱动类
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				String url = "jdbc:sqlserver://localhost:1433; DatabaseName = TiKu";
				con = DriverManager.getConnection(url,"sa","123456");// 连接数据�?
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	// 查询
	public ResultSet  Search(String sql, String str[]) {
		DataBase();
		try {
			PreparedStatement pst =con.prepareStatement(sql);
			if (str != null) {
				for (int i = 0; i < str.length; i++) {
					pst.setString(i + 1, str[i]);
				}
			}
			res = pst.executeQuery();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	// 增删修改
	public int AddU(String sql, String str[]) {
		int a = 0;
		DataBase();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			if (str != null) {
				for (int i = 0; i < str.length; i++) {
					pst.setString(i + 1, str[i]);
				}
			}
			a = pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

}
