package com.om.ser1;

import java.io.Serializable;

import com.om.ser2.Collar;

public class Cat implements Serializable{
	private static Collar col;
	private	int dog;
	public Cat(Collar col, int dog) {
		super();
		this.col = col;
		this.dog = dog;
	}
	public Collar getCol() {
		return col;
	}

	public void setCol(Collar col) {
		this.col = col;
	}

	public int getDog() {
		return dog;
	}

	public void setDog(int dog) {
		this.dog = dog;
	}

	
	
	
	}
