
abstract class Animal{
static int x=10;
static{

}
 static void show(){
System.out.println(x=1000);
}
abstract void eating();
abstract void sleeping();
abstract void running();
}

class Dog extends Animal{
static int x;
 Dog (int x)
{
 this.x=x;
System.out.println(x); 
 super.show();
 }
 
 void eating(){
System.out.println("Dog eating");
}
void sleeping (){
System.out.println("Dog sleeping");
}

void running(){
System.out.println("Dog running");
}

void barking(){
System.out.println("Dog barking");
}
}

abstract class Cat extends Animal{
void eating(){
System.out.println("Cat eating");
}

void barking(){
System.out.println("Cat eating");
}
}

class tamana5{
public static void main(String as[]){
Animal a=null;
 a=new Dog(10);
a.eating();
a.sleeping();
a.running();
//a.barking();
//a=new Cat();
//a.eating();
//a.sleeping();
//a.running();
//a.barking();
}
}


