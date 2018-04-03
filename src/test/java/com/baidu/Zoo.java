package com.baidu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * @author 作者 wr:
 * @version 创建时间：2018年3月30日 下午3:38:33 类说明
 */
public class Zoo implements Lock, Watcher {
	private ZooKeeper zk;
	private String cur;
	private String pre;
	private String source = "lock";
	private String root_lock = "/root";

	private CountDownLatch countDownLatch = null;

	// 创建主节点
	public Zoo(String cur) {

		try {
			zk = new ZooKeeper("127.0.0.1:2181", 30000, this);
			Stat exists = zk.exists(root_lock, false);
			if (exists == null) {
				zk.create("/root", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void process(WatchedEvent event) {

	}

	@Override
	public void lock() {
		if (this.tryLock()) {
			return;
		}
		try {
			waitForLock(pre, 4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {

	}

	// 创建临时节点,如果是最小的获取锁
	// 如果不是最小的等待前一个锁
	// 前一个锁释放了获取锁
	@Override
	public boolean tryLock() {
		String split = "_lock_";
		try {
			cur = zk.create(root_lock + "/" + source + split, new byte[0], ZooDefs.Ids.READ_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
			List<String> children = zk.getChildren(root_lock, false);
			// 不包括 开头的部分 root_lock
			List<String> look = new ArrayList<String>();
			for (String string : children) {
				if (source.equals(string.split(split)[0])) {
					look.add(string);
				}
			}
			Collections.sort(look);
			if (cur.equals(root_lock + look.get(0))) {
				return true;
			}
			int binarySearch = Collections.binarySearch(look, cur.substring(cur.lastIndexOf("/") + 1));
			pre = look.get(binarySearch - 1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) {
//		if (this.tryLock()) {
//			return true;
//		}
//		try {
//			waitForLock(pre, time);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return false;
	}

	public boolean waitForLock(String pre, long time) throws Exception {
		Stat exists = zk.exists(root_lock + "/" + pre, true);
		if (exists != null) {
			this.countDownLatch = new CountDownLatch(1);
			countDownLatch.await(time, TimeUnit.SECONDS);
			countDownLatch = null;
		}

		return false;
	}

	@Override
	public void unlock() {

		try {
			zk.delete(cur, -1);
			cur = null;
			zk.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Condition newCondition() {

		return null;
	}

}
