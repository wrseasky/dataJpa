package com.baidu.distributedTrans.zookeeper;
/**
* @author 作者 wr:
* @version 创建时间：2018年3月29日 下午6:56:54
* 类说明
*/
public class Test {
    static int n = 500;

    public static void secskill() {
        System.out.println(--n);
    }

    public static void main(String[] args) {
        
        Runnable runnable = new Runnable() {
            public void run() {
            	ZooDistributeLock lock = null;
                try {
                    lock = new ZooDistributeLock("127.0.0.1:2181", "test1");
                    lock.lock();
                    secskill();
                    System.out.println(Thread.currentThread().getName() + "正在运行");
                } finally {
                    if (lock != null) {
                        lock.unlock();
                    }
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
    }
}