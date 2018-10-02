package com.ysd.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysd.entity.DepTools;
import com.ysd.entity.Technology;
import com.ysd.service.DeptoolsServiceImpl;
import com.ysd.service.QuestionsServiceImpl;
import com.ysd.service.WebSiteAdviseServiceImpl;

@Controller
public class DepToolsController {
	@Resource
	DeptoolsServiceImpl deptoolsServiceImpl;
	
	@RequestMapping("/queryDepTools")
	public @ResponseBody List<DepTools> queryAllTechnology() {
		return deptoolsServiceImpl.queryAllTechnology();
	}
	
	@RequestMapping("/addDepTools")
	public @ResponseBody boolean addTechnology(DepTools depTools) {
		System.out.println("<<<<<<<添加");
		System.out.println(depTools);
		return deptoolsServiceImpl.addDepTools(depTools);
	}
	
	@RequestMapping("/deleteDepTools")
	public @ResponseBody boolean deleteTechnology(Integer depToolsID) {
		return deptoolsServiceImpl.deleteDepTools(depToolsID);
	}
	
	@RequestMapping("/updateDepTools")
	public @ResponseBody boolean updateTechnology(DepTools depTools) {
		return deptoolsServiceImpl.updateDepTools(depTools);
	}
}
