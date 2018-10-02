package com.ysd.entity;

import java.sql.Timestamp;

public class WebSiteAdvise {
	private Integer id;
	private String content;
	private String name;
	private Timestamp creatTime;
	public WebSiteAdvise(Integer id, String content, String name, Timestamp creatTime) {
		super();
		this.id = id;
		this.content = content;
		this.name = name;
		this.creatTime = creatTime;
	}
	public WebSiteAdvise() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "WebSiteAdvise [id=" + id + ", content=" + content + ", name=" + name + ", creatTime=" + creatTime + "]";
	}
	
}
