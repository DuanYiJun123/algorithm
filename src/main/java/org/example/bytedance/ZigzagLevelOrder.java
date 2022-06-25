/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 3:31 下午 2022/6/22
 **/


package org.example.bytedance;


import java.util.*;

public class ZigzagLevelOrder {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //true从左向右，false从右向左
        boolean isleft = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (isleft) {
                    temp.offerLast(poll.val);
                } else {
                    temp.offerFirst(poll.val);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            isleft = !isleft;
            result.add(new ArrayList<>(temp));
        }
        return result;
    }
}
