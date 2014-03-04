import java.util.*;
class HashSetColl1{
static HashSet m1(HashSet s){
return s;
}
public static void main(String as[]){
HashSet hs1=new HashSet();
System.out.println("hs1.size(): "+hs1.size());
System.out.println("hs1.isEmpty(): "+hs1.isEmpty());
hs1.add("My");
hs1.add(new Integer(123));
hs1.add(new Integer(123));//No dublicate object or element.It will not give any error.
hs1.add(new Long(123));
hs1.add(null);
hs1.add(new Integer(1211253));
hs1.add("null");
System.out.println(hs1);
Iterator it=hs1.iterator();
while(it.hasNext()){
System.out.print("  "+it.next());
}
HashSet hs2=m1(hs1);
System.out.println("  ");
it=hs2.iterator();
while(it.hasNext()){
System.out.print("  "+it.next());
}
}
}