package org.jack.java;

import java.io.Serializable;

public class Company implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1476116958829856891L;

	private String companyName;
	
	private String location;

	public Company(String companyName, String location) {
		super();
		this.companyName = companyName;
		this.location = location;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Company [companyName=" + companyName + ", location=" + location + "]";
	}
}
