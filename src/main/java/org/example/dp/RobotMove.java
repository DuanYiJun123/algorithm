/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:02 上午 2022/6/10
 **/


package org.example.dp;

/**
 * 给一个1-N的数组，机器人起始位置为吗m,目标位置为a，经过K步移动到a，其中1位置只能往右走，N位置只能往左走，求总共有多少种走法
 */
public class RobotMove {

    public int sulution(int N, int start, int end, int K) {
        int[][] array = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            array[i][0] = 0;
            if (i == end) {
                array[end][0] = 1;
            }
        }

        for (int j = 1; j <= K; j++) {
            for (int i = 1; i <= N; i++) {
                if (i == 1) {
                    array[i][j] = array[2][j - 1];
                    continue;
                }
                if (i == N) {
                    array[i][j] = array[i - 1][j - 1];
                    continue;
                }
                array[i][j] = array[i - 1][j - 1] + array[i + 1][j - 1];
            }
        }
        return array[start][K];
    }

//    public static void main(String[] args) {
//        RobotMove robotMove = new RobotMove();
//        int sulution = robotMove.sulution(5, 2, 4, 6);
//        int process = robotMove.process(2, 6, 4, 5);
//
//        System.out.println(sulution);
//        System.out.println(process);
//    }

    /**
     * 递归
     *
     * @param current
     * @param rest
     * @param aim
     * @param N
     * @return
     */
    public int process(int current, int rest, int aim, int N, int[][] dp) {
        if (dp[current][rest] != -1) {
            return dp[current][rest];
        }

        if (rest == 0) {
            if (current == aim) {
                return 1;
            } else {
                return 0;
            }
        }
        if (current == 1) {
            int process = process(2, rest - 1, aim, N, dp);
            dp[current][rest] = process;
            return process;
        } else if (current == N) {
            int process = process(N - 1, rest - 1, aim, N, dp);
            dp[current][rest] = process;
            return process;
        } else {
            int i = process(current - 1, rest - 1, aim, N, dp) + process(current + 1, rest - 1, aim, N, dp);
            dp[current][rest] = i;
            return i;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int start = 2;
        int end = 4;
        int k = 6;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = -1;
            }
        }
        RobotMove robotMove = new RobotMove();
//        int process = robotMove.process(start, k, end, n, dp);
//        System.out.println(process);
        int sulution = robotMove.sulution(5, 2, 4, 6);
        System.out.println(sulution);
    }
}
