import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。*/
public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= right) {
                right = Math.max(right, intervals[i][1]);
            } else {
                res.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        res.add(new int[]{left, right});
        return res.toArray(new int[0][0]);
    }
}
