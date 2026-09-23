public class todayleet {
    import java.util.HashMap;
import java.util.Map;
class Solution {
    public int minOperations(int[] nums, int x) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum < x) return -1;
        if (totalSum == x) return nums.length;

        long target = totalSum - x;
        
        Map<Long, Integer> rep_hogya = new HashMap<>();
        rep_hogya.put(0L, -1);

        long currentSum = 0;
        int maxLength = -1;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (rep_hogya.containsKey(currentSum - target)) {
                int previousIndex = rep_hogya.get(currentSum - target);
                maxLength = Math.max(maxLength, i - previousIndex);
            }

            rep_hogya.putIfAbsent(currentSum, i);
        }

        return maxLength == -1 ? -1 : nums.length - maxLength;
    }
} // approach 1
}
