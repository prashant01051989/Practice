import java.util.*;

class Lab6{
public static void main(String as[]){
System.out.println("LINKEDHASHSET_SET CLASS");

LinkedHashSet  lh=new LinkedHashSet();
lh.add("a");
lh.add("b");
lh.add("c");
lh.add("d");
lh.add("e");
lh.add(new Integer(99));
lh.add(null);
//h.add("f");
System.out.println("lh: "+lh);
System.out.println("END");
}
}