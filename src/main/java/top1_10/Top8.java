package top1_10;

import java.util.ArrayList;
import java.util.List;

public class Top8 {

    public static void main(String[] args) {
        System.out.println(new Top8().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        int max = 0;
        List<Character> list = new ArrayList<>();
        for (char c : array) {
            int index = list.indexOf(c);
            if (index >= 0) {
                for (int i = 0; i < index + 1; i++) {
                    list.remove(0);
                }
            }
            list.add(c);
            max = Math.max(max, list.size());
        }
        return max;
    }
}
