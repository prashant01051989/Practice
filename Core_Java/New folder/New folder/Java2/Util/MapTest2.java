 import java.util.*;
 class MapTest2{
 public static void main(String as[]){
 Hashtable<Integer,String> ht1=new Hashtable<Integer,String>();
 System.out.println(ht1);
 System.out.println("m1.size() :"+ht1.size());
 ht1.put(1,"A");
 ht1.put(2,"B");
 ht1.put(3,"C");
 ht1.put(4,"D");
 System.out.println(ht1);
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
 