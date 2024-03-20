package Graph;

/*
Given are the two distinct words startWord and targetWord, and a list denoting wordList of unique words of equal lengths. Find the length of the shortest transformation sequence from startWord to targetWord.

In this problem statement, we need to keep the following conditions in mind:

A word can only consist of lowercase characters.
Only one letter can be changed in each transformation.
Each transformed word must exist in the wordList including the targetWord.
startWord may or may not be part of the wordList
Note:  If there’s no possible way to transform the sequence from startWord to targetWord return 0.

Example 1:

Input:
wordList = {"des","der","dfr","dgt","dfs"}
startWord = "der", targetWord = "dfs"
Output:
3
Explanation:
The length of the smallest transformation sequence from "der" to
"dfs" is 3 i.e. "der" -> (replace ‘e’ by ‘f’) -> "dfr" -> (replace ‘r’ by ‘s’)  -> "dfs". So, it takes 3 different strings for us to reach the targetWord. Each of these strings are present in the wordList.
*/

import java.util.*;

public class WordLadderI {
    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {
                "des",
                "der",
                "dfr",
                "dgt",
                "dfs"
        };

        WordLadderI obj = new WordLadderI();
        int ans = obj.wordLadderLength(startWord, targetWord, wordList);
        System.out.print(ans);
        System.out.println();
    }

    private int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        Set<String> set = new HashSet<>(Arrays.asList(wordList));
        Queue<Pairs> q = new LinkedList<>();
        q.add(new Pairs(startWord, 1));
        set.remove(startWord);

        while (!q.isEmpty()) {
            String currentWord = q.peek().startword;
            int steps = q.peek().steps;
            q.remove();
            if (currentWord.equals(targetWord)) {
                return steps;
            }
            for (int i = 0; i < currentWord.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char[] replacedWordCharArray = currentWord.toCharArray();
                    replacedWordCharArray[i] = c;
                    String replacedWord = new String(replacedWordCharArray);
                    if (set.contains(replacedWord)) {
                        q.add(new Pairs(replacedWord, steps + 1));
                        set.remove(replacedWord);
                    }
                }
            }
        }
        return 0;
    }
}
