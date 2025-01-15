/**
 * @author pku-lyh
 * @Description 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @date 2025/1/15 8:59
 */
public class LeetCode70 {
    public int climbStairs(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }
}
