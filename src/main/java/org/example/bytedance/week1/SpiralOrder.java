/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:17 上午 2022/6/24
 **/


package org.example.bytedance.week1;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int total = row * column;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[row][column];
        int currentRow = 0;
        int currentColumn = 0;
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            visited[currentRow][currentColumn] = true;
            result.add(matrix[currentRow][currentColumn]);
            int nextRow = currentRow + directions[directionIndex][0];
            int nextColumn = currentColumn + directions[directionIndex][1];
            if (nextRow >= row || nextColumn >= column || nextRow < 0 || nextColumn < 0 || visited[nextRow][nextColumn]) {
                directionIndex++;
                directionIndex = directionIndex % 4;
            }
            currentRow = currentRow + directions[directionIndex][0];
            currentColumn = currentColumn + directions[directionIndex][1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        SpiralOrder spiralOrder = new SpiralOrder();
        spiralOrder.spiralOrder(matrix);
    }
}
