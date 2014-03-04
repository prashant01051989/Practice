import java.io.*;
class SystemTest{
public static void main(String as[]){
//1.	System sys=new System();
PrintStream p=System.out;
p.println("System Class");
p.println(System.currentTimeMillis());
//p.println(System.getProperties());
p.println(System.getProperty("java.version"));
p.println(System.getProperty("java.vendor"));
p.println(System.getProperty("java.home"));
p.println(System.getProperty("java.version"));
p.println(System.getProperty("java.vendor.url"));
p.println(System.getProperty("os.name"));
System.setProperty("owner.name","Prashant");
p.println(System.getProperty("owner.name"));
//System.exit(0);
System.clearProperty("owner.name");
p.println(System.getProperty("owner.name"));
p.println(System.getProperty("owner.name"));
System.err.println("Anshu");
}
}
/*
1.	SystemTest.java:3: System() has private access in java.lang.System
	System sys=new System();
*/