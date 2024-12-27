/*对于字符串 s 和 t，只有在 s = t + t + t + ... + t + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。

给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。*/

//结论：如果两个字符串能被一个字符串同时整除，那么该字符串长度就是他们的最大公因数
public class LeetCode1071 {
    public String gcdOfStrings(String str1, String str2) {
        if (!str1.concat(str2).equals(str2.concat(str1))) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    public int gcd(int i, int j) {
        int remind = i % j;
        while (remind != 0) {
            i = j;
            j = remind;
            remind = i % j;
        }
        return j;
    }
}
