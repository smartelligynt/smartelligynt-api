package com.smartelligynt.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestAWSMySQLConnection {
	
	public static void main (String [] args) throws InstantiationException, IllegalAccessException
	{
		
		    Connection connection = null;
		    try
		    {
		      // the mysql driver string
		    	Class.forName("com.mysql.jdbc.Driver").newInstance();
		    
		      // the mysql url
		      String url = "jdbc:mysql://smartelligynt-mysql.cvyiyawijdj9.us-west-2.rds.amazonaws.com:3306/smartelligyntdb";
		      
		      // get the mysql database connection
		      connection = DriverManager.getConnection(url,"mysql_admin", "Smart$123");
		      
		      // now do whatever you want to do with the connection
		      // ...
		      
		    }
		    catch (ClassNotFoundException e)
		    {
		      e.printStackTrace();
		      System.exit(1);
		    }
		    catch (SQLException e)
		    {
		      e.printStackTrace();
		      System.exit(2);
		    }
		
	}

}
