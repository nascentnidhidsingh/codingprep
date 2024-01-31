package CodingPrep;//Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//
//
//
//        Example 1:
//
//Input: s = "anagram", t = "nagaram"
//Output: true

import java.util.HashMap;
import java.util.Map;

class ValidAnagrams {
    public boolean isAnagram(String s, String t) {
        //Time Complexity - O(n)
        //Space Complexity - O(n)

        HashMap<Character,Integer> map = new HashMap<>();

        for (char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch,0)+1);

        for (char ch : t.toCharArray())
            map.put(ch, map.getOrDefault(ch,0)-1);


        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0)
                return false;
        }
        return true;
    }
}