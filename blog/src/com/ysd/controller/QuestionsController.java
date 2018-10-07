package com.ysd.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysd.entity.Count;
import com.ysd.entity.Personnel;
import com.ysd.entity.Technology;
import com.ysd.service.QuestionsServiceImpl;

@Controller
public class QuestionsController {
	@Resource
	QuestionsServiceImpl questionsServiceImpl;
	
	@RequestMapping("/queryTechnology")
	public @ResponseBody List<Technology> queryAllTechnology(String byString) {
		return questionsServiceImpl.queryAllTechnology(byString);
	}
	
	@RequestMapping("/addTechnology")
	public @ResponseBody boolean addTechnology(Technology technology) {
		System.out.println("<<<<<<<添加");
		return questionsServiceImpl.addTechnology(technology);
	}
	
	@RequestMapping("/deleteTechnology")
	public @ResponseBody boolean deleteTechnology(Integer technologyID) {
		System.out.println(technologyID);
		return questionsServiceImpl.deleteTechnology(technologyID);
	}
	
	@RequestMapping("/updateTechnology")
	public @ResponseBody boolean updateTechnology(Technology technology) {
		System.out.println(technology);
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
	
	@RequestMapping("/admin/verify")
	public @ResponseBody boolean admin_technology(HttpServletRequest request,HttpServletResponse response, String password) {
		boolean flag = false;
		if(password.equals("admin_t")) {
			HttpSession session = request.getSession();
			session.setAttribute("isAdmin", true);
			session.setMaxInactiveInterval(-1);
			flag=true;
		}else {
			flag=false;
		}
		return flag;
	}
	
	@RequestMapping("/admin/exit_admin")
	public @ResponseBody boolean exit_admin(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("isAdmin");
		System.out.println(session.getAttribute("isAdmin"));
		return true;
	}
	
	@RequestMapping("/getCount")
	public @ResponseBody Count getCount() {
		return questionsServiceImpl.getCount();
	}
}
