import java.util.*;

class Lab8{
public static void main(String as[]){
System.out.println("HASH_MAP");

HashMap  hm=new HashMap();
System.out.println(hm);
System.out.println(hm.size());
System.out.println(hm.isEmpty());
hm.put(new Integer(55),"a");
hm.put(new Integer(66),new Integer(33));
hm.put(new Double(66.23),new Integer(77));
hm.put("new",new Double(66.23));
hm.put(new Integer(88),"n");
hm.put(null,new Integer(99));
hm.put("asz",new Integer(44));
hm.put("aaa","aaa");
hm.put(new Integer(99),null);
System.out.println("hm: "+hm);
System.out.println(hm.size());
System.out.println(hm.isEmpty());
System.out.println(hm.containsKey("aaa"));
System.out.println(hm.containsValue("aaa"));
System.out.println(hm.get("aaa"));
System.out.println(hm.remove("aaa"));
Collection col=hm.values();
System.out.println("col: "+col);
Set s=hm.keySet();
System.out.println("s: "+s);
System.out.println("hm: "+hm);
System.out.println("Using KeySet()");
Iterator it=s.iterator();
while(it.hasNext()){
Object ob1=it.next();
Object key=null;
if(ob1 instanceof String){
key=ob1.toString();
}else if (ob1 instanceof Integer){
key=(Integer)ob1;
}else if (ob1 instanceof Double){
key=(Double)ob1;
}else if(ob1==null){
key=null;
}
Object ob2=hm.get(key);
Object val=null;
if(ob2 instanceof String){
val=ob2.toString();
}else if (ob2 instanceof Integer){
val=(Integer)ob2;
}else if (ob2 instanceof Double){
val=(Double)ob2;
}else if(ob2==null){
val=null;
}
System.out.println(key+"-----"+val);
}
System.out.println("Using entrySet()");
Set es=hm.entrySet();
Iterator it1=es.iterator();
while(it1.hasNext()){
Object ob1=it1.next();
Map.Entry me=(Map.Entry)ob1;
Object ob2=me.getKey();
Object key=null;
if(ob2 instanceof String){
key=ob2.toString();
}else if (ob2 instanceof Integer){
key=(Integer)ob2;
}else if (ob2 instanceof Double){
key=(Double)ob2;
}else if(ob2==null){
key=null;
}
Object ob3=me.getValue();
Object val=null;
if(ob3 instanceof String){
val=ob3.toString();
}else if (ob3 instanceof Integer){
val=(Integer)ob3;
}else if (ob3 instanceof Double){
val=(Double)ob3;
}else if(ob2==null){
val=null;
}
System.out.println(key+"-----"+val);
}





System.out.println("END");
}
}