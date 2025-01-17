package com.test.builder;

public class NutritionFactsBuilder {
private final int servingSize;
private final int servings;
private final int calories;
private final int fat;
private final int sodium;
private final int carbohydrate;

public static class Builder{
	//Required
	private final int servingSize;
	private final int servings;
	
	//Optionals
	private  int calories=0;
	private  int fat=0;
	private  int sodium=0;
	private  int carbohydrate=0;
	
	public Builder(int servingSize,int servings){
		this.servingSize=servingSize;
		this.servings=servings;
	}

	public Builder calories(int val){
		calories=val;
		return this;
	}
	
	public Builder fat(int val){
		fat=val;
		return this;
	}
	
	public Builder sodium(int val){
		sodium=val;
		return this;
	}
	public Builder carbohydrate(int val){
		carbohydrate=val;
		return this;
	}
	public NutritionFactsBuilder build(){
		return new NutritionFactsBuilder(this);
	}
}
private NutritionFactsBuilder(Builder builder) {
servingSize = builder.servingSize;
servings = builder.servings;
calories = builder.calories;
fat = builder.fat;
sodium = builder.sodium;
carbohydrate = builder.carbohydrate;
}
public static void main(String as[]){
	NutritionFactsBuilder nfb=new NutritionFactsBuilder.Builder(30, 20).calories(10).carbohydrate(30).build();
	System.out.println(nfb);
}
}
