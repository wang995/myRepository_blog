package com.ysd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.entity.Technology;
import com.ysd.mapper.QuestionsMapper;
@Service
public class QuestionsServiceImpl implements QuestionServices{
	@Autowired
	QuestionsMapper questionsMapper;
	@Override
	public List<Technology> queryAllTechnology() {
		// TODO Auto-generated method stub
		return questionsMapper.queryAllTechnology();
	}

	@Override
	public boolean addTechnology(Technology technology) {
		// TODO Auto-generated method stub
		return questionsMapper.addTechnology(technology);
	}

	@Override
	public boolean deleteTechnology(Integer technologyID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTechnology(Technology technology) {
		// TODO Auto-generated method stub
		return false;
	}

}