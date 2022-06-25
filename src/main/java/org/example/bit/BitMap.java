/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 4:53 下午 2022/6/14
 **/


package org.example.bit;

/**
 * 位图的实现。位图可以使存储空间大大压缩
 */
public class BitMap {

    public static class BitMapNode {
        //一个long型的数有64位，即可以表示0——63个数
        private long[] bits;

        // >>6 右移6位相当于 除以 64
        public BitMapNode(int max) {
            bits = new long[(max + 64) >> 6];
        }

        //&63的操作和 %64 的结果是一样的
        public void add(int num) {
            bits[num >> 6] = bits[num >> 6] | (1L << (num & 63));
        }

        public void delete(int num) {
            bits[num >> 6] = bits[num >> 6] & ~(1L << (num & 63));
        }

        public boolean contains(int num) {
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }
    }

    public static void main(String[] args) {
        BitMapNode bitMapNode = new BitMapNode(1024);
        bitMapNode.add(170);
        System.out.println(bitMapNode.contains(170));
    }
}
