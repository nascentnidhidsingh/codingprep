package CodingPrep;// Substrings of Size Three with Distinct Characters
//        Solved
//        Easy
//        Topics
//        Companies
//        Hint
//        A string is good if there are no repeated characters.
//
//        Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.
//
//        Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
//
//        A substring is a contiguous sequence of characters in a string.
//
//
//
//        Example 1:
//
//        Input: s = "xyzzaz"
//        Output: 1
//        Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
//        The only good substring of length 3 is "xyz".

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CountGoodSubstring {
    public static int countGoodSubstrings(String s) {

        int count = 0;
        List<Character> list = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (j < s.length()) {
            list.add(s.charAt(j));

            if ((j - i + 1) < 3) {
                j++;
            } else if ((j - i + 1) == 3) {
                //System.out.println("List : " + list);
                Set<Character> set = new HashSet<>(list);
                //System.out.println("Set : " + set);
                if (set.size() == 3) {
                    count++;
                }
                list.removeFirst();
                i++;
                j++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        String s = "xyzzaz";
        int result = countGoodSubstrings(s);
        System.out.println(result);
    }
}