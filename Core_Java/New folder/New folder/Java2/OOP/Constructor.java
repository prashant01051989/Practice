class Student{
int sid;
String name;
String email;
long phone;
static String course="JAVA";

static{
System.out.println("Static Block");
}
{
System.out.println("Instance Block");
}

Student(){}
//1. student(){}
//4. final Student(){}
//5. static Student(){}
Student (int id,String sn,String se,long p){
sid=id;
name=sn;
email=se;
phone=p;
}
 Student (String sn,String se,long p){
int i=10;
System.out.println("i= "+i);
//3. static int j=30;
final int k=30;
System.out.println("k= "+k);
{
System.out.println("Instance Block-Inside Constructor");
}

/*2. static{
System.out.println("Static Block-Inside Constructor");
}*/


}

void Student (){}



void show(){
System.out.println(sid);
System.out.println(name);
System.out.println(email);
System.out.println(phone);
System.out.println(course);
}









}

class Constructor{
public static void main(String as[]){
Student s1=new Student();
s1.show();
Student s2=new Student(101,"aaa","a@a",12364);
s2.show();
Student s3=new Student("aaa","a@a",12364);
s3.show();
s3.Student();
}
}

/*

1.  constructor.java:22: invalid method declaration; return type required
	student (String sn,String se,long p){
				
2. constructor.java:29: illegal start of expression
	static{
		
	constructor.java:32: ';' expected

3. constructor.java:26: illegal start of expression
	static int j=30; 
4. constructor.java:23: modifier final not allowed here
	final Student (String sn,String se,long p){
5. constructor.java:18: modifier static not allowed here
static Student(){}      				  
*/