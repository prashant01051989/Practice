package com.test.enum1;

public enum Operation {
	
		/*PLUS, MINUS, TIMES, DIVIDE;
		// Do the arithmetic op represented by this constant
		double apply(double x, double y) {
		switch(this) {
		case PLUS: return x + y;
		case MINUS: return x - y;
		case TIMES: return x * y;
		case DIVIDE: return x / y;
		}
		throw new AssertionError("Unknown op: " + this);
		}*/
	PLUS { public double apply(double x, double y){return x + y;} },
	MINUS { double apply(double x, double y){return x - y;} },
	TIMES { double apply(double x, double y){return x * y;} },
	DIVIDE { double apply(double x, double y){return x / y;} },
	MUL{double apply(double x,double y){return x%y; }};
	
	abstract double apply(double x, double y);
	
	
	
	
		public static void main(String[] args) {
			double x = 10;
			double y = 20;
			for (Operation op : Operation.values())
			System.out.printf("%f %s %f = %f%n",x, op, y, op.apply(x, y));
			}
}
