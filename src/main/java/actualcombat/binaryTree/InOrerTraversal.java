/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:43 上午 2022/6/18
 **/


package actualcombat.binaryTree;

import java.util.Stack;

public class InOrerTraversal {

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

    /**
     * 递归的方式解决
     *
     * @param root
     */
    public void solution(TreeNode root) {
        if (root == null) {
            return;
        }
        solution(root.left);
        System.out.println(root.val);
        solution(root.right);
    }

    /**
     * 非递归的方式解决
     *
     * @param root
     */
    public void solution2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                System.out.println(current.val);
                current = current.right;
            }
        }
    }

    public static void main(String[] args) {
        InOrerTraversal inOrerTraversal = new InOrerTraversal();
        TreeNode head = inOrerTraversal.init();
       // inOrerTraversal.solution(head);
        inOrerTraversal.solution2(head);
    }
}
