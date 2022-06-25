/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:17 上午 2022/6/19
 **/


package actualcombat.dp;

/**
 * 存在一个m*n的网格，一个小虫在左上角，目标地点在右下角，小虫仅能向右或者向下走，求走到右下角的话多少种不同的走法
 */
public class UniquePaths {

    public static int solution(int row, int column) {

        if (row == 1) {
            if (column > 1) {
                return column - 1;
            } else {
                return 0;
            }
        }
        if (column == 1) {
            if (row > 1) {
                return row - 1;
            } else {
                return 0;
            }
        }

        int[][] dp = new int[row][column];
        for (int i = 0; i < row; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < column; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[row - 1][column - 1];
    }

    public static void main(String[] args) {
        int solution = solution(3, 4);
        System.out.println(solution);
    }


}
