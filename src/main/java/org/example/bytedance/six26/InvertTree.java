/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 6:03 下午 2022/6/26
 **/


package org.example.bytedance.six26;

import actualcombat.binaryTree.TreeNode;

/**
 * 翻转二叉树
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
