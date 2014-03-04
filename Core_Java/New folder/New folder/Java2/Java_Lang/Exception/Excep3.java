class Excep3{
public static void main(String as[]){
try{
System.out.println("Start A-try");
System.out.println(10/10);
try{
System.out.println("Start A1-try");
System.out.println(10/10);
System.out.println("End A1-try");
}catch(Exception e){
System.out.println("Start A1-catch");
System.out.println(10/10);
System.out.println("end A1-catch");
}finally{
System.out.println("Start A1-finally");
System.out.println(10/10);
System.out.println("end A1-finally");
}
System.out.println(10/0);
System.out.println("end A-try");
}catch(Exception e){
System.out.println("Start A-catch");
System.out.println(10/10);
try{
System.out.println("Start A-catch-try");
System.out.println(10/10);
System.out.println("End A-catch-try");
}catch(Exception ae){
System.out.println("Start A-catch-try-catch");
System.out.println(10/10);
System.out.println("End A-catch-try-catch");
}finally{
System.out.println("Start A-catch-finally");
System.out.println(10/10);
System.out.println("End A-catch-finally");
}
System.out.println(10/10);
System.out.println("End A-catch");
}finally{
System.out.println("Start A-finally");
System.out.println(10/10);
try{
System.out.println("Start A-finally-try");
System.out.println(10/10);
System.out.println("End A-finally-try");
}catch(Exception ae){
System.out.println("Start A-finally-catch");
System.out.println(10/10);
System.out.println("End A-finally-catch");
}finally{
System.out.println("Start A-finally-finally");
System.out.println(10/10);
System.out.println("End A-finally-finally");
}
System.out.println(10/10);
System.out.println("End A-finally");
}

}
}