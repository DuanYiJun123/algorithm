/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:39 上午 2022/6/15
 **/


package org.example.binarytree;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class MirrorTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode newRoot = new TreeNode(root.val);
        newRoot.right = mirrorTree(root.left);
        newRoot.left = mirrorTree(root.right);
        return newRoot;
    }

}
