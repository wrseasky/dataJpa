package com.baidu.zoo_keeper;
import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooDefs.Perms;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;

import com.google.common.collect.Lists;
import com.mysql.jdbc.TimeUtil;

/**
* @author 作者 wr:
* @version 创建时间：2018年3月29日 下午5:41:05
* 类说明
*/
public class Zoo_keeper {
	public static void main(String[] args) throws Exception {
		ZooKeeper zk = new ZooKeeper("192.168.190.134:2181", 3000, new Watcher() {
			
			@Override
			public void process(WatchedEvent event) {
				System.out.println(event.getType());
			}
		});
		
		
		String create = zk.create("/path", "first".getBytes(), Ids.READ_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
		System.out.println(create);
		
		// 取出子目录节点列表
		 System.out.println(zk.getChildren("/",true));
		 
		 zk.delete("/path", 1);
		
	}

}
















