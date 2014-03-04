import java.util.*;


class Lab14{
public static void main(String as[]){
System.out.println("COLLECTIONS");
ArrayList al=new ArrayList();
al.add("cc");
al.add("aa");
al.add("bb");
al.add("dd");
al.add("aa");
al.add("bb");
System.out.println(al);
Vector v=new Vector();
v.add("4");
v.add("2");
v.add("3");
v.add("5");
v.add("1");
v.add("6");
//System.out.println(v);
Collections.sort(al);
System.out.println(al);
System.out.println(Collections.binarySearch(al,"aa"));
Collections.reverse(al);
System.out.println(al);
Collections.shuffle(al);
System.out.println(al);
Collections.swap(al,0,1);
System.out.println(al);
//Collections.fill(al,"A");
//System.out.println(al);
ArrayList al1=new ArrayList(50);
Collections.copy(v,al);
System.out.println(v);
System.out.println(Collections.min(v));
System.out.println(Collections.max(v));
System.out.println(al);
Collections.rotate(al,3);
System.out.println(al);
Collections.replaceAll(al,"aa","AA");
System.out.println(al);
List list=al.subList(3,5);
System.out.println(list);
System.out.println(Collections.lastIndexOfSubList(al,list));
Collection c1=Collections.unmodifiableCollection(list);
System.out.println(c1);
//c1.add("AA");

 c1 = Collections.synchronizedCollection(al);
  synchronized(c1) {
    Iterator i = c1.iterator(); // Must be in the synchronized block
    while (i.hasNext())
	System.out.print(i.next()+" ");
  }
System.out.println("");
Set s=Collections.singleton("OP");
//s.remove("OP");
System.out.println(s);
System.out.println(Collections.addAll(al,v));
System.out.println(al);
System.out.println(Collections.disjoint(al,v));
System.out.println(Collections.frequency(al,"AA"));
Enumeration en =v.elements();
al=Collections.list(en);
System.out.println(al);
en=Collections.enumeration(al);
Collections.sort(al,Collections.reverseOrder());
System.out.println(al);

System.out.println("END");
}	
}