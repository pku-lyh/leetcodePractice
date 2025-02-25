/**
 * @author pku-lyh
 * @Description 描述
 * @date 2025/2/24 21:56
 */
public class LeetCode374 {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (guess(mid) == 0) {
                return mid;
            }
            if (guess(mid) < 0) {
                right = mid - 1; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }

    private int guess(int mid) {
        return 0;
    }
}
