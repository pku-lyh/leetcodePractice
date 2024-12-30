/*Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补全和拼写检查。

请你实现 Trie 类：

Trie() 初始化前缀树对象。
void insert(String word) 向前缀树中插入字符串 word 。
boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。*/
public class LeetCode208 {
    class Trie {
        private Trie[] children;
        private boolean isEnd;
        public Trie() {
             children = new Trie[26];
             isEnd = false;
        }

        public void insert(String word) {
             Trie node = this;
             while (!word.isEmpty()) {
                 if (node.children[word.charAt(0) - 'a'] == null) {
                     node.children[word.charAt(0) - 'a'] = new Trie();
                 }
                 node = node.children[word.charAt(0) - 'a'];
                 word = word.substring(1);
             }
                node.isEnd = true;
        }

        public boolean search(String word) {
             Trie node = this;
             while (!word.isEmpty()) {
                  if (node.children[word.charAt(0) - 'a'] == null) {
                       return false;
                  }
                  node = node.children[word.charAt(0) - 'a'];
                  word = word.substring(1);
             }
             if (!node.isEnd) {
                  return false;
             }
             return true;
        }

        public boolean startsWith(String prefix) {
             Trie node = this;
             while (!prefix.isEmpty()) {
                  if (node.children[prefix.charAt(0) - 'a'] == null) {
                       return false;
                  }
                  node = node.children[prefix.charAt(0) - 'a'];
                  prefix = prefix.substring(1);
             }
             return true;
        }
    }
}
