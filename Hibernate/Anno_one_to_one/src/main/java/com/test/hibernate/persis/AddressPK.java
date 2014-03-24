package com.test.hibernate.persis;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AddressPK implements Serializable {

	private int sid;
	
	
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	

}
