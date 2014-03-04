public class Strings3{
public static void main(String as[]){
String s1="jlcindiajlc";
System.out.println(s1.length());
byte []b=new byte[s1.length()];
b=s1.getBytes();
for(int i=0;i<b.length;i++){
	System.out.print((char)b[i]);
}
System.out.println("");

byte []b1=new byte[s1.length()];
s1.getBytes(3,8,b1,4);
for(int i=0;i<b1.length;i++){
	System.out.print((char)b1[i]);
}

System.out.println("");
System.out.println("*************************");
char []c=new char[s1.length()];
c=s1.toCharArray();
for(int i=0;i<c.length;i++){
	System.out.print(c[i]);
}

System.out.println("");

char []c1=new char[s1.length()];
s1.getChars(3,8,c1,4);
for(int i=0;i<c1.length;i++){
	System.out.print(c1[i]);
}

System.out.println("");
System.out.println("*************************");
//String s2=new String(2,8,c);
String s2=new String(b);
System.out.println(s2);
String s3=new String(c);
System.out.println("**"+s3);
System.out.println(s2.length());

}
}