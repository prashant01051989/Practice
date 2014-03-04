import java.util.*;
import java.util.*;
class Hello{}
public class AList1{
public static void main(String as[]){

Collection cl1=new ArrayList();
System.out.println(cl1);
System.out.println(cl1.size());
System.out.println(cl1.isEmpty());
System.out.println(cl1.hashCode());
cl1.add("ans");
cl1.add("ans");
cl1.add(null);
cl1.add("nshu");
cl1.add(new Double(33.36));
cl1.add(new Long(99945));

System.out.println(cl1);
System.out.println(cl1.size());
System.out.println(cl1.isEmpty());
System.out.println(cl1.hashCode());
System.out.println("cl1.equals(cl1): "+cl1.equals(cl1));
Collection cl2=new ArrayList();
cl2.add(new Double(33.36));
cl2.add(new Long(99945));
cl2.add("ans");
cl2.add(null);
cl2.add("nshu");
System.out.println("cl1.equals(cl2): "+cl1.equals(cl2));

cl1.add(cl1);
System.out.println(cl1);

cl1.addAll(cl1);
System.out.println(cl1);

System.out.println(cl1.contains(cl1));
System.out.println(cl1.containsAll(cl1));
/*2.
Collection cl3=null;
System.out.println(cl1.containsAll(cl3));
*/
Collection cl4=new ArrayList();
cl4.add(new Hello());
System.out.println(cl1.containsAll(cl4));


System.out.println("Displaying through for loop");
Object[] o1=cl1.toArray();
for(int i=0;i<o1.length;i++){
System.out.println(o1[i]);
}

System.out.println("Displaying through iterator");
Iterator it=cl1.iterator();
while(it.hasNext()){
Object o=it.next();
System.out.println(o);
}

System.out.println(cl1.size());

System.out.println(cl1.remove(cl1));
System.out.println(cl1);
cl1.add(cl1);
System.out.println(cl1);
System.out.println(cl1.removeAll(cl1));
System.out.println(cl1);
/*
System.out.println(cl1.retainAll(cl1));
System.out.println(cl1);
cl1.clear();
System.out.println(cl1);
//1.	cl1.get(1);
*/
}
}
/*
1.	AList1.java:46: cannot resolve symbol
symbol  : method get (int)
location: interface java.util.Collection
cl1.get(1);
2.	Exception in thread "main" java.lang.NullPointerException
*/