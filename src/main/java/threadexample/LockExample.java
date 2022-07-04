/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 4:34 下午 2022/7/4
 **/


package threadexample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁的例子
 */
public class LockExample {

    static Lock lock = new ReentrantLock();

    private static int count = 0;

    public static void incr() {
        lock.lock();//抢占锁，如果没有抢占到锁，会阻塞
        try {
            Thread.sleep(1);
            count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                LockExample.incr();
            }).start();
        }
        Thread.sleep(3000);
        System.out.println("result " + count);
    }
}
