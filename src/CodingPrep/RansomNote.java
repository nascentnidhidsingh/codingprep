package CodingPrep;//Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
//
//Each letter in magazine can only be used once in ransomNote.
//
//
//
//        Example 1:
//
//Input: ransomNote = "a", magazine = "b"
//Output: false

class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {

        // //Time Complexity - O(n)
        // //Space Complexity - O(n)

        // HashMap<Character,Integer> magazineMap = new HashMap<>();

        // for (Character ch : magazine.toCharArray())
        // magazineMap.put(ch, magazineMap.getOrDefault(ch,0)+1);

        // System.out.print(magazineMap);

        // for (Character ch : ransomNote.toCharArray()) {
        //     if (!magazineMap.containsKey(ch)) {
        //         return false;
        //     } else if (magazineMap.containsKey(ch) && magazineMap.get(ch) <= 0) {
        //         return false;
        //     } else {
        //         magazineMap.put(ch, magazineMap.get(ch)-1);
        //     }
        // }
        // return true;

        int array[] = new int[26];
        //Time Complexity - O(n)
        //Space Complexity - O(1)
        for (char ch : magazine.toCharArray()) {
            array[ch - 'a']++;
        }

        for (char ch : ransomNote.toCharArray()) {
            if (array[ch - 'a'] <= 0)
                return false;
            else
                array[ch - 'a']--;
        }
        return true;
    }
}
