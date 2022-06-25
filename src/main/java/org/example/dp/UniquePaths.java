/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 5:19 下午 2022/6/7
 **/


package org.example.dp;

/**
 * 存在一个m*n的网格，一个小虫在左上角，目标地点在右下角，小虫仅能向右或者向下走，求走到右下角的话多少种不同的走法
 */
public class UniquePaths {

    public static void main(String[] args) {
        int solution = solution(3, 7);
        System.out.println(solution);
    }

    public static int solution(int row, int column) {
        if (row == 0 || column == 0) {
            return 1;
        }
        int[][] path = new int[row][column];
        for (int i = 0; i < row; i++) {
            path[i][0] = 1;
        }
        for (int i = 0; i < column; i++) {
            path[0][i] = 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                path[i][j] = path[i - 1][j] + path[i][j - 1];
            }
        }
        return path[row - 1][column - 1];
    }
}
