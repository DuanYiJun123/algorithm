/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 8:13 下午 2022/6/17
 **/


package actualcombat.binaryTree;

import java.util.Stack;

public class PreOrderTraversal {

    /**
     * 递归的方法
     *
     * @param root
     */
    public void solution(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        solution(root.left);
        solution(root.right);
    }

    /**
     * 非递归的方法
     */
    public void solution2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                System.out.println(current.val);
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
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
        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
        TreeNode head = preOrderTraversal.init();
        //preOrderTraversal.solution(head);
        preOrderTraversal.solution2(head);
    }
}
