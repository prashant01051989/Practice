package om.coll.test;
import java.util.*;
 class MapTest2{
 public static void main(String as[]){
 Hashtable ht1=new Hashtable();
 System.out.println(ht1);
 System.out.println("m1.size() :"+ht1.size());
 ht1.put(1,"A");
 ht1.put(2,"A");
 ht1.put(3,new Integer(3));
 ht1.put(4,"D");
 System.out.print("\t"+ht1);
 System.out.println();
 //1.	ht1.put(null,"E");
 //1.	ht1.put(5,null);
 	System.out.println(ht1.put(4,"Anshu"));
	System.out.println(ht1.put(5,"C"));
	System.out.println(ht1);

 }
 }
 /*
 1.	Exception in thread "main" java.lang.NullPointerException
 */
 