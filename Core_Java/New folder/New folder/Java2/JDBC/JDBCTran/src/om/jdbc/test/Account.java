package om.jdbc.test;

import java.sql.*;

public class Account {
int bal;
int dabal,sabal,danbal,sanbal;
public void transfer(int sa,int da,int amt){
	Connection con=null;
	PreparedStatement ps1=null;
	PreparedStatement ps2=null;
	PreparedStatement ps3=null;
	
	try{
		con=JdbcUtil.getOracleConnection();
		con.setAutoCommit(false);
		con.setTransactionIsolation(2);
		ps1=con.prepareStatement("select bal from account where accno=?");
		ps1.setInt(1,da);
		ResultSet r1=ps1.executeQuery();
		ps3=con.prepareStatement("update account set bal=? where accno=?");
		ps3.setInt(1,100);
		ps3.setInt(2,1);
		ps3.executeUpdate();;
		if(r1.next()){
			dabal=r1.getInt(1);
		}else{
			throw new InvalidAccountNumberException(da);
		}
		danbal=dabal+amt;
		ps2=con.prepareStatement("update account set bal=? where accno=?");
		ps2.setInt(1,danbal);
		ps2.setInt(2,da);
		ps2.executeUpdate();
		
		ps1.setInt(1,sa);
		r1=ps1.executeQuery();
		if(r1.next()){
			sanbal=r1.getInt(1);
		}else{
			throw new InvalidAccountNumberException(sa);
		}
	    if(sanbal>=amt){
	    	sanbal-=amt;
	    }else{
	    		throw new InsufficientFundsException();
	    	}
	    ps2.setInt(1,sanbal);
	    ps2.setInt(2,sa);
	    ps2.executeUpdate();
	    con.commit();
	    }catch(Exception e1){
	    	try{
	    		con.rollback();
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
		}finally{
			try{
			if(ps1!=null)
				ps1.close();
			if(ps2!=null)
				ps2.close();
			
			if(con!=null)
				con.close();
			
			}catch(Exception s){
				s.printStackTrace();
			}
			}
		}
}

