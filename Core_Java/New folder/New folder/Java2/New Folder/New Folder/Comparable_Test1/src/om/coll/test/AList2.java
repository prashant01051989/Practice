package om.coll.test;

import java.util.*;

public class AList2{
public static void main(String as[]){

List l1=new ArrayList();
l1.add(new Integer(123));
l1.add("Anshu");
l1.add("ans");
l1.add(new Double(12.36));
l1.add(new Long(12345));
l1.add(new Long(12345));
System.out.println(l1);
List l2=new ArrayList();
l2.add(new Integer(1000));
l2.add("MY");
l2.add("Name");
l2.add("is");
l2.add("Ans");
System.out.println(l2);
l1.add(2,"Computer");
System.out.println(l1);
l1.add(2,l2);
System.out.println(l1);
//1.	l1.addAll(14,l2);
System.out.println(l1.get(2));
System.out.println(l1.indexOf(l2));
System.out.println(l1.indexOf("ans"));
System.out.println(l1.indexOf("aprs"));
System.out.println(l1.lastIndexOf("ans"));
System.out.println("Display1 through ListIterator");
ListIterator li=l2.listIterator();
while(li.hasNext()){
System.out.print(li.nextIndex()+"====");
System.out.println(li.next());
}
System.out.println("Display2 through ListIterator");

while(li.hasPrevious()){
System.out.print(li.previousIndex()+"====");
System.out.println(li.previous());
}
List l3=l1.subList(3,5);
System.out.println(l3);
}
}
/*
1.	Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 14, Size: 8
*/