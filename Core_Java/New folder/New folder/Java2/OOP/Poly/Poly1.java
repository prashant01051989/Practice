class Human{
void eating(){
System.out.println("Human-Eating");
}
void sleeping(){
System.out.println("Human-Sleeping");
}
static void clothing(){
System.out.println("Human-clothing");
}

}

class Girl extends Human{
void eating(){
System.out.println("Girl less Eating");
}
void Showing(){
System.out.println("Girl showing more");
}
static void clothing(){
System.out.println("Girl more clothing");
}

}

class Boy extends Human{
void eating(){
System.out.println("Boy more Eating");
}

 void sleeping(){
System.out.println("Boy more sleeping");
}

}
class Poly1{
public static void main(String as[]){

Human h=new Human();
/*
h.eating();
h.sleeping();
h.clothing();
*/
h=null;
h=new Girl();
h.eating();
h.sleeping();
h.clothing();// Human class method call because static method invoke based on reference type 
Girl.clothing();
//1. h.showing();
/*
h=new Boy();
h.eating();
h.sleeping();
h.clothing();
*/
}

}
/*
1.	Poly1.java:40: cannot find symbol
	symbol  : method showing()
	location: class Human
	h.showing();
*/