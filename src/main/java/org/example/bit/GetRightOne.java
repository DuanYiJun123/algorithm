/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 9:40 下午 2022/7/4
 **/


package org.example.bit;

/**
 * 已知一个整型数，将最右侧的1提取出来
 * <p>
 * 解法：a与上&自己的取反+1  即   a与上自己的相反数，即可得到
 */
public class GetRightOne {

    public static void main(String[] args) {
        int a = 3551464;
        System.out.println(solution(a));
    }

    public static int solution(int a) {
        return a & (~a + 1);
    }
}
