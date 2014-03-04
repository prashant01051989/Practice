import java.util.*;
class LocaleTest{
public static void main(String as[]){
System.out.println(Locale.JAPAN);
System.out.println(Locale.getDefault());
Locale l1[]=Locale.getAvailableLocales();
System.out.println("*******getAvailableLocales************");
for(int i=0;i<l1.length;i++){
System.out.print(l1[i]+" ,");
}
System.out.println();
System.out.println("*******getISOCountries************");
String s1[]=Locale.getISOCountries();
for(int i=0;i<s1.length;i++){
System.out.print(s1[i]+" ,");
}
System.out.println();
System.out.println("*******getISOLanguages************");
String s2[]=Locale.getISOLanguages();
for(int i=0;i<s2.length;i++){
System.out.print(s2[i]+" ,");
}
System.out.println();
System.out.println("*******Methods Test************");
Locale loc1=new Locale("HI","India");
Locale loc2=new Locale("en");
Locale loc3=new Locale("en");
System.out.println("loc1.toString(): "+loc1.toString());
System.out.println("loc1.equals(loc2): "+loc1.equals(loc2));
System.out.println("loc3.equals(loc2): "+loc3.equals(loc2));

System.out.println("loc1.getCountry(): "+loc1.getCountry());
System.out.println("loc1.getDisplayCountry(): "+loc1.getDisplayCountry());
System.out.println("loc1.getVariant(): "+loc1.getVariant());
System.out.println("loc1.getDisplayVariant(): "+loc1.getDisplayVariant());
System.out.println("loc1.getLanguage(): "+loc1.getLanguage());
System.out.println("loc1.getDisplayLanguage(): "+loc1.getDisplayLanguage());

System.out.println("loc2.getCountry(): "+loc2.getCountry());
System.out.println("loc2.getDisplayCountry(): "+loc2.getDisplayCountry());
System.out.println("loc2.getVariant(): "+loc2.getVariant());
System.out.println("loc2.getDisplayVariant(): "+loc2.getDisplayVariant());
System.out.println("loc2.getLanguage(): "+loc2.getLanguage());
System.out.println("loc2.getDisplayLanguage(): "+loc2.getDisplayLanguage());
}
}