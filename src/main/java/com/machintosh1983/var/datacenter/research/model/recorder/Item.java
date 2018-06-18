package com.machintosh1983.var.datacenter.research.model.recorder;

import com.machintosh1983.var.datacenter.research.model.performance.Selector;

public class Item {

	private Selector selector;
    
    private int link;
    private int extract;
    private String nextPageLink;
    
    private String label;
    private String labelattr;
    private String valueattr;
    
    private int img;
    private int index;
    
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabelattr() {
		return labelattr;
	}

	public void setLabelattr(String labelattr) {
		this.labelattr = labelattr;
	}

	public String getValueattr() {
		return valueattr;
	}

	public void setValueattr(String valueattr) {
		this.valueattr = valueattr;
	}

	public void setLink(int link) {
		this.link = link;
	}

	public int getExtract() {
		return extract;
	}

	public void setExtract(int extract) {
		this.extract = extract;
	}

	public int getImg() {
		return img;
	}

	public void setImg(int img) {
		this.img = img;
	}

	public int getLink() {
		return link;
	}

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

	public String getNextPageLink() {
		return nextPageLink;
	}

	public void setNextPageLink(String nextPageLink) {
		this.nextPageLink = nextPageLink;
	}

	
}
