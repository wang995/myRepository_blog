package com.ysd.entity;

import java.util.List;

public class Country {
	private String Code;//国家代码
	private String Name;//国家名称
	private String Continent;//大陆
	private String Region;//地区
	private double SurfaceArea;//面积
	private Integer Population;//人口
	private double GNP;//国民生产总值
	private String HeadOfState;//国家元首
	private String Code2;//国家代码2;
	private CountryLanguage countryLanguage;
	private List<City> cityList;
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getContinent() {
		return Continent;
	}
	public void setContinent(String continent) {
		Continent = continent;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	public double getSurfaceArea() {
		return SurfaceArea;
	}
	public void setSurfaceArea(double surfaceArea) {
		SurfaceArea = surfaceArea;
	}
	public Integer getPopulation() {
		return Population;
	}
	public void setPopulation(Integer population) {
		Population = population;
	}
	public double getGNP() {
		return GNP;
	}
	public void setGNP(double gNP) {
		GNP = gNP;
	}
	public String getHeadOfState() {
		return HeadOfState;
	}
	public void setHeadOfState(String headOfState) {
		HeadOfState = headOfState;
	}
	public String getCode2() {
		return Code2;
	}
	public void setCode2(String code2) {
		Code2 = code2;
	}
	public CountryLanguage getCountryLanguage() {
		return countryLanguage;
	}
	public void setCountryLanguage(CountryLanguage countryLanguage) {
		this.countryLanguage = countryLanguage;
	}
	public List<City> getCityList() {
		return cityList;
	}
	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}
	public Country(String code, String name, String continent, String region, double surfaceArea, Integer population,
			double gNP, String headOfState, String code2, CountryLanguage countryLanguage, List<City> cityList) {
		super();
		Code = code;
		Name = name;
		Continent = continent;
		Region = region;
		SurfaceArea = surfaceArea;
		Population = population;
		GNP = gNP;
		HeadOfState = headOfState;
		Code2 = code2;
		this.countryLanguage = countryLanguage;
		this.cityList = cityList;
	}
	public Country() {
		super();
	}
	@Override
	public String toString() {
		return "Country [Code=" + Code + ", Name=" + Name + ", Continent=" + Continent + ", Region=" + Region
				+ ", SurfaceArea=" + SurfaceArea + ", Population=" + Population + ", GNP=" + GNP + ", HeadOfState="
				+ HeadOfState + ", Code2=" + Code2 + ", countryLanguage=" + countryLanguage + ", cityList=" + cityList
				+ "]";
	}
	
}
