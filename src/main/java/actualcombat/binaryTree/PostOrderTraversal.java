/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 11:00 上午 2022/6/18
 **/


package actualcombat.binaryTree;

import java.util.Stack;

/**
 * 后序遍历
 */
public class PostOrderTraversal {

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

    public void solution2(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = head;
        TreeNode prev = null;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.peek();
                if (current.right != null && current.right != prev) {
                    current = current.right;
                    stack.push(current);
                    current = current.left;
                } else {
                    current = stack.pop();
                    System.out.println(current.val);
                    prev = current;
                    current = null;
                }
            }
        }
    }

    public static void main(String[] args) {
        PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
        TreeNode head = postOrderTraversal.init();
        postOrderTraversal.solution2(head);
    }
}
