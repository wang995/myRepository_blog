package com.ysd.entity;

import java.sql.Timestamp;

public class FeedBack {
	private Integer id;
	private Integer questionID;
	private String content;
	private String name;
	private Timestamp creatTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQuestionID() {
		return questionID;
	}
	public void setQuestionID(Integer questionID) {
		this.questionID = questionID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Timestamp creatTime) {
		this.creatTime = creatTime;
	}
	public FeedBack(Integer id, Integer questionID, String content, String name, Timestamp creatTime) {
		super();
		this.id = id;
		this.questionID = questionID;
		this.content = content;
		this.name = name;
		this.creatTime = creatTime;
	}
	public FeedBack() {
		super();
	}
	@Override
	public String toString() {
		return "FeedBack [id=" + id + ", questionID=" + questionID + ", content=" + content + ", name=" + name
				+ ", creatTime=" + creatTime + "]";
	}
	
}
