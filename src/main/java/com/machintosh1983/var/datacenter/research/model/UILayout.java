package com.machintosh1983.var.datacenter.research.model;

import java.awt.Color;

public class UILayout {

	private int offsetParentLeft;
	private int offsetParentTop;
	private int zindex = 1;
	
	private int contentWidth;
	private int contentHeight;
	
	private int paddingTop;
	private int paddingRight;
	private int paddingBottom;
	private int paddingLeft;
	
	private int marginTop;
	private int marginRight;
	private int marginBottom;
	private int marginLeft;
	
	private Color backgroundColor = Color.WHITE;
	private float opacity = 1.0f;
	
	private boolean shadow = false;
	private int border;
	private Color borderColor = Color.BLACK;
	private boolean borderRound = false;
	
	public int getOffsetParentLeft() {
		return offsetParentLeft;
	}
	public void setOffsetParentLeft(int offsetParentLeft) {
		this.offsetParentLeft = offsetParentLeft;
	}
	public int getOffsetParentTop() {
		return offsetParentTop;
	}
	public void setOffsetParentTop(int offsetParentTop) {
		this.offsetParentTop = offsetParentTop;
	}
	public int getZindex() {
		return zindex;
	}
	public void setZindex(int zindex) {
		this.zindex = zindex;
	}
	public int getContentWidth() {
		return contentWidth;
	}
	public void setContentWidth(int contentWidth) {
		this.contentWidth = contentWidth;
	}
	public int getContentHeight() {
		return contentHeight;
	}
	public void setContentHeight(int contentHeight) {
		this.contentHeight = contentHeight;
	}
	public int getPaddingTop() {
		return paddingTop;
	}
	public void setPaddingTop(int paddingTop) {
		this.paddingTop = paddingTop;
	}
	public int getPaddingRight() {
		return paddingRight;
	}
	public void setPaddingRight(int paddingRight) {
		this.paddingRight = paddingRight;
	}
	public int getPaddingBottom() {
		return paddingBottom;
	}
	public void setPaddingBottom(int paddingBottom) {
		this.paddingBottom = paddingBottom;
	}
	public int getPaddingLeft() {
		return paddingLeft;
	}
	public void setPaddingLeft(int paddingLeft) {
		this.paddingLeft = paddingLeft;
	}
	public int getMarginTop() {
		return marginTop;
	}
	public void setMarginTop(int marginTop) {
		this.marginTop = marginTop;
	}
	public int getMarginRight() {
		return marginRight;
	}
	public void setMarginRight(int marginRight) {
		this.marginRight = marginRight;
	}
	public int getMarginBottom() {
		return marginBottom;
	}
	public void setMarginBottom(int marginBottom) {
		this.marginBottom = marginBottom;
	}
	public int getMarginLeft() {
		return marginLeft;
	}
	public void setMarginLeft(int marginLeft) {
		this.marginLeft = marginLeft;
	}
	public Color getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public float getOpacity() {
		return opacity;
	}
	public void setOpacity(float opacity) {
		this.opacity = opacity;
	}
	public boolean isShadow() {
		return shadow;
	}
	public void setShadow(boolean shadow) {
		this.shadow = shadow;
	}
	public int getBorder() {
		return border;
	}
	public void setBorder(int border) {
		this.border = border;
	}
	public Color getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}
	public boolean isBorderRound() {
		return borderRound;
	}
	public void setBorderRound(boolean borderRound) {
		this.borderRound = borderRound;
	}
	
}
