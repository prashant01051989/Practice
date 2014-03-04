package com.test.eum;

import java.util.HashMap;
import java.util.Map;

/*
 class A{}
 interface I{
 public String name();
 }



 //Enum type that switches on its own value - questionable
 enum EnumSwitch{
 PLUS,MINUS,DIVI,MULTI,CON;
 double apply(double x,double y){
 switch(this){
 case PLUS:	return x+y;
 case MINUS: return x-y;
 case DIVI: 	return x/y;
 case MULTI: return x*y;
 }
 throw new AssertionError("Unknown op: " + this);
 }
 }


 //Enum type with constant-specific method implementations

 //enum EnumMethod extends A{		-No
 //enum EnumMethod implements I{		-yes
 enum EnumMethod {
 PLUS{double apply(double x,double y){return x+y;}},
 MINUS{double apply(double x,double y){return x-y;}},
 DIVI{double apply(double x,double y){return x/y;}},
 MULTI{double apply(double x,double y){return x*y;}} //CONS
 ;
 abstract double apply(double x,double y);
 }


 //Enum type with constant-specific class bodies and data
 enum EnumDataMethod {

 PLUS("+"){double apply(double x,double y){return x+y;}},
 MINUS("-"){double apply(double x,double y){return x-y;}},
 DIVI("/"){double apply(double x,double y){return x/y;}},
 MULTI("*"){double apply(double x,double y){return x*y;}};
 private final String symbol;
 abstract double apply(double x,double y);
 EnumDataMethod(String symbol){
 this.symbol=symbol;
 }
 public String toString(){
 return symbol;
 }

 }

 //Implementing a fromString method on an enum type
 enum EnumFromString {

 PLUS("+") {
 double apply(double x, double y) {
 return x + y;
 }
 },
 MINUS("-") {
 double apply(double x, double y) {
 return x - y;
 }
 },
 MULTI("*") {
 double apply(double x, double y) {
 return x * y;
 }
 },
 DIVIDE("/") {
 double apply(double x, double y) {
 return x / y;
 }
 };
 private final String symbol;

 EnumFromString(String symbol) {
 this.symbol = symbol;
 }

 @Override
 public String toString() {
 return symbol;
 }

 abstract double apply(double x, double y);

 // Implementing a fromString method on an enum type - Page 154
 private static final Map<String, EnumFromString> stringToEnum = new HashMap<String, EnumFromString>();
 static { // Initialize map from constant name to enum constant
 System.out.println("static block");
 for (EnumFromString op : values())
 stringToEnum.put(op.toString(), op);
 }

 // Returns Operation for string, or null if string is invalid
 public static EnumFromString fromString(String symbol) {
 System.out.println("fromString");
 return stringToEnum.get(symbol);
 }


 }
 */

public class EnumTest {

	public static void main(String[] args) {
		for(Planet p:Planet.values()){
			System.out.println(p.ordinal()+"   "+p.name()+"   "+p.toString()+"  "+Planet.valueOf(p.name()));
			
		}

	}

}
