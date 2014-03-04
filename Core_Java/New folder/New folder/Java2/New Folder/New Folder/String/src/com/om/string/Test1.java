package com.om.string;

public class Test1 {

	public static void main(String[] args) {
		String s1="My name is Prashant";
		System.out.println(s1.trim());
		System.out.println(s1);
		String s2="prashant";
		int con=0;
		int spa=0;
		System.out.println(s1.compareTo(s2));
		char []c1=s1.toCharArray();
		
		for(int i=0;i<c1.length;i++){
			System.out.print(","+c1[i]);
			switch(c1[i]){
			case ' ':
				c1[i]='A';
				break;
			
			}
		}
		s1=String.copyValueOf(c1);
		System.out.println(s1);
		System.out.println("");
 System.out.println(con);
 System.out.println(spa);
	}

}
