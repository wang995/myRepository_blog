package com.ysd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.ysd.entity.City;
import com.ysd.entity.Country;
import com.ysd.entity.CountryLanguage;
import com.ysd.service.CountryServiceImpl;

@Controller
public class CountryController {
	@Resource
	CountryServiceImpl countryServiceImpl;
	@RequestMapping("/queryCountry")
	public void queryAllCountry(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<Country> list = countryServiceImpl.queryAllCountry();
		out.write(new Gson().toJson(list));
		out.flush();
		out.close();
	}
	@RequestMapping("/query")
	public String queryAllCountry(Model m){
		List<Country> list = countryServiceImpl.queryAllCountry();
		m.addAttribute("result",list);
		return "Country";
	}
	@RequestMapping("/queryCity")
	public void queryAllCity(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<City> list = countryServiceImpl.queryAllCity();
		out.write(new Gson().toJson(list));
		out.flush();
		out.close();
	}
	@RequestMapping("/queryCountryLanguage")
	public void queryAllCountryLanguage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<CountryLanguage> list = countryServiceImpl.queryAllCountryLanguage();
		out.write(new Gson().toJson(list));
		out.flush();
		out.close();
	}
	@RequestMapping("/queryCityByCountryCode")
	public String queryAllCityByCountryCode(Model m,String countryCode) {
		List<City> list = countryServiceImpl.queryCityByCountryCode(countryCode);
		if (list != null) {
			m.addAttribute("result", list);
		} else {
			m.addAttribute("result", "查询失败");
		}
		return "City";
	}
	@RequestMapping("/queryLanguageByCountryCode")
	public String queryLanguageByCountryCode(Model m,String countryCode) {
		List<CountryLanguage> LanguageList = countryServiceImpl.queryLanguageByCountryCode(countryCode);
		if (LanguageList != null) {
			m.addAttribute("result", LanguageList);
		} else {
			m.addAttribute("result", "查询失败");
		}
		return "Language";
	}
	@RequestMapping("/addCountry")
	public String addCountry(Country c,Model m) {
		String view = "view";
		boolean b = false;
		System.out.println(c);
		try {
			b = countryServiceImpl.addCountry(c);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			m.addAttribute("result", "国家添加失败，异常信息如下： "+e.getMessage());
			view = "Failure";
		}
		if (b) {
			List<Country> list = countryServiceImpl.queryAllCountry();
			m.addAttribute("result", list);
			view = "Country";
		} 
		return view;
	}
	@RequestMapping("/queryCountryByCountryCode")
	public String queryCountryByCountryCode(Model m,String countryCode) {
		Country country = countryServiceImpl.queryCountryByCountryCode(countryCode);
		System.out.println(countryCode);
		if (country != null) {
			m.addAttribute("result", country);
		} else {
			m.addAttribute("result", "查询失败");
		}
		return "updateCountry";
	}
	@RequestMapping("/updateCountry")
	public String updateCountry(Model m,Country c) {
		String view = "view";
		boolean b = false;
		System.out.println(c);
		try {
			b = countryServiceImpl.updateCountry(c);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			m.addAttribute("result", "数据修改失败，异常信息如下： "+e.getMessage());
			view = "Failure";
		}
		if (b) {
			List<Country> list = countryServiceImpl.queryAllCountry();
			m.addAttribute("result", list);
			view = "Country";
		} 
		return view;
	}
	@RequestMapping("/deleteCountry")
	public String updateCountry(Model m,String countryCode) {
		String view = "view";
		boolean b = false;
		try {
			b = countryServiceImpl.deleteCity(countryCode);
			b = countryServiceImpl.deleteCountryLanguage(countryCode);
			b = countryServiceImpl.deleteCountry(countryCode);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			m.addAttribute("result", "数据修改失败，异常信息如下： "+e.getMessage());
			view = "Failure";
		}
		if (b) {
			List<Country> list = countryServiceImpl.queryAllCountry();
			m.addAttribute("result", list);
			view = "Country";
		} 
		return view;
	}
}
