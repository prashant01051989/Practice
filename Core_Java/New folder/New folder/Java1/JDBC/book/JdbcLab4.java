package com.jdbc;
import java.util.*;
public class JdbcLab4
{
	public static void main(String as[])
	{
		BooksService bm=new BooksService();
		//verify user
		int y=bm.verifyUser("sri","sri");
		System.out.println("y is"+y);
		//Adding The Book
		Book b=new Book("B-08","java","Srinivas","JLC","250","4","111-12");
		int x=bm.addBook(b);
		System.out.println("x is"+x);
		//Update Book
		Book bk=new Book("B-05","jDBC","SD","SD","250","4","111-12");
		int a=bm.updateBook(bk);
		System.out.println("a is"+a);
		//Delete Book
		int c=bm.deleteBook("B-08");
		System.out.println("c is"+c);
		//get Book by B-ID
		System.out.println("Book by B-ID");
		Book bo=bm.getBookByBid("B-05");
		System.out.println(bo);
		//Get Book by Bname
		System.out.println("Get Book by Bname");
		List list=bm.getBooksByBname("JDBC");
		Iterator it=list.iterator();
		while(it.hasNext())
		{
			Book boo=(Book)it.next();
			System.out.println("Book is::"+boo);
		}
		
		//Get Book by Author
		System.out.println("Get Book by Author");
		List list1=bm.getBooksByAuthor("Srinivas");
		Iterator it1=list1.iterator();
		while(it1.hasNext())
		{
			Book boo=(Book)it1.next();
			System.out.println("Book is::"+boo);
		}
		
		//Get Book by Publications
		System.out.println("Get Book by Publications");
		List list2=bm.getBooksByPub("JLC");
		Iterator it2=list2.iterator();
		while(it2.hasNext())
		{
			Book boo=(Book)it2.next();
			System.out.println("Book is::"+boo);
		}
		//Get Book by Cost
		System.out.println("Get Book by Cost");
		List list3=bm.getBooksByCost("250");
		Iterator it3=list3.iterator();
		while(it3.hasNext())
		{
			Book boo=(Book)it3.next();
			System.out.println("Book is::"+boo);
		}
		
		//Get Book by Isbn
		System.out.println("Get Book by Isbn");
		Book bo1=bm.getBooksByIsbn("111-12");
		System.out.println("Book is::"+bo1);
		
		
		//Get All Books 
		System.out.println("All Books");
		List list4=bm.getAllBooks();
		Iterator it4=list4.iterator();
		while(it4.hasNext())
		{
			Book boo=(Book)it4.next();
			System.out.println("Book is::"+boo);
		}
		
	}

}