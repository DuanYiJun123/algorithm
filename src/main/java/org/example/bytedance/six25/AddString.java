/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 9:41 下午 2022/6/25
 **/


package org.example.bytedance.six25;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * <p>
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 * <p>
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 * <p>
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddString {

    public String addStrings(String num1, String num2) {
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            Integer num1Add = Integer.valueOf(String.valueOf(num1.charAt(i)));
            Integer num2Add = Integer.valueOf(String.valueOf(num2.charAt(j)));
            int result = (num1Add + num2Add + carry) % 10;
            carry = (num1Add + num2Add + carry) / 10;
            sb.append(result);
            i--;
            j--;
        }
        while (i >= 0) {
            Integer num1Add = Integer.valueOf(String.valueOf(num1.charAt(i)));
            int result = (num1Add + carry) % 10;
            carry = (num1Add + carry) / 10;
            sb.append(result);
            i--;
        }

        while (j >= 0) {
            Integer num2Add = Integer.valueOf(String.valueOf(num2.charAt(j)));
            int result = (num2Add + carry) % 10;
            carry = (num2Add + carry) / 10;
            sb.append(result);
            j--;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddString addString = new AddString();
        String s = addString.addStrings("456", "77");
        System.out.println(s);
    }
}
