package com.baidu.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author 作者 wr:
 * @version 创建时间：2018年4月3日 下午2:34:56 类说明
 */
@Configuration
public class CustomInterceptorAdaptor extends WebMvcConfigurerAdapter {
	@Autowired
	private BaseInterceptor baseInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(baseInterceptor).addPathPatterns("/random/**");
	}
}
