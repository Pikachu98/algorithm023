package Week2;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

            char[] cArr = str.toCharArray();
            Arrays.sort(cArr);
            String sorted_str = new String(cArr);

            if (hashMap.containsKey(sorted_str)) {
                hashMap.get(sorted_str).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                hashMap.put(sorted_str, list);
            }
        }

        List<List<String>> res = new ArrayList<>(hashMap.values());
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> res = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});

        for (List<String> list: res) {
            for(String s: list)
                System.out.println(s + " ");
            System.out.println();
        }
    }
}
