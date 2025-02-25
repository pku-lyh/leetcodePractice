import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author pku-lyh
 * @Description 给你一个 m x n 的迷宫矩阵 maze （下标从 0 开始），矩阵中有空格子（用 '.' 表示）和墙（用 '+' 表示）。同时给你迷宫的入口 entrance ，用 entrance = [entrancerow, entrancecol] 表示你一开始所在格子的行和列。
 *
 * 每一步操作，你可以往 上，下，左 或者 右 移动一个格子。你不能进入墙所在的格子，你也不能离开迷宫。你的目标是找到离 entrance 最近 的出口。出口 的含义是 maze 边界 上的 空格子。entrance 格子 不算 出口。
 *
 * 请你返回从 entrance 到最近出口的最短路径的 步数 ，如果不存在这样的路径，请你返回 -1 。
 * @date 2025/2/18 15:14
 */
public class LeetCode1926 {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(entrance);
        int[][] visited = new int[maze.length][maze[0].length];
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            if (!(x == entrance[0] && y == entrance[1]) && (x == 0 || x == maze.length - 1 || y == 0 || y == maze[0].length - 1)) {
                return visited[x][y];
            }

            if (maze[x][y] == '+') {
                continue;
            }
            if (x + 1 <= maze.length - 1 && maze[x + 1][y] == '.' && visited[x + 1][y] == 0 && !(x + 1 == entrance[0] && y == entrance[1])) {
                queue.add(new int[]{x + 1, y});
                visited[x + 1][y] = visited[x][y] + 1;
            }
            if (x - 1 >= 0 && maze[x - 1][y] == '.' && visited[x - 1][y] == 0 && !(x - 1 == entrance[0] && y == entrance[1])) {
                queue.add(new int[]{x - 1, y});
                visited[x - 1][y] = visited[x][y] + 1;
            }
            if (y + 1 <= maze[0].length - 1 && maze[x][y + 1] == '.' && visited[x][y + 1] == 0 && !(x == entrance[0] && y + 1 == entrance[1])) {
                queue.add(new int[]{x, y + 1});
                visited[x][y + 1] = visited[x][y] + 1;
            }
            if (y - 1 >= 0 && maze[x][y - 1] == '.' && visited[x][y - 1] == 0 && !(x == entrance[0] && y - 1 == entrance[1])) {
                queue.add(new int[]{x, y - 1});
                visited[x][y - 1] = visited[x][y] + 1;
            }
        }
        return -1;
    }

}
