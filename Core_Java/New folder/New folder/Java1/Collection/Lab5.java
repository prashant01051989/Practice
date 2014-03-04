import java.util.*;

class Lab5{
public static void main(String as[]){
System.out.println("HASHSET_SET CLASS");

HashSet  h=new HashSet();
h.add("a");
h.add("b");
h.add("c");
h.add("d");
h.add("e");
h.add(new Integer(99));
h.add(null);
//h.add("f");
System.out.println("h: "+h);
System.out.println("END");
}
}