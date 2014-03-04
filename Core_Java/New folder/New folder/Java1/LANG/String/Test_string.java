class Test_string{
public static void main(String as[]){
String s="JLC";
String a =new String("JLC");
String a1 =new String("   PRASHANT   ");
String a2=a1.toString();
System.out.println(a2);
char a3=a1.charAt(0);
System.out.println(a3);
int a4=a1.codePointAt(0);
System.out.println(a4);
 a4=a1.codePointBefore(1);
System.out.println(a4);
a4=a1.codePointCount(1,4);
System.out.println(a4);
a4=a1.offsetByCodePoints(1,4);
System.out.println(a4);
boolean a5=a1.equals(a);
System.out.println(a5);
StringBuffer a6=new StringBuffer("TAMANA");
a5=a1.contentEquals(a6);
System.out.println(a5);
a5=a1.equalsIgnoreCase(a);
System.out.println(a5);
a4=a1.compareTo(a);
System.out.println(a4);
a4=a1.compareToIgnoreCase(a);
System.out.println(a4);
a5=a.regionMatches(1,a1,1,3);
System.out.println(a5);
boolean ignoreCase=true;
a5=a.regionMatches(ignoreCase,1,a1,1,3);
System.out.println(a5);
a5=a.startsWith("HAN",5);
System.out.println(a5);
a5=a.startsWith("H");
System.out.println(a5);
a5=a1.endsWith("P");
System.out.println(a5);
long a7=a.hashCode();
System.out.println(a7);
a4=a1.indexOf('A');
System.out.println(a4);
a4=a1.indexOf('A',3);
System.out.println(a4);
a4=a1. lastIndexOf('A');
System.out.println(a4);
a4=a1.lastIndexOf('A',4);
System.out.println(a4);
a4=a1.indexOf("SH");
System.out.println(a4);
a2=a1.substring(3);
System.out.println(a2);
a2=a1.substring(3,5);
System.out.println(a2);
a2=a1.replace('A','z');
System.out.println(a2);
a5=a.matches("p");
System.out.println(a5);
a2=a1.replaceFirst("RAS","ANSHU");
System.out.println(a2);
a2=a1.replaceAll("RAS","ANSHU");
System.out.println(a2);
a2=a1.toLowerCase();
System.out.println(a2);
a2=a1.toUpperCase();
System.out.println(a2);
System.out.println(a==s);
a2=a1.intern();
System.out.println(a2.equals(a1));
a2=String.valueOf(a7);
System.out.println(a2);
a2=String.valueOf(a3);
System.out.println(a2);
char a8[]={'T','A','M','A','N','A'};
a2=String.copyValueOf(a8,1,4);
System.out.println(a2);
a2=String.copyValueOf(a8);
System.out.println(a2);
a2=String.valueOf(a8,1,4);
System.out.println(a2);
a8=a1.toCharArray();
for(int i=0;i<a8.length;i++)
   {
   System.out.println(a8[i]);
   }
a2=a1.trim();
System.out.println(a2);
System.out.println(a1.length());

//System.out.println(a2.codePointAt(0));
}
}

