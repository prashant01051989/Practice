class Hello{}
class StringBuff1{
//2.	final static int a;
public static void main(String as[]){
//1.	StringBuffer sb1="Anshu";
StringBuffer sb1=new StringBuffer("Anshu");
System.out.println(sb1);
StringBuffer sb2=new StringBuffer("Anshu");
System.out.println(sb2);
System.out.println(sb1==sb2);
System.out.println("********************");
StringBuffer sb3=new StringBuffer();
System.out.println(sb3.length());
System.out.println(sb3.capacity());
System.out.println("********************");

StringBuffer sb4=new StringBuffer("Anshu");
System.out.println(sb4.length());
System.out.println(sb4.capacity());
System.out.println("********************");
//2.	StringBuffer sb5=new StringBuffer(-1);
StringBuffer sb5=new StringBuffer(0);
System.out.println(sb5.length());
System.out.println(sb5.capacity());
sb5=sb5.append(new Hello());
System.out.println(sb5);
System.out.println(sb5.length());
System.out.println(sb5.capacity());
System.out.println("********************");
StringBuffer sb6=new StringBuffer("Hai");
System.out.println(sb6);
sb6.append(" Prashant");
System.out.println(sb6);
System.out.println("********************");
System.out.println(sb6);
StringBuffer sb7=new StringBuffer("How r u?");
sb6.append(sb7);
System.out.println(sb6);
System.out.println("********************");
char []c={' ','A','n','s','h','u'};
System.out.println(sb6);
sb6.append(c);
System.out.println(sb6);
System.out.println("********************");
System.out.println(sb6);
sb6.append(c,1,3);
System.out.println(sb6);
System.out.println("********************");
System.out.println(sb6);
sb6.append(true);
System.out.println(sb6);
System.out.println("********************");
System.out.println(sb6);
sb6.append('Z');
System.out.println(sb6);
System.out.println("********************");
System.out.println(sb6);
sb6.append(126);
System.out.println(sb6);
System.out.println("********************");
System.out.println(sb6);
sb6.delete(0,2);
System.out.println(sb6);
System.out.println("********************");
System.out.println(sb6);
sb6.deleteCharAt(0);
System.out.println(sb6);
System.out.println("********************");
System.out.println(sb6);
sb6.deleteCharAt(0);
System.out.println(sb6);
System.out.println("********************");
System.out.println(sb6.toString());
System.out.println("********************");
System.out.println(sb6.reverse());
String s="Prashant";
StringBuffer sb8=new StringBuffer(s);
System.out.println(sb8.reverse());
System.out.println("********************");
sb6.reverse();
System.out.println(sb6);
System.out.println(sb6.lastIndexOf("Ans",30));
System.out.println("********************");
System.out.println(sb6);
System.out.println(sb6.indexOf("Ans"));
System.out.println("********************");
System.out.println(sb6);
System.out.println(sb6.insert(0,"Hi"));
System.out.println(sb6.capacity());
}
}
/*
1.	StringBuff1.java:3: incompatible types
	found   : java.lang.String
	required: java.lang.StringBuffer
	StringBuffer sb1="Anshu";
2.	Exception in thread "main" java.lang.NegativeArraySizeException
3.	StringBuff1.java:2: variable a might not have been initialized
	class StringBuff1{
*/