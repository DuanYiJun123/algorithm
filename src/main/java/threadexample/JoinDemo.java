/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 4:00 下午 2022/7/4
 **/


package threadexample;

import java.util.concurrent.TimeUnit;

/**
 * 这个例子展示了join的用法
 */
public class JoinDemo extends Thread {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        JoinDemo joinDemo = new JoinDemo();
        joinDemo.start();
        //TODO ....do something
        joinDemo.join();//等待JoninDemo线程执行结束，如果没有执行结束，则会阻塞main线程（那个线程调用，则阻塞那个线程）
        //TODO
        System.out.println("main线程执行结束");
    }
}
