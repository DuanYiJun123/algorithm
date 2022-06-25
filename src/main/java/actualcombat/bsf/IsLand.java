/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 6:01 下午 2022/6/19
 **/


package actualcombat.bsf;

import java.util.LinkedList;
import java.util.Queue;

public class IsLand {

    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        boolean[][] visited = new boolean[row][column];
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(i, j, grid, visited);
                    result++;
                }
            }
        }
        return result;
    }

    private void bfs(int i, int j, char[][] grid, boolean[][] visited) {
        visited[i][j] = true;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<Integer> xQueue = new LinkedList();
        Queue<Integer> yQueue = new LinkedList();
        xQueue.offer(i);
        yQueue.offer(j);
        while (!xQueue.isEmpty()) {
            int x = xQueue.poll();
            int y = yQueue.poll();
            for (int k = 0; k < 4; k++) {
                int newx = x + dx[k];
                int newY = y + dy[k];
                if (newx >= 0 && newx < grid.length && newY >= 0 && newY < grid[0].length && grid[newx][newY] == '1' && !visited[newx][newY]) {
                    xQueue.offer(newx);
                    yQueue.offer(newY);
                }
            }
        }
    }
}
