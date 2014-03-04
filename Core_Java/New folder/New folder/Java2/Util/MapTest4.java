import java.util.*;
class Student implements Comparable{
int sid;
String sname;
String email;
Student(int sid,String sname,String email){
this.sid=sid;
this.sname=sname;
this.email=email;
}
public String toString(){
return ""+sid+"\t"+sname+"\t"+email;
}
public boolean equals(Object o){
System.out.println("equals()");
Student s=(Student)o;
if(this.sid==s.sid)
return true;
return false;
}
public int compareTo(Object o){
System.out.println("CompartTo()");
Student s=(Student)o;
System.out.println(s);
return this.sname.compareTo(s.sname);
}
}

class SnameComparator implements Comparator{
public int compare(Object o1,Object o2){
Student s1=(Student)o1;
Student s2=(Student)o2;
return s1.sname.compareTo(s2.sname);
}

}

class MapTest4{
public static void main(String as[]){
ArrayList al=new ArrayList();
Student s1=new Student (22,"dd","cc@jlc");
Student s2=new Student (44,"tt","bb@jlc");
Student s3=new Student (11,"aa","dd@jlc");
Student s4=new Student (33,"cc","aa@jlc");
Student s5=new Student (55,"bb","ee@jlc");
al.add(s1);
al.add(s2);
al.add(s3);
al.add(s4);
al.add(s5);
System.out.println("*********************No Sorting*********************");
Iterator it=al.iterator();
while(it.hasNext()){
Student s=(Student)it.next();
System.out.println(s);
}
System.out.println("*********************Sorting By Sid************************");
/*
Collections.sort(al);
Iterator it1=al.iterator();
while(it1.hasNext()){
Student s=(Student)it1.next();
System.out.println(s);
}
*/
System.out.println("*********************Sorting By Sname*********************");
Collections.sort(al,new SnameComparator());
Iterator it2=al.iterator();
while(it2.hasNext()){
Student s=(Student)it2.next();
System.out.println(s);
}
}
}