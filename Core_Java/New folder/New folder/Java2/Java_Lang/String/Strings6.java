public class Strings6{
public static void main(String as[]){
String s1="jlcindiajlc";
String s2="hello";
System.out.println(s2.concat("jlc"));
System.out.println(s2);
//System.out.println(s1.replaceFirst("jlc","JLC"));
System.out.println(s1.replaceAll("jlc","JLC"));
System.out.println("*************************");
String s3="I am p . Now i am doing String lab .";
String s4[]=s3.split("");
for(int i=0;i<s4.length;i++){
System.out.print(s4[i]);
}
System.out.println();
System.out.println("*************************");
String s5[]=s3.split("am");
for(int i=0;i<s5.length;i++){
System.out.println(s5[i]);
}
System.out.println("*************************");
int x=99;
String s6=String.valueOf(x);
System.out.println(s6);
System.out.println("*************************");
float f=99.969f;
String s7=String.valueOf(f);
System.out.println(s7);
System.out.println("*************************");
double d=123.369;
String s8=String.valueOf(d);
System.out.println(s8);
System.out.println("*************************");
boolean b=true;
String s9=String.valueOf(b);
System.out.println(s9);
System.out.println("*************************");
String s10="aaBBBcDDDeeFAA";
System.out.println(s10.matches("a*B*cD*e*FA*"));
System.out.println(s10.matches("a*B?cD*e*FA*"));
System.out.println(s10.matches("a*B+cD*e*FA*"));
System.out.println("*************************");

System.out.println(s1.regionMatches(0,"India",0,4));
System.out.println(s1.regionMatches(true,3,"India",0,5));
System.out.println(s1.regionMatches(3,"India",0,5));
System.out.println(s1.regionMatches(true,3,"India",1,4));
System.out.println(s1.regionMatches(true,4,"India",1,4));
}
}