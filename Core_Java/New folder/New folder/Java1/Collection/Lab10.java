import java.util.*;

class Lab10{
public static void main(String as[]){
System.out.println("HASHTABLE_MAP");
Hashtable  ht=new Hashtable();
System.out.println(ht);
System.out.println(ht.size());
System.out.println(ht.isEmpty());
ht.put(new Integer(55),"a");
ht.put(new Integer(66),new Integer(33));
ht.put(new Double(66.23),new Integer(77));
ht.put("new",new Double(66.23));
ht.put(new Integer(88),"n");
//ht.put(null,new Integer(99));
ht.put("asz",new Integer(44));
ht.put("aaa","aaa");
//ht.put(new Integer(99),null);
System.out.println("ht: "+ht);
System.out.println(ht.size());
System.out.println(ht.isEmpty());
System.out.println(ht.containsKey("aaa"));
System.out.println(ht.containsValue("aaa"));
System.out.println(ht.get("aaa"));
System.out.println(ht.remove("aaa"));
System.out.println("ht: "+ht);
System.out.println("END");
}
}