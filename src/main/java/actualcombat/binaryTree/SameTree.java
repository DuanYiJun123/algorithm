/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 2:40 下午 2022/6/18
 **/


package actualcombat.binaryTree;

public class SameTree {


    public boolean solution(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return solution(p.left, q.left) && solution(p.right, q.right);
    }
}
