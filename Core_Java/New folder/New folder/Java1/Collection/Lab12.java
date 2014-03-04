import java.util.*;


class Hello implements Comparable{
int a;
String str;
Hello (int a,String str){
this.a=a;
this.str=str;
}
public String toString(){
return "["+a+","+str+"]";	
}

public int compareTo(Object obj){
Hello h=(Hello)obj;
int x=this.a-h.a;
return x;
}
}

class strcomparator implements Comparator{
public int compare(Object o1,Object o2){
Hello h1=(Hello)o1;
Hello h2=(Hello)o2;
int x=h1.str.compareTo(h2.str);
return x;
} 
}

class Lab12{
public static void main(String as[]){
System.out.println("COMPARATOR AND COMPARABLE");
ArrayList al=new ArrayList();
al.add("cc");
al.add("ee");
al.add("bb");
al.add("dd");
al.add("aa");
Collections.sort(al);
System.out.println(al);
Hello h1=new Hello(30,"cc");
Hello h2=new Hello(10,"dd");
Hello h3=new Hello(40,"aa");
Hello h4=new Hello(20,"bb");
ArrayList al1=new ArrayList();
al1.add(h1);
//System.out.println("***********"+h1);
al1.add(h2);
//System.out.println("----------------"+al1.get(1));
al1.add(h3);
al1.add(h4);
al1.add(h4);
//al1.add("h4");
System.out.println(al1);

Collections.sort(al1);
System.out.println(al1);
Collections.sort(al1,new strcomparator());
System.out.println(al1);



System.out.println("END");
}	
}