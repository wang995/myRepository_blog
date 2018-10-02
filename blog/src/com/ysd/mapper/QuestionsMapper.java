package com.ysd.mapper;

import java.util.List;

import com.ysd.entity.Technology;

public interface QuestionsMapper {
	public List<Technology> queryAllTechnology();
	public boolean addTechnology(Technology technology);
	public boolean deleteTechnology(Integer technologyID);
	public boolean updateTechnology(Technology technology);
}