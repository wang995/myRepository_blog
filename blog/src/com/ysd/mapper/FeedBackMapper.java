package com.ysd.mapper;

import java.util.List;

import com.ysd.entity.FeedBack;

public interface FeedBackMapper {
	public List<FeedBack> queryAllFeedBack();
	public List<Integer> queryFeedBackTechnologyID();
	public boolean addFeedBack(FeedBack feedBack);
	public boolean deleteFeedBack(Integer feedBackID);
	public boolean updateFeedBack(FeedBack feedBack);
}
