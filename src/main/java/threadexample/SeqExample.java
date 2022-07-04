/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:20 上午 2022/7/4
 **/


package threadexample;

/**
 * 这个demo展示了cpu指令重排序的问题
 */
public class SeqExample {

    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        x = 0;
        y = 0;
        a = 0;
        b = 0;
       for(;;){
            i++;
            Thread t1 = new Thread(() -> {
                a = 1;
                x = b;
            });
            Thread t2 = new Thread(() -> {
                b = 1;
                y = a;
            });
            /**
             * 可能得结果
             * 1和1
             * 0和1
             * 1和0
             * ------
             * 0和0
             */
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            if (x == 0 && y == 0) {
                System.out.println("第" + i + "次" + "x和y都等于0");
                break;
            }
        }
    }
}
