/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 3:20 下午 2022/7/1
 **/


package threadexample;

public class ThreeThreadOneTwoThree {

    public static void main(String[] args) {
        ThreeThreadOneTwoThree threeThreadOneTwoThree = new ThreeThreadOneTwoThree();
        new Thread(() -> {
            while (true){
                threeThreadOneTwoThree.printA();
            }

        }).start();

        new Thread(() -> {
            while (true){
                threeThreadOneTwoThree.printB();
            }

        }).start();

        new Thread(() -> {
            while (true){
                threeThreadOneTwoThree.printC();
            }

        }).start();
    }

    private volatile int flag = 1;

    public synchronized void printA() {
//        while (true) {
            if (flag == 1) {
//                synchronized (this) {
                    if (flag == 1) {
                        System.out.println(Thread.currentThread().getName() + "1");
                        flag = 2;
                    }
                }
//            }
//        }
    }

    public synchronized void printB() {
       // while (true) {
            if (flag == 2) {
               // synchronized (this) {
                    if (flag == 2) {
                        System.out.println(Thread.currentThread().getName() + "2");
                        flag = 3;
                    }
                }
            //}
        //}
    }

    public void printC() {
        //while (true) {
            if (flag == 3) {
                //synchronized (this) {
                    if (flag == 3) {
                        System.out.println(Thread.currentThread().getName() + "3");
                        flag = 1;
                    }
                }
            //}
        //}
    }
}
