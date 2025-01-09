/*给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。*/
public class LeetCode79 {
    boolean ans = false;

    public boolean exist(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    backTrack(board, i, j, 0, word, vis);
                    if (ans) {
                        return ans;
                    }
                }
            }
        }
        return ans;
    }

    private void backTrack(char[][] board, int i, int j, int index, String word, boolean[][] vis) {
        if (index == word.length()) {
            ans = true;
            return;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || vis[i][j] || board[i][j]!=word.charAt(index)) {
            return;
        }
        vis[i][j] = true;
        backTrack(board, i-1, j, index+1,word, vis);
        backTrack(board, i+1, j, index+1,word, vis);
        backTrack(board, i, j-1, index+1,word, vis);
        backTrack(board, i, j+1, index+1,word, vis);
        vis[i][j] = false;
    }
}
