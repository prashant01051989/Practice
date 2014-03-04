class Test_Integer{
public static void main(String as[]){
Integer a=new Integer(-1987);
Integer a1=new Integer(12);
String str=a.toString();

System.out.println(str);
System.out.println(Integer.toString(a,2));
System.out.println(a.hashCode());
System.out.println(a1.doubleValue());
System.out.println(a1.intValue());
System.out.println(a1.shortValue());
System.out.println(a1.byteValue());
System.out.println(Integer.reverseBytes(12));
System.out.println(Integer.signum(a1));
System.out.println(Integer.reverse(14));
System.out.println(a1.compareTo(a));
System.out.println(Integer.decode("12"));

str=Integer.toHexString(a);
System.out.println(str);
System.out.println(a1.equals(a));
System.out.println(Integer.parseInt("111000",2));
int a3=Integer.parseInt("234");
System.out.println(a3);
//System.out.println(Integer.getChars(12345,1, e));
System.out.println(Integer.MAX_VALUE);
System.out.println(Integer.MIN_VALUE);
System.out.println(Integer.TYPE);
System.out.println(Integer.SIZE);
str=Integer.toBinaryString(1235);
System.out.println(str);
str="11111111110";
System.out.println(Integer.valueOf(str));
//System.out.println(Integer.getInteger("os.name"));


}
}
/*
*Returns a String object representing this Integer's value. The value is
converted to signed decimal representation and returned as a string, 
exactly as if the integer value were given as an argument to the 
{@link java.lang.Integer#toString(int)} method.
*Returns a string representation of the first argument in the radix specified 
 by the second argument. 
* a hash code value for this object, equal to the primitive 
<code>int</code> value represented by this <code>Integer</code> object. 
*Returns the value of this Integer as a double. 
*Returns the value of this Integer as an int. 
*Returns the value of this Integer as a short.
*Returns the value of this Integer as a byte. 
*Returns the value obtained by reversing the bytes in the specified int value
*Returns the value obtained by reversing the order of the bytes in the two's 
complement representation of the specified int value.
*Compares two Integer objects numerically.
*Decodes a <code>String</code> into an <code>Integer</code>. Accepts decimal,
hexadecimal, and octal numbers given.

*Returns a string representation of the integer argument as an unsigned integer
in base 16. 
*Returns a String object representing the specified integer. The argument is 
converted to signed decimal representation and returned as a string, exactly
as if the argument and radix 10 
*Compares this object to the specified object. The result is true if and only
if the argument is not null and is an Integer object that contains the same
int value as this object. 
*Parses the string argument as a signed integer in the radix specified by the
second argument. The characters in the string must all be digits of the specified
radix except that the first character may be an ASCII minus sign '-' 
('\u002D') to indicate a negative value. The resulting integer value is 
returned. 
*Parses the string argument as a signed decimal integer. The characters in 
the string must all be decimal digits, except that the first character may 
be an ASCII minus sign '-' ('\u002D') to indicate a negative value.
*A constant holding the maximum value an int can have, 2 power31 -1. 
*A constant holding the minimum value an int can have, -2power 31. 
*The Class instance representing the primitive type int.
*The number of bits used to represent an int value in two's complement binary form. 
*/