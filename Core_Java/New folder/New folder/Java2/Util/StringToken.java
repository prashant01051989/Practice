import java.util.*;
public class StringToken{
public static void main(String as[]){
String str="Welcome to my StringTokenizer lab Thankyou";
StringTokenizer token=new StringTokenizer(str);
System.out.println("token.hasMoreTokens(): "+token.hasMoreTokens());
System.out.println("token.hasMoreTokens(): "+token.countTokens()); 
}
}