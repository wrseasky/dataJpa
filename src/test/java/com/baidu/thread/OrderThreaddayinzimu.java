package com.baidu.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 作者 wr:
 * @version 创建时间：2018年3月28日 上午11:40:11 类说明
 */
public class OrderThreaddayinzimu {
	static ReentrantLock lock = new ReentrantLock();
	static int count = 0;
	public static void main(String[] args) {

		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10;) {
					lock.lock();
					if (count % 3 == 0) {
						System.out.println("A");
						count++;
						i++;
					}
					lock.unlock();
				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10;) {
					lock.lock();
					if (count % 3 == 1) {
						System.out.println("B");
						count++;
						i++;
					}
					lock.unlock();

				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10;) {
					lock.lock();
					if (count % 3 == 2) {
						System.out.println("C");
						count++;
						i++;
					}
					lock.unlock();
				}
			}
		}).start();
	}
}
