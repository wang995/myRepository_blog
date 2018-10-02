package com.ysd.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysd.entity.Log;
import com.ysd.service.LogServiceImpl;
import com.ysd.service.QuestionsServiceImpl;
import com.ysd.service.WebSiteAdviseServiceImpl;

@Controller
public class LogController {
	@Resource
	LogServiceImpl logServiceImpl;
	
	@RequestMapping("/queryLog")
	public @ResponseBody List<Log> queryAllLog() {
		return logServiceImpl.queryAllLog();
	}
	
	@RequestMapping("/addLog")
	public @ResponseBody boolean addLog(Log log) {
		System.out.println("<<<<<<<添加");
		System.out.println(log);
		return logServiceImpl.addLog(log);
	}
	
	@RequestMapping("/deleteLog")
	public @ResponseBody boolean deleteLog(Integer logID) {
		return logServiceImpl.deleteLog(logID);
	}
	
	@RequestMapping("/updateLog")
	public @ResponseBody boolean updateLog(Log log) {
		return logServiceImpl.updateLog(log);
	}
}
