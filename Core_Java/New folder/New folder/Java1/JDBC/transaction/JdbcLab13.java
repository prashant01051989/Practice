package com.jdbc;
import com.jdbc.util.*;
import java.sql.*;
class JdbcLab13
{
	public static void main(String as[])
	{
		Account acc=new Account();
		acc.transfer(88,1,5000);
	}
}