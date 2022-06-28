/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 3:46 下午 2022/6/27
 **/


package org.example.bytedance.six27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum2 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        dfs(result, path, candidates, target, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> path, int[] candidates, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            dfs(result, path, candidates, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 6, 7};
        int target = 7;
        CombinationSum2 combinationSum2 = new CombinationSum2();
        List<List<Integer>> lists = combinationSum2.combinationSum(array, target);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
    }
}
