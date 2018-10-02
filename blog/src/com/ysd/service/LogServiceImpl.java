package com.ysd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.entity.Log;
import com.ysd.entity.WebSiteAdvise;
import com.ysd.mapper.LogMapper;
import com.ysd.mapper.QuestionsMapper;
import com.ysd.mapper.WebSiteAdviseMapper;
@Service
public class LogServiceImpl implements LogService{
	@Autowired
	LogMapper logmapper;
	@Override
	public List<Log> queryAllLog() {
		// TODO Auto-generated method stub
		return logmapper.queryAllLog();
	}

	@Override
	public boolean addLog(Log log) {
		// TODO Auto-generated method stub
		return logmapper.addLog(log);
	}

	@Override
	public boolean deleteLog(Integer logID) {
		// TODO Auto-generated method stub
		return logmapper.deleteLog(logID);
	}

	@Override
	public boolean updateLog(Log log) {
		// TODO Auto-generated method stub
		return logmapper.updateLog(log);
	}
	

}
