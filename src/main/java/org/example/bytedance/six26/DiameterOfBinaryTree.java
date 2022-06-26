/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 9:02 下午 2022/6/26
 **/


package org.example.bytedance.six26;

import actualcombat.binaryTree.TreeNode;

/**
 * 二叉树的直径
 */
public class DiameterOfBinaryTree {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        process(root);
        return max;
    }

    private int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = process(root.left);
        int right = process(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
