import java.util.ArrayList;
import java.util.List;

/**
 * @author pku-lyh
 * @Description 描述
 * @date 2025/2/18 12:11
 */
public class LeetCode1466 {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] list = new List[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            list[connection[0]].add(new int[]{connection[1], 1});
            list[connection[1]].add(new int[]{connection[0], 0});
        }
        return dfs(list, 0, -1);
    }

    private int dfs(List<int[]>[] list, int index, int pre) {
        int res = 0;
        List<int[]> ints = list[index];
        for (int[] anInt : ints) {
            if (anInt[0] == pre){
                continue;
            }
            res += anInt[1];
            res += dfs(list, anInt[0], index);
        }
        return res;
    }
}
