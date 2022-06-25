/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 4:25 下午 2022/6/18
 **/


package actualcombat.binaryTree;

public class BalanceTree {

    public class Info {
        int hight;
        boolean balanced;

        public Info(int hight, boolean balanced) {
            this.hight = hight;
            this.balanced = balanced;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return process(root).balanced;
    }

    public Info process(TreeNode root) {
        if (root == null) {
            return new Info(0, true);
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int hight = Math.max(leftInfo.hight, rightInfo.hight) + 1;
        if (!leftInfo.balanced) {
            return new Info(hight, false);
        }
        if (!rightInfo.balanced) {
            return new Info(hight, false);
        }
        if (Math.abs(leftInfo.hight - rightInfo.hight) > 1) {
            return new Info(hight, false);
        }
        return new Info(hight, true);
    }
}
