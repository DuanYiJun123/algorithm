/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:32 上午 2022/6/18
 **/


package actualcombat.binaryTree;

public class MaxDeepth {

    public TreeNode init() {
        TreeNode head = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);

        head.left = node1;
        head.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        return head;
    }

    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(solution(root.left), solution(root.right)) + 1;
    }

    public static void main(String[] args) {
        MaxDeepth maxDeepth = new MaxDeepth();
        TreeNode head = maxDeepth.init();
        int solution = maxDeepth.solution(head);
        System.out.println(solution);
    }
}
