package CodingPrep;

import java.util.HashMap;

public class LongestSubstringOfKDistinctCharacters {
    public static void main(String[] args) {
        String str = "aabacbebebe";
        int distinctCharacters = 3;
        longestSubarray(str, distinctCharacters);
    }

    private static void longestSubarray(String str, int distinctCharacters) {

        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();

        while (j < str.length()) {
            map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);
            if (map.size() < distinctCharacters) {
                j++;
            } else if (map.size() == distinctCharacters) {
                max = Math.max(max, (j - i + 1));
                j++;
            } else {
                while (map.size() > distinctCharacters) {
                    map.put(str.charAt(i), map.get(str.charAt(i)) - 1);
                    if (map.get(str.charAt(i)) == 0)
                        map.remove(str.charAt(i));
                    i++;
                }
                j++;
            }
        }
        System.out.println(max);
    }
}
