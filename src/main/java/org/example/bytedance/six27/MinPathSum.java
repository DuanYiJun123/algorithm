/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 8:47 下午 2022/6/27
 **/


package org.example.bytedance.six27;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinPathSum {

    //搜索dfs算法，在数据量大的时候，会耗时过长
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int max = 0;
        List<Integer> path = new ArrayList<>();
        dfs(path, grid, 0, 0, max);
        path.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        max = path.get(0);
        return max;
    }


    //动态规划方法
    public int minPathSum2(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        //用来表示，在某个点上的最小路径和，则 dp[i][j]=grid[i][j]+min(dp[i][j-1],dp[i-1][j])
        int[][] dp = new int[row][column];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < column; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[row - 1][column - 1];
    }


    private void dfs(List<Integer> path, int[][] grid, int i, int j, int max) {
        int row = grid.length;
        int column = grid[0].length;
        if (i == row - 1 && j == column - 1) {
            max = max + grid[i][j];
            path.add(max);
            return;
        }
        if (i > row - 1) {
            return;
        }
        if (j > column - 1) {
            return;
        }
        max = max + grid[i][j];
        dfs(path, grid, i + 1, j, max);
        dfs(path, grid, i, j + 1, max);
    }

    public static void main(String[] args) {
        int[][] grid = {{7, 1, 3, 5, 8, 9, 9, 2, 1, 9, 0, 8, 3, 1, 6, 6, 9, 5}, {9, 5, 9, 4, 0, 4, 8, 8, 9, 5, 7, 3, 6, 6, 6, 9, 1, 6}, {8, 2, 9, 1, 3, 1, 9, 7, 2, 5, 3, 1, 2, 4, 8, 2, 8, 8}, {6, 7, 9, 8, 4, 8, 3, 0, 4, 0, 9, 6, 6, 0, 0, 5, 1, 4}, {7, 1, 3, 1, 8, 8, 3, 1, 2, 1, 5, 0, 2, 1, 9, 1, 1, 4}, {9, 5, 4, 3, 5, 6, 1, 3, 6, 4, 9, 7, 0, 8, 0, 3, 9, 9}, {1, 4, 2, 5, 8, 7, 7, 0, 0, 7, 1, 2, 1, 2, 7, 7, 7, 4}, {3, 9, 7, 9, 5, 8, 9, 5, 6, 9, 8, 8, 0, 1, 4, 2, 8, 2}, {1, 5, 2, 2, 2, 5, 6, 3, 9, 3, 1, 7, 9, 6, 8, 6, 8, 3}, {5, 7, 8, 3, 8, 8, 3, 9, 9, 8, 1, 9, 2, 5, 4, 7, 7, 7}, {2, 3, 2, 4, 8, 5, 1, 7, 2, 9, 5, 2, 4, 2, 9, 2, 8, 7}, {0, 1, 6, 1, 1, 0, 0, 6, 5, 4, 3, 4, 3, 7, 9, 6, 1, 9}};
        int[][] grid2 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinPathSum minPathSum = new MinPathSum();
        int i = minPathSum.minPathSum2(grid);
        System.out.println(i);
    }
}
