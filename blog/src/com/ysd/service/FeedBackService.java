package com.ysd.service;

import java.util.List;

import com.ysd.entity.FeedBack;

public interface FeedBackService {
	public List<FeedBack> queryAllFeedBack();
	public boolean addFeedBack(FeedBack feedBack);
	public boolean deleteFeedBack(Integer feedBackID);
	public boolean updateFeedBack(FeedBack feedBack);
}
