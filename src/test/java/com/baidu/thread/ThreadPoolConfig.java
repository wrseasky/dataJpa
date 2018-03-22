package com.baidu.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 作者 wr:
 * @version 创建时间：2018年3月19日 下午7:03:40 类说明
 */
@Configuration
public class ThreadPoolConfig {

	@Bean(name = "contractThreadPool")
	public ThreadPoolExecutor taskExecutor() {

		return new ThreadPoolExecutor(2, 2, 3, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadFactory() {
			private AtomicInteger count = new AtomicInteger(0);
			@Override
			public Thread newThread(Runnable r) {
				Thread t = new Thread(r);
				String threadName = ThreadPoolConfig.class.getSimpleName() + "-" + count.addAndGet(1);
				t.setName(threadName);
				return t;
			}
		});
	}
}

// @Resource(name = "contractThreadPool")
//
// private ThreadPoolExecutor threadPoolExecutor;
//
// threadPoolExecutor.execute(() -> test());
