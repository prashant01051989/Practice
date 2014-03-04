package om.jdbc;
import java.sql.*;
import java.util.Enumeration;

public class JDBCTest2 {
	
public static void main(String as[]){
	
	Student stu=new Student(5,"C","Blore","a@a.com");
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/jdbc1","root","prashant");
		st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		String sql="select * from Student";
		rs=st.executeQuery(sql);
						
			while(rs.next()){
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getString(3)+"\t");
			System.out.print(rs.getString(4)+"\t");
			System.out.println("");
			}
		System.out.println("***********Statement*******************");
		
		System.out.println("**********DatabaseMetaData**************");
		DatabaseMetaData dm=con.getMetaData();
		System.out.println(dm.getJDBCMajorVersion() );
		System.out.println(dm.getJDBCMinorVersion());
		System.out.println(dm.getDatabaseMajorVersion());
		System.out.println(dm.getDatabaseMinorVersion());
		System.out.println(dm.getResultSetHoldability());
		System.out.println(dm.getDriverName());
		System.out.println(dm.getMaxConnections());
		System.out.println(dm.getMaxConnections());
	}catch(Exception e){
		e.printStackTrace();
	}
}
}
