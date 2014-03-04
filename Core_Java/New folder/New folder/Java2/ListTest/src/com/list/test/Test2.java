package com.list.test;

import java.util.*;




public class Test2 {
	
public static void main(String[] args) {
	List<String> arr1=new LinkedList<String>();
	arr1.add("Anshu");
	arr1.add(null);
	arr1.add("Anshu");
	System.out.println(arr1.hashCode());
	System.out.println(arr1);
	/*List<String> arr2=new ArrayList<String>(arr1);
	arr2.add("PRashant");
	arr2.add(null);
	arr2.add("Anshu");
	*/
}
}
