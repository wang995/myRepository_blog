package com.ysd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.entity.WebSiteAdvise;
import com.ysd.mapper.QuestionsMapper;
import com.ysd.mapper.WebSiteAdviseMapper;
@Service
public class WebSiteAdviseServiceImpl implements WebSiteAdviseService{
	@Autowired
	WebSiteAdviseMapper webSiteAdviseMapper;

	@Override
	public boolean addAdvice(WebSiteAdvise advice) {
		// TODO Auto-generated method stub
		return webSiteAdviseMapper.addAdvice(advice);
	}

	@Override
	public boolean deleteAdvice(Integer adviceID) {
		// TODO Auto-generated method stub
		return webSiteAdviseMapper.deleteAdvice(adviceID);
	}

	@Override
	public boolean updateAdvice(WebSiteAdvise advice) {
		// TODO Auto-generated method stub
		return webSiteAdviseMapper.updateAdvice(advice);
	}

	@Override
	public List<com.ysd.entity.WebSiteAdvise> queryAllAdvice() {
		// TODO Auto-generated method stub
		return webSiteAdviseMapper.queryAllAdvice();
	}
	

}
