package com.baidu.countdownlatch;

/**
* @author 作者 wr:
* @version 创建时间：2018年3月30日 上午11:29:02
* 类说明
*/
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest1 {
	
	public static void main(String[] args) throws InterruptedException {
		// new CountDownLatch(0)当为0时，latch.await()无效果
		CountDownLatch latch = new CountDownLatch(1);
		
		new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					latch.countDown();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
		/**
		 * 最多等待10秒 1.如果10秒内，没有countDown为0，10秒后发行
		 * 2.如果10秒内，countDown为0，立刻发行，不用等待10秒
		 */
		latch.await(10, TimeUnit.SECONDS);
		System.out.println("==========");
	}
}
