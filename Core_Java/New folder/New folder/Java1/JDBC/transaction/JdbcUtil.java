package com.jdbc.util;
import java.sql.*;
public class JdbcUtil
{
	public static Connection getOracleConnection()
	{
		Connection con=null;
		try
		{
			//1. Load the Driver Class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. Establish the connection .
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tamanna");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	public static Connection getMysqlConnection()
	{
		Connection con=null;
		try
		{
			//1. Load the Driver Class
			Class.forName("com.mysql.jdbc.Driver");
			//2. Establish the connection .
			con=DriverManager.getConnection("jdbc:mysql://localhost/anshu","root","tamana");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	public static void cleanup(Statement st,Connection con)
	{
		try
		{
			if(st!=null)
			st.close();
			if(con!=null)
			con.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();	
		}
	}

	public static void cleanup(Statement st,Connection con,ResultSet rs)
	{
		try
		{
			if(st!=null)
			st.close();
			if(con!=null)
			con.close();
			if(rs!=null)
			rs.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();	
		}
	}
}