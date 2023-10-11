package top1_10;

public class Top5 {

    public static void main(String[] args) {
        System.out.println(new Top5().maxArea(new int[]{2, 3, 4, 5, 18, 17, 6}));
    }

    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            int total = getWater(height, left, right);
            max = Math.max(total, max);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }

    private int getWater(int[] height, int left, int right) {
        int min = Math.min(height[left], height[right]);
        return min * (right - left);
    }

}
