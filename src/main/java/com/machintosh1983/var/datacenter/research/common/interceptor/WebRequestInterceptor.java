package com.machintosh1983.var.datacenter.research.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.machintosh1983.var.datacenter.research.common.Constant;
import com.machintosh1983.var.datacenter.research.common.ErrorCode;
import com.machintosh1983.var.datacenter.research.common.WebApplicationException;
import com.machintosh1983.var.datacenter.research.model.User;

/**
 * 
 * @author Machintosh1983
 *
 */
public class WebRequestInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if( ex != null ) {
			if( ex instanceof WebApplicationException ) {
				int errorCode = ((WebApplicationException) ex).getErrorCode();
				switch( errorCode ) {
				case ErrorCode.CODE_9000:
					response.setStatus(Constant.APPLICATION_RESPONSE_STATUS_CODE_NOAUTH);
					return;
					
				default:break;
				}
			}
			response.setStatus(Constant.APPLICATION_RESPONSE_STATUS_CODE_ERROR);
		}
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User u = null;
		String token = request.getHeader(Constant.APPLICATION_COOKIE_NAME_TIME);
		u = new User();
		u.setUserId(10000);
		u.setUserName("test001");
		request.setAttribute(Constant.APPLICATION_REQUEST_ATTR_NAME_USER, u);
		
		return true;
	}

}
