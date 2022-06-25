/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 8:35 下午 2022/6/24
 **/


package org.example.bytedance.week1;

import java.util.ArrayList;
import java.util.Arrays;
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
        if (intervals == null) {
            return null;
        }
        List<Info> result = new ArrayList<>();
        List<Info> array = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            array.add(new Info(intervals[i][0], intervals[i][1]));
        }
        array.sort(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.left - o2.left;
            }
        });
        int end = array.get(0).right;
        int start = array.get(0).left;
        for (int i = 1; i <= array.size(); i++) {
            Info current = array.get(i - 1);
            if (current.left <= end) {
                end = Math.max(current.right, end);
            } else {
                result.add(new Info(start, end));
                end = current.right;
                start = current.left;

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
        int[][] intervals = {{1, 3}, {4, 6}, {2, 4}, {7, 9}, {5, 8}};
        MergeInterval mergeInterval = new MergeInterval();
        int[][] merge = mergeInterval.merge(intervals);
        System.out.println("");
    }
}
