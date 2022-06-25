/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:59 下午 2022/6/19
 **/


package actualcombat.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 站在二叉树右边去看，解题思路，层序遍历
 */
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            boolean findRight = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (!findRight) {
                    result.add(poll.val);
                    findRight = true;
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
