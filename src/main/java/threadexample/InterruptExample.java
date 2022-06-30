/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:24 下午 2022/6/28
 **/


package threadexample;

/**
 * 如何在线程外中断线程的运行的Demo
 * isInterrupted 的调用
 */
public class InterruptExample implements Runnable {


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new InterruptExample());
        t1.start();
        Thread.sleep(2000);
        //这里调用，就会让下面线程中while语句中的循环跳出
        t1.interrupt();
    }

    @Override
    public void run() {
        //注意这里使用过的条件  isInterrupted
        while (!Thread.currentThread().isInterrupted()) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                //这里阻塞的方法，发生中断，抛出InterruptedException之后，会恢复中断状态，仍然会执行 sout的打印
                //如果你希望它中断，那么可以执行代码 Thread.currentThread.interrupt
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName() + "--");
        }
    }
}
