package com.test.lang;

class A{
	@Override
	public String toString(){
		return "This is A ";
	}
	
}
public class StringBufferTest {
	
	public void test(){
		StringBuffer sb1=new StringBuffer("Prahsant");
		System.out.println("sb1 :"+sb1);
		System.out.println("sb1.length() :"+sb1.length());
		System.out.println("sb1.capacity() :"+sb1.capacity());
		sb1.trimToSize();
		System.out.println("sb1.capacity() :"+sb1.capacity());
		sb1.setCharAt(2, 'A');
		System.out.println("sb1 :"+sb1);
		A a=new A();
		sb1.append(a);
		System.out.println("sb1 :"+sb1);
		String st=null;
		sb1.append(st);
		System.out.println("sb1 :"+sb1);
		st=" Infinite ";
		sb1.append(st);
		System.out.println("sb1 :"+sb1);
		float f=1.23f;
		sb1.append(f);
		System.out.println("sb1 :"+sb1);
		double d=2.25;
		sb1.append(f);
		System.out.println("sb1 :"+sb1);
		char []c=new char[]{' ','A','B'};
		sb1.append(c);
		System.out.println("sb1 :"+sb1);
		sb1.append('6');
		System.out.println("sb1 :"+sb1);
		sb1.append(true);
		System.out.println("sb1 :"+sb1);
		sb1.append(6);
		System.out.println("sb1 :"+sb1);
		//sb1.delete(401, 55);
		sb1.delete(41, 55);
		System.out.println("sb1 :"+sb1);
		sb1.deleteCharAt(39);
		System.out.println("sb1 :"+sb1);
		
		sb1.replace(32, 40,"Anshu");
		System.out.println("sb1 :"+sb1);
		System.out.println("sb1 :"+sb1.substring(32));
		System.out.println("sb1 :"+sb1.substring(10,20));
		
		
		c=new char[]{' ','A','B','C','D','E','F','G','H'};
		sb1.insert(37,c,0,4);
		System.out.println("sb1 :"+sb1);
		sb1.insert(41,a);
		System.out.println("sb1 :"+sb1);
		sb1.insert(51,"Computer");
		System.out.println("sb1 :"+sb1);
		System.out.println(sb1.length());
		System.out.println(sb1.reverse());
		
		
	}

	public static void main(String[] args) {
		StringBufferTest sbt=new StringBufferTest();
		sbt.test();
	}

}
