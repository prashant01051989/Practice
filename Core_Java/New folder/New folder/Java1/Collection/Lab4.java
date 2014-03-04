import java.util.*;

class Lab4{
public static void main(String as[]){
System.out.println("LINKEDLIST_LIST CLASS");

LinkedList  l=new LinkedList();
l.add("a");
l.add("b");
l.add("c");
l.add("d");
l.add("e");
l.add("f");
l.add(null);
l.add("f");
System.out.println("l: "+l);
l.addFirst("g");
System.out.println("l.getFirst(): "+l.getFirst());
System.out.println("l.getLast(): "+l.getLast());
System.out.println("l.offer(\"h\"): "+l.offer("h"));
System.out.println("l.peek(): "+l.peek());
System.out.println("l.poll(): "+l.poll());
System.out.println("l.remove(): "+l.remove());
System.out.println("l.removeFirst(): "+l.removeFirst());
System.out.println("l.removeLast(): "+l.removeLast());
System.out.println("l: "+l);
System.out.println("END");
}
}