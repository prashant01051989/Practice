public class Strings2{
public static void main(String as[]){
String s1="jlcindia";
String s2=new String("jlcindia");
String s3=s2.intern();
System.out.println(s1==s3);
System.out.println(s1.equals(s3));
String s4="Ram".intern();
System.out.println(s4);
System.out.println("Sita".intern());
System.out.println(s4.intern());
System.out.println("*************************");
String s5="jlc"+"india";
System.out.println(s5==s1);
System.out.println("*************************");
String s6="jlc";
s6=s6+"india";
System.out.println(s1==s6);
System.out.println("*************************");
String s7="india";
s7="jlc"+s7;
System.out.println(s7==s1);
System.out.println("*************************");
String s8="jlc";
String s9="india";
String s10=s8+s9;
System.out.println(s10==s1);
System.out.println(s8.hashCode());
/*

System.out.println(s5.equals(s4));

System.out.println(s5==s6);
System.out.println(s5.equals(s6));
String s7=new String("jlc");
System.out.println(s2==s7);
System.out.println(s2.equals(s7));
*/
}
}