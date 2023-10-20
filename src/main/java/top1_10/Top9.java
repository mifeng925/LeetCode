package top1_10;

import java.util.*;

public class Top9 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] data = new int[26];
        for (char c : p.toCharArray()) {
            data[c - 'a'] += 1;
        }
        int[] t = new int[26];
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            char[] array = s.substring(i, i + p.length()).toCharArray();
            for (char c : array) {
                t[c - 'a'] += 1;
            }
            if (Arrays.equals(t, data)) {
                list.add(i);
            }
            Arrays.fill(t, 0);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Top9().findAnagrams("ababababab", "aab"));
    }

}
