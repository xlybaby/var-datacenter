package com.machintosh1983.var.datacenter.research.model.performance;

import java.util.List;

import com.machintosh1983.var.datacenter.research.model.UILayout;

/**
 * 
 * @author Machintosh1983
 */
public class Template {

	private UILayout layout;
	private List<Scenario> scenarios;
	private String title;
	private String keywords;
	private boolean shareTemplate;
	private boolean shareContent;
	
	public UILayout getLayout() {
		return layout;
	}

	public void setLayout(UILayout layout) {
		this.layout = layout;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public boolean isShareTemplate() {
		return shareTemplate;
	}

	public void setShareTemplate(boolean shareTemplate) {
		this.shareTemplate = shareTemplate;
	}

	public boolean isShareContent() {
		return shareContent;
	}

	public void setShareContent(boolean shareContent) {
		this.shareContent = shareContent;
	}

	public List<Scenario> getScenarios() {
		return scenarios;
	}

	public void setScenarios(List<Scenario> scenarios) {
		this.scenarios = scenarios;
	}
	
}
