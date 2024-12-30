import java.util.Arrays;

/*给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。

注意 只在一点上接触的区间是 不重叠的。例如 [1, 2] 和 [2, 3] 是不重叠的。*/
public class LeetCode435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int ans = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end){
                ans++;
                end = intervals[i][1];
            }
        }
        return intervals.length - ans;
    }
}
