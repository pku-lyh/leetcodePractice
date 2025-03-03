/*给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。*/
public class LeetCode136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            // 异或操作，相同的数字抑或会等于0
            ans ^= num;
        }
        return ans;
    }
}
