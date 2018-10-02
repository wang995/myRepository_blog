package com.ysd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.entity.DepTools;
import com.ysd.entity.WebSiteAdvise;
import com.ysd.mapper.DepToolsMapper;
import com.ysd.mapper.QuestionsMapper;
import com.ysd.mapper.WebSiteAdviseMapper;
@Service
public class DeptoolsServiceImpl implements DeptoolsService{
	@Autowired
	DepToolsMapper depToolsMapper;

	@Override
	public List<DepTools> queryAllTechnology() {
		// TODO Auto-generated method stub
		return depToolsMapper.queryAllDepTool();
	}

	@Override
	public boolean addDepTools(DepTools deptools) {
		// TODO Auto-generated method stub
		return depToolsMapper.addDepTool(deptools);
	}

	@Override
	public boolean deleteDepTools(Integer deptoolsID) {
		// TODO Auto-generated method stub
		return depToolsMapper.deleteDepTool(deptoolsID);
	}

	@Override
	public boolean updateDepTools(DepTools deptools) {
		// TODO Auto-generated method stub
		return depToolsMapper.updateDepTool(deptools);
	}
	

}
