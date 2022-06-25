/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 9:35 上午 2022/6/20
 **/


package actualcombat.dfs;

import java.util.ArrayList;
import java.util.List;

public class Permutations2 {

    public List<List<Integer>> solutions2(int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        if (array == null) {
            return result;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        result.add(temp);
        dfs2(result, temp, array, 0);
        return result;
    }

    private void dfs2(List<List<Integer>> result, List<Integer> temp, int[] array, int pos) {
        if (pos > array.length) {
            return;
        }
        for (int i = pos; i < array.length; i++) {
            temp.add(array[i]);
            result.add(new ArrayList<>(temp));
            dfs2(result, temp, array, ++pos);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> solutions(int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        if (array == null) {
            return result;
        }
        if (array.length == 0) {
            result.add(new ArrayList<>());
        }
        List<Integer> temp = new ArrayList<>();
        dfs(result, temp, array);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> temp, int[] array) {
        if (temp.size() == array.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (temp.contains(array[i])) {
                continue;
            }
            temp.add(array[i]);
            dfs(result, temp, array);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations2 permutations2 = new Permutations2();
        int[] array = {1, 2, 3};
        List<List<Integer>> solutions = permutations2.solutions2(array);
        for (int i = 0; i < solutions.size(); i++) {
            System.out.println(solutions.get(i));
        }
    }
}
