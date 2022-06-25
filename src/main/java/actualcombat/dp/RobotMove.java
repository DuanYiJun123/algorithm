/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 8:20 下午 2022/6/18
 **/


package actualcombat.dp;

/**
 * 给一个1-N的数组，机器人起始位置为吗m,目标位置为a，经过K步移动到a，其中1位置只能往右走，N位置只能往左走，求总共有多少种走法
 */
public class RobotMove {

    public int sulution(int N, int start, int end, int K) {
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < K + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return process(start, K, end, N, dp);
    }

    public static void main(String[] args) {
        RobotMove robotMove = new RobotMove();
        System.out.println(robotMove.sulution(5, 2, 4, 6));
    }


    public int process(int current, int rest, int aim, int N, int[][] dp) {
        if (dp[current][rest] != -1) {
            return dp[current][rest];
        }
        if (rest == 0) {
            if (current == aim) {
                dp[current][0] = 1;
                return 1;
            } else {
                dp[current][0] = 0;
                return 0;
            }
        }
        if (current == 1) {
            int process = process(2, rest - 1, aim, N, dp);
            dp[1][rest] = process;
            return process;
        }
        if (current == N) {
            int process = process(N - 1, rest - 1, aim, N, dp);
            dp[N][rest] = process;
            return process;
        }
        int i = process(current - 1, rest - 1, aim, N, dp) + process(current + 1, rest - 1, aim, N, dp);
        dp[current][rest] = i;
        return i;
    }
}


