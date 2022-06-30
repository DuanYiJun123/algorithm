/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 2:45 下午 2022/6/8
 **/


package org.example;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("1");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("2");
        });
        Thread thread3 = new Thread(() -> {
            System.out.println("3");
        });
        thread1.start();
        thread2.start();
        thread3.start();
        while (true) {

            thread1.join();
            thread2.join();
            thread3.join();
            thread1.notifyAll();
        }
    }
}
