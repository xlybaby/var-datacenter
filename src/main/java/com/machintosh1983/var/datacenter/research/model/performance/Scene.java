package com.machintosh1983.var.datacenter.research.model.performance;

import java.util.List;

public class Scene {

	private String href;
	private List<Page> pages;
	/**
	 * Starts to collect info after specified deplay seconds
	 */
	private long delay;
	
	public long getDelay() {
		return delay;
	}

	public void setDelay(long delay) {
		this.delay = delay;
	}

	public String getHref() {
		return href;
	}
	
	public void setHref(String href) {
		this.href = href;
	}
	
	public List<Page> getPages() {
		return pages;
	}
	
	public void setPages(List<Page> pages) {
		this.pages = pages;
	}
	
}
