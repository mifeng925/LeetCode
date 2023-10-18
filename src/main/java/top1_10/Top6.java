package top1_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Top6 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ret = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            if (first > 0)//当前位置 向右找 l..r范围内 因为当前nums是有序的 所以nums[i]>0 nums[l] nums[r]必大于0 所以[和]肯定无解
                break;
            if (i != 0 && first == nums[i - 1])//连续相同的i 找到的结果肯定相同 所以要去重
                continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (l != i + 1 && nums[l] == nums[l - 1]) {//连续相同的l 找到的结果肯定相同 所以要去重
                    l++;
                    continue;
                }

                if (r != nums.length - 1 && nums[r] == nums[r + 1]) {//连续相同的r 找到的结果肯定相同 所以要去重
                    r--;
                    continue;
                }

                if (first + nums[l] + nums[r] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(first);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    ret.add(list);
                    //找到后 两端指针都要移动
                    l++;
                    r--;
                } else if (first + nums[l] + nums[r] > 0) {
                    r--;//因为是有序的 所以 【和】大的话，大端就要缩小
                } else {
                    l++;//因为是有序的 所以 【和】小的话，小端就要扩大
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Top6().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
