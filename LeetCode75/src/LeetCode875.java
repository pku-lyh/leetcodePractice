/*珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。

珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。

珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。

返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。*/
public class LeetCode875 {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 0;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }
        int ans = 0;
        while (min < max){
            int mid = (min + max)/2;
            int sum = 0;
            for (int pile : piles) {
                sum += (pile - 1) /mid +1;
            }
            if (sum >= h){
                min = mid + 1;
                ans = mid;
            }else {
                max = mid;
            }
        }
        return ans;
    }
}
