package com.baidu.logAspect;

import java.lang.reflect.Method;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.baidu.repository.LogRepository;

@Aspect
@Component
@SuppressWarnings("all")
public class SystemLogAspect {

	@Resource
	private LogRepository logRepository;

	/**
	 * 日志记录
	 */
	private static final Logger LOGGER = Logger.getLogger(SystemLogAspect.class);

	/**
	 * Service层切点
	 */
	@Pointcut("@annotation(com.baidu.logAspect.SystemServiceLog)")
	public void serviceAspect() {

	}

	/**
	 * doServiceLog:获取注解参数，记录日志. <br/>
	 * 
	 * @param joinPoint
	 *            切入点参数
	 * @since JDK 1.7
	 */
	@After("serviceAspect()")
	public void doServiceLog(JoinPoint joinPoint) {
		LOGGER.info("日志记录");
		try {
			// 数据库日志
			CmsOperationLog log = new CmsOperationLog();
			log.setOperationType(getServiceMthodTableType(joinPoint));
			// 获取日志描述信息
			String content = getServiceMthodDescription(joinPoint);
			log.setContent(content);
			log.setRemarks(getServiceMthodParams(joinPoint));
			log.setCreateTime(new Date());
			System.out.println(log);
			logRepository.save(log);
		} catch (Exception e) {
			LOGGER.error("异常信息:{}", e);
		}
	}

	/**
	 * getServiceMthodDescription:获取注解中对方法的描述信息 用于service层注解 .
	 * 
	 * @param joinPoint
	 *            切点
	 * @return 方法描述
	 * @throws Exception
	 * @since JDK 1.7
	 */
	private String getServiceMthodDescription(JoinPoint joinPoint) throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();// service类的全路径
																		// com.baidu.log.LogService
		String methodName = joinPoint.getSignature().getName();// 方法名
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String description = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				
				Class[] clazzs = method.getParameterTypes();
				
				if (clazzs.length == arguments.length) {
					description = method.getAnnotation(SystemServiceLog.class).description();
					break;
				}
			}
		}
		return description;
	}

	/**
	 * getServiceMthodTableType:获取注解中对方法的数据表类型 用于service层注解 . <br/>
	 * 
	 * @param joinPoint
	 * @return
	 * @throws Exception
	 * @since JDK 1.7
	 */
	private int getServiceMthodTableType(JoinPoint joinPoint) throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		int tableType = 0;
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					tableType = method.getAnnotation(SystemServiceLog.class).tableType();
					break;
				}
			}
		}
		return tableType;
	}

	/**
	 * getServiceMthodParams:获取json格式的参数. <br/>
	 * 
	 * @author lcma
	 * @param joinPoint
	 * @return
	 * @throws Exception
	 * @since JDK 1.7
	 */
	private String getServiceMthodParams(JoinPoint joinPoint) throws Exception {
		Object[] arguments = joinPoint.getArgs();
		String params = JSONObject.toJSONString(arguments);
		return params;
	}

}