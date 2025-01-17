package com.collection.set.test;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;

/*

import java.util.PriorityQueue;




class Product implements Comparable<Product>{
	int id;
	String name;
	public Product(int id,String name){
		this.id=id;
		this.name=name;
	}
	public boolean equals(Object o){
		System.out.println("equals");
		if(o instanceof Product){
			Product p=(Product)o;
			if(this.name.equals(p.name))
				return true;
		}
		return false;
	}
	public int hashCode(){
		System.out.println("hashcode");
		return id;
	}
	
	public int compareTo(Product p){
		return this.name.compareTo(p.name);
	}
	public String toString(){
		return String.valueOf(this.id);
	}
}



public class PriorityQueueTest {

	
	public static void main(String[] args) {
		Product p1=new Product(1,"C");
		Product p2=new Product(2,"D");
		Product p3=new Product(3,"B");
		Product p4=new Product(4,"A");
		PriorityQueue<Product>pq=new PriorityQueue<Product>();
		pq.add(p1);
		pq.add(p2);
		pq.add(p3);
		pq.add(p4);
		System.out.println(pq);
		
	}

}
*/



/*enum ProductQuality {
  Nigh, Medium, Low
}

class Product implements Comparable<Product> {
  String name;

  ProductQuality priority;

  Product(String str, ProductQuality pri) {
    name = str;
    priority = pri;
  }

  public int compareTo(Product msg2) {
	  System.out.println("CompareTO method");
    return priority.compareTo(msg2.priority);
  }
}

class MessageComparator implements Comparator<Product> {
  public int compare(Product msg1, Product msg2) {
    return msg2.priority.compareTo(msg1.priority);
  }
}

public class PriorityQueueTest {
  public static void main(String args[]) {

    PriorityQueue<Product> pq = new PriorityQueue<Product>(3);

    pq.add(new Product("A", ProductQuality.Low));
    pq.add(new Product("B", ProductQuality.Nigh));
    pq.add(new Product("C", ProductQuality.Medium));
    //pq.add(null);
    Product m;
    while ((m = pq.poll()) != null)
      System.out.println(m.name + " Priority: " + m.priority);

    PriorityQueue<Product> pqRev = new PriorityQueue<Product>(3, new MessageComparator());

    pqRev.add(new Product("D", ProductQuality.Low));
    pqRev.add(new Product("E", ProductQuality.High));
    pqRev.add(new Product("F", ProductQuality.Medium));

    while ((m = pqRev.poll()) != null)
      System.out.println(m.name + " Priority: " + m.priority);
  }
}*/

public class PriorityQueueTest
{  
   public static void main(String[] args)
   {  
      PriorityQueue<GregorianCalendar> pq = new PriorityQueue<GregorianCalendar>();
      pq.add(new GregorianCalendar(1906, Calendar.DECEMBER, 9)); // G. Hopper
      pq.add(new GregorianCalendar(1815, Calendar.DECEMBER, 10)); // A. Lovelace
      pq.add(new GregorianCalendar(1903, Calendar.DECEMBER, 3)); // J. von Neumann
      pq.add(new GregorianCalendar(1910, Calendar.JUNE, 22)); // K. Zuse

      System.out.println("Iterating over elements...");
      for (GregorianCalendar date : pq)
         System.out.println(date.get(Calendar.YEAR));
      System.out.println("Removing elements...");
      while (!pq.isEmpty())
         System.out.println(pq.remove().get(Calendar.YEAR));
   }
}


