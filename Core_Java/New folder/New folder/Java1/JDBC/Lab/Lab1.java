import java.sql.*;
class Lab1{
public static void main(String as[]){
Connection con=null;
Statement st=null;
try{
//1. Load the Driver Class.
Class.forName("oracle.jdbc.driver.OracleDriver");
//2. Establish the connection .
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");
//3.Create the required JDBC statement.
st=con.createStatement();
//4.Prepare the required SQL statement.
String sql="insert into ans values(12,'sd','sd@jlc',999,'Blore',234.34)";
//5.Submit the SQL statement to DB.
int x=st.executeUpdate(sql);
//6.Process the results
if(x==1){
System.out.println("Record is inserted...");
}else{
System.out.println("Sorry,Record is not inserted...");
}
}catch(Exception e){
e.printStackTrace();
}finally{
try{
if(st!=null)
st.close();
if(con!=null)
con.close();
}catch(Exception e){
e.printStackTrace();
}
}
}
}
/*create table ans (
sid int(3),
sname char(10),
email char(10),
phone int(10),
city char(10),
fee double(5,2));
*/