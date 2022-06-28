/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:15 上午 2022/6/28
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
public class MinDepth {

    int res = 0;
    int start = 0;
    public int minDepth(TreeNode root) {
        dfs(root, start);
        return res;
    }

    private void dfs(TreeNode root, int current) {
        if (root == null) {
            return;
        }
        current++;
        if (root.left == null && root.right == null) {
            if(current<res||res==0){
                res=current;
            }
        }
        dfs(root.left, current);
        dfs(root.right, current);
    }
}
