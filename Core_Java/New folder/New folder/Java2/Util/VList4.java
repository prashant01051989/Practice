import java.util.*;
class VList4{
public static void main(String as[]){
Vector v1=new Vector();
System.out.println("v1.capacity(): "+v1.capacity());
v1.add("ADD");
v1.add("Sub");
v1.add(new Double(3445));
v1.add(new Integer(2345));
v1.add(new Integer(2345));
v1.add(null);
System.out.println(v1);
v1.add(2,"Add2index");
System.out.println(v1);
v1.addElement("AddElement");
System.out.println(v1);
System.out.println("v1.capacity(): "+v1.capacity());
System.out.println("v1.elementAt(2): "+v1.elementAt(2));
System.out.println("v1.get(2): "+v1.get(2));
System.out.println("v1.toString(): "+v1.toString());
System.out.println("v1.size(): "+v1.size());
v1.setSize(13);
System.out.println("v1.size(): "+v1.size());
System.out.println(v1);
v1.add("Hai");
System.out.println(v1);
System.out.println("v1.set(8,\"Hello\"): "+v1.set(8,"Hello"));
System.out.println(v1);
v1.setElementAt("9Hello",9);
System.out.println(v1);
v1.removeElementAt(2);
System.out.println(v1);
System.out.println("v1.removeElement(null):" +v1.removeElement(null));
System.out.println(v1);
//v1.removeAllElements();
//System.out.println("v1.size(): "+v1.size());
System.out.println("v1.lastIndexOf(null,5):" +v1.lastIndexOf(null,8));
v1.insertElementAt("Prashant",8);
System.out.println(v1);
System.out.println("v1.lastElement():" +v1.lastElement());
System.out.println("v1.firstElement():" +v1.firstElement());
System.out.println("v1.hashCode():" +v1.hashCode());
Enumeration enu=v1.elements();
while(enu.hasMoreElements()){
System.out.println(enu.nextElement());
}
}
}