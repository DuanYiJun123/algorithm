/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:20 上午 2022/6/13
 **/


package org.example.random;

/**
 * 假设一个函数f1 以固定但不等 概率 返回0，和1。借助该函数，生成一个函数等概率的返回 0，1
 */
public class Random2 {

    /**
     * 固定不等概率返回，0.84的概率返回0，0.16的概率返回1
     *
     * @return
     */
    public static int f1() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    public static int solution() {
        int i = 0;
        int i1 = 0;
        do {
            i = f1();
            i1 = f1();
        } while (i == i1);
        if (i == 1 && i1 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int solution2() {
        int ans = 0;
        do {
            ans = f1();
        } while (ans == f1());
        return ans;
    }
}
