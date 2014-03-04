class A implements Serializable{}

class B extends A implements Serializable{}
class C extends A implements Serializable{}
class D{
public static void main(String as[]){
C c=new B();
}
}