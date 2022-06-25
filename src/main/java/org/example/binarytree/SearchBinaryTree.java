/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 9:31 下午 2022/6/15
 **/


package org.example.binarytree;

/**
 * 搜索二叉树  对于任意一棵树，左树小于右树，对于搜索二叉树，中序遍历一定是递增的
 */
public class SearchBinaryTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isSearchTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = 0;
        int right = 0;
        if (root.left != null && root.right != null) {
            left = root.left.val;
            right = root.right.val;
            if (left < root.val && root.val < right) {
                return true;
            } else {
                return false;
            }
        }
        if (root.left != null) {
            left = root.left.val;
            if (left < root.val) {
                return true;
            } else {
                return false;
            }
        }
        if (root.right != null) {
            right = root.right.val;
            if (root.val < right) {
                return true;
            } else {
                return false;
            }
        }
        boolean searchTree = isSearchTree(root.left);
        boolean searchTree1 = isSearchTree(root.right);
        return searchTree && searchTree1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(1);
        treeNode.left=treeNode1;
        boolean searchTree = isSearchTree(treeNode);
        System.out.println(searchTree);
    }
}
