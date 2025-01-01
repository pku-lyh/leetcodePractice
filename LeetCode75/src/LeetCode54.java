import java.util.ArrayList;
import java.util.List;

/*给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。*/
public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] direction = new int[]{0, 1, 0, -1, 0};
        int i = 0, j = 0, k = 0;
        while (res.size() < m * n) {
            res.add(matrix[i][j]);
            visited[i][j] = true;
            if (!(i + direction[k] >= 0 && i + direction[k] < m && j + direction[k + 1] >= 0
                    && j + direction[k + 1] < n && !visited[i + direction[k]][j + direction[k + 1]])) {
                k = (k + 1) % 4;
            }
            i += direction[k];
            j += direction[k + 1];
        }
        return res;
    }
}
