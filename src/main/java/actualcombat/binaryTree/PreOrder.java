/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 9:29 上午 2022/6/20
 **/


package actualcombat.binaryTree;

import java.util.Stack;

public class PreOrder {

    public void solution(TreeNode root) {
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

    public static void main(String[] args) {
        PreOrder preOrder=new PreOrder();
        TreeNode head = preOrder.init();
        preOrder.solution(head);
    }
}
