/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 8:52 下午 2022/6/15
 **/


package org.example.binarytree;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class BalanceTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class Info {
        boolean isBalanced;
        int hight;

        public Info(boolean isBalanced, int hight) {
            this.isBalanced = isBalanced;
            this.hight = hight;
        }
    }

    public static boolean isBalanced(TreeNode root) {

        Info treeInfo = getTreeInfo(root,0);
        return treeInfo.isBalanced;
    }

//    public static Info getTreeInfo(TreeNode node) {
//        if (node == null) {
//            return new Info(true, 0);
//        }
//
//        Info leftInfo = getTreeInfo(node.left);
//        Info rightInfo = getTreeInfo(node.right);
//        int height = Math.max(leftInfo.hight, rightInfo.hight) + 1;
//        if (Math.abs(leftInfo.hight - rightInfo.hight) > 1) {
//            return new Info(false, height);
//        }
//        if (Math.abs(leftInfo.hight - rightInfo.hight) <= 1 && leftInfo.isBalanced && rightInfo.isBalanced) {
//            return new Info(true, height);
//        }
//        return new Info(false, height);
//    }

    public static Info getTreeInfo(TreeNode root, int height) {
        if (root == null) {
            return new Info(true, height);
        }
        height++;
        Info leftInfo = getTreeInfo(root.left, height);
        Info rightInfo = getTreeInfo(root.right, height);
        height = Math.max(leftInfo.hight, rightInfo.hight);
        if (Math.abs(leftInfo.hight - rightInfo.hight) > 1) {
            return new Info(false, height);
        }
        if (Math.abs(leftInfo.hight - rightInfo.hight) <= 1 && leftInfo.isBalanced && rightInfo.isBalanced) {
            return new Info(true, height);
        }
        return new Info(false, height);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;

        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        node2.left = node4;
        node2.right = node5;

        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(4);
        node4.left = node6;
        node4.right = node7;
        boolean balanced = isBalanced(node1);
        System.out.println(balanced);
    }
}
