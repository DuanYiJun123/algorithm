/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 7:52 下午 2022/6/18
 **/


package actualcombat.dp;

public class ClimbingStairs {

    public int climbStairs(int n) {
        int[] array = new int[n + 1];
        array[1] = 1;
        array[2] = 2;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        int i = climbingStairs.climbStairs(4);
        System.out.println(i);

    }
}
