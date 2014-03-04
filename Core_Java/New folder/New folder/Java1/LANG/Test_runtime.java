class Test_runtime{
public static void main(String as[])throws Exception{
Runtime rt=Runtime.getRuntime();
//rt.exit(0);
//rt.halt(0);
 System.out.println("I am in Test_runtime Class");
//rt.exec("notepad");
System.out.println(rt.totalMemory());
System.out.println(rt.maxMemory());
System.out.println(rt.freeMemory());
//System.out.println(rt.maxMemory()-rt.totalMemory());
System.gc();
rt.runFinalization();
System.out.println(rt.totalMemory());
System.out.println(rt.maxMemory());
System.out.println(rt.freeMemory());

}
}