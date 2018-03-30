package com.baidu.distributedTrans.redis;

/**
 * @author 作者 wr:
 * @version 创建时间：2018年3月21日 下午2:37:30 类说明
 */
public class ThreadA extends Thread {
	private Service service;

	public ThreadA(Service service) {
		this.service = service;
	}

	@Override
	public void run() {
		service.seckill();
	}

	public static void main(String[] args) {
		Service service = new Service();
		for (int i = 0; i < 100; i++) {
			ThreadA threadA = new ThreadA(service);
			threadA.start();
		}
	}
}
