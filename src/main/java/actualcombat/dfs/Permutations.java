/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 2:59 下午 2022/6/19
 **/


package actualcombat.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列 给一个数组，输出所有可能的全排列
 */
public class Permutations {


    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        List<Integer> temp = new ArrayList<>();
        dfs(result, temp, nums);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            result.add(temp);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            dfs(result, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        List<Integer> tmp = new ArrayList<>();
        if (nums.length == 1) {
            tmp.add(nums[0]);
            result.add(tmp);
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            tmp.add(nums[i]);
            List<List<Integer>> permute = permute(removeElement(nums, nums[i]));
            for (List<Integer> list : permute) {
                list.add(0, nums[i]);
            }
            result.addAll(permute);
        }
        return result;
    }

    public int[] removeElement(int[] nums, int element) {
        int[] array = new int[nums.length - 1];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (nums[i] == element) {
                j++;
            }
            array[i] = nums[j];
            j++;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        Permutations permutations = new Permutations();
        List<List<Integer>> permute = permutations.permute(array);
        for (int i = 0; i < permute.size(); i++) {
            System.out.println(permute.get(i));
        }
    }
}
