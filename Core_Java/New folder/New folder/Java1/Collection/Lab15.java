import java.util.*;


class Lab15{
public static void main(String as[]){
Date d=new Date();
System.out.println(d);
System.out.println(d.getDate());
System.out.println(d.getMonth());
System.out.println(d.getMonth()+1);
System.out.println(d.getYear());
System.out.println(d.getYear()+1900);
System.out.println(d.getHours());
System.out.println(d.getMinutes());
System.out.println(d.getSeconds());
System.out.println(d.getTime());
int day=d.getDay();
String str="";
switch(day){
case 0:	str="Sunday";		break;
case 1:	str="Monday";		break;
case 2:	str="Tuesday";		break;
case 3:	str="Wednesday";	break;
case 4:	str="Thrusday";		break;
case 5:	str="Friday";		break;
case 6:	str="Saturday";		break;

}
System.out.println(day+"\t"+str);
Date d1=new Date(111,1,12); 
System.out.println(d1);
System.out.println(d.after(d1));
System.out.println(d.before(d1));
System.out.println(d.after(d));
System.out.println(d.before(d));
System.out.println(d);
d.setDate(10);
d.setMonth(0);
d.setYear(111);
d.setHours(12);
d.setMinutes(53);
d.setSeconds(55);
System.out.println(d);



}	
}