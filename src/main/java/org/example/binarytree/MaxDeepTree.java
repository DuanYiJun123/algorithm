/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:57 上午 2022/6/15
 **/


package org.example.binarytree;

public class MaxDeepTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
