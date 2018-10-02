package com.ysd.entity;

import java.sql.Timestamp;

public class DepTools {
	private Integer id;
	private String title;
	private String link;
	private String size;
	private Integer download_num;
	private Timestamp creatTime;
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Integer getDownload_num() {
		return download_num;
	}
	public void setDownload_num(Integer download_num) {
		this.download_num = download_num;
	}
	public Timestamp getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Timestamp creatTime) {
		this.creatTime = creatTime;
	}
	public DepTools(Integer id, String title, String link, String size, Integer download_num, Timestamp creatTime) {
		super();
		this.id = id;
		this.title = title;
		this.link = link;
		this.size = size;
		this.download_num = download_num;
		this.creatTime = creatTime;
	}
	public DepTools() {
		super();
	}
	@Override
	public String toString() {
		return "deptools [id=" + id + ", title=" + title + ", link=" + link + ", size=" + size + ", download_num="
				+ download_num + ", creatTime=" + creatTime + "]";
	}
	
}
