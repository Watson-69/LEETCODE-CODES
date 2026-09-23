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


class Solution {
    public int minOperations(int[] nums, int x) {
        int result = chut_ke_lode(nums, 0, nums.length - 1, x);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int chut_ke_lode(int[] nums, int left, int right, int remainingX) {
        if (remainingX == 0) {
            return 0;
        }
        if (remainingX < 0 || left > right) {
            return Integer.MAX_VALUE;
        }

        int removeLeft = chut_ke_lode(nums, left + 1, right, remainingX - nums[left]);
        if (removeLeft != Integer.MAX_VALUE) {
            removeLeft += 1;
        }

        int removeRight = chut_ke_lode(nums, left, right - 1, remainingX - nums[right]);
        if (removeRight != Integer.MAX_VALUE) {
            removeRight += 1;
        }

        return Math.min(removeLeft, removeRight);
    }
} // a pproach 2 recursion not opitmixaable
}
