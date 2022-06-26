/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 3:14 下午 2022/6/26
 **/


package org.example.bytedance.six26;

import actualcombat.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                result.add(current.val);
                current = current.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        root.right = right;
        right.left = left;
        InOrder inOrder = new InOrder();
        List<Integer> list = inOrder.inorderTraversal(root);
        for(Integer integer:list){
            System.out.println(integer);
        }
    }
}
