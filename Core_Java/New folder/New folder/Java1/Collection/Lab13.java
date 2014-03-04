import java.util.*;

class Hello implements Comparable{
int sid;
String sname;
String email;
Hello (int sid,String sname,String email){
this.sid=sid;
this.sname=sname;
this.email=email;
}
public String toString(){
return ""+sid+"\t"+sname+"\t"+email;	
}
/*public boolean equals(Object o){
Hello h=(Hello)o;
if(this.sid==h.sid)
	return true;
return false;
}*/
public int compareTo(Object obj){
Hello h=(Hello)obj;
int x=this.sid-h.sid;
return x;
}
}

class Snamecomparator implements Comparator{
public int compare(Object o1,Object o2){
Hello h1=(Hello)o1;
Hello h2=(Hello)o2;
int x=h1.sname.compareTo(h2.sname);
return x;
} 
}
class Emailcomparator implements Comparator{
public int compare(Object o1,Object o2){
Hello h1=(Hello)o1;
Hello h2=(Hello)o2;
int x=h1.email.compareTo(h2.email);
return x;
}
} 
class Lab13{
public static void main(String as[]){
System.out.println("COMPARATOR");
Hello h1=new Hello(30,"cc","cc@jlc");
Hello h2=new Hello(10,"dd","dd@jlc");
Hello h3=new Hello(40,"aa","aa@jlc");
Hello h4=new Hello(20,"bb","bb@jlc");
ArrayList al1=new ArrayList();
al1.add(h1);
al1.add(h2);
al1.add(h3);
al1.add(h4);
System.out.println("No Sorting");
Iterator it=al1.iterator();
while(it.hasNext()){
Hello h=(Hello)it.next();
System.out.println(h);
}
System.out.println("Sorting by sid");
Collections.sort(al1);
it=al1.iterator();
while(it.hasNext()){
Hello h=(Hello)it.next();
System.out.println(h);
}
System.out.println("Sorting by Sname");
Collections.sort(al1,Collections.reverseOrder(new Snamecomparator()));
System.out.println("**********"+Collections.max(al1,new Snamecomparator()));

it=al1.iterator();
while(it.hasNext()){
Hello h=(Hello)it.next();
System.out.println(h);
}
System.out.println("Sorting by Email");
Collections.sort(al1,new Emailcomparator());
it=al1.iterator();
while(it.hasNext()){
Hello h=(Hello)it.next();
System.out.println(h);
}

}	
}