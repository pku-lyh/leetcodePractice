/*按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。

n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。

每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode51 {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    Map<Integer, Integer> column = new HashMap<>();
    Map<Integer, Integer> diagonal = new HashMap<>();
    Map<Integer, Integer> antiDiagonal = new HashMap<>();

    public List<List<String>> solveNQueens(int n) {
        String[] s = new String[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.setLength(0);
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            s[i] = sb.toString();
        }
        backTrack(n, 0, s);
        return res;
    }

    private void backTrack(int n, int row, String[] s) {
        if (row == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (column.containsKey(i) || diagonal.containsKey(row + i) || antiDiagonal.containsKey(row - i)) {
                continue;
            }
            path.add(s[i]);
            column.put(i, 1);
            diagonal.put(row + i, 1);
            antiDiagonal.put(row - i, 1);
            backTrack(n, row + 1, s);
            path.remove(path.size() - 1);
            column.remove(i);
            diagonal.remove(row + i);
            antiDiagonal.remove(row - i);
        }
    }
}
