/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 8:00 下午 2022/6/18
 **/


package actualcombat.dp;

/**
 * 数组，不能连续相加，求数组中的最大和
 * 例如 input [1，2，3，1] output 1+3=4
 * input [2,7,9,3,1] output 2+9+1=12
 */
public class HouseRobber {

    public int solution(int[] array) {
        int[] result = new int[array.length];
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        if (array.length == 2) {
            return Math.max(array[0], array[1]);
        }
        result[0] = array[0];
        result[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            result[i] = Math.max(result[i - 2] + array[i], result[i]);
        }
        return result[array.length - 1];
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        int[] array = {1,2,3,1};
        System.out.println(houseRobber.solution(array));
    }
}
