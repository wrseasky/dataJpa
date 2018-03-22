package com.baidu.utils;
/**
* @author 作者 wr:
* @version 创建时间：2018年3月6日 下午12:01:21
* 类说明
*/
public class OtherUtils {

	static final ThreadLocal<Integer> local = new ThreadLocal<>();
	
	public static ThreadLocal<Integer> getThreadLocal(){
		return local;
	}
}
