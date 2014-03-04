class Test_boolean{
public static void main(String as[]){
Boolean b=new Boolean("trUe");
Boolean b1=new Boolean("Anshu");

System.out.println(b);
b1=Boolean.parseBoolean("JAVA");
System.out.println(b1);
System.out.println(b.booleanValue());
boolean b2=true;
b2=Boolean.valueOf(b2);
System.out.println(b2);
String s=Boolean.toString(b2);
System.out.println(s);
s=b1.toString();
System.out.println(s);
int i=b1.hashCode();
System.out.println(i);
System.out.println(b.equals(b1));
System.out.println(b.compareTo(b1));

}
}
