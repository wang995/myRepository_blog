package com.ysd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.entity.FeedBack;
import com.ysd.entity.Technology;
import com.ysd.entity.WebSiteAdvise;
import com.ysd.mapper.FeedBackMapper;
import com.ysd.mapper.QuestionsMapper;
import com.ysd.mapper.WebSiteAdviseMapper;
@Service
public class FeedBackServiceImpl implements FeedBackService{
	@Autowired
	FeedBackMapper feedBackMapper;

	@Override
	public List<FeedBack> queryAllFeedBack() {
		// TODO Auto-generated method stub
		return feedBackMapper.queryAllFeedBack();
	}

	@Override
	public boolean addFeedBack(FeedBack feedBack) {
		// TODO Auto-generated method stub
		return feedBackMapper.addFeedBack(feedBack);
	}

	@Override
	public boolean deleteFeedBack(Integer feedBackID) {
		// TODO Auto-generated method stub
		return feedBackMapper.deleteFeedBack(feedBackID);
	}

	@Override
	public boolean updateFeedBack(FeedBack feedBack) {
		// TODO Auto-generated method stub
		return feedBackMapper.updateFeedBack(feedBack);
	}

}
