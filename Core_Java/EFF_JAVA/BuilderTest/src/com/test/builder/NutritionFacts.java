package com.test.builder;
public class NutritionFacts {
private final int servingSize;
private final int servings;
private final int calories;
private final int fat;
private final int sodium;
private final int carbohydrate;

public NutritionFacts(int servingSize, int servings){
	this(servingSize,servings,0);
	System.out.println("2-arg");
}

public NutritionFacts(int servingSize, int servings, int calories) {
	this(servingSize,servings,calories,0);
	System.out.println("3-arg");
}

public NutritionFacts(int servingSize, int servings, int calories,int fat){
	this(servingSize,servings,calories,fat,0);
	System.out.println("4-arg");
}

public NutritionFacts(int servingSize, int servings, int calories, int fat,
		int sodium) {
	this(servingSize,servings,calories,fat,sodium,0);
	System.out.println("5-arg");
}

public NutritionFacts(int servingSize, int servings, int calories, int fat,
		int sodium, int carbohydrate) {
	this.servingSize = servingSize;
	this.servings = servings;
	this.calories = calories;
	this.fat = fat;
	this.sodium = sodium;
	this.carbohydrate = carbohydrate;
}
	


public static void main(String[] args) {
	NutritionFacts nf=new NutritionFacts(10,20,30);
	
	
}
	
}
