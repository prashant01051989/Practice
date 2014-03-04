class Test_stringbuffer{
public static void main(String as[]){
StringBuffer s=new StringBuffer("JLCINDIA");
StringBuffer s1=new StringBuffer("jlcindia");

s.ensureCapacity(25);
System.out.println("s.capacity(): "+s.capacity());
s.trimToSize();
System.out.println("s.capacity(): "+s.capacity());
System.out.println("s: "+s);
System.out.println("s.length(): "+s.length());
s.setLength(7);
System.out.println("s: "+s);
System.out.println("s.length(): "+s.length());
System.out.println("s.capacity(): "+s.capacity());
System.out.println("s.charAt(2): "+s.charAt(2));
s.setCharAt(0,'j');
System.out.println("s: "+s);
StringBuffer s3=s.append(s1);
System.out.println("s.append(s1): "+s3);
s3=s.append("Prashant");
System.out.println("s.append(\"Prashant\"): "+s3);
boolean  b=true;
s3=s.append(b);
System.out.println("s.append(b): "+s3);
s3=s.append('@');
System.out.println("s.append('@'): "+s3);
s3=s.append(123);
System.out.println("s.append(123): "+s3);
s3=s.append(123.256f);
System.out.println("s.append(123.256f): "+s3);
s3=s.append(321.256);
System.out.println("s.append(321.256): "+s3);
s3=s.delete(0,6);
System.out.println("s.delete(0,6): "+s3);
s3=s.deleteCharAt(0);
System.out.println("s.deleteCharAt(0): "+s3);
s3=s.replace(0,8,"Anshu");
System.out.println("s.replace(0,8,\"Anshu\"): "+s3);
String st=s.substring(5);
System.out.println("s.substring(5): "+st);
st=s.substring(0,5);
System.out.println("s.substring(0,5): "+st);
char ch[]={'P','R','A','S','H','A','N','T'};
s3=s.insert(5,ch,0,8);
System.out.println("s.insert(5,ch,0,6): "+s3);
s3=s.insert(1,st);
System.out.println("s.insert(1,st): "+s3);
s3=s.insert(1,ch);
System.out.println("s.insert(1,ch): "+s3);
int i=s.indexOf("PRASHANT");
System.out.println("s.indexOf(\"PRASHANT\"): "+i);
 i=s.indexOf("PRASHANT",2);
System.out.println("s.indexOf(\"PRASHANT\",2): "+i);
i=s.lastIndexOf("PRASHANT");
System.out.println("s.lastIndexOf(\"PRASHANT\"): "+i);
i=s.lastIndexOf("PRASHANT",17);
System.out.println("s.lastIndexOf(\"PRASHANT\",17): "+i);
s3=s.reverse();
System.out.println("s.reverse(): "+s3);
st=s.toString();
System.out.println("s.toString(): "+st);

}
}

