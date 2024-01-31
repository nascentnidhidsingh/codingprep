package CodingPrep;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "aabacbebebe";
        int max = longestSubstring(str);
        System.out.println(max);
    }

    private static int longestSubstring(String s) {
        int i = 0;
        int j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if (map.size() == j - i + 1) {
                max = Math.max(max, map.size());
                j++;
            } else if (map.size() < (j - i + 1)) {
                while (map.size() < (j - i + 1)) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if (map.get(s.charAt(i)) == 0)
                        map.remove(s.charAt(i));
                    i++;
                }
                j++;
            }
        }
        return max;
    }
}
