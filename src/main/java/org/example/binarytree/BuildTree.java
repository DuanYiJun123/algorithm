/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 4:20 下午 2022/6/15
 **/


package org.example.binarytree;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree {

    public class TreeNode {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length != inorder.length) {
            return null;
        }

        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length);
    }

    //有一课树，先序结果是pre[L1...R1] 中序结果是【L2....R2】
    //请建出整棵树，返回头节点
    public TreeNode build(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        if (l1 > r1) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[l1]);
        if (l1 == r1) {
            return head;
        }
        int find = l2;
        while (preorder[l1] != inorder[find]) {
            find++;
        }
        head.left = build(preorder, l1 + 1, l1 + find - l2, inorder, l2, find - 1);
        head.right = build(preorder, l1 + find - l2 + 1, r1, inorder, find + 1, r2);
        return head;

    }
}
