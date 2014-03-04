package com.om.ser2;

import java.io.Serializable;

public class Collar implements Serializable{
	private int  size;
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Collar() {
		super();
	}

	public Collar(int size) {
		super();
		this.size = size;
	}
	

}
