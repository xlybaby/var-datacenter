package com.machintosh1983.var.datacenter.research.common.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.machintosh1983.var.datacenter.research.common.interceptor.WebRequestInterceptor;

@Configuration
public class ConfigureInterceptor extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new WebRequestInterceptor()).addPathPatterns("/authorized/**");
		super.addInterceptors(registry);
	}

	
}
