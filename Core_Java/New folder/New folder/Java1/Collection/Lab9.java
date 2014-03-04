import java.util.*;

class Lab9{
public static void main(String as[]){
System.out.println("LINKED_HASH_MAP");

LinkedHashMap  lhm=new LinkedHashMap();
System.out.println(lhm);
System.out.println(lhm.size());
System.out.println(lhm.isEmpty());
lhm.put(new Integer(55),"a");
lhm.put(new Integer(66),new Integer(33));
lhm.put(new Double(66.23),new Integer(77));
lhm.put("new",new Double(66.23));
lhm.put(new Integer(88),"n");
lhm.put(null,new Integer(99));
lhm.put("asz",new Integer(44));
lhm.put("aaa","aaa");
lhm.put(new Integer(99),null);
System.out.println("lhm: "+lhm);
System.out.println(lhm.size());
System.out.println(lhm.isEmpty());
System.out.println(lhm.containsKey("aaa"));
System.out.println(lhm.containsValue("aaa"));
System.out.println(lhm.get("aaa"));
System.out.println(lhm.remove("aaa"));
System.out.println("lhm: "+lhm);
System.out.println("END");
}
}