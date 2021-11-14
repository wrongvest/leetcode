package com.wrongme.daily.w20211112;

/**
 * 208. 实现 Trie (前缀树)
 */
public class Trie2 {
    class TrieNode {
        boolean end;
        TrieNode[] tns = new TrieNode[26];
    }

    TrieNode root;

    public Trie2() {
        root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode p = root;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) {
                p.tns[u] = new TrieNode();
            }
            p = p.tns[u];
        }
        p.end = true;
    }

    public boolean search(String s) {
        TrieNode p = root;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) {
                return false;
            }
            p = p.tns[u];
        }
        return p.end;
    }

    public boolean startsWith(String s) {
        TrieNode p = root;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) {
                return false;
            }
            p = p.tns[u];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie2 trie = new Trie2();
        trie.insert("apple");
        trie.insert("apply");
        trie.insert("ear");
        trie.insert("bear");

//        trie.search("are");
        System.out.println(trie.search("app"));
//        trie.printf(trie);
        System.out.println(trie.startsWith("app"));
    }

}
