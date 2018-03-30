package com.baidu.service.distributedTrand;

import org.springframework.stereotype.Service;

/**
 * @author 作者 wr:
 * @version 创建时间：2018年3月30日 下午2:11:29 类说明
 */
@Service
public class DistributedService {

	public void get() {
		ZooDistributeLock zooDistributeLock = null;
		try {
			zooDistributeLock = new ZooDistributeLock("127.0.0.1", "get");
			zooDistributeLock.lock();
			System.out.println(Thread.currentThread().getName() + "正在运行");
		} finally {
			if (zooDistributeLock != null) {
				zooDistributeLock.unlock();
			}
		}
	}

}
