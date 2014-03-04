import java.util.*;
class TreeSetColl3{
public static void main(String as[]){
TreeSet ts1=new TreeSet();
System.out.println(ts1.size());
ts1.add(new Integer(23));
ts1.add(new Integer(11));
//ts1.add(new Integer(11)); No Duplicate value
//1.	ts1.add(null);
ts1.add("Anssu");
System.out.println(ts1);
}
}
/*
1. NullPointerException
*/