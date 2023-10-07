package top1_10;

import java.util.HashMap;

class _1Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];
            if (map.containsKey(c)) {
                return new int[]{i, map.get(c)};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
