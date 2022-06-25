/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 5:42 下午 2022/6/22
 **/


package org.example.bytedance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/SsGoHC
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeInterval {

    public static class Info {
        int left;
        int right;

        public Info(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        //先按照第一个元素进行排序
        List<Info> array = new ArrayList<>(intervals.length);
        for (int i = 0; i < intervals.length; i++) {
            array.add(new Info(intervals[i][0], intervals[i][1]));
        }
        array.sort(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.left - o2.left;
            }
        });

        List<Info> result = new ArrayList<>();
        int start = array.get(0).left;
        int end = array.get(0).right;
        for (int i = 1; i <= array.size(); i++) {
            Info current = array.get(i - 1);
            if (current.left <= end) {
                end = Math.max(current.right, end);
            } else {
                Info info = new Info(start, end);
                result.add(info);
                start = current.left;
                end = current.right;
            }
        }
        result.add(new Info(start, end));
        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            res[i][0] = result.get(i).left;
            res[i][1] = result.get(i).right;
        }
        return res;
    }

    public static void main(String[] args) {
        MergeInterval mergeInterval = new MergeInterval();
        //int[][] array = {{1, 3}, {4, 6}, {2, 4}, {7, 9}, {5, 8}};
        //int[][] array = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals = {{1, 3}, {4, 6}, {2, 4}, {7, 9}, {5, 8}};
        int[][] merge = mergeInterval.merge(intervals);
        for (int i = 0; i < merge.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(merge[i][j]);
            }
        }
    }
}
