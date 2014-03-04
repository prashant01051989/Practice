package com.collection.set.test;

import java.util.Date;
import java.util.HashSet;



class C{
	public int hashCode(){
		System.out.println("dddddddd");
		return (int)(new Date()).getTime();
	}
}
public class dfdf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		C a =new C();
		HashSet<C> h=new HashSet<C>();
		h.add(a);
		h.add(a);
		h.add(a);
		h.add(a);
		h.add(a);

	}

}

