import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*给你一个整数数组 arr，如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 */
public class LeetCode1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        Map<Integer, Integer> map1 = new HashMap<>();
        Set<Integer> hashSet = new HashSet<>();
        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            hashSet.add(x.getValue());
        }
        return map.size() == hashSet.size();
    }
}
