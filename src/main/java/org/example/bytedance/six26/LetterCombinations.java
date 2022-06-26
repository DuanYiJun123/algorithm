/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 10:27 下午 2022/6/26
 **/


package org.example.bytedance.six26;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0 || digits.equals("1")) {
            return result;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2' , "abc");
        map.put('3' , "def");
        map.put('4' , "ghi");
        map.put('5' , "jkl");
        map.put('6' , "mno");
        map.put('7' , "pqrs");
        map.put('8' , "tuv");
        map.put('9' , "wxyz");

        backtrack(result, map, digits, 0, new StringBuffer());
        return result;
    }

    private void backtrack(List<String> result, Map<Character, String> map, String digits, int index, StringBuffer stringBuffer) {
        if (index == digits.length()) {
            result.add(stringBuffer.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = map.get(digit);
            int length = letters.length();
            for (int i = 0; i < length; i++) {
                stringBuffer.append(letters.charAt(i));
                backtrack(result, map, digits, index + 1, stringBuffer);
                stringBuffer.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> strings = letterCombinations.letterCombinations("23");
        for (String str : strings) {
            System.out.println(str);
        }
    }
}
