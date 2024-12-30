import java.util.ArrayList;
import java.util.List;

/*给你一个产品数组 products 和一个字符串 searchWord ，products  数组中每个产品都是一个字符串。

请你设计一个推荐系统，在依次输入单词 searchWord 的每一个字母后，推荐 products 数组中前缀与 searchWord 相同的最多三个产品。如果前缀相同的可推荐产品超过三个，请按字典序返回最小的三个。

请你以二维列表的形式，返回在输入 searchWord 每个字母后相应的推荐产品的列表。*/
public class LeetCode1268 {
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

        public Trie startsWith(String prefix) {
            Trie node = this;
            while (!prefix.isEmpty()) {
                if (node.children[prefix.charAt(0) - 'a'] == null) {
                    return null;
                }
                node = node.children[prefix.charAt(0) - 'a'];
                prefix = prefix.substring(1);
            }
            return node;
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        Trie root = new Trie();
        for (String product : products) {
            root.insert(product);
        }
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> list = new ArrayList<>();
            StringBuffer stringBuffer = new StringBuffer();
            String prefix = searchWord.substring(0, i + 1);
            stringBuffer.append(prefix);
            Trie node = root.startsWith(prefix);
            if (node != null) {
                backTrack(node, list, stringBuffer);
            }
            ans.add(list);
        }
        return ans;
    }

    private void backTrack(Trie node, List<String> list, StringBuffer stringBuffer) {
        if (list.size() == 3) {
            return;
        }
        if (node.isEnd) {
            list.add(stringBuffer.toString());
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                stringBuffer.append((char) (i + 'a'));
                backTrack(node.children[i], list, stringBuffer);
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
        }
    }
}
