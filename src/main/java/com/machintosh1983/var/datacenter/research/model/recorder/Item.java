package com.machintosh1983.var.datacenter.research.model.recorder;

import com.machintosh1983.var.datacenter.research.model.performance.Selector;

public class Item {

	private Selector selector;
    
    private boolean isLink;
    private boolean linkExtract;
    private String nextPageLink;
    
    private boolean isImg;
    private int index;
    
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Selector getSelector() {
		return selector;
	}

	public void setSelector(Selector selector) {
		this.selector = selector;
	}

	public boolean isLink() {
		return isLink;
	}

	public void setLink(boolean isLink) {
		this.isLink = isLink;
	}

	public boolean isLinkExtract() {
		return linkExtract;
	}

	public void setLinkExtract(boolean linkExtract) {
		this.linkExtract = linkExtract;
	}

	public String getNextPageLink() {
		return nextPageLink;
	}

	public void setNextPageLink(String nextPageLink) {
		this.nextPageLink = nextPageLink;
	}

	public boolean isImg() {
		return isImg;
	}

	public void setImg(boolean isImg) {
		this.isImg = isImg;
	}
    
}
