 import java.util.*;
 class MapTest1{
 public static void main(String as[]){
 Map<Integer,String> m1=new HashMap<Integer,String>();
 System.out.println(m1);
 m1.put(1,"A");
 m1.put(2,"B");
 m1.put(3,"C");
 m1.put(4,"D");
 System.out.println(m1);
 System.out.println("m1.size() :"+m1.size());
 System.out.println("");
System.out.println(m1.hashCode());
Map<Integer,Object> m2=new HashMap<Integer,Object>();
 m2.put(101,"AB");
 m2.put(201,"BB");
 m2.put(301,"CC");
 m2.put(401,"DD");
 m2.put(501,m1);
 m2.put(601,"ECC");
 System.out.println(m2);
 System.out.println(m2.put(701,"DDD"));
System.out.println(m2.put(701,"FFF"));
System.out.println(m2.put(702,null));
System.out.println(m2);
m2.put(null,null);
m2.put(666,null);
System.out.println(m2);
m2.put(null,"DFDFDF");
System.out.println(m2);
System.out.println(m2.containsKey(601));
System.out.println(m2.get(601));
System.out.println(m2.containsValue("FFFF"));
System.out.println(m2.isEmpty());
Set<Integer> s=m2.keySet();
System.out.println(s);
Collection<Object> s1=m2.values();
System.out.println(s1);
System.out.println(m2.hashCode());
Set<Map.Entry<Integer,Object>>se=m2.entrySet();
System.out.println(se);
Iterator it=se.iterator();
while(it.hasNext()){
Object o=it.next();
Map.Entry es=(Map.Entry)o;
System.out.print("es: "+es);
System.out.print("--: es.getKey(): "+es.getKey());
System.out.print("--: es.getValue(): "+es.getValue());
System.out.println("-- es.hashCode(): "+es.hashCode());
if(es.getValue()==null)
es.setValue("Prashant");
}
System.out.println("");
System.out.println(m2);
m2.clear();
System.out.println("m2: "+m2);

 }
 }