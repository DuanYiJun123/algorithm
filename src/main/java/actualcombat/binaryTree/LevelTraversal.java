/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:36 上午 2022/6/18
 **/


package actualcombat.binaryTree;

import java.util.*;

public class LevelTraversal {

    public List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.poll();
                tmp.add(pop.val);
                if (pop.left != null) {
                    queue.offer(pop.left);
                }
                if (pop.right != null) {
                    queue.offer(pop.right);
                }
            }
            result.add(tmp);
        }
        return result;
    }
}
