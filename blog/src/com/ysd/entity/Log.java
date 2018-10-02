package com.ysd.entity;

import java.sql.Timestamp;

public class Log {
	private Integer id;
	private String category;
	private String title;
	private String content;
	private Timestamp creat_time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCreat_time() {
		return creat_time;
	}
	public void setCreat_time(Timestamp creat_time) {
		this.creat_time = creat_time;
	}
	public Log(Integer id, String category, String title, String content, Timestamp creat_time) {
		super();
		this.id = id;
		this.category = category;
		this.title = title;
		this.content = content;
		this.creat_time = creat_time;
	}
	public Log() {
		super();
	}
	@Override
	public String toString() {
		return "log [id=" + id + ", category=" + category + ", title=" + title + ", content=" + content
				+ ", creat_time=" + creat_time + "]";
	}
	
}
