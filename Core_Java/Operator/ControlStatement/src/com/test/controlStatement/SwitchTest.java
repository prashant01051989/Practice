package com.test.controlStatement;

public class SwitchTest {

	public static void main(String[] args) {
		int a = 6;
		char c = 65;
		byte b = 10;
		long l = 100;
		final int I = 10;
		// ** switch (int a=10) {
		// switch (a) {
		// switch (c) {
		// switch (b) {
		// ** switch (l) {
		// switch (a+b) {
		switch (b) {
		// *case (a + b):
		// case(a):
		case I:
			System.out.println("1");
			// case 5+a:
		case 5:
			System.out.println("5");
			// case 128:
			// case 5:
			// case 5>4:
		case 15:

			System.out.println("6");
			System.out.println("Hi");
		case 'a':
			System.out.println('a');
		}
	}

}