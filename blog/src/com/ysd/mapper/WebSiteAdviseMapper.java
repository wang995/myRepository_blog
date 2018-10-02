package com.ysd.mapper;

import java.util.List;

import com.ysd.entity.WebSiteAdvise;

public interface WebSiteAdviseMapper {
	public List<WebSiteAdvise> queryAllAdvice();
	public boolean addAdvice(WebSiteAdvise advice);
	public boolean deleteAdvice(Integer adviceID);
	public boolean updateAdvice(WebSiteAdvise advice);
}
