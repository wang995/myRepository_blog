package com.ysd.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysd.entity.WebSiteAdvise;
import com.ysd.service.WebSiteAdviseServiceImpl;

@Controller
public class WebSiteAdviseContorller {
	@Resource
	WebSiteAdviseServiceImpl adviseServiceImpl;
	
	@RequestMapping("/queryAdvice")
	public @ResponseBody List<WebSiteAdvise> queryAllTechnology() {
		List<WebSiteAdvise> list = adviseServiceImpl.queryAllAdvice();
		return list;
	}
	
	@RequestMapping("/addAdvice")
	public @ResponseBody boolean addTechnology(WebSiteAdvise advice) {
		System.out.println("<<<<<<<添加");
		System.out.println(advice);
		return adviseServiceImpl.addAdvice(advice);
	}
	
	@RequestMapping("/deleteAdvice")
	public @ResponseBody boolean deleteTechnology(Integer adviceID) {
		return adviseServiceImpl.deleteAdvice(adviceID);
	}
	
	@RequestMapping("/updateAdvice")
	public @ResponseBody boolean updateTechnology(WebSiteAdvise advice) {
		return adviseServiceImpl.updateAdvice(advice);
	}
	
}
