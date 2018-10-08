package com.ysd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.entity.Count;
import com.ysd.entity.Personnel;
import com.ysd.entity.Technology;
import com.ysd.mapper.PersonnelMapper;
import com.ysd.mapper.QuestionsMapper;
@Service
public class QuestionsServiceImpl implements QuestionServices{
	@Autowired
	QuestionsMapper questionsMapper;
	@Autowired
	PersonnelMapper personnelMapper;
	
	@Override
	public List<Technology> queryAllTechnology(String byString) {
		// TODO Auto-generated method stub
		return questionsMapper.queryAllTechnology(byString);
	}

	@Override
	public boolean addTechnology(Technology technology) {
		// TODO Auto-generated method stub
		return questionsMapper.addTechnology(technology);
	}

	@Override
	public boolean deleteTechnology(Integer technologyID) {
		// TODO Auto-generated method stub
		return questionsMapper.deleteTechnology(technologyID);
	}

	@Override
	public boolean updateTechnology(Technology technology) {
		// TODO Auto-generated method stub
		return questionsMapper.updateTechnology(technology);
	}

	@Override
	public List<Personnel> queryAllPersonnel(String byString) {
		// TODO Auto-generated method stub
		return personnelMapper.queryAllPersonnel(byString);
	}

	@Override
	public boolean addPersonnel(Personnel personnel) {
		// TODO Auto-generated method stub
		return personnelMapper.addPersonnel(personnel);
	}

	@Override
	public boolean deletePersonnel(Integer personnelID) {
		// TODO Auto-generated method stub
		return personnelMapper.deletePersonnel(personnelID);
	}

	@Override
	public boolean updatePersonnel(Personnel personnel) {
		// TODO Auto-generated method stub
		return personnelMapper.updatePersonnel(personnel);
	}

	@Override
	public Count getCount() {
		// TODO Auto-generated method stub
		return questionsMapper.getCount();
	}

}
