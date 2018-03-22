package com.baidu.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 作者 wr:
 * @version 创建时间：2018年3月22日 上午10:12:54 类说明
 */
public class OrderThread {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Thread 1 run");
				for (int i = 0; i < 30; i++) {
					System.out.println(Thread.currentThread().getName() + " --- " + i);
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Thread 2 run");
				for (int i = 0; i < 30; i++) {
					System.out.println(Thread.currentThread().getName() + " --- " + i);
				}
			}
		});

		Thread t3 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Thread 3 run");
				for (int i = 0; i < 30; i++) {
					System.out.println(Thread.currentThread().getName() + " --- " + i);
				}
			}
		});
		
//		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.DAYS, new LinkedBlockingQueue<Runnable>());
		threadPoolExecutor.execute(t1);
		threadPoolExecutor.execute(t2);
		threadPoolExecutor.execute(t3);
		threadPoolExecutor.shutdown();
//		executorService.submit(t1);
//		executorService.submit(t2);
//		executorService.submit(t3);
//		executorService.shutdown();
		
//		new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		
	}
}
