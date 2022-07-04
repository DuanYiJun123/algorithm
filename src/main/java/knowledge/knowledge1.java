/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 4:15 下午 2022/7/1
 **/


package knowledge;

/**
 * new String ("hello")一共创建了几个对象
 */
public class knowledge1 {

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = "he" + "llo";
        String s4 = "hel" + new String("lo");
        String s5 = new String("hello");
        String s6 = s5.intern();
        String s7 = "h";
        String s8 = "ello";
        String s9 = s7 + s8;

        System.out.println(s1 == s2); //都是常量池
        System.out.println(s1 == s3); //s3编译时候自动合并
        System.out.println(s1 == s4); //s4是两个对象的相加，相加的对象在堆中，
        System.out.println(s1 == s9);
        System.out.println(s4 == s5); //s5和s4都是在堆中
        System.out.println(s1 == s6);
    }
}
