import java.util.*;
class LinkHashSetColl2{

public static void main(String as[]){
LinkedHashSet lhs1=new LinkedHashSet();
System.out.println("lhs1.size(): "+lhs1.size());
System.out.println("lhs1.isEmpty(): "+lhs1.isEmpty());
lhs1.add("My");
lhs1.add(new Integer(123));
lhs1.add(new Integer(123));//No dublicate object or element.It will not give any error.
lhs1.add(new Long(123));
lhs1.add(null);
lhs1.add(new Integer(1211253));
lhs1.add("null");
System.out.println(lhs1);

Iterator it=lhs1.iterator();
while(it.hasNext()){
System.out.print("  "+it.next());
}
System.out.println();
System.out.println("lhs1.isEmpty(\"My\"): "+lhs1.contains("My"));
System.out.println("lhs1.isEmpty(new Integer(3333)): "+lhs1.contains(new Integer(333)));
}
}