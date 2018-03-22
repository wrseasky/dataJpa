package com.baidu.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
* @author 作者 wr:
* @version 创建时间：2018年3月19日 下午5:48:47
* 类说明
*/
public class ThreadPoolTest implements Runnable{

	@Override
	public void run() {
		synchronized(this){
			
			try {
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	//LinkedBlockingQueue
	public static void main1(String[] args) {
		BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(2);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 6, 1, TimeUnit.DAYS, queue);
		for (int i = 0; i < 9; i++) {
			
			try {
				executor.execute(new ThreadPoolTest());
			} catch (Exception e) {
				System.out.println("异常  -- > " + e.getMessage());
			}
			int threadSize = queue.size();
			System.out.println("线程队列大小为-->" + threadSize);
		}

		executor.shutdown();
	}
	
	//ArrayBlockingQueue
	public static void main2(String[] args) {
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(4);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 6, 1, TimeUnit.DAYS, queue);
		for (int i = 0; i < 11; i++) {
			executor.execute(new ThreadPoolTest());
			System.out.println("队列大小为 --> " + queue.size());
		}
		executor.shutdown();
	}
	
	//queue.add()
	public static void main3(String[] args) {
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(4);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 6, 1, TimeUnit.DAYS, queue);
		for (int i = 0; i < 10; i++) {
			executor.execute(new ThreadPoolTest());
			int size = queue.size();
			System.out.println("队列的大小 --> " + size);
			if (size == 4) {
				queue.add(new Runnable() {
					public void run() {
						System.out.println("我是新线程");
					}
				});
			}
		}
		executor.shutdown();
	}
	
	//queue.offer()
	public static void main4(String[] args) {
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(4);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 6, 1, TimeUnit.DAYS, queue);
		for (int i = 0; i < 10; i++) {
			executor.execute(new ThreadPoolTest());
			int size = queue.size();
			System.out.println("队列的大小 --> " + size);
			if (size == 4) {
				boolean offer = queue.offer(new Runnable() {
					public void run() {
						System.out.println("我是新线程");
					}
				});
				System.out.println("添加新线程标志 --> " + offer);
			}
		}
		executor.shutdown();
	}
	
	//queue.put()
	public static void main5(String[] args) throws InterruptedException {
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(4);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 6, 1, TimeUnit.DAYS, queue);
		for (int i = 0; i < 10; i++) {
			executor.execute(new ThreadPoolTest());
			int size = queue.size();
			System.out.println("队列的大小 --> " + size);
			if (size == 4) {
				queue.put(new Runnable() {
					public void run() {
						System.out.println("我是新线程");
					}
				});
			}
		}
		executor.shutdown();
	}
	
	//SynchronousQueue
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Runnable> queue = new SynchronousQueue<>();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 6, 1, TimeUnit.DAYS, queue);
		for (int i = 0; i < 6; i++) {
			executor.execute(new ThreadPoolTest());
			int size = queue.size();
			System.out.println("队列的大小 --> " + size);
		}
//		Integer.MAX_VALUE
		executor.shutdown();
	}
}


















