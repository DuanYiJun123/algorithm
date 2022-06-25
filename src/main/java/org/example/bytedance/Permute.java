/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:34 上午 2022/6/22
 **/


package org.example.bytedance;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    public List<List<Integer>> permute(int[] array) {
        List<List<Integer>> reuslt = new ArrayList<>();
        if (array == null) {
            return reuslt;
        }
        List<Integer> temp = new ArrayList<>();
        dfs(reuslt, temp, array);
        return reuslt;
    }

    private void dfs(List<List<Integer>> reuslt, List<Integer> temp, int[] array) {
        if (temp.size() == array.length) {
            reuslt.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (temp.contains(array[i])) {
                continue;
            }
            temp.add(array[i]);
            dfs(reuslt, temp, array);
            temp.remove(temp.size() - 1);
        }
    }

}
