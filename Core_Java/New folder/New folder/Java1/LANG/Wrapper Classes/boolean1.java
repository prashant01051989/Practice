class boolean1{
public static void main(String as[]){
Boolean b1=new Boolean("TruE");
Boolean b2=new Boolean("JLC");

System.out.println(b1);
System.out.println(b2);
Boolean b3=Boolean.valueOf("tRue");
System.out.println(b3);

String str=b1.toString();
System.out.println(str);

Boolean b4=new Boolean(true);
System.out.println(b4);

boolean b5=b4.booleanValue();
System.out.println(b5);
System.setProperty("jlc.property","true");
 b5=Boolean.getBoolean("jlc.property");
System.out.println(b5);

 b5=Boolean.parseBoolean("true");
System.out.println(b5);

Boolean b7=new Boolean(true);
Boolean b8=new Boolean(true);
System.out.println("b7\t:"+b7);
System.out.println("b8\t:"+b8);
System.out.println("b7==b8\t:"+(b7==b8));

}
}
