package com.ysd.mapper;

import java.util.List;

import com.ysd.entity.City;
import com.ysd.entity.Country;
import com.ysd.entity.CountryLanguage;

public interface CountryMapper {
	public List<Country> queryAllCountry();
	public List<City> queryAllCity();
	public List<CountryLanguage> queryAllLanguage();
	public List<City> queryAllCityByCountryCode(String countryCode);
	public List<CountryLanguage> queryLanguageByCountryCode(String countryCode);
	public boolean addCountry(Country c);
	public boolean updateCountry(Country c);
	public boolean deleteCountry(String countryCode);
	public boolean deleteCountryLanguage(String countryCode);
	public boolean deleteCity(String countryCode);
	public Country queryCountryByCountryCode(String countryCode);
}
