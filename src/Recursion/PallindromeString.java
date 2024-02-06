package Recursion;

public class PallindromeString {


    public static void main(String[] args) {
        System.out.println(isPallindrome("test", 0));
    }

    private static boolean isPallindrome(String str, int current) {
        if (current >= (str.length()/2))
            return true;
        if (str.charAt(current) != str.charAt(str.length() - current - 1))
            return false;
        return isPallindrome(str, current + 1);
    }
}
