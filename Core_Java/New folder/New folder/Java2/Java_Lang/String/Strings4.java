public class Strings4{
public static void main(String as[]){
String s1="jlcindiajlc";
System.out.println();
System.out.println(s1.charAt(3));
System.out.println(s1.codePointAt(3));
//System.out.println(s1.codePointBefore(12));
System.out.println(s1.codePointBefore(10));
System.out.println(s1.codePointCount(1,4));
System.out.println(s1.offsetByCodePoints(1,5));
System.out.println(s1.indexOf('i'));
System.out.println(s1.lastIndexOf('i'));
//System.out.println(s1.indexOf(4,'i'));
System.out.println(s1.indexOf('i',7));
System.out.println(s1.lastIndexOf('i',7));
System.out.println("*************************");
String s2="   123   Anshu    ";
System.out.println(s2);
System.out.println(s2.trim());
System.out.println("*************************");
System.out.println(s1);
String s3=s1.replace('i','I');
System.out.println(s3);
System.out.println("*************************");
String s4=s1.substring(3);
System.out.println(s4);
String s5=s1.substring(3,5);
System.out.println(s5);
}
}