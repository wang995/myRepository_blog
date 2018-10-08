package com.ysd.service;

import java.util.List;

import com.ysd.entity.WebSiteAdvise;

public interface WebSiteAdviseService {
	public List<WebSiteAdvise> queryAllAdvice(String byString);
	public boolean addAdvice(WebSiteAdvise advice);
	public boolean deleteAdvice(Integer adviceID);
	public boolean updateAdvice(WebSiteAdvise advice);
}
