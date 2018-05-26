package com.machintosh1983.var.datacenter.research.common;

public class ErrorCode {
	
	public final static int CODE_9000 = 9000;
	public final static int CODE_9001 = 9001;
	
	public final static int CODE_3001 = 3001;

	public static String error (int code, String ... parms) {
		switch( code ) {
		case CODE_9000:
			return  _9000 (parms);
		case CODE_9001:
			return  _9001 (parms);
		case CODE_3001:
			return  _3001 (parms);
			
		default: return "["+code+"] Unknown exception.";
		}
		
	}
	
	private static String _9000 (String ... parms) {
		return  "[9000] Operation without authorization["+getParamString(parms)+"].";
	}
	
	private static String _9001 (String ... parms) {
		return  "[9001] Can't get elasticsearch http client from pool ["+getParamString(parms)+"].";
	}
	
	private static String _3001 (String ... parms) {
		return  "[3001] Access Elasticsearch met network exception ["+getParamString(parms)+"].";
	}
	
	private static String getParamString(String ... parms) {
		StringBuffer buf = new StringBuffer();
		if( parms.length > 0 )
			buf.append(parms[0]);
		
		for( int i=1; i<parms.length; i++) {
			buf.append(",").append(parms[i]);
		}
		
		return buf.toString();
	}
	
}
