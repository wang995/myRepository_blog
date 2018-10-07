package com.ysd.entity;

public class Count {
	private Integer depToolsNum;
	private Integer feedBackNum;
	private Integer logNum;
	private Integer personnelNum;
	private Integer technologyNum;
	private Integer adviseNum;
	public Integer getDepToolsNum() {
		return depToolsNum;
	}
	public void setDepToolsNum(Integer depToolsNum) {
		this.depToolsNum = depToolsNum;
	}
	public Integer getFeedBackNum() {
		return feedBackNum;
	}
	public void setFeedBackNum(Integer feedBackNum) {
		this.feedBackNum = feedBackNum;
	}
	public Integer getLogNum() {
		return logNum;
	}
	public void setLogNum(Integer logNum) {
		this.logNum = logNum;
	}
	public Integer getPersonnelNum() {
		return personnelNum;
	}
	public void setPersonnelNum(Integer personnelNum) {
		this.personnelNum = personnelNum;
	}
	public Integer getTechnologyNum() {
		return technologyNum;
	}
	public void setTechnologyNum(Integer technologyNum) {
		this.technologyNum = technologyNum;
	}
	public Integer getAdviseNum() {
		return adviseNum;
	}
	public void setAdviseNum(Integer adviseNum) {
		this.adviseNum = adviseNum;
	}
	public Count(Integer depToolsNum, Integer feedBackNum, Integer logNum, Integer personnelNum, Integer technologyNum,
			Integer adviseNum) {
		super();
		this.depToolsNum = depToolsNum;
		this.feedBackNum = feedBackNum;
		this.logNum = logNum;
		this.personnelNum = personnelNum;
		this.technologyNum = technologyNum;
		this.adviseNum = adviseNum;
	}
	public Count() {
		super();
	}
	@Override
	public String toString() {
		return "Count [depToolsNum=" + depToolsNum + ", feedBackNum=" + feedBackNum + ", logNum=" + logNum
				+ ", personnelNum=" + personnelNum + ", technologyNum=" + technologyNum + ", adviseNum=" + adviseNum
				+ "]";
	}
	
}
