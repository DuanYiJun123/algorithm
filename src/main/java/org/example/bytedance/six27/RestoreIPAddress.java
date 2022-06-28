/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 2:45 下午 2022/6/27
 **/


package org.example.bytedance.six27;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * <p>
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RestoreIPAddress {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        List<String> path = new ArrayList<>();
        dfs(result, path, s, s.length(), 0);
        return result;
    }

    private void dfs(List<String> result, List<String> path, String s, int remainlength, int index) {
        if (path.size() == 4 && remainlength == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i));
                if (i != 3) {
                    sb.append(".");
                }
            }
            result.add(sb.toString());
        }

        if (remainlength < 4 - path.size() || remainlength > (4 - path.size()) * 3) {
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (index + i + 1 > s.length()) {
                break;
            }
            String c = s.substring(index, index + i + 1);
            Integer num = Integer.valueOf(c);
            if ((num >= 1 && num <= 255) || num == 0 && i == 0) {
                path.add(c);
                dfs(result, path, s, remainlength - i - 1, index + i + 1);
                path.remove(path.size() - 1);
            }
            if (num == 0 && i == 0) {
                continue;
            }
        }
    }

    public static void main(String[] args) {
        RestoreIPAddress restoreIPAddress = new RestoreIPAddress();
        String str = "25525511135";
        List<String> strings = restoreIPAddress.restoreIpAddresses(str);
        for (String str1 : strings) {
            System.out.println(str1);
        }
    }
}
