/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:39 上午 2022/6/29
 **/


package threadexample;

import org.openjdk.jol.info.ClassLayout;

/**
 * 这个demo主要是为了观察 锁在对象头MarkWord 中的情况
 */
public class LockDemo {
    public static void main(String[] args) {
        LockDemo demo = new LockDemo();
        //加锁之前
        System.out.println(ClassLayout.parseInstance(demo).toPrintable());
        System.out.println("加锁之后...");
        synchronized (demo) {
            System.out.println(ClassLayout.parseInstance(demo).toPrintable());
        }
    }

}
