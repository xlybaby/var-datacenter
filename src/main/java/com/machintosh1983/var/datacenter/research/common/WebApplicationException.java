package com.machintosh1983.var.datacenter.research.common;

/**
 * 
 * @author Machintosh1983
 *
 */
public class WebApplicationException extends Exception {

	private int code;
	public WebApplicationException(int code, String ... parms) {
		super(ErrorCode.error(code, parms));
		this.code = code;
	}
	
	public WebApplicationException(int code, Throwable cause, String ... parms) {
		super(ErrorCode.error(code, parms), cause);
		this.code = code;
	}
	
	public int getErrorCode() {
		return this.code;
	}
	
}
