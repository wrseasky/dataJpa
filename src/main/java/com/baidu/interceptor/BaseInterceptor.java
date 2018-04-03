package com.baidu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
* @author 作者 wr:
* @version 创建时间：2018年4月3日 下午2:28:31
* 类说明
*/
@Component
public class BaseInterceptor implements HandlerInterceptor{

	
	/**
	 * 在页面渲染完成返回客户端之前执行
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
		System.out.println("after completion");
	}

	/**
	 * 在controller执行之后
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("postHandle");
	}

	
	/**
	 * 在dispatcherServlet执行之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("preHandle");
		return true;
	}

}
