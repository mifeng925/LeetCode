package top1_10;

import java.util.HashSet;
import java.util.Set;

public class Top3 {

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int size = 0;
        for (Integer i : set) {
            if (!set.contains(i - 1)) {
                int total = 1;
                int current = i;
                while (set.contains(current + 1)) {
                    total = total + 1;
                    current = current + 1;
                }
                size = Math.max(size, total);
            }
        }
        return size;
    }
}
