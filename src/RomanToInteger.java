//Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
//        Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
//For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
//
//Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
//
//I can be placed before V (5) and X (10) to make 4 and 9.
//X can be placed before L (50) and C (100) to make 40 and 90.
//C can be placed before D (500) and M (1000) to make 400 and 900.
//Given a roman numeral, convert it to an integer.
//
//
//
//Example 1:
//
//Input: s = "III"
//Output: 3
//Explanation: III = 3.

class Solution {
    public int romanToInt(String s) {

//Time Complexity-O(N)
//Space Complexity-O(1)
        //    int roman = 0;

        //    char[] ch = s.toCharArray();

        //    for (int i=0; i < ch.length; i++) {
        //        if(ch[i]=='I') {
        //            if(i+1 < ch.length && ch[i+1]=='V'){
        //                roman = roman+4;
        //                i++;
        //            }
        //            else if (i+1 < ch.length && ch[i+1]=='X'){
        //                roman = roman+9;
        //                i++;
        //            }else
        //            roman = roman+1;
        //        }
        //        else if(ch[i]=='X') {
        //            if(i+1 < ch.length && ch[i+1]=='L'){
        //                roman = roman+40;
        //                i++;
        //            }
        //            else if (i+1 < ch.length && ch[i+1]=='C'){
        //                roman = roman+90;
        //                i++;
        //            }else
        //            roman = roman+10;
        //        }
        //        else if(ch[i]=='C') {
        //            if(i+1 < ch.length && ch[i+1]=='D'){
        //                roman = roman+400;
        //                i++;
        //            }
        //            else if (i+1 < ch.length && ch[i+1]=='M'){
        //                roman = roman+900;
        //                i++;
        //            }else
        //            roman = roman+100;
        //        } else if (ch[i]=='V')
        //           roman = roman+5;
        //           else if (ch[i]=='L')
        //           roman = roman+50;
        //           else if (ch[i]=='D')
        //           roman = roman+500;
        //           else if (ch[i]=='M')
        //           roman = roman+1000;
        //    }
        //    return roman;

        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int result=0;

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1)))
                result-= map.get(s.charAt(i));
            else
                result+= map.get(s.charAt(i));

        }
        return result;
    }
}