/*给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。

 */
public class LeetCode338 {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            ans[i] = ans[i / 2] + i % 2;
        }
        return ans;
    }
}
