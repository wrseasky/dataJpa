package com.baidu.countdownlatch;

/**
* @author 作者 wr:
* @version 创建时间：2018年3月30日 上午11:28:09
* 类说明
*/
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 案例： 取到一批数据，利用两个线程对数据进行逻辑处理 当处理完过后，再用这批数据做一些其它事情
 */
public class CountDownLatchTest {
	private static Random random = new Random(System.currentTimeMillis());
	private static ExecutorService executor = Executors.newFixedThreadPool(2);
	private static CountDownLatch latch = new CountDownLatch(9);

	public static void main(String[] args) throws InterruptedException {
		// 获取数组
		int[] data = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// 两次线程去操作逻辑
		for (int i = 0; i < 9; i++) {
			executor.execute(new SimpleRunnAble(data, i, latch));

		}
		// 保证所有线程执行完毕，再执行下面程序    最多等待时间,如果其他线程都countDown(),就不用等待了,
		latch.await();
		
		executor.shutdown();
		// 获取处理过的数据
		System.out.println("取到数字" + Arrays.toString(data));
	}

	static class SimpleRunnAble implements Runnable {
		private final int[] data;
		private final int index;
		private final CountDownLatch latch;

		SimpleRunnAble(int[] data, int index, CountDownLatch latch) {
			this.data = data;
			this.index = index;
			this.latch = latch;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			int value = data[index];
			if (value % 2 == 0) {
				data[index] = value * 2;
			} else {
				data[index] = value * 10;
			}
			System.out.println(Thread.currentThread().getName() + "结束");
			latch.countDown();
		}
	}

}
