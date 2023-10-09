package top1_10;

import java.util.*;

public class Top2 {


    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String string = Arrays.toString(array);
            List<String> strings = map.get(string);
            if (strings == null) {
                ArrayList<String> da = new ArrayList<>();
                da.add(str);
                map.put(string, da);
            } else {
                strings.add(str);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {


        System.out.println(new Top2().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
