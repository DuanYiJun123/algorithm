/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:26 下午 2022/7/4
 **/


package org.example.bit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 一个数组中有一种数出现了K次，其他数都出现了M次
 * M>1,K<M
 * 找到，出现了K次的数
 * 要求，空间复杂度O1，时间复杂度ON
 * <p>
 * <p>
 * 解法思路 ：借助一个长度的32位的数组，然后将数组中的每个数展开为二进制，对应每一位上为1的话，就累加到该32位长的数组上去。最后看该数组的每一位的数字
 * 若该数字是M的整数倍，则一定不是K的数字，若该数字是M的整数倍，则该位对应的K的数字的一定也是1
 */
public class FindKNum {

    //需要保障arr中只有一种数出现了k次，其他都出现了M次
    public static int solution(int[] array, int K, int M) {
        //tem[0] 0位置的1出现了几个
        //tem[1] 1位置出现了几个
        int[] tem = new int[32];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <= 31; j++) {
                //依次提取出每位上的非0数字   向右移动j位与上1不等于0，即表示j位是1
                if ((array[i] >> j & 1) != 0) {
                    tem[j]++;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < tem.length; i++) {
            if (tem[i] % M == 0) {
                //说明K数在第i位置上不为1
            } else {
                //说明K数在第i位置上是1
                ans |= (1 << i);   //将1或到第i位置上
            }
        }
        return ans;
    }

    //用hash表实现，用于对数器实现
    public static int test(int[] arr, int k, int m) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int num : map.keySet()) {
            if (map.get(num) == k) {
                return num;
            }
        }
        return -1;
    }

    //对数器，生成一个随机的数组
    public static int[] randomArray(int maxKinds, int range, int k, int m) {
        int ktimeNum = randomNumber(range);
        //2种以上的数
        int numKinds = (int) (Math.random() * maxKinds + 2);
        //k*1+(numKinds-1)*m
        int[] arr = new int[k + (numKinds - 1) * m];

        int index = 0;
        for (; index < k; index++) {
            arr[index] = ktimeNum;
        }
        numKinds--;

        HashSet<Integer> set = new HashSet<>();
        set.add(ktimeNum);
        while (numKinds != 0) {
            int curNum = 0;
            do {
                curNum = randomNumber(range);
            } while (set.contains(curNum));
            set.add(curNum);
            numKinds--;
            for (int i = 0; i < m; i++) {
                arr[index++] = curNum;
            }
        }
        // arr 填好了

        //打乱arr中的数字的顺序
        for (int i = 0; i < arr.length; i++) {
            //i位置的数，我想随机和J位置的数做交换
            int j = (int) (Math.random() * arr.length);//0~N-1
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    //生成随机数 [-range,+range]
    public static int randomNumber(int range) {
        return ((int) (Math.random() * range) + 1) - ((int) (Math.random() * range) + 1);
    }

    public static void main(String[] args) {
        int kinds = 10;
        int range = 200;
        int testTimes = 100000;
        int max = 9;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            int a = (int) (Math.random() * max) + 1;//a 1-9
            int b = (int) (Math.random() * max) + 1;//b 1-9
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            //k<m
            if (k == m) {
                m++;
            }
            int[] arr = randomArray(kinds, range, k, m);
            int ans1 = test(arr, k, m);
            int ans2 = solution(arr, k, m);
            if (ans1 != ans2) {
                System.out.println("出错了");
            }
        }
        System.out.println("测试结束");
    }

}
