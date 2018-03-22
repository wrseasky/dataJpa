package com.baidu.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
* @author 作者 wr:
* @version 创建时间：2018年3月6日 下午1:39:59
* 类说明
*/
public class BigDecimalUtils {

	//加
	public static double add(double v1, double v2){
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.add(b2).doubleValue();
	}
	
	//减
	public static double sub(double v1, double v2){
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.subtract(b2).doubleValue();
	}
	
	//乘
	public static double mul(double v1, double v2){
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.multiply(b2).doubleValue();
	}
	
	//除 保留scale位有效数
	public static double div(double v1, double v2, int scale){
		if(scale < 0){
			throw new IllegalArgumentException("参数");
		}
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public static void main(String[] args) {
		double add = add(1.0, 2.0);
		System.out.println(add);
		
		double sub = sub(2.0, 1.0);
		System.out.println(sub);
		
		double mul = mul(3.0, 4.0);
		System.out.println(mul);
		
		double div = div(100.0, 3.0, 3);
		System.out.println(div);
		
//		System.out.println(3.0/2);
//		System.out.println(3/2.0);
//		System.out.println(3.0/2.0);
//		System.out.println(3/2);
		
	}
}
