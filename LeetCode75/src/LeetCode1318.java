/*给你三个正整数 a、b 和 c。

你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算   a OR b == c  成立的最小翻转次数。

「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。*/
public class LeetCode1318 {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;
            if (bitC == 0){
                ans += (bitA + bitB);
            }else {
                if (bitA + bitB == 0){
                    ans++;
                }
            }
        }
        return ans;
    }
}
