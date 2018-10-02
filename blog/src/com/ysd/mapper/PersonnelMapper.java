package com.ysd.mapper;

import java.util.List;

import com.ysd.entity.Personnel;

public interface PersonnelMapper {
	public List<Personnel> queryAllPersonnel();
	public boolean addPersonnel(Personnel personnel);
	public boolean deletePersonnel(Integer personnelID);
	public boolean updatePersonnel(Personnel personnel);
}
