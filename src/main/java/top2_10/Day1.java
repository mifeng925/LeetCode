package top2_10;

import java.util.Arrays;
import java.util.LinkedList;

public class Day1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Day1().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
//        System.out.println(Arrays.toString(new Day1().maxSlidingWindow(new int[]{1}, 1)));
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
//        if (nums.length <= k) {
//            return nums;
//        }
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i + k > nums.length) {
                continue;
            }
            int max = nums[i];
            for (int j = 0; j < k; j++) {
                max = Math.max(max, nums[i + j]);
            }
//            int max = Math.max(Math.max(nums[i], nums[i + 1]), nums[i + 2]);
            result[i] = max;
        }

        return result;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList<>();
        // 结果数组
        int[] result = new int[nums.length - k + 1];
        // 遍历nums数组
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peek()];
            }
        }
        return result;
    }
}
