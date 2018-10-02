package com.ysd.entity;

public class Technology {
	private Integer id;
	private String title;
	private String content;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Technology(Integer id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
	public Technology() {
		super();
	}
	@Override
	public String toString() {
		return "Technology [id=" + id + ", title=" + title + ", content=" + content + "]";
	}
	
}
