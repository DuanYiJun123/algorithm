/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 3:24 下午 2022/6/26
 **/


package org.example.bytedance.six26;

import actualcombat.binaryTree.TreeNode;

/**
 * 对称二叉树
 */
public class Symmetric {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
