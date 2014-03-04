 package com.jdbc;
import java.sql.*;
import java.util.*;
import com.jdbc.util.*;
class BooksService
{
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		public int verifyUser(String un,String pw)
		{
			int x=0;
			try
			{
				con=JdbcUtil.getMysqlConnection();
				ps=con.prepareStatement("select * from user_table where username=? and password=?");
				ps.setString(1,un);
				ps.setString(2,pw);
				rs=ps.executeQuery();
				if(rs.next())
				{
					x=1;
				}
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
			 JdbcUtil.cleanup(ps,con,rs);
			}
			return x;
		}	
		
		public int addBook(Book bo)
		{
			int x=0;
			try
			{
				con=JdbcUtil.getMysqlConnection();
				ps=con.prepareStatement("insert into jlcbooks values(?,?,?,?,?,?,?)");
				ps.setString(1,bo.getBid());
				ps.setString(2,bo.getBname());
				ps.setString(3,bo.getAuthor());
				ps.setString(4,bo.getPub());
				ps.setString(5,bo.getCost());
				ps.setString(6,bo.getEdi());
				ps.setString(7,bo.getIsbn());
				x=ps.executeUpdate();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
			 JdbcUtil.cleanup(ps,con);
			}
			return x;
		}
		
		public int updateBook(Book bo)
		{
			int x=0;
			try
			{
				con=JdbcUtil.getMysqlConnection();
				System.out.println("update 2");
				ps=con.prepareStatement("update jlcbooks set bname=?,author=?,pub=?,cost=?,edition=?,isbn=? where bid=?");
				System.out.println("update 3");
				System.out.println(bo.getBid());
				ps.setString(7,bo.getBid());
				ps.setString(1,bo.getBname());
				ps.setString(2,bo.getAuthor());
				ps.setString(3,bo.getPub());
				ps.setString(4,bo.getCost());
				ps.setString(5,bo.getEdi());
				ps.setString(6,bo.getIsbn());
				x=ps.executeUpdate();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
			 JdbcUtil.cleanup(ps,con);
			}
			return x;
		}
		
		public int deleteBook(String bid)
		{
			int x=0;
			try
			{
				con=JdbcUtil.getMysqlConnection();
				ps=con.prepareStatement("delete from jlcbooks where bid=?");
				ps.setString(1,bid);
				x=ps.executeUpdate();
			
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
			 JdbcUtil.cleanup(ps,con);
			}
			return x;
		}
		
		public Book getBookByBid(String bid)
		{
			Book bo=null;
			try
			{
				con=JdbcUtil.getMysqlConnection();
				ps=con.prepareStatement("select *from jlcbooks where bid=?");
				ps.setString(1,bid);
				rs=ps.executeQuery();
				if(rs.next())
				{
					bo=new Book();
					bo.setBid(rs.getString(1));
					bo.setBname(rs.getString(2));
					bo.setAuthor(rs.getString(3));
					bo.setPub(rs.getString(4));
					bo.setCost(rs.getString(5));
					bo.setEdi(rs.getString(6));
					bo.setIsbn(rs.getString(7));
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
			 JdbcUtil.cleanup(ps,con);
			}
			return bo;
		}
	
		public List getBooksByBname(String bname)
		{
			List al=new ArrayList();
			try
			{
				con=JdbcUtil.getMysqlConnection();
				ps=con.prepareStatement("select *from jlcbooks where bname=?");
				ps.setString(1,bname);
				rs=ps.executeQuery();
				if(rs.next())
				{
					Book bo=new Book();
					bo.setBid(rs.getString(1));
					bo.setBname(rs.getString(2));
					bo.setAuthor(rs.getString(3));
					bo.setPub(rs.getString(4));
					bo.setCost(rs.getString(5));
					bo.setEdi(rs.getString(6));
					bo.setIsbn(rs.getString(7));
					al.add(bo);
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
			 JdbcUtil.cleanup(ps,con);
			}
			return al;
		}
		
		public List getBooksByAuthor(String author)
		{
			List al=new ArrayList();
			try
			{
				con=JdbcUtil.getMysqlConnection();
				ps=con.prepareStatement("select *from jlcbooks where author=?");
				ps.setString(1,author);
				rs=ps.executeQuery();
				while(rs.next())
				{
					Book bo=new Book();
					bo.setBid(rs.getString(1));
					bo.setBname(rs.getString(2));
					bo.setAuthor(rs.getString(3));
					bo.setPub(rs.getString(4));
					bo.setCost(rs.getString(5));
					bo.setEdi(rs.getString(6));
					bo.setIsbn(rs.getString(7));
					al.add(bo);
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
			 JdbcUtil.cleanup(ps,con);
			}
			return al;
		}
		
		public List getBooksByPub(String pub)
		{
			List al=new ArrayList();
			try
			{
				con=JdbcUtil.getMysqlConnection();
				ps=con.prepareStatement("select *from jlcbooks where pub=?");
				ps.setString(1,pub);
				rs=ps.executeQuery();
				while(rs.next())
				{
					Book bo=new Book();
					bo.setBid(rs.getString(1));
					bo.setBname(rs.getString(2));
					bo.setAuthor(rs.getString(3));
					bo.setPub(rs.getString(4));
					bo.setCost(rs.getString(5));
					bo.setEdi(rs.getString(6));
					bo.setIsbn(rs.getString(7));
					al.add(bo);
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
			 JdbcUtil.cleanup(ps,con);
			}
			return al;
		}
		
		public List getBooksByCost(String cost)
		{
			List al=new ArrayList();
			try
			{
				con=JdbcUtil.getMysqlConnection();
				ps=con.prepareStatement("select *from jlcbooks where cost=?");
				ps.setString(1,cost);
				rs=ps.executeQuery();
				while(rs.next())
				{
					Book bo=new Book();
					bo.setBid(rs.getString(1));
					bo.setBname(rs.getString(2));
					bo.setAuthor(rs.getString(3));
					bo.setPub(rs.getString(4));
					bo.setCost(rs.getString(5));
					bo.setEdi(rs.getString(6));
					bo.setIsbn(rs.getString(7));
					al.add(bo);
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
			 JdbcUtil.cleanup(ps,con);
			}
			return al;
		}
		
		public Book getBooksByIsbn(String isbn)
		{
			Book bo=null;
			try
			{
				con=JdbcUtil.getMysqlConnection();
				ps=con.prepareStatement("select *from jlcbooks where isbn=?");
				ps.setString(1,isbn);
				rs=ps.executeQuery();
				if(rs.next())
				{
					bo=new Book();
					bo.setBid(rs.getString(1));
					bo.setBname(rs.getString(2));
					bo.setAuthor(rs.getString(3));
					bo.setPub(rs.getString(4));
					bo.setCost(rs.getString(5));
					bo.setEdi(rs.getString(6));
					bo.setIsbn(rs.getString(7));
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
			 JdbcUtil.cleanup(ps,con);
			}
			return bo;
		}
		
		public List getAllBooks()
		{
			List al=new ArrayList();
			try
			{
				con=JdbcUtil.getMysqlConnection();
				ps=con.prepareStatement("select *from jlcbooks ");
				rs=ps.executeQuery();
				while(rs.next())
				{
					Book bo=new Book();
					bo.setBid(rs.getString(1));
					bo.setBname(rs.getString(2));
					bo.setAuthor(rs.getString(3));
					bo.setPub(rs.getString(4));
					bo.setCost(rs.getString(5));
					bo.setEdi(rs.getString(6));
					bo.setIsbn(rs.getString(7));
					al.add(bo);
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
			 JdbcUtil.cleanup(ps,con);
			}
			return al;
		}
		
		
	
}

