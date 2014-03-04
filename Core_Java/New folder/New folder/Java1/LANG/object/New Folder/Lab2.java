class Customer
{
	 int cid;
	 String cname;
	 String email;
	 long phone;
	Customer()
	{}
	Customer(int cid,String cname,String email,long phone)
	{
		this.cid=cid;
		this.cname=cname;
		this.email=email;
		this.phone=phone;
	}
	void show()
	{
		System.out.println("cid"+"\t"+"cname"+"\t"+"email"+"\t"+"phone");
		System.out.println(cid+"\t"+cname+"\t"+email+"\t"+phone);
	}
	public int hashcode()
	{
		System.out.println("inside hashcode()...");
		int x=20;
		return x;
	}
	public boolean equals(Object o)
	{
		Customer c=(Customer)o;
		if(this.cid==c.cid && this.cname.equals(c.cname))
		{
			return true;
		}
		return false;
	}
	public String toString()
	{
		return ""+cid+"\t"+cname+"\t"+email+"\t"+phone;
	}
}

class Lab2
{
	public static void main(String as[])
	{
		Customer c1=new Customer(101,"sri","sri@jlc",9999);
		Customer c2=new Customer(101,"sri","sri@jlc",9999);
		Customer c3=new Customer(102,"sri","sri@jlc",9999);
		c1.show();
		System.out.println(c1.getClass());
		System.out.println(c1.hashcode());
		System.out.println(c1.toString());
		System.out.println(c2);
		System.out.println(c1);
		System.out.println(c1==c2);
		System.out.println(c1.equals(c2));
		System.out.println(c1==c3);
		System.out.println(c1.equals(c3));
	}
}
/*
-------output-------
E:\Navin\lang\object>java Lab2
cid     cname   email   phone
101     sri     sri@jlc 9999
class Customer
inside hashcode()...
20
101     sri     sri@jlc 9999
101     sri     sri@jlc 9999
101     sri     sri@jlc 9999
false
true
false
false
*/