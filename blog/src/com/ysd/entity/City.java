package com.ysd.entity;

public class City {
	private Integer ID;
	private String Name;
	private String CountryCode;
	private String District;
	private Integer Population;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCountryCode() {
		return CountryCode;
	}
	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public Integer getPopulation() {
		return Population;
	}
	public void setPopulation(Integer population) {
		Population = population;
	}
	public City(Integer iD, String name, String countryCode, String district,
			Integer population) {
		super();
		ID = iD;
		Name = name;
		CountryCode = countryCode;
		District = district;
		Population = population;
	}
	public City() {
		super();
	}
	@Override
	public String toString() {
		return "City [ID=" + ID + ", Name=" + Name + ", CountryCode="
				+ CountryCode + ", District=" + District + ", Population="
				+ Population + "]";
	}
	
}
