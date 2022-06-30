/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:05 上午 2022/6/29
 **/


package threadexample;

/**
 * 两个线程执行i++引发的线程安全问题
 */
public class AutomicDemo {

    int i = 0;

    //排他锁，互斥锁
    public synchronized void incr() {
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        AutomicDemo automicDemo = new AutomicDemo();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                automicDemo.incr();
            }

        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                automicDemo.incr();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(automicDemo.i);
    }
}
