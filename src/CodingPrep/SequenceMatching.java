package CodingPrep;

public class SequenceMatching {
    public static void main(String[] args) {
        String s = "ABC";
        String t = "WAFGBHYCG";

        int m = s.length();
        int n = t.length();
        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            char sCurrent = s.charAt(i);
            char tCurrent = t.charAt(j);
            if (sCurrent == tCurrent) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        boolean result = (i == m);
        System.out.println(result);
    }
}
