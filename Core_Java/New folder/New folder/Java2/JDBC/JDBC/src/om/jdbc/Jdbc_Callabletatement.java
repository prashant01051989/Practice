package om.jdbc;
import java.sql.*;
import java.util.Enumeration;

public class Jdbc_Callabletatement {
	
public static void main(String as[]){
	
	Connection con=null;
	CallableStatement cs=null;
	ResultSet rs=null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");
		cs=con.prepareCall("{call p1(?,?,?,?)}");
		cs.setInt(1,10);
		cs.setString(2,"Prashant");
		cs.setString(3, "Patna");
		cs.setString(4, "p@p.com");
		cs.execute();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
		if(rs!=null)
			rs.close();
		if(cs!=null)
			cs.close();
		if(con!=null)
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
}
