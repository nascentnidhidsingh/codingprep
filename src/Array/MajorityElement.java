package Array;

public class MajorityElement {
    public static void main(String[] args) {
        int[] ar = {2, 3, 3, 2, 1, 3, 3};
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i : ar) {
//            map.put(i, map.getOrDefault(i, 0) + 1);
//        }
//        System.out.println(map);
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() >= (ar.length / 2)) {
//                System.out.println(entry.getKey());
//            }
//        }
        int majorityElement = -1;
        int count = 0;
        for (int i : ar) {
            if (count == 0) {
                count = 1;
                majorityElement = i;
            } else if (i == majorityElement) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int i : ar) {
            if (i == majorityElement)
                count++;
        }
        System.out.println(count > (ar.length / 2) ? majorityElement : -1);
    }
}
