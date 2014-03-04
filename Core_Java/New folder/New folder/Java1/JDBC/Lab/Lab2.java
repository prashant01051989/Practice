import java.sql.*;
class Lab2
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
		try
		{
			//1. Load the Driver Class.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. Establish the connection .
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tamanna");
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
		}catch(Exception e)
			{
				e.printStackTrace();
			}
		finally
		{
			try
			{
				if(st!=null)
				st.close();
				if(con!=null)
				con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
