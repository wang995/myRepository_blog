package com.ysd.mapper;

import java.util.List;

import com.ysd.entity.DepTools;

public interface DepToolsMapper {
	public List<DepTools> queryAllDepTool();
	public boolean addDepTool(DepTools depTools);
	public boolean deleteDepTool(Integer depToolsID);
	public boolean updateDepTool(DepTools depTools);
}
