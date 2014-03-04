class Test_short{
public static void main(String as[]){
Short b1=new Short((short)2);
Short b2=new Short((short)4);
System.out.println(b1);
System.out.println(b2);
System.out.println(Short.MIN_VALUE);
System.out.println(Short.MAX_VALUE);
System.out.println(Short.TYPE);
System.out.println(Short.SIZE);
String str=b1.toString();
System.out.println(str);
 str=Short.toString((short)45);
System.out.println(str);
short b3=Short.parseShort(str);
System.out.println(b3);
 b3=Short.parseShort(str,16);
System.out.println(b3);
b3=Short.valueOf(str);
System.out.println(b3);
b3=Short.valueOf(str,16);
System.out.println(b3);
short b4=b1.shortValue();
System.out.println(b4);
int i=b1.intValue();
System.out.println(i);

}
}
