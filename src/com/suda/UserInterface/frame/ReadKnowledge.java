package com.suda.UserInterface.frame;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Random;

import com.suda.JDBC.ConnDB;
public class ReadKnowledge {
	private ConnDB sql = new ConnDB();
//	private JDBC sql = new JDBC();
	
	public String[] ReadAll(String sql1) {
		ResultSet rs;
	    rs = sql.getResult(sql1);
	    int i = 0;
	    try {
			while(rs.next()){				 
				 i++;
			   }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	    
	    
	    String str2[] = new String[i];
		int j = 0;
		rs = sql.getResult(sql1);
	       try {
			while(rs.next()){
				 str2[j] = rs.getString(2);
				 j++;
			   }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	       return str2;
	}
	
	
	
	public String[] Test(String sql1) {
		ResultSet rs;
	    rs = sql.getResult(sql1);
	    int i = 0;
	    try {
			while(rs.next()){				 
				 i++;
			   }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	    
	    String str1[] = new String[i];
		int j = 0;
		rs = sql.getResult(sql1);
	       try {
			while(rs.next()){
				 str1[j] = rs.getString(1);
				 j++;
			   }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
//	       System.out.println(Arrays.deepToString(str1));

	       return str1;
	}
	

	
}
