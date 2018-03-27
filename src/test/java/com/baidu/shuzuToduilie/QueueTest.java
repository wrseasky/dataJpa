package com.baidu.shuzuToduilie;

/**
 * @author 作者 wr:
 * @version 创建时间：2018年3月26日 下午4:47:27 类说明
 */
public class QueueTest {
	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(5);

		System.out.println(queue.isEmpty());

		for (int i = 0; i < 7; i++) {
			queue.insert(i);
		}
		System.out.println(queue.isFull());
		

		while (!queue.isEmpty()) {
			System.out.println(queue.remove());
		}
	}
}
