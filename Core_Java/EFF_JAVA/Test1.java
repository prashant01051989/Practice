package com.eff.java.test;

import java.util.ArrayList;
import java.util.Locale;

class A{
	public final StringBuffer sb=new StringBuffer("Anshu");
	A(){
		
	}
}
public class Test1 {
	public static void main(String[] args) {
		/*A a =new A();
		System.out.println(a.sb);
		a.sb.append("Prahsant");
		System.out.println(a.sb);
		Long.valueOf(1);*/
		/*final int [] a=new int[2];
		a[0]=1;
		System.out.println(a[0]);
		a[0]=11;
		System.out.println(a[0]);*/
		
		/*ArrayList a1=new ArrayList();
		a1.add("a1");
		ArrayList a2=new ArrayList();
		a2.add("a2");
		if(a1.isEmpty() &&  a2.isEmpty()){
			System.out.println("PASSED");
		} else if(a1.isEmpty() ) {
			System.out.println("PASSED_WITH_WARNINGS");			
		} else {
			System.out.println("FAILED");
		}*/
		/*Boolean b1=true;
		Boolean b2=false;
		boolean b3=(!b1.valueOf(true)==false);
		System.out.println(b3);*/
		Locale.setDefault(new Locale("lt"));
		String st="TITLE";
		System.out.println(st);
		String lc=st.toLowerCase();
		System.out.println(lc);
		Locale.setDefault(new Locale("us"));
		String lc1=st.toLowerCase();
		System.out.println(lc1);
	}
}
