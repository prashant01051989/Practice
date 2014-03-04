import java.util.*;


class Lab16{
public static void main(String as[]){
Calendar c= Calendar.getInstance();
Date d= c.getTime(); 
System.out.println(d);
System.out.println(c.get(Calendar.DATE));
System.out.println(c.get(Calendar.MONTH));
System.out.println(c.get(Calendar.YEAR));
System.out.println(c.get(Calendar.HOUR));
System.out.println(c.get(Calendar.MINUTE));
System.out.println(c.get(Calendar.SECOND));
System.out.println(c.get(Calendar.AM_PM));
Calendar c1= Calendar.getInstance();
c1.set(Calendar.DATE,20);
c1.set(Calendar.MONTH,1);
c1.set(Calendar.YEAR,2010);
System.out.println(c1.getTime());
System.out.println(c.after(c1));
System.out.println(c.before(c1));
System.out.println(c.getFirstDayOfWeek());
System.out.println(c.getTimeInMillis());
System.out.println(c.getActualMaximum(Calendar.DATE));
System.out.println(c.getActualMinimum(Calendar.DATE));
System.out.println(c.getLeastMaximum(Calendar.MONTH));
System.out.println(c.getGreatestMinimum(Calendar.MONTH));
System.out.println(c.isLenient());
}	
}