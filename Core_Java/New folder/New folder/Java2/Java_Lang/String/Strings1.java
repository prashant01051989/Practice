public class Strings1{
public static void main(String as[]){
String s1="jlc";
System.out.println(s1);
System.out.println("*************************");
String s2="jlc";
System.out.println(s1==s2);
System.out.println(s1.equals(s2));
System.out.println("*************************");
String s3=new String("jlc1");
String s4=new String("jlc1");
System.out.println(s3==s4);
System.out.println(s3.equals(s4));
System.out.println("*************************");
String s5=s4.intern();
System.out.println(s5==s4);
System.out.println(s5.equals(s4));
System.out.println("*************************");
String s6="jlc1";
System.out.println(s5==s6);
System.out.println(s5.equals(s6));
System.out.println("*************************");
String s7=new String("jlc");
System.out.println(s2==s7);
System.out.println(s2.equals(s7));
}
}