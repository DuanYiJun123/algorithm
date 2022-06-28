/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:30 上午 2022/6/28
 **/


package org.example.bytedance.six28;

import actualcombat.binaryTree.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 */
public class MinDepth2 {

    int min = 0;

    int current = 0;

    public int minDepth(TreeNode root) {
        process(root, current);
        return min+1;
    }

    public void process(TreeNode root, int current) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (current < min || min == 0) {
                min = current;
            }
        }
        current++;
        process(root.left, current);
        process(root.right, current);
    }
}
