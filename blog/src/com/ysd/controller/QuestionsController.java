package com.ysd.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysd.entity.Personnel;
import com.ysd.entity.Technology;
import com.ysd.service.QuestionsServiceImpl;
import com.ysd.service.WebSiteAdviseServiceImpl;

@Controller
public class QuestionsController {
	@Resource
	QuestionsServiceImpl questionsServiceImpl;
	
	@RequestMapping("/queryTechnology")
	public @ResponseBody List<Technology> queryAllTechnology() {
		return questionsServiceImpl.queryAllTechnology();
	}
	
	@RequestMapping("/addTechnology")
	public @ResponseBody boolean addTechnology(Technology technology) {
		System.out.println("<<<<<<<添加");
		System.out.println(technology);
		return questionsServiceImpl.addTechnology(technology);
	}
	
	@RequestMapping("/deleteTechnology")
	public @ResponseBody boolean deleteTechnology(Integer technologyID) {
		return questionsServiceImpl.deleteTechnology(technologyID);
	}
	
	@RequestMapping("/updateTechnology")
	public @ResponseBody boolean updateTechnology(Technology technology) {
		return questionsServiceImpl.updateTechnology(technology);
	}
	//--------------------------------------------------------------------------
	@RequestMapping("/queryPersonnel")
	public @ResponseBody List<Personnel> queryAllPersonnel() {
		return questionsServiceImpl.queryAllPersonnel();
	}
	
	@RequestMapping("/addPersonnel")
	public @ResponseBody boolean addPersonnel(Personnel personnel) {
		System.out.println("<<<<<<<添加");
		System.out.println(personnel);
		return questionsServiceImpl.addPersonnel(personnel);
	}
	
	@RequestMapping("/deletePersonnel")
	public @ResponseBody boolean deletePersonnel(Integer personnelID) {
		return questionsServiceImpl.deletePersonnel(personnelID);
	}
	
	@RequestMapping("/updatePersonnel")
	public @ResponseBody boolean updatePersonnel(Personnel personnel) {
		return questionsServiceImpl.updatePersonnel(personnel);
	}
}
