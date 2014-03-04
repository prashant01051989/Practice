class A
{
	A(int a)
	{
		//super(a);
		super();
	}
}
class B extends A
{
	B(int a,int b)
	{
		super(a+b);
	}
}
class Hello{
int a=10;
int b=20;
int c=30;
public int hashCode(){
		return 99;
	}
public String toString(){
return"[a="+a+",b="+b+",c="+c+"]";
}
	
public boolean equals(Object o){
Hello h=(Hello)o;
if(this.a==h.a&&this.b==h.b&&this.c==h.c)
   return true;
  else
  return false;
  }

}
class Lab3{
	public static void main(String as[]){
		A a=new B(10,20);
		Class c1=a.getClass();
		System.out.println("a.getClass(): "+c1);
		System.out.println("c1.getName(): "+c1.getName());
		System.out.println("c1.hashCode(): "+c1.hashCode());
		System.out.println("a.hashCode(): "+a.hashCode());
		System.out.println("a.toString(): "+a.toString());
		System.out.println("a: "+a);
		
		Hello h1=new Hello();
		Hello h2=new Hello();
		h2=h1;
		Class c2=h1.getClass();
		System.out.println("h.getClass(): "+c2);
		System.out.println("c2.getName(): "+c2.getName());
		System.out.println("c2.hashCode(): "+c2.hashCode());
		System.out.println("h1.hashCode(): "+h1.hashCode());
		System.out.println("h2.hashCode(): "+h2.hashCode());
		System.out.println("h1.toString(): "+h1.toString());
		System.out.println("h1: "+h1);
		//System.out.println("h1.hashCode(): "+h1.equals(h2));
		//System.out.println("h1.hashCode(): "+h1.equals(null));
		try{
		System.out.println("class.forName(/Hello/): "+Class.forName("Hello"));
		}catch(ClassNotFoundException e){}
		System.out.println("Hello.class: "+Hello.class);
		String a1="PRASAHNT";
		Object o=a1;
		System.out.println("Hello.class: "+String.class);
		
	}
}