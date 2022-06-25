/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 9:33 下午 2022/6/5
 **/


package org.example.unionfind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给一个m*n的矩阵，随即选取其中的点，然后输出小岛的个数
 */
public class IsLand2 {

    public static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public static class UnionFind {
        private Map<Integer, Integer> father = new HashMap<>();

        public UnionFind(int row, int column) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    int id = convertId(i, j, column);
                    father.put(id, id);
                }
            }
        }

        public int find(int x) {
            int parent = father.get(x);
            int temp = father.get(x);
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
            if (temp != parent) {
                father.put(x, parent);
            }
            return parent;
        }

        public void union(int x, int y) {
            int parent_x = father.get(x);
            int parent_y = father.get(y);
            if (parent_x != parent_y) {
                father.put(parent_x, parent_y);
            }
        }

        /**
         * 将矩阵的点生成id
         *
         * @param i
         * @param j
         * @param column
         * @return
         */
        private int convertId(int i, int j, int column) {
            return i * column + j;
        }
    }


    public List<Integer> numIsLands(int n, int m, Point[] operators) {
        List<Integer> result = new ArrayList<>();
        if (operators == null || operators.length == 0) {
            return result;
        }
        boolean[][] visited = new boolean[n][m];
        UnionFind unionFind = new UnionFind(n, m);
        int count = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (Point point : operators) {
            int x = point.x;
            int y = point.y;
            if (!visited[x][y]) {
                visited[x][y] = true;
                count++;
                int id = unionFind.convertId(x, y, m);
                for (int i = 0; i < 4; i++) {
                    int newX = x + dx[i];
                    int newY = y + dy[i];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && visited[newX][newY]) {
                        int newId = unionFind.convertId(newX, newY, m);
                        int parentNew = unionFind.find(newId);
                        int parent = unionFind.find(id);
                        if (parentNew != parent) {
                            unionFind.union(parent, parentNew);
                            count--;
                        }
                    }
                }
            }
            result.add(count);
        }
        return result;
    }

    /**
     * 测试用例
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 4;
        int m = 5;
        Point[] operators = new Point[4];
        Point point1 = new Point(1, 1);
        Point point2 = new Point(0, 1);
        Point point3 = new Point(3, 3);
        Point point4 = new Point(3, 4);
        operators[0] = point1;
        operators[1] = point2;
        operators[2] = point3;
        operators[3] = point4;
        IsLand2 isLand2 = new IsLand2();
        List<Integer> integers = isLand2.numIsLands(n, m, operators);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
