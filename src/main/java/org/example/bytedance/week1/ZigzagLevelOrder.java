/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 7:37 下午 2022/6/24
 **/


package org.example.bytedance.week1;

import actualcombat.binaryTree.TreeNode;

import java.util.*;

public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeft = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (isLeft) {
                    list.offerFirst(poll.val);
                } else {
                    list.offerLast(poll.val);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            isLeft = !isLeft;
            result.add(new ArrayList<>(list));
        }
        return result;
    }
}
