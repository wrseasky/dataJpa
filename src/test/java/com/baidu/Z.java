package com.baidu;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Z {
	public static void main(String[] args) {
		
		Logger logger = LoggerFactory.getLogger(Z.class);
		if(logger.isDebugEnabled()){
			logger.debug("`11111111111111");
		}
		System.out.println(new Date().getTime());
	}
}
