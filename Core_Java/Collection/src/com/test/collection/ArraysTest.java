package com.test.collection;

import java.util.Arrays;
import java.util.List;

public class ArraysTest {

	public static void main(String[] args) {
		String []st={"Anshu","Prashant","Kumar","23 "};
		Integer []i={100,200,300,400,500};
		String st1=Arrays.toString(i);
		System.out.println(st1);
		byte []by=new byte[5];
		
		by[0]=50;
		by[1]=10;
		by[2]=40;
		by[3]=30;
		by[4]=20;
		st1=Arrays.toString(by);
		System.out.println(st1);
		Arrays.sort(by);
		for(int x=0;x<by.length;x++){
			System.out.print(by[x]+"\t");
		}
		System.out.println();
		int []i2=new int[5];
		i2[0]=50;
		i2[1]=30;
		i2[2]=10;
		i2[3]=40;
		i2[4]=20;
		Arrays.sort(i2, 1,3);
		for(int x=0;x<i2.length;x++){
			System.out.print(i2[x]+"\t");
		}
		System.out.println();
		
		List<String> blist=Arrays.asList("Anshu","Prashant","Kumar","Infinite");
		System.out.println(blist);
		String []st3=(String[]) blist.toArray();
		for(int x=0;x<st3.length;x++){
			System.out.print(st3[x]+"\t");
		}
		System.out.println();
	
	}

}
