import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {

        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        List<Integer> output = new ArrayList<>();
        int count = 0;

        for (char ch : p.toCharArray())
            map.put(ch, (map.getOrDefault(ch, 0) + 1));

        while (j < s.length()) {

            if (map.containsKey(s.charAt(j))) {
                int val = map.get(s.charAt(j)) - 1;
                if (val == 0)
                    count--;
                map.put(s.charAt(j), val);
            }

            if ((j - i + 1) < map.size()) {
                j++;
            } else if ((j - i + 1) == map.size()) {
                if (count == 0)
                    output.add(i);
                if (map.containsKey(s.charAt(i))) {
                    int val = map.get(s.charAt(i));
                    if (val == 0)
                        count++;
                    map.put(s.charAt(j), val+1);
                }
                i++;
                j++;
            }
        }
        return output;
    }
}