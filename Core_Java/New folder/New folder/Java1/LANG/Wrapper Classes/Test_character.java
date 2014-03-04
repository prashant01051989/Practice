class Test_character{
public static void main(String as[]){
Character c=new Character('a');
Character c1=new Character('A');
Character c2='1';
Character c3='\n';
System.out.println(Character.isLowerCase(c1));
System.out.println(Character.isUpperCase(c1 ));
System.out.println(Character.isDigit(c2));
System.out.println(Character.isLetter(c1));
System.out.println(Character.isLetterOrDigit(c2));
//System.out.println(Character.isJavaLetter('-'));
System.out.println(Character.toLowerCase(c1));
System.out.println(Character.toUpperCase(c));
System.out.println(Character.getNumericValue(c1));
//System.out.println(Character.isSpace(c3));
System.out.println(c1.compareTo(c));
Character c4=Character.valueOf('1');
System.out.println(c4);
char t=c1.charValue();
System.out.println(t);
int i=c1.hashCode();
System.out.println(i);
boolean b=c.equals(c1);
System.out.println(b);
String s=c1.toString();
System.out.println(s);
System.out.println(Character.toString('s'));



}
}
