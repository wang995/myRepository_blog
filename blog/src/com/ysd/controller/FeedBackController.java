package com.ysd.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysd.entity.FeedBack;
import com.ysd.service.FeedBackServiceImpl;
import com.ysd.service.QuestionsServiceImpl;
import com.ysd.service.WebSiteAdviseServiceImpl;

@Controller
public class FeedBackController {
	@Resource
	FeedBackServiceImpl feedBackServiceImpl;
	
	@RequestMapping("/queryFeedBack")
	public @ResponseBody List<FeedBack> queryAllFeedBack() {
		return feedBackServiceImpl.queryAllFeedBack();
	}
	
	@RequestMapping("/addFeedBack")
	public @ResponseBody boolean addFeedBack(FeedBack feedback) {
		System.out.println("<<<<<<<添加");
		System.out.println(feedback);
		return feedBackServiceImpl.addFeedBack(feedback);
	}
	
	@RequestMapping("/deleteFeedBack")
	public @ResponseBody boolean deleteFeedBack(Integer feedbackID) {
		return feedBackServiceImpl.deleteFeedBack(feedbackID);
	}
	
	@RequestMapping("/updateFeedBack")
	public @ResponseBody boolean updateFeedBack(FeedBack feedback) {
		return feedBackServiceImpl.updateFeedBack(feedback);
	}
}
