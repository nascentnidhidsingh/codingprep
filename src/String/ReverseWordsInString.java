package String;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String str = "This is a preparation space";
        String[] ar = str.split(" ");
        int start = 0;
        int end = ar.length - 1;

        while (start <= end) {
            String temp = ar[start];
            ar[start] = ar[end];
            ar[end] = temp;
            start++;
            end--;
        }

        StringBuilder s = new StringBuilder();

        for (String current : ar) {
            s.append(current);
            s.append(" ");
        }
        System.out.println(s);
    }
}
