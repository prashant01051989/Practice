class Test_double{
public static void main(String as[]){
Double b1=new Double(2.00);
Double b2=new Double(4.00);
System.out.println("b1: "+b1);
System.out.println("b2: "+b2);
System.out.println("Double.MIN_VALUE: "+Double.MIN_VALUE);
System.out.println("Double.MAX_VALUE: "+Double.MAX_VALUE);
System.out.println("Double.TYPE: "+Double.TYPE);
System.out.println("Double.SIZE: "+Double.SIZE);
System.out.println("Double.NaN: "+Double.NaN);			
System.out.println("Double.POSITIVE_INFINITY: "+Double.POSITIVE_INFINITY);
System.out.println("Double.NEGATIVE_INFINITY: "+Double.NEGATIVE_INFINITY);
String str=b1.toString();
System.out.println("b1.toString(): "+str);
str=Double.toString(45.00);
System.out.println("Double.toString(45.00): "+str);
str=Double.toHexString(45.00);
System.out.println("Double.toHexString(45.00);: "+str);
Double b3=Double.valueOf("12.00");
System.out.println("Double.valueOf(\"12.00\"): "+b3);
b3=Double.valueOf(12.00);
System.out.println("Double.valueOf(12.00): "+b3);
b3=Double.parseDouble(str);
System.out.println("Double.parseDouble(str): "+b3);
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
System.out.println("b1.compareTo(123.00): "+b1.compareTo(123d));
System.out.println("Double.compare(b1,b2): "+Double.compare(b1,b2));

}
}
