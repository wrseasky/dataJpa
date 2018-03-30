package com.baidu.distributedTrans.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author 作者 wr:
 * @version 创建时间：2018年3月21日 下午2:35:29 类说明
 */
public class Service {

	private static JedisPool pool = null;
	private DistributedLock lock = new DistributedLock(pool);

	int n = 500;

	static {
		JedisPoolConfig config = new JedisPoolConfig();
		// 设置最大连接数
		config.setMaxTotal(200);
		// 设置最大空闲数
		config.setMaxIdle(8);
		// 设置最大等待时间
		config.setMaxWaitMillis(1000 * 100);
		// 在borrow一个jedis实例时，是否需要验证，若为true，则所有jedis实例均是可用的
		config.setTestOnBorrow(true);
		pool = new JedisPool(config, "127.0.0.1", 6379, 3000);
	}

	public void seckill() {
		// 返回锁的value值，供释放锁时候进行判断	5秒获取时间,1秒key过期
		String identifier = lock.lockWithTimeout("resource", 5000, 1000);
		if(identifier != null){
			System.out.println(Thread.currentThread().getName() + "获得了锁");
			System.out.println(--n);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock.releaseLock("resource", identifier);//value相等就删除key
		}else{
			System.out.println("获取锁失败");
		}
	}
}
/**
 * 第一个设置成功返回字符串,处理业务, 未释放
 * 
 * 第二个未设置成功返回null
 */










