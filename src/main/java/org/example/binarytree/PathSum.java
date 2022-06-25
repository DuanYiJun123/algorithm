/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:33 上午 2022/6/16
 **/


package org.example.binarytree;

public class PathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isSum = false;

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        isSum = false;
        process(root, 0, targetSum);
        return isSum;
    }


    public static void process(TreeNode x, int preSum, int sum) {
        if (x.left == null && x.right == null) {
            if (x.val + preSum == sum) {
                isSum = true;
            }
            return;
        }
        preSum += x.val;
        if (x.left != null) {
            process(x.left, preSum, sum);
        }
        if (x.right != null) {
            process(x.right, preSum, sum);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);

        node.left = node1;
        node.right = node2;
        TreeNode node3 = new TreeNode(11);

        node1.left = node3;

        TreeNode node4 = new TreeNode(13);
        node4.left = node4;

        hasPathSum(node,20);
    }
}
