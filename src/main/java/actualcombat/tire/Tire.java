/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 1:59 下午 2022/6/19
 **/


package actualcombat.tire;

import java.util.HashMap;
import java.util.Map;

public class Tire {

    public static void main(String[] args) {
        Tire tire=new Tire();
        tire.insert("apple");
        System.out.println( tire.search("app"));
        System.out.println(tire.startWith("app"));
    }

    private Node root = new Node();

    public static class Node {
        char val;
        Map<Character, Node> children = new HashMap<>();
        boolean hasWord = false;

        public Node(char val) {
            this.val = val;
        }

        public Node() {
        }
    }

    public Tire() {

    }

    public void insert(String word) {
        Map<Character, Node> children = root.children;
        Node current = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!children.containsKey(chars[i])) {
                Node newNode = new Node(chars[i]);
                children.put(chars[i], newNode);
                current = newNode;
                children = current.children;
            } else {
                current = children.get(chars[i]);
                current.children = children;
            }
            if (i == chars.length - 1) {
                current.hasWord = true;
            }
        }
    }

    public boolean search(String word) {
        Node current = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Map<Character, Node> children = current.children;
            if (children.containsKey(chars[i])) {
                current = children.get(chars[i]);
            } else {
                return false;
            }
            if (i == chars.length - 1) {
                return current.hasWord;
            }
        }
        return false;
    }


    public boolean startWith(String prefix) {
        Node current = root;
        char[] chars = prefix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Map<Character, Node> children = current.children;
            if (children.containsKey(chars[i])) {
                current = children.get(chars[i]);
            } else {
                return false;
            }

        }
        return true;
    }
}
