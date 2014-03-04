package om.jdbc;
import java.sql.*;
import java.util.Enumeration;

public class Jdbc_PreparedStatement {
	
public static void main(String as[]){
	
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/jdbc1","root","prashant");
		ps=con.prepareStatement("insert into student values(?,?,?,?)");
		System.out.println(ps);
		ps.setInt(1,125);
		ps.setString(2,"Prashant");
		ps.setString(3,"Patna");
		ps.setString(4,"p@p.com");
		
		int i=ps.executeUpdate();
		System.out.println(ps);
		System.out.println(i);
		rs=ps.executeQuery("select * from student");
		System.out.println(ps);
		while(rs.next()){
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getString(3)+"\t");
			System.out.print(rs.getString(4)+"\t");
			System.out.println("");
			}
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
		if(rs!=null)
			rs.close();
		if(ps!=null)
			ps.close();
		if(con!=null)
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
}
