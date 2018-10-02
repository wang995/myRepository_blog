package com.ysd.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ysd.entity.City;
import com.ysd.entity.Country;
import com.ysd.entity.CountryLanguage;
import com.ysd.mapper.CountryMapper;
@Component
public class CountryServiceImpl implements CountryService{
	@Resource
	CountryMapper countryMapper;
	@Override
	public List<Country> queryAllCountry() {
		// TODO Auto-generated method stub
		return countryMapper.queryAllCountry();
	}
	@Override
	public List<City> queryAllCity() {
		// TODO Auto-generated method stub
		return countryMapper.queryAllCity();
	}
	@Override
	public List<CountryLanguage> queryAllCountryLanguage() {
		// TODO Auto-generated method stub
		return countryMapper.queryAllLanguage();
	}
	@Override
	public List<City> queryCityByCountryCode(String countryCode) {
		// TODO Auto-generated method stub
		return countryMapper.queryAllCityByCountryCode(countryCode);
	}
	@Override
	public List<CountryLanguage> queryLanguageByCountryCode(String countryCode) {
		// TODO Auto-generated method stub
		return countryMapper.queryLanguageByCountryCode(countryCode);
	}
	@Override
	public boolean addCountry(Country c) {
		// TODO Auto-generated method stub
		return countryMapper.addCountry(c);
	}
	@Override
	public boolean updateCountry(Country c) {
		// TODO Auto-generated method stub
		return countryMapper.updateCountry(c);
	}
	@Override
	public Country queryCountryByCountryCode(String countryCode) {
		// TODO Auto-generated method stub
		return countryMapper.queryCountryByCountryCode(countryCode);
	}
	@Override
	public boolean deleteCountry(String countryCode) {
		// TODO Auto-generated method stub
		return countryMapper.deleteCountry(countryCode);
	}
	@Override
	public boolean deleteCountryLanguage(String countryCode) {
		// TODO Auto-generated method stub
		return countryMapper.deleteCountryLanguage(countryCode);
	}
	@Override
	public boolean deleteCity(String countryCode) {
		// TODO Auto-generated method stub
		return countryMapper.deleteCity(countryCode);
	}
}
