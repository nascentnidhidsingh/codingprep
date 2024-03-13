package test;

import java.io.*;
import java.util.*;

class Reverse {

    static char[] reverseWords(char[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    
    /*for (int i  = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
    }
    */
        StringBuilder str = new StringBuilder();
        int index = 0;
        for (char c : arr) {

            if (c == ' ' || (arr.length - 1) == index) {
                str = str.reverse();
                char[] a = str.toString().toCharArray(); //N,i,d,h,i
                for (int i = index; i < a.length; i++) {
                    arr[i] = a[i];
                }
                index = index + a.length;
                if ((arr.length - 1) != index) {
                    arr[index] = ' ';
                    index++;
                }
            }
            str = str.append(c);
        }
        return arr;
    }

    public static void main(String[] args) {
        char[] c = {'p', 'e', 'r', 'f', 'e', 'c', 't', ' ','m', 'a', 'k', 'e', 's', ' ','p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};
        char[] output = reverseWords(c);

        for (int i  = 0; i < output.length; i++) {
            System.out.print(output[i]);
        }
    }

}
/*

I/P = {My name is Nidhi} , {ihdiN si eman yM}
O/P = {Nidhi is name My}
input:  arr = [ 'p', 'e', 'r', 'f', 'e', 'c', 't', '  ',
                'm', 'a', 'k', 'e', 's', '  ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' ]
 

*/