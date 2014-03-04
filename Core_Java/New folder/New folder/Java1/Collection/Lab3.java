import java.util.*;

class Lab3{
public static void main(String as[]){
System.out.println("VECTOR_LIST CLASS");

Vector  v=new Vector();
v.add("a");
v.add("b");
v.add("c");
v.addElement("d");
v.add("e");
v.add("f");
v.add(null);
v.add("f");
System.out.println("v: "+v);
v.insertElementAt("1",6);
v.setElementAt("2",6);
Vector  v1=(Vector)v.clone();
System.out.println("v1: "+v1);
System.out.println("v.lastElement(): "+v.lastElement());
System.out.println("v.firstElement(): "+v.firstElement());
System.out.println("v.elementAt(2): "+v.elementAt(2));
System.out.println("v.indexOf(\"2\",1): "+v.indexOf("2",1));
System.out.println("v.lastIndexof(\"2\",4): "+v.lastIndexOf("2",4));
v.removeElementAt(2);
System.out.println("v.removeElement(null): "+v.removeElement(null));
Enumeration en=v.elements();
while(en.hasMoreElements()){
System.out.print(en.nextElement()+" ");
}
v.removeAllElements();
System.out.println("v: "+v);
System.out.println("END");
}
}