class Lab1{
public static void main(String as[]){
System.out.println("Main Begin");
Thread t=Thread.currentThread();
System.out.println(t);
System.out.println(t.getName());
System.out.println(t.getPriority());
System.out.println(t.getThreadGroup());
t.setName("ANSHU");
System.out.println(t.getName());
t.setPriority(3);
System.out.println(t.getPriority());






System.out.println("Main End");
}
}