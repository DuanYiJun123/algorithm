/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 3:59 下午 2022/6/27
 **/


package org.example.bytedance.six27;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }

        List<Info> result = new ArrayList<>();
        List<Info> list = new ArrayList<>(intervals.length);
        for (int i = 0; i < intervals.length; i++) {
            list.add(new Info(intervals[i][0], intervals[i][1]));
        }
        list.sort(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.left - o2.left;
            }
        });
        int left = list.get(0).left;
        int right = list.get(0).right;
        for (int i = 1; i <= list.size(); i++) {
            Info info = list.get(i - 1);
            if (info.left <= right) {
                right = Math.max(info.right, right);
            } else {
                result.add(new Info(left,right));
                right = info.right;
                left = info.left;
            }
        }
        result.add(new Info(left, right));

        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            res[i][0] = result.get(i).left;
            res[i][1] = result.get(i).right;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        MergeInterval mergeInterval = new MergeInterval();
        int[][] merge = mergeInterval.merge(intervals);
        System.out.println(merge);
    }
}
