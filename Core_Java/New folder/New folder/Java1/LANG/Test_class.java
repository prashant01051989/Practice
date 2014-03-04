class Hello{}
class Test_class{
public static void main(String as[]){
Hello h=new Hello();
Object o=h.getClass();
System.out.println(o);
//Class cls =h.getClass();
Class cls1[]=h.getClass().getClasses();
for(int i=0;i<cls1.length;i++){
System.out.println(cls1[i].getName());
}
try{
Class cls2=Class.forName("Hello");
System.out.println(cls2);
System.out.println(cls2.getName());
}catch(ClassNotFoundException e){}
}
}

