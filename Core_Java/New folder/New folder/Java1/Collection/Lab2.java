import java.util.*;

class Lab2 {
public static void main(String as[]){
System.out.println("ARRAY_LIST CLASS");

ArrayList  al=new ArrayList();
al.add("a");
al.add("b");
al.add("c");
al.add("d");
al.add("e");
al.add("f");
al.add(null);
al.add("f");
System.out.println("al: "+al);
ArrayList  al1=(ArrayList)al.clone();
System.out.println("al1: "+al1);
//al1.removeRange(1,4);

System.out.println("END");
}
}