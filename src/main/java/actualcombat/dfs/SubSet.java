/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 4:00 下午 2022/6/19
 **/


package actualcombat.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 */
public class SubSet {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (nums == null) {
            result.add(temp);
            return result;
        }

        if (nums.length == 0) {
            result.add(temp);
            return result;
        }
        if (nums.length == 1) {
            temp.add(nums[0]);
            result.add(temp);
            result.add(new ArrayList<>());
            return result;
        }
        result.add(new ArrayList<>());
        dfs(result,temp,nums,0);

        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> tmp, int[] nums, int pos) {
        result.add(new ArrayList<>(tmp));
        for (int i = pos; i < nums.length; i++) {
            tmp.add(nums[i]);
            pos++;
            dfs(result, tmp, nums, pos);
            tmp.remove(tmp.size() - 1);
        }
    }


}
