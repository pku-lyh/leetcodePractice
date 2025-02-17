/**
 * @author pku-lyh
 * @Description 描述
 * @date 2025/2/13 18:16
 */
public class LeetCode1456 {
    public int maxVowels(String s, int k) {
        int sum = 0;
        int n = s.length();
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))){
                sum++;
            }
        }
        int ans = sum;
        for (int i = k; i < n; i++) {
            if (isVowel(s.charAt(i))){
                sum++;
            }
            if (isVowel(s.charAt(i-k))){
                sum--;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    private boolean isVowel(char c){
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
