package om.coll.test;
import java.util.*;
 class MapTest3{
 public static void main(String as[]){
 TreeMap<Integer,String> tm1=new TreeMap<Integer,String>();
 System.out.println(tm1);
 System.out.println("tm1.size() :"+tm1.size());
 tm1.put(1,"A");
 tm1.put(2,"B");
 tm1.put(4,"D");
 tm1.put(3,"C");
 System.out.println(tm1);
//1.	tm1.put(null,"E");
//1.	tm1.put(5,null);
 tm1.put(101,"X");
 tm1.put(103,"M");
 System.out.println(tm1);
 System.out.println(tm1.tailMap(101));
  System.out.println(tm1.subMap(2,125));
 }
 }
 /*
 1.	Exception in thread "main" java.lang.NullPointerException
 */
 