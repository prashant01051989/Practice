package om.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {

	public static Connection getOracleConnection() {
		Connection con=null;
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","prashant");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}

}
