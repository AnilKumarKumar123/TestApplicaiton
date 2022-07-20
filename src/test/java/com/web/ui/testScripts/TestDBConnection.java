package com.web.ui.testScripts;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDBConnection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Step 1:
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Establish the connection 
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
		
		System.out.println("Connection created");
		
		
		
		//Step 3: write the quesry 
		
		java.sql.Statement st=con.createStatement();
		
		
		//REteritve the data 
		
		ResultSet rs=st.executeQuery("select * from students");
		
		while(rs.next())
		{
			System.out.print(rs.getString(1));
			System.out.print(rs.getString(2));
			System.out.print(rs.getString(3));
			System.out.print(rs.getString(4));
			System.out.println();
			
		}
		
		//close the connection 
		con.close();
		
	}

	
	
}
