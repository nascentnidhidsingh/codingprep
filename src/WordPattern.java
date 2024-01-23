//Given a pattern and a string s, find if s follows the same pattern.
//
//Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
//
//
//
//Example 1:
//
//Input: pattern = "abba", s = "dog cat cat dog"
//Output: true

import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {

        HashMap<Character, String> map = new HashMap<>();

        String[] ar = s.split(" ");

        if (ar.length != pattern.length())
            return false;

        for (int i = 0; i < pattern.length(); i++) {
            char patternCurr = pattern.charAt(i);
            if (map.containsKey(patternCurr)) {
                if (!map.get(patternCurr).equals(ar[i]))
                    return false;
            } else {
                if (map.containsValue(ar[i]))
                    return false;
                map.put(patternCurr, ar[i]);
            }
        }
        System.out.print(map);
        return true;
    }
}
