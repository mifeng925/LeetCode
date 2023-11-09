package top2_10;

import java.util.Arrays;
import java.util.Comparator;

public class Day3 {
    public static void main(String[] args) {
        for (int[] ints : new Day3().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[][] result = new int[intervals.length][2];
        int index = 0;
        result[0] = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int oL = result[index][0];
            int oR = result[index][1];

            int cL = intervals[i][0];
            int cR = intervals[i][1];

            if (oL <= cL && oR >= cL) {
                if (cR > oR) {
                    result[index][1] = cR;
                }
            } else {
                index++;
                result[index][0] = cL;
                result[index][1] = cR;
            }

        }

        return Arrays.copyOf(result, index + 1);
    }

}
