/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 5:18 下午 2022/6/9
 **/


package org.example.binarysearch;

/**
 * 切木头 给一个数组，数组中的元素代表木头长度，然后对该数组中的木头进行切，切的长度最后要满足切后的木头数量大于k
 * 例如 L=[232,124,456]
 * k=7
 * 如果切的长度为100的话，则232/100 =2 124/100=1 456/100=4  2+1+4=7,则100是满足长度的，那么101是不是可以呢？102呢？求最长的这个数
 */
public class WoodCut {

    public static void main(String[] args) {
        WoodCut woodCut = new WoodCut();
        int[] l = {232, 124, 456};
        int k = 7;
        int i = woodCut.woodCut(l, k);
        System.out.println(i);
    }

    public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0) {
            return 0;
        }
        int start = 1;
        int end = getMax(L);
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (getPices(L, mid) == k) {
                return mid;
            }
            if (getPices(L, mid) > k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (getPices(L, start) == k) {
            return start;
        }
        if (getPices(L, end) == k) {
            return end;
        }
        return -1;
    }

    private int getMax(int[] l) {
        int result = 0;
        for (int i = 0; i < l.length; i++) {
            if (l[i] > result) {
                result = l[i];
            }
        }
        return result;
    }


    private int getPices(int[] l, int mid) {
        int result = 0;
        for (int i = 0; i < l.length; i++) {
            result = result + l[i] / mid;
        }
        return result;
    }

}
