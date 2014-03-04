public class Strings5{
public static void main(String as[]){
String s1="abc";
String s2="aBc";
String s3="abc";

System.out.println(s1.compareTo(s2));
System.out.println(s2.compareTo(s1));
System.out.println(s1.compareTo(s3));
System.out.println("*************************");
System.out.println(s1.compareToIgnoreCase(s2));
System.out.println(s2.compareToIgnoreCase(s1));
System.out.println(s1.compareToIgnoreCase(s3));
System.out.println("*************************");
System.out.println(s1.equals(s2));
System.out.println(s2.equals(s1));
System.out.println(s1.equals(s3));
System.out.println("*************************");
System.out.println(s1.equalsIgnoreCase(s2));
System.out.println(s2.equalsIgnoreCase(s1));
System.out.println(s1.equalsIgnoreCase(s3));
System.out.println("*************************");
String s4="jlcindiajlc";
System.out.println(s4.indexOf("jlc"));
System.out.println(s4.lastIndexOf("jlc"));
System.out.println(s4.indexOf("jlc",1));
System.out.println(s4.lastIndexOf("jlc",8));
System.out.println("*************************");
System.out.println(s4.startsWith("jlc"));
System.out.println(s4.startsWith("sri"));
System.out.println("*************************");
System.out.println(s4.endsWith("jlc"));
System.out.println(s4.endsWith("sri"));
}
}