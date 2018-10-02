package com.ysd.entity;

public class CountryLanguage {
	private String CountryCode;
	private String Language;
	private String IsOfficial;
	private double Percentage;
	public String getCountryCode() {
		return CountryCode;
	}
	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public String getIsOfficial() {
		return IsOfficial;
	}
	public void setIsOfficial(String isOfficial) {
		IsOfficial = isOfficial;
	}
	public double getPercentage() {
		return Percentage;
	}
	public void setPercentage(double percentage) {
		Percentage = percentage;
	}
	public CountryLanguage(String countryCode, String language,
			String isOfficial, double percentage) {
		super();
		CountryCode = countryCode;
		Language = language;
		IsOfficial = isOfficial;
		Percentage = percentage;
	}
	public CountryLanguage() {
		super();
	}
	@Override
	public String toString() {
		return "CountryLanguage [CountryCode=" + CountryCode + ", Language="
				+ Language + ", IsOfficial=" + IsOfficial + ", Percentage="
				+ Percentage + "]";
	}
	
}
