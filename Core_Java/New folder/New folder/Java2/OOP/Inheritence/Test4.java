class Hai{
static int b;

Hai(){
System.out.println("Hai-con");
}
void Hai1(){
//this();
System.out.println("Hai1()");
}
}


class Test4{
public static void main(String as[]){

Hai b=new Hai();
b.Hai1();

}

}
