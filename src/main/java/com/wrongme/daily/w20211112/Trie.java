package com.wrongme.daily.w20211112;

/**
 * 208. 实现 Trie (前缀树)
 */
public class Trie {
    int N = 14;
    // 用二维数组来存储我们所有的单词
    int[][] trie;
    // 自增记录我们到底用了多少个格子（相当于给被用到格子进行编号）
    int index;
    // 记录某个格子被「被标记为结尾的次数」（当 idx 编号的格子被标记了 n 次，则有 cnt[idx] = n）
    int count[];

    public Trie() {
        trie = new int[N][26];
        count = new int[N];
        index = 0;
    }

    public void insert(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0) {
                trie[p][u] = ++index;
            }
            p = trie[p][u];
        }
        count[p]++;
    }

    public boolean search(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0) {
                return false;
            }
            p = trie[p][u];
        }
        return count[p] != 0;
    }

    public boolean startsWith(String prefix) {
        int p = 0;
        for (int i = 0; i < prefix.length(); i++) {
            int u = prefix.charAt(i) - 'a';
            if (trie[p][u] == 0) {
                return false;
            }
            p = trie[p][u];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("apply");
        trie.insert("ear");
        trie.insert("bear");

//        trie.search("are");
        System.out.println(trie.search("app"));
//        trie.printf(trie);
        System.out.println(trie.startsWith("app"));
    }

    void printf(Trie trie) {
        System.out.println("A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z");
        for (int i = 0; i < trie.trie.length; i++) {
            for (int j = 0; j < trie.trie[0].length; j++) {
                System.out.print(trie.trie[i][j] + "  ");
            }
            System.out.println();
        }
//        System.out.println("=================================");
    }
}
