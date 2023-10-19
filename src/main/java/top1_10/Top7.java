package top1_10;


public class Top7 {


    public static void main(String[] args) {
        System.out.println(new Top7().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {
        int[] let = new int[height.length];
        int[] right = new int[height.length];
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i]);
            let[i] = max;
        }
        max = height[height.length - 1];
        for (int i = height.length - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            right[i] = max;
        }
        int count = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] == let[i] || height[i] == right[i]) {
                continue;
            }
            if (let[i] > right[i]) {
                count += right[i] - height[i];
            } else {
                count += let[i] - height[i];
            }
        }
        return count;
    }


}
