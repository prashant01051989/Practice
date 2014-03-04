package om.jdbc;

import java.sql.*;
import java.util.Enumeration;
import java.util.Iterator;

import oracle.jdbc.driver.OracleDriver;

class c{
	void m1(){
		
	}
}

public class JdbcTest1 {
	static String s;
public static void main(String as[]){
	
	Student stu=new Student(5,"C","Blore","a@a.com");
	Connection con=null;
	Statement st=null;
	Statement st1=null;
	ResultSet rs=null;
	try{
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		OracleDriver od=new OracleDriver();
		
		Enumeration em=DriverManager.getDrivers();
		while(em.hasMoreElements()){
			Object o=em.nextElement();
			System.out.println(o);
		}
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");
		//1.	st=con.createStatement();
		//2.byDefault	st=con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
		//3.	st=con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
		//4.	st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		st1=con.createStatement();
		//String sql="insert into JLCstudent values("+stu.getSid()+",'"+stu.getSname()+"','"+stu.getEmail()+"','"+stu.getCity()+"')";
		//st.executeUpdate(sql);
		String sql="select * from JLCstudent where sid=2";
		rs=st.executeQuery(sql);
		/*while(rs.next()){
			
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getString(3)+"\t");
			System.out.print(rs.getString(4)+"\t");
			System.out.println("");
		}
		*/
		//System.out.println(rs.absolute(3));
		/*rs.afterLast();
		rs.previous();*/
		/*rs.beforeFirst();
		rs.next();*/
		/*
		rs.absolute(3);
		rs.deleteRow();
		*/
		/*
		rs.absolute(4);
		System.out.println(rs.findColumn("Email"));
		*/
		/*
		rs.absolute(-3);
		System.out.print(rs.getInt(1)+"\t");
		System.out.print(rs.getString(2)+"\t");
		System.out.print(rs.getString(3)+"\t");
		System.out.print(rs.getString(4)+"\t");
		System.out.println("");
		*/
	/*
		rs.last();
		System.out.println("rs.getFetchDirection(): "+rs.getFetchDirection());
		System.out.println("rs.getFetchSize(): "+rs.getFetchSize());
		System.out.println("rs.getRow(): "+rs.getRow());
		System.out.println("rs.getStatement(): "+rs.getStatement());
		System.out.println("rs.getType(): "+rs.getType());
		System.out.println("rs.getWarnings(): "+rs.getWarnings());
		rs.previous();
	*/
		/*
		rs.moveToInsertRow();
		rs.updateInt(1, 115);
		rs.updateString(2,"Raman");
		rs.insertRow();
		*/
		/*
		rs.updateString(2,"Anshu");
		rs.updateRow();
		*/
		/*
		rs.setFetchSize(10);
		System.out.println("rs.getFetchSize(): "+rs.getFetchSize());
		*/
		
	
				
			while(rs.next()){
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getString(3)+"\t");
			System.out.print(rs.getString(4)+"\t");
			System.out.println("");
		}
		st1.executeUpdate("update jlcstudent set sname=\'RAM\' where sid=2");
		rs.beforeFirst();
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
