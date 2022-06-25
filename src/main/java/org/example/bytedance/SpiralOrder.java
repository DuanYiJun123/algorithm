/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:25 上午 2022/6/21
 **/


package org.example.bytedance;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null) {
            return result;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        boolean[][] visited = new boolean[row][column];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directIndex = 0;
        int currentRow = 0;
        int currentColumn = 0;

        int total = row * column;
        for (int i = 0; i < total; i++) {
            visited[currentRow][currentColumn] = true;
            result.add(matrix[currentRow][currentColumn]);
            int nextRow = currentRow + directions[directIndex][0];
            int nextColumn = currentColumn + directions[directIndex][1];
            if (nextColumn < 0 || nextColumn >= column || nextRow >= row || nextRow < 0 || visited[nextRow][nextColumn]) {
                directIndex = (directIndex + 1) % 4;
            }
            currentRow = currentRow + directions[directIndex][0];
            currentColumn = currentColumn + directions[directIndex][1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};
        SpiralOrder spiralOrder = new SpiralOrder();
        List<Integer> list = spiralOrder.spiralOrder(grid);
        System.out.println(list);
    }
}
