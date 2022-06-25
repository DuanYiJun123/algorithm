/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:41 下午 2022/6/24
 **/


package org.example.bytedance.week1;

import actualcombat.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSide {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean hasRight = false;
        while (!queue.isEmpty()) {
            hasRight = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (!hasRight) {
                    result.add(poll.val);
                    hasRight = true;
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
            }
        }
        return result;
    }
}
