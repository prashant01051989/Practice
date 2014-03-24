package com.test.collection;

import java.util.ArrayDeque;

public class ArrayDequeTest {

	public static void main(String[] args) {
		ArrayDeque<String> ad=new ArrayDeque<String>();
		ad.add("FirstElement");
		ad.add("SecondElement");
		ad.add("ThirdElement");
		ad.add("FourElement");
		System.out.println(ad);
	}

}
