import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author pku-lyh
 * @Description 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * @date 2025/1/7 11:15
 */
public class LeetCode994 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = {0, 1, 0, -1, 0};
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> depth = new HashMap<>();
        int res = 0;
        // 腐烂橘子入队
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(i * n + j);
                    depth.put(i * n + j, 0);
                }
            }
        }
        while (!queue.isEmpty()){
            int num = queue.poll();
            int i = num / n;
            int j = num % n;
            for (int k = 0; k < 4; k++) {
                if (i + dx[k] >= 0 && i + dx[k] < m && j + dx[k + 1] >= 0 && j + dx[k + 1] < n && grid[i + dx[k]][j + dx[k + 1]] == 1) {
                    grid[i + dx[k]][j + dx[k + 1]] = 2;
                    queue.offer((i + dx[k]) * n + (j + dx[k + 1]));
                    depth.put((i + dx[k]) * n + (j + dx[k + 1]), depth.get(num) + 1);
                    res = Math.max(res, depth.get((i + dx[k]) * n + (j + dx[k + 1])));
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return res;
    }
}
