class A
{
	int x;
	A(int x)
	{
		this.x=x;
	}
}
class B
{
	int p;
	A aobj;
	B(int p,A aobj)
	{
		this.p=p;
		this.aobj=aobj;
	}
}
class C
{
	int q;
	B bobj;
	C(int q,B bobj)
	{
		this.q=q;
		this.bobj=bobj;
	}
}

class Hello implements Cloneable
{
	int a;
	C cobj;
	Hello(){}
	Hello(int a,C cobj)
	{
		this.a=a;
		this.cobj=cobj;
	}
	void show()
	{
		System.out.println("a="+a);
		System.out.println("cobj.q="+cobj.q);
		System.out.println("cobj.bobj.p="+cobj.bobj.p);
		System.out.println("cobj.bobj.aobj.x="+cobj.bobj.aobj.x);
	}
	public Hello myclone()
	{
		Hello h=null;
		Object o=null;
		try
		{
		o=this.clone();
		}catch(CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		h=(Hello)o;
		return h;
	}
}
class Test_clone2
{
	public static void main(String as[])
	{
		A aobj=new A(10);
		B bobj=new B(20,aobj);
		C cobj=new C(30,bobj);
		Hello h=new Hello(40,cobj);
		h.show();
		Hello h1=h.myclone();
		h1.show();
		System.out.println(h==h1);
		System.out.println(h.cobj==h1.cobj);
		System.out.println(h.cobj.bobj==h1.cobj.bobj);
		System.out.println(h.cobj.bobj.aobj==h1.cobj.bobj.aobj);
		h.a=1000;
		System.out.println("h.a: "+h.a);
		System.out.println("h1.a: "+h1.a);
		
	
	}
}
