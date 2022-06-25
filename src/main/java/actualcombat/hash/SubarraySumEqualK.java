/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 8:26 下午 2022/6/19
 **/


package actualcombat.hash;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualK {

    public int subarraySum(int[] nums, int k) {
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        preSumFreq.put(0, 1);
        int count = 0;
        int temp = 0;
        int[] array = new int[nums.length];
        array[0] = nums[0];
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i - 1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            if (preSumFreq.containsKey(array[i] - k)) {
                count += preSumFreq.get(array[i] - k);
            }
            // 然后维护 preSumFreq 的定义
            if (preSumFreq.containsKey(array[i])) {
                temp = preSumFreq.get(array[i]) + 1;
            } else {
                temp = 1;
            }
            //preSumFreq.put(array[i], preSumFreq.getOrDefault(array[i], 0) + 1);
            preSumFreq.put(array[i], temp);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        SubarraySumEqualK subarraySumEqualK = new SubarraySumEqualK();
        int i = subarraySumEqualK.subarraySum(nums, 3);
        System.out.println(i);
    }

}
