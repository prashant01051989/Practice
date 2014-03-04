package com.test.controlStatement;

public class EnhancedForLoop {
	public static void main(String[] args) {
		int[] num = new int[5];
		int z = 10;
		for (int i = 0; i < num.length; i++)
			num[i] = ++z;

		for (int i : num) {
			System.out.println(i);
		}
	}

}
