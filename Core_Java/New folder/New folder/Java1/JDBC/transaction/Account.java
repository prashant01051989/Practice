package com.jdbc;
import java.sql.*;
import com.jdbc.util.*;
class Account
{
	int bal;
	int dabal,sabal,danbal,sanbal;
	public  void transfer(int sa,int da,int amt)
	{
		
		Connection con=null;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		ResultSet rs1=null;
		try
		{
			con=JdbcUtil.getOracleConnection();
			//start TX
			con.setAutoCommit(false);
			
			//op 1 select
			ps1=con.prepareStatement("select accno from account where accno=?");
			ps1.setInt(1,da);
			rs1=ps1.executeQuery();
			if(rs1.next())
			{
				dabal=rs1.getInt(1);
				System.out.println(dabal);
			}
			
			else
			{
			 throw new InvalidAccountNumberException(da);
			}
			danbal=dabal+amt;
			//op 2 update
			ps2=con.prepareStatement("update account set bal=? where accno=?");
			ps2.setInt(1,danbal);
			ps2.setInt(2,1);
			ps2.executeQuery();
			//op 3 select
			ps1.setInt(1,2);
			rs1=ps1.executeQuery();
			if(rs1.next())
			{
				sabal=rs1.getInt(1);
			}
			else
			{
				throw new InvalidAccountNumberException(2);
			}
			if(sabal>=amt)
			{
				sanbal=sabal-amt;
			}
			else
			{
				throw new InsufficientFundsException();
			}
			//op 4 update
			ps2.setInt(1,sanbal);
			ps2.setInt(2,2);
			ps2.executeUpdate();
			con.commit();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			JdbcUtil.cleanup(ps1,con,rs1);
			JdbcUtil.cleanup(ps2,con);
		}
	}
	
}