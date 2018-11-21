package com.machintosh1983.var.datacenter.uc.scenario.vo;

public class CorpusScenarioQueryVO extends ScenarioQueryVO {

	private int level;
	private String id;
	private String parentId;
	
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public int getLevel() {
		return level;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
