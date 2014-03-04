abstract class Human{
final static int d=20;
int x=1000;
abstract void eating();
abstract void sleeping();
//1.	abstract static void clothing();
abstract void clothing();
static{
System.out.println("Human-static");
}
{
System.out.println("Human-Instance");
}
Human(){
System.out.println("Human-def-con");
}
}
/*
abstract class Girl extends Human{
int a=10;
//3.	abstract int b=10;
void eating(){
System.out.println("Girl less Eating");
System.out.println(a);
}
void clothing(){
System.out.println("Girl more clothing");
}
}
*/
class Boy extends Human{
int y=2000;
void eating(){
System.out.println("Boy more Eating");
}

void sleeping(){
System.out.println("Boy more sleeping");
}

void clothing(){
System.out.println("Boy more clothing");
System.out.println(super.d);
}

}

class Poly2{
public static void main(String as[]){

//2.	Human h=new Human();
/*
Human h=new Boy();
h.eating();
h.sleeping();
h.clothing();
//4.	System.out.println(h.y);
*/
//System.out.println(Boy.d);

}
}
/*
1.	Poly2.java:4: illegal combination of modifiers: abstract and static
	abstract static void clothing();
 2.	Poly2.java:35: Human is abstract; cannot be instantiated
	Human h=new Human();             
3.	Poly2.java:11: modifier abstract not allowed here
	abstract int b=10;	
4.	Poly2.java:57: cannot find symbol
	symbol  : variable y
	location: class Human
	System.out.println(h.y);
*/