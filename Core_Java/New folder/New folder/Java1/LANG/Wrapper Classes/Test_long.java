class Test_long{
public static void main(String as[]){
Long b1=new Long (2123654);
Long  b2=new Long ("1479653");
System.out.println("b1: "+b1);
System.out.println("b2: "+b2);
System.out.println("Long.MIN_VALUE: "+Long.MIN_VALUE);
System.out.println("Long.MAX_VALUE: "+Long.MAX_VALUE);
System.out.println("Long.TYPE: "+Long.TYPE);
System.out.println("Long.SIZE: "+Long.SIZE);
String str=b1.toString();
System.out.println("b1.toString(): "+str);
str=Long.toString(45125986);
System.out.println("Long.toString(45125986): "+str);
str=Long.toHexString(45125986);
System.out.println("Long .toHexString(45125986): "+str);
str=Long.toBinaryString(45125986);
System.out.println("Long .toBinaryString(45125986): "+str);
str=Long.toOctalString(45125986);
System.out.println("Long .toOctalString(45125986): "+str);
Long b3=Long.valueOf("1278562");
System.out.println("Long.valueOf(\"1278562\"): "+b3);
b3=Long.valueOf(7854126);
System.out.println("Long.valueOf(7854126): "+b3);
b3=Long.parseLong (str);
System.out.println("Long.parseLong(str): "+b3);
short s=b1.shortValue();
System.out.println("b1.shortValue(): "+s);
byte b=b1.byteValue();
System.out.println("b1.byteValue(): "+b);
int i=b1.intValue();
System.out.println("b1.intValue(): "+i);
int i2=b1.hashCode();
System.out.println("b1.hashCode(): "+i2);
System.out.println("b1.equals(b2): "+b1.equals(b2));
System.out.println("b1.compareTo(b2): "+b1.compareTo(b2));
System.out.println("b1.compareTo(123): "+b1.compareTo(123l));
//System.out.println("Long .compare(b1,b2): "+Long.compare(b1,b2));

}
}
