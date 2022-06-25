/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 3:16 下午 2022/6/18
 **/


package actualcombat.binaryTree;

public class BuildTree {

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null) {
            return null;
        }
        if (preOrder.length != inOrder.length) {
            return null;
        }
        return build(preOrder, 0, preOrder.length - 1, inOrder, 0, preOrder.length - 1);
    }

    public TreeNode build(int[] preOrder, int L1, int R1, int[] inOrder, int L2, int R2) {
        if (L1 > R1) {
            return null;
        }
        TreeNode head = new TreeNode(preOrder[L1]);
        if (L1 == R1) {
            return head;
        }
        int find = findHead(preOrder, inOrder, L1, R1);
        head.left = build(preOrder, L1 + 1, L1 - L2 + find, inOrder, L2, find - 1);
        head.right = build(preOrder, L1 - L2 + find + 1, R1, inOrder, find + 1, R2);

        return head;
    }

    public int findHead(int[] preOrder, int[] inOrder, int L1, int R1) {
        int head = preOrder[L1];
        int index = L1;
        while (inOrder[index] != head && index < R1) {
            index++;
        }
        return index;
    }
}
