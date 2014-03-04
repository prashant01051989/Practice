class Test_float{
public static void main(String as[]){
Float b1=new Float(2.00);
Float b2=new Float(4.00);
System.out.println(b1);
System.out.println(b2);
System.out.println(Float.MIN_VALUE);
System.out.println(Float.MAX_VALUE);
System.out.println(Float.TYPE);
System.out.println(Float.SIZE);
System.out.println(Float.NaN);			
System.out.println(Float.POSITIVE_INFINITY);
System.out.println(Float.NEGATIVE_INFINITY);
String str=b1.toString();
System.out.println(str);
str=Float.toString(45.00f);
System.out.println(str);
Float b3=Float.valueOf("12.00");
System.out.println(b3);
b3=Float.valueOf(12.00f);
System.out.println(b3);
b3=Float.parseFloat(str);
System.out.println(b3);
short s=b1.shortValue();
System.out.println(s);
int i2=b1.hashCode();
System.out.println(i2);
System.out.println(b1.equals(b2));
System.out.println(b1.compareTo(b2));
System.out.println(b1.compareTo(123f));
System.out.println(Float.compare(b1,b2));

}
}
