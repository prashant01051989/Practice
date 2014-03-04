import java.util.*;
class LList3{
public static void main(String as[]){
LinkedList ll1=new LinkedList();
ll1.add(new Integer(234));
ll1.add(new Long(11234));
ll1.add(new Double(234444));
ll1.add("23333334string");
ll1.add(null);
System.out.println(ll1);
ll1.addLast("Last");
ll1.addLast(null);
System.out.println(ll1);
ll1.addFirst("First");
System.out.println(ll1);
System.out.println("ll1.getFirst(): "+ll1.getFirst());
System.out.println("ll1.getLast(): "+ll1.getLast());
System.out.println("ll1.removeFirst(): "+ll1.removeFirst());
System.out.println(ll1);
System.out.println("ll1.removeLast(): "+ll1.removeLast());
System.out.println(ll1);
List ll2=(List)ll1.clone();
System.out.println(ll2);
ll2.add("Prashant");
System.out.println(ll2);
System.out.println(ll1);
/*
LinkedList ll2=new LinkedList();
ll2.add(new Integer(0000));
ll2.add(new Long(99999));
ll2.add(new Double(88888));
ll2.add("string");
ll2.add("Anshu");
System.out.println(ll2);



System.out.println("l: "+l);
*/
}

}
/*
1.	AList3.java:11: removeRange(int,int) has protected access in java.util.ArrayList
*/