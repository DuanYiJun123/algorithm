/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 2:41 下午 2022/6/9
 **/


package org.example.binarysearch;

/**
 * 二分法查找的模板（二分法查找一定是一个有序的数组）
 */
public class Template {

    public int getIndex(int[] num, int target) {
        if (num == null || num.length == 0) {
            return -1;
        }
        int start = 0;
        int end = num.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] == target) {
                return mid;
            }
            if (num[mid] > target) {
                end = mid;
            }
            if (num[mid] < target) {
                start = mid;
            }
        }
        if (num[start] == target) {
            return start;
        }
        if (num[end] == target) {
            return end;
        }
        return -1;
    }

    public static void main(String[] args) {
        Template template = new Template();
        int[] num = {1};
        int target = 1;
        int index = template.getIndex(num, target);
        System.out.println(index);
    }

}
