/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:01 上午 2022/6/22
 **/


package org.example.bytedance;

import java.util.LinkedList;
import java.util.Queue;

public class IsLand {
    public static int getIslandCount(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        boolean[][] visited = new boolean[row][column];
        int number = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; i++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, i, j, visited);
                    number++;
                }
            }
        }
        return number;
    }

    private static void bfs(char[][] grid, int i, int j, boolean[][] visited) {
        int[] arrayx = {0, 0, 1, -1};
        int[] arrayy = {1, -1, 0, 0};
        visited[i][j] = true;
        Queue<Integer> queueX = new LinkedList();
        queueX.offer(i);
        Queue<Integer> queueY = new LinkedList();
        queueY.offer(j);
        while (!queueX.isEmpty()) {
            Integer x = queueX.poll();
            Integer y = queueY.poll();
            for (int k = 0; k < 4; k++) {
                x = x + arrayx[k];
                y = y + arrayy[k];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !visited[x][y]) {
                    if (grid[x][y] == '1') {
                        queueX.offer(x);
                        queueY.offer(y);
                        visited[x][y] = true;
                    }
                }
            }
        }
    }
}
