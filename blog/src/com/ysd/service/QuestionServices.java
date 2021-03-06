package com.ysd.service;

import java.util.List;

import com.ysd.entity.Count;
import com.ysd.entity.Personnel;
import com.ysd.entity.Technology;

public interface QuestionServices {
	public List<Technology> queryAllTechnology(String byString);
	public boolean addTechnology(Technology technology);
	public boolean deleteTechnology(Integer technologyID);
	public boolean updateTechnology(Technology technology);
	
	public List<Personnel> queryAllPersonnel(String byString);
	public boolean addPersonnel(Personnel personnel);
	public boolean deletePersonnel(Integer personnelID);
	public boolean updatePersonnel(Personnel personnel);
	
	public Count getCount();
}
