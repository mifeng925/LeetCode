package top2_10;

public class Day2 {
    public static void main(String[] args) {
        System.out.println(new Day2().maxSubArray(new int[]{1, 2, -1, -7, -8}));
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int temp = 0;
        for (int num : nums) {
            if (temp > 0) {
                temp = temp + num;
            } else {
                temp = num;
            }
            max = Math.max(max, temp);
        }
        return max;
    }
}
