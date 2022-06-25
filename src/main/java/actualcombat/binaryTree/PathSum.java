/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 2:50 下午 2022/6/18
 **/


package actualcombat.binaryTree;

public class PathSum {

    private boolean isSum;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        process(0, root, targetSum);
        return isSum;
    }

    public void process(int preSum, TreeNode root, int target) {

        if (root.left == null && root.right == null) {
            preSum = preSum + root.val;
            if (preSum == target) {
                isSum = true;
            }
            return;
        }
        preSum += root.val;
        if (root.left != null) {
            process(preSum, root.left, target);
        }
        if (root.right != null) {
            process(preSum, root.right, target);
        }

    }
}
