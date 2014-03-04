class Test_byte{
public static void main(String as[]){
Byte b1=new Byte((byte)2);
Byte b3=new Byte((byte)41);
System.out.println(b1);
System.out.println(Byte.MIN_VALUE);
System.out.println(Byte.MAX_VALUE);
System.out.println(Byte.TYPE);
System.out.println(Byte.SIZE);
byte b2=b1.byteValue();
System.out.println(b2);
short s1=b1.shortValue();
System.out.println(s1);
int  i1=b1.intValue();
System.out.println(i1);
String str=b1.toString();
System.out.println(str);
 str=Byte.toString(b1);
System.out.println(str);
int i2=b3.hashCode();
System.out.println(i2);
System.out.println(b1.equals(b3));
System.out.println(b1.compareTo(b3));
b2=Byte.parseByte(str);
System.out.println(b2);
//System.out.println(Byte.compare(b1,b3));
}
}
