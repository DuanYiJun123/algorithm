/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 5:41 下午 2022/6/12
 **/


package org.example.random;

/**
 * 假设已知一个函数 f1 可以等概率返回随即返回 1——5 。在不修改 f1的情况下，对f1进行加工得到等概率返回随机 1——7
 */
public class Random1 {

    /**
     * 已知函数，不能修改 等概率随机返回1——5
     *
     * @return
     */
    public static int f1() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 0和1等概率返回 各百分之50的概率
     *
     * @return
     */
    public static int solution1() {
        int i = 0;
        do {
            i = f1();
        } while (i == 3);
        return i < 3 ? 0 : 1;
    }

    /**
     * 得到000~111做到等概率 即0——7等概率返回
     *
     * @return
     */
    public static int solution2() {
        int i1 = solution1() << 2;
        int i2 = solution1() << 1;
        return i1 + i2;
    }

    /**
     * 得到0——6等概率返回
     *
     * @return
     */
    public static int solution3() {
        int i = 0;
        do {
            i = solution2();
        } while (i == 7);
        return i;
    }

    /**
     * 得到1——7等概率返回
     *
     * @return
     */
    public static int solution4() {
        return solution3() + 1;
    }
}
