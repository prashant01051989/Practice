abstract class Animal1{
abstract void eating();
}
interface Animal2{
abstract void eating1();
}
abstract class Animal3{
abstract void eating();
}
class Hello{
Animal1 a1=new Animal1(){
public void eating(){
System.out.println("Animal1 is eating");
}
};
Animal2 a2=new Animal2() {
public void eating1(){
System.out.println("Animal2 is eating");
}
};
Animal3 a3=new Animal3() {
public void eating(){
System.out.println("Animal3 is eating");
}
};
}
class InnerClass6{
public static void main(String as[]){
Hello h1=new Hello();
}
}
