package com.baidu.thread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 作者 wr:
 * @version 创建时间：2018年3月20日 下午3:45:42 类说明
 */
public class LockTest {
	public static void main(String[] args) {
		ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
		
		ReadWriteLock rw = new ReentrantReadWriteLock();
	}
}
