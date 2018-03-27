package com.baidu.shuzuToduilie;

import java.util.Arrays;

/**
 * @author 作者 wr:
 * @version 创建时间：2018年3月26日 下午4:26:57 类说明
 */
public class ArrayQueue {
	private int[] arrInt;
	private int front;
	private int rear;

	public ArrayQueue(int size) {
		this.arrInt = new int[size];
		front = 0;
		rear = -1;
	}

	/**
	 * 判断队列是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return front == arrInt.length;
	}

	/**
	 * 判断队列是否已满
	 * 
	 * @return
	 */
	public boolean isFull() {
		return arrInt.length - 1 == rear;
	}

	/**
	 * 向队列的队尾插入一个元素
	 */
	public void insert(int item) {
		if (isFull()) {
//			throw new RuntimeException("队列已满");
			// 扩容
			copyOf();
		}
		arrInt[++rear] = item;
	}

	/**
	 * 获得对头元素
	 * 
	 * @return
	 */
	public int peekFront() {
		return arrInt[front];
	}

	/**
	 * 获得队尾元素
	 * 
	 * @return
	 */
	public int peekRear() {
		return arrInt[rear];
	}

	/**
	 * 从队列的对头移除一个元素
	 * 
	 * @return
	 */
	public int remove() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		return arrInt[front++];
	}

	/**
	 * 数组的拷贝
	 */
	public void copyOf() {
		arrInt = Arrays.copyOf(arrInt, arrInt.length * 2);
	}
}
