import java.util.*;

class Lab11{
public static void main(String as[]){
System.out.println("TREE_MAP");
TreeMap  tm=new TreeMap();
System.out.println(tm);
System.out.println(tm.size());
System.out.println(tm.isEmpty());
tm.put(new Integer(55),"a");
tm.put(new Integer(66),new Integer(33));
//tm.put(new Double(66.23),new Integer(77));
//tm.put("new",new Double(66.23));
tm.put(new Integer(88),"n");
//tm.put(null,new Integer(99));
//tm.put("asz",new Integer(44));
//tm.put("aaa","aaa");
tm.put(new Integer(99),null);
System.out.println("tm: "+tm);
System.out.println(tm.size());
System.out.println(tm.isEmpty());
//System.out.println(tm.containsKey("aaa"));
System.out.println(tm.containsValue("aaa"));
//System.out.println(tm.get("aaa"));
//System.out.println(tm.remove("aaa"));
System.out.println("tm.FirstKey(): "+tm.firstKey());
System.out.println("tm.LastKey(): "+tm.lastKey());
SortedMap sm=tm.subMap(new Integer(55), new Integer(88));
System.out.println("sm: "+sm);
 sm=tm.tailMap(new Integer(44));
System.out.println("sm: "+sm);
System.out.println("tm: "+tm);
System.out.println("END");
}
}