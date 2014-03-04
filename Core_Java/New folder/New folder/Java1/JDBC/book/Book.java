package com.jdbc;
public class Book
{
	String bid;
	String bname;
	String author;
	String pub;
	String cost;
	String edi;
	String isbn;
	
	public Book()
	{
	}
	public Book(String bid,String bname,String author,String pub,String cost,String edi,String isbn)
	{
		this.bid=bid;
		this.bname=bname;
		this.author=author;
		this.pub=pub;
		this.cost=cost;
		this.edi=edi;
		this.isbn=isbn;
	}
	public String getBid()
	{
		return bid;
	}
	public void setBid(String bid)
	{
		this.bid=bid;
	}
	public String getBname()
	{
		return bname;
	}
	public void setBname(String bname)
	{
		this.bname=bname;
	}
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author=author;
	}
	public String getPub()
	{
		return pub;
	}
	public void setPub(String pub)
	{
		this.pub=pub;
	}
	public String getCost()
	{
		return cost;
	}
	public void setCost(String cost)
	{
		this.cost=cost;
	}
	public String getEdi()
	{
		return edi;
	}
	public void setEdi(String edi)
	{
		this.edi=edi;
	}public String getIsbn()
	{
		return isbn;
	}
	public void setIsbn(String isbn)
	{
		this.isbn=isbn;
	}
	public String toString()
	{
		return ""+bid+"\t"+bname+"\t"+author+"\t"+pub+"\t"+cost+"\t"+edi+"\t"+isbn;
	}
	
}