package com.machintosh1983.var.datacenter.research.common;

public interface Constant {
	
	public final int VAR_SCENARIO_TYPE_BANNER = 1;
	public final int VAR_SCENARIO_TYPE_REFRESHBLOCK = 2;
	public final int VAR_SCENARIO_TYPE_RANKLIST = 3;
	public final int VAR_SCENARIO_TYPE_TIMESERIES = 4;
	public final int VAR_SCENARIO_TYPE_CORPUSCOLLECT = 5;
	
	public final int VAR_ACTOR_TYPE_RECORDING = 2;
	public final int VAR_ACTOR_TYPE_SCREEN = 6;
	public final int VAR_ACTOR_TYPE_INPUT = 3;
	public final int VAR_ACTOR_TYPE_CLICK = 2;
	public final int VAR_ACTOR_TYPE_DOWNLOAD = 4;
	public final int VAR_ACTOR_TYPE_RECORDINGKV = 10;
	public final int VAR_ACTOR_TYPE_ELEMENT = 5;
	
	public final int VAR_USER_CUSTOM_JOB_STATUS_ACTIVE = 1;
	public final int VAR_USER_CUSTOM_JOB_STATUS_DISABLE = 2;
	public final int VAR_USER_CUSTOM_JOB_STATUS_DELETED = 0;
	
	public final String APPLICATION_COOKIE_NAME_TIME = "_time";
	public final String APPLICATION_COOKIE_NAME_AUTORIZATION = "Authorization";
	
	public final String APPLICATION_REQUEST_ATTR_NAME_USER = "_requestuser";
	
	public final int APPLICATION_RESPONSE_STATUS_CODE_OK = 200;
	public final int APPLICATION_RESPONSE_STATUS_CODE_NOAUTH = 401;
	public final int APPLICATION_RESPONSE_STATUS_CODE_UNKNOWN = 404;
	public final int APPLICATION_RESPONSE_STATUS_CODE_ERROR = 500;
}
