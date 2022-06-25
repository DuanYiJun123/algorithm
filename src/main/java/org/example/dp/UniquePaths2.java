/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 6:08 下午 2022/6/7
 **/


package org.example.dp;

/**
 * 存在一个m*n的网格数组，一个小虫在左上角，目标地点在右下角，小虫仅能向右或者向下走，如果网格数组的值为1，则小虫不能通过该地，求走到右下角的话多少种不同的走法
 */
public class UniquePaths2 {

    public int solution(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 1;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return 1;
        }
        int row = grid.length;
        int column = grid[0].length;
        int[][] path = new int[row][column];
        for (int i = 0; i < row; i++) {
            if (grid[i][0] != 1) {
                path[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < column; i++) {
            if (grid[0][i] != 1) {
                path[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (grid[i][j] != 1) {
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
                } else {
                    path[i][j] = 0;
                }
            }
        }
        return path[row - 1][column - 1];
    }
}
