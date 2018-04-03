package com.baidu;
/**
* @author 作者 wr:
* @version 创建时间：2018年3月30日 下午6:45:59
* 类说明
*/
public class T {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			
			new Thread(new Runnable() {
				public void run() {
					Zoo zoo = new Zoo("127.0.0.1:2181");
					zoo.lock();
					
					zoo.unlock();
				}
			}).start();
		}
	}
}
