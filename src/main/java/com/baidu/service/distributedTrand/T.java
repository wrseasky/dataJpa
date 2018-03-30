package com.baidu.service.distributedTrand;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * @author 作者 wr:
 * @version 创建时间：2018年3月30日 下午2:35:17 类说明
 */
public class T {
	public static void main(String[] args) throws Exception {
		ZooKeeper zk = new ZooKeeper("127.0.0.1", 3000, new Watcher() {

			@Override
			public void process(WatchedEvent event) {

			}

		});
//		zk.create("/tttt", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

		Stat stat = zk.exists("/t", true);
		System.out.println(stat);

	}
}
