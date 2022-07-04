/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:33 下午 2022/6/27
 **/


package org.example.bytedance.six27;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 */
public class NumTrees {


    /**
     * 解法 假设 n 个节点存在二叉排序树的个数是 G (n)，令 f(i) 为以 i 为根的二叉搜索树的个数，则
     * G(n) = f(1) + f(2) + f(3) + f(4) + ... + f(n)G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n)
     * <p>
     * 当 i 为根节点时，其左子树节点个数为 i-1 个，右子树节点为 n-i，则
     * f(i) = G(i-1)*G(n-i)f(i)=G(i−1)∗G(n−i)
     * <p>
     * 综合两个公式可以得到 卡特兰数 公式
     * G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)  G(n)=G(0)∗G(n−1)+G(1)∗(n−2)+...+G(n−1)∗G(0)
     * <p>
     * 作者：guanpengchn
     * 链接：https://leetcode.cn/problems/unique-binary-search-trees/solution/hua-jie-suan-fa-96-bu-tong-de-er-cha-sou-suo-shu-b/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
//        dp[1] = 1;
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

//    public int numTrees(int n) {
//        int[] G = new int[n + 1];
//        G[0] = 1;
//        G[1] = 1;
//
//        for (int i = 2; i <= n; ++i) {
//            for (int j = 1; j <= i; ++j) {
//                G[i] += G[j - 1] * G[i - j];
//            }
//        }
//        return G[n];
//    }



    public static void main(String[] args) {
        NumTrees numTrees=new NumTrees();
        int i = numTrees.numTrees(3);
        System.out.println(i);
    }
}
