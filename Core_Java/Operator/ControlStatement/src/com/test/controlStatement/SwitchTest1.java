package com.test.controlStatement;

public class SwitchTest1 {

	public static void main(String[] args) {
		int a = 10;

		switch (a) {
		case 1: {
			System.out.println("1");
			if (1 == a)
				System.out.println("TRUE");
			else
				System.out.println("FALSE");
			//continue;
		}
		default:
			System.out.println("This is a default");
			break;
		case 5:
			if (a == 5) {
				System.out.println("5");
			} else
				System.out.println("NOT MATCH");
			break;
		/*default:
			System.out.println("This is a default");
			break;*/
		case 15:
			System.out.println("6");
			System.out.println("Hi");
		case 'a':
			System.out.println('a');
		/*default:
			System.out.println("This is a default");*/
		}
	}
}
