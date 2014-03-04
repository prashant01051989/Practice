import java.util.*;
class MathTest{
public static void main(String as[]){
System.out.println("---------------------MATH TEST----------------");
System.out.println("Math.abs(23.4456): "+Math.abs(23.4456));
System.out.println("Math.max(5,10): "+Math.max(5,10));
System.out.println("Math.max(10,10): "+Math.max(10,10));
System.out.println("Math.max(5.25,5.256): "+Math.max(5.25,5.256));
System.out.println("Math.min(5.25,5.256): "+Math.min(5.25,5.256));
System.out.println("Math.ulp(5.25): "+Math.ulp(5.25));
System.out.println("Math.ulp(5.2555556): "+Math.round(5.2555556));
System.out.println("Math.ulp(5.5555556): "+Math.round(5.5555556));
System.out.println("Math.sqrt(5): "+Math.sqrt(5));
System.out.println("Math.cbrt(5): "+Math.cbrt(5));
System.out.println("Math.ceil(5.5555556): "+Math.ceil(5.5555556));
System.out.println("Math.floor(5.5555556): "+Math.floor(5.5555556));
System.out.println("Math.floor(1.73333333333): "+Math.floor(1.73333333333));
Currency c=Currency.getInstance("rs");
System.out.println(c);
}
}
/*

*/