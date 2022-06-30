/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:51 上午 2022/6/29
 **/


package threadexample;

import org.openjdk.jol.info.ClassLayout;

/**
 * 这个demo演示的是重量级锁
 */
public class HeightLockDemo {

    public static void main(String[] args) {
        HeightLockDemo demo = new HeightLockDemo();
        Thread t1 = new Thread(() -> {
            synchronized (demo) {
                System.out.println("t1 locked");
                System.out.println(ClassLayout.parseInstance(demo).toPrintable());
            }
        });
        t1.start();
        synchronized (demo) {
            System.out.println("main locked");
            System.out.println(ClassLayout.parseInstance(demo).toPrintable());
        }
    }
}
