/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 9:45 下午 2022/6/28
 **/


package threadexample;

import java.util.concurrent.TimeUnit;

/**
 * 线程各种状态的demo程序
 *
 * 运行之后，命令jps查找到进程号，然后用Jstack命令可以查看到各个线程的状态
 */
public class ThreadStatusExample {

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "TIME_WATING").start();

        new Thread(() -> {
            while (true) {
                synchronized (ThreadStatusExample.class) {
                    try {
                        ThreadStatusExample.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "WAITING");

        new Thread(new BlockDemo(), "BLOCKED-DEMO-01").start();
        new Thread(new BlockDemo(), "BLOCKED-DEMO-02").start();
    }

    static class BlockDemo extends Thread {

        @Override
        public void run() {
            synchronized (BlockDemo.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
