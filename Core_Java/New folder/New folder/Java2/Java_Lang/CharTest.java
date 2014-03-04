class CharTest{
public static void main(String as[]){
System.out.println((int)Character.MIN_VALUE);
System.out.println((int)Character.MAX_VALUE);
System.out.println(Character.UNASSIGNED);
System.out.println((char)Character.UPPERCASE_LETTER);
System.out.println("*******char to  Character********");
Character c1=new Character('a');
System.out.println(c1);
c1=Character.valueOf('4');
System.out.println(c1);
System.out.println("*******Character to char********");
char ch1=c1.charValue();
System.out.println(ch1);
System.out.println("**********************************");
System.out.println(c1.hashCode());
Character c2='p';
Character c3='p';
System.out.println(c2.equals(c3));
System.out.println(c2.toString());
System.out.println(c2.);
}
}