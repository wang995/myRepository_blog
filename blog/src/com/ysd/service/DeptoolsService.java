package com.ysd.service;

import java.util.List;

import com.ysd.entity.DepTools;

public interface DeptoolsService {
	public List<DepTools> queryAllTechnology();
	public boolean addDepTools(DepTools deptools);
	public boolean deleteDepTools(Integer deptoolsID);
	public boolean updateDepTools(DepTools deptools);
}
