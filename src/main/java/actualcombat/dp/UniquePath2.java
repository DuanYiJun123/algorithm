/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:35 上午 2022/6/19
 **/


package actualcombat.dp;

/**
 * 存在一个m*n的网格数组，一个小虫在左上角，目标地点在右下角，小虫仅能向右或者向下走，如果网格数组的值为1，则小虫不能通过该地，求走到右下角的话多少种不同的走法
 */
public class UniquePath2 {

    public int solution(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] result = new int[row][column];
        for (int i = 0; i < row; i++) {
            if (grid[i][0] == 1) {
                break;
            }
            result[i][0] = 1;
        }

        for (int j = 0; j < column; j++) {
            if (grid[0][j] == 1) {
                break;
            }
            result[0][j] = 1;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (grid[i][j] != 1) {
                    result[i][j] = grid[i - 1][j] + grid[i][j - 1];
                } else {
                    result[i][j] = 0;
                }

            }
        }
        return result[row - 1][column - 1];
    }
}
