package com.ysd.mapper;

import java.util.List;

import com.ysd.entity.Log;

public interface LogMapper {
	public List<Log> queryAllLog();
	public boolean addLog(Log log);
	public boolean deleteLog(Integer logID);
	public boolean updateLog(Log log);
}
