package com.collection.set.test;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTEst {

	

	   private static final int MAX_ENTRIES = 5;

	   @SuppressWarnings({ "serial", "rawtypes" })
	public static void main(String[] args) {
	      LinkedHashMap lhm = new LinkedHashMap(MAX_ENTRIES + 1, .75F, false) {

	         protected boolean removeEldestEntry(Map.Entry eldest) {
	        	 System.out.println(">>>>>>>>>>>>>>>"+ eldest);
	            return size() > MAX_ENTRIES;
	         }
	      };
	      lhm.put(0, "H");
	      lhm.put(1, "E");
	      lhm.put(2, "L");
	      lhm.put(3, "L");
	      lhm.put(4, "O");
	      lhm.put(4, "O");
	     // lhm.put(lhm, "O");

	      System.out.println("" + lhm);

	   }
	

}
