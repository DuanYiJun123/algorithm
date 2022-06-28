/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 8:21 下午 2022/6/27
 **/


package org.example.bytedance.six27;

/**
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Rotate {

    //解法一，先上下交换，然后再对角线交换
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        //先上下交换
        for (int i = 0; i < length / 2; i++) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[length - 1 - i];
            matrix[length - 1 - i] = tmp;
        }
        //对角线交换
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    //解法二，当前位置的列，是后一个位置的行
    //当前位置的行，是前一个位置的列
    public void rotate2(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length / 2; i++) {
            for (int j = i; j < length - i - 1; j++) {
                //(i,j)->(j,n-i-1)->(n-i-1,n-j-1)->(n-j-1,i)
                int tmp = matrix[i][j];
                matrix[length - j - 1][i] = matrix[length - i - 1][length - j - 1];
                matrix[length - i - 1][length - j - 1] = matrix[j][length - i - 1];
                matrix[j][length - i - 1] = tmp;
            }
        }
    }
}
