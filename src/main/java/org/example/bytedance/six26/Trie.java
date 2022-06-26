/**
 * @Author yijun.dyj
 * @Description
 * @Date:Created in 6:21 下午 2022/6/26
 **/


package org.example.bytedance.six26;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    Node root;

    Map<Character, Node> children = null;

    public static class Node {
        Character c;
        Map<Character, Node> children = new HashMap<>();
        boolean fundWord = false;

        public Node(Character c) {
            this.c = c;
        }

        public Node() {
        }
    }

    public Trie() {
        root = new Node();
        children = root.children;
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        children = root.children;
        for (int i = 0; i < chars.length; i++) {
            Node node = null;
            if (!children.containsKey(chars[i])) {
                node = new Node(chars[i]);
                children.put(chars[i], node);
                children = node.children;
            } else {
                node = children.get(chars[i]);
                children = node.children;
            }
            if (i == chars.length - 1) {
                node.fundWord = true;
            }
        }
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Node current = null;
        children = root.children;
        if (children.isEmpty()) {
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            if (children.containsKey(chars[i])) {
                Node node = children.get(chars[i]);
                children = node.children;
                current = node;
            } else {
                return false;
            }
        }
        return current.fundWord;
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Node current = null;
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                children = root.children;
            }
            if (children.containsKey(chars[i])) {
                Node node = children.get(chars[i]);
                children = node.children;
                current = node;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        System.out.println(trie.search("hell"));
        System.out.println(trie.search("helloa"));
        System.out.println(trie.search("hello"));

    }
}
