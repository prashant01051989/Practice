import java.util.*;
class Lab1{
public static void main(String as[]){
System.out.println("COLLECTION INTERFACE");

ArrayList  al=new ArrayList();
System.out.println(al);
System.out.println(al.size());
System.out.println(al.isEmpty());
al.add("a");
al.add("b");
al.add("c");
al.add("d");
al.add("e");
al.add("f");
System.out.println(al);
System.out.println(al.size());
System.out.println(al.isEmpty());
System.out.println(al.contains("a"));
System.out.println(al.contains(" "));
System.out.println(al.remove("f"));
System.out.println(al);
ArrayList  al1=new ArrayList();
al1.add("1");
al1.add("2");
al1.add("3");
al1.add("4");
al1.add("5");
al1.add("6");
System.out.println(al1);
al.add(al1);
System.out.println(al.addAll(al1));
System.out.println(al.remove(al1));
System.out.println(al.removeAll(al1));
al.addAll(al1);
System.out.println(al.retainAll(al1));
System.out.println(al);
Object obj[]=al.toArray();
for(int i=0;i<obj.length;i++){
System.out.print(obj[i]+" ");
}
System.out.println("");

System.out.println("ITERATOR INTERFACE");
Iterator it=al.iterator();
while(it.hasNext()){
Object o=it.next();
if(o.equals("5")){
it.remove();
}
System.out.print(o);
}
System.out.println(al);

System.out.println("LIST INTERFACE");
System.out.println(al.get(1));
System.out.println(al.remove(1));
al.add(1,"2");
//al.add(4,null);
System.out.println(al.addAll(4,al1));
System.out.println(al.set(5,"5"));
System.out.println(al);
System.out.println(al.indexOf("9"));
System.out.println(al.lastIndexOf("1"));
List l=al.subList(0,6);
System.out.println(l);

System.out.println("LISTITERATOR INTERFACE");
ListIterator li=al.listIterator();
li.add("7");
//al.add("8");
while(li.hasNext())//null not take
{
Object o=li.next();
if(o.equals("5")){
li.remove();
}
System.out.print(o+" ");
}
System.out.println("");
System.out.println(al);
while(li.hasPrevious()){
Object o=li.previous();
if(o.equals("5")){
li.remove();
}
System.out.print(o+" ");
}
System.out.println("");
System.out.println(al);
 li=al.listIterator(2);
while(li.hasNext())
{
Object o=li.next();
System.out.print(o+" ");
}
System.out.println(al);
System.out.println("END");
}
}