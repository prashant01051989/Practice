package om.jdbc;
import java.sql.*;
import java.util.Enumeration;

public class Jdbc_BatchUpdate {
	
public static void main(String as[]){
	
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/jdbc1","root","prashant");
		st=con.createStatement();
		st.cancel();
		/*
		String sql1="insert into student values(116,'C','Blore','a@a.com')";
		st.addBatch(sql1);
		String sql2="insert into student values(117,'C','Blore','a@a.com')";
		st.addBatch(sql2);
		String sql3="insert into student values(118,'C','Blore','a@a.com')";
		st.addBatch(sql3);
		String sql4="insert into student values(119,'C','Blore','a@a.com')";
		st.addBatch(sql4);
		String sql5="insert into student values(120,'C','Blore','a@a.com')";
		st.addBatch(sql5);
		String sql6="insert into student values(121,'C','Blore','a@a.com')";
		st.addBatch(sql6);
		String sql7="insert into student values(122,'C','Blore','a@a.com')";
		st.addBatch(sql7);
		
		int []x=st.executeBatch();
		System.out.println(x.length);
		*/
		rs=st.executeQuery("select * from student");
		while(rs.next()){
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getString(3)+"\t");
			System.out.print(rs.getString(4)+"\t");
			System.out.println("");
		}
	}catch(Exception e){
		e.printStackTrace();
	}
}
}
