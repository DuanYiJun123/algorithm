/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 4:38 下午 2022/6/27
 **/


package org.example.bytedance.six27;

import actualcombat.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {

    public boolean isValidBST(TreeNode root) {

        List<Integer> list = InOrder(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static class Info {
        int min;
        int max;
        boolean isBST;

        public Info(int min, int max, boolean isBST) {
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }


    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Info process = process(root);

        return process.isBST;
    }

    private Info process(TreeNode root) {
        if (root == null) {
            return null;
        }
        Info left = process(root.left);
        Info right = process(root.right);
        int max = root.val;
        int min = root.val;
        if (left != null) {
            max = Math.max(left.max, max);
            min = Math.min(left.min, min);
        }
        if (right != null) {
            max = Math.max(right.max, max);
            min = Math.min(right.min, min);
        }
        boolean isBST = true;
        if (left != null && !left.isBST) {
            isBST = false;
        }

        if (right != null && !right.isBST) {
            isBST = false;
        }
        boolean leftMaxLessRoot = left == null ? true : (left.max < root.val);
        boolean rightMinGreaterRoot = right == null ? true : (right.min > root.val);

        if (!leftMaxLessRoot || !rightMinGreaterRoot) {
            isBST = false;
        }
        return new Info(max, min, isBST);
    }

    public List<Integer> InOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(InOrder(root.left));
        result.add(root.val);
        result.addAll(InOrder(root.right));
        return result;
    }
}
