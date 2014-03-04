package com;
import java.sql.*;
import com.jdbc.util.*;
class Lab4
{
	public static void main(String as[])
	{
		int sid=Integer.parseInt(as[0]);
		String sn=as[1];
		String em=as[2];
		long ph=Long.parseLong(as[3]);
		String ci=as[4];
		double fee=Double.parseDouble(as[5]);
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try
		{
			con=JdbcUtil.getOracleConnection();
			//3.Create the required JDBC statement.
			st=con.createStatement();
			//4.Prepare the required SQL statement.
			String sql="insert into anshu values("+sid+",'"+sn+"','"+em+"',"+ph+",'"+ci+"',"+fee+")";
			System.out.println(sql);
			//5.Submit the SQL statement to DB.
			int x=st.executeUpdate(sql);
			//6.Process the results
			if(x==1)
			{
				System.out.println("Record is inserted...");
			}
			else
			{
				System.out.println("Sorry,Record is not inserted...");
			}
			//4.Prepare the required SQL statement.
			String sql1="select *from anshu";
			rs=st.executeQuery(sql1);
			//6.Process the results
			while(rs.next())
			{
				sid=rs.getInt(1);
				sn=rs.getString(2);
				em=rs.getString(3);
				ph=rs.getLong(4);
				ci=rs.getString(5);
				fee=rs.getDouble(6);
				System.out.println(sid+"\t"+sn+"\t"+em+"\t"+ph+"\t"+ci+"\t"+fee);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		finally
		{
			JdbcUtil.cleanup(st,con,rs);
		}
	}
}
