package top1_10;

import java.util.Arrays;

public class Top4 {


    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] nums, int i, int index) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }

    public static void main(String[] args) {
        int[] x = new int[]{0, 1, 0, 3, 12};


        new Top4().moveZeroes(x);

        System.out.println(Arrays.toString(x));
    }


}
