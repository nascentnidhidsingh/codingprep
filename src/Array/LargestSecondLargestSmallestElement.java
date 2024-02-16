package Array;

public class LargestSecondLargestSmallestElement {

    public static void main(String args[]) {
        int[] nums = {8, 9, 6, 5, 2, 30, 4, 7};
        int ar[] = {2, 2, 2, 2};
//        largestElement(nums);
//        secondLargestElement(nums);
        largestElement(ar);
        secondLargestElement(ar);
        secondSmallestElement(ar);
    }

    private static void secondLargestElement(int[] nums) {
        if (nums.length < 2) {
            System.out.println("The array size is less than 2");
            return;
        }

        int sLargest = Math.min(nums[0], nums[1]);
        int largest = Math.max(nums[0], nums[1]);
        if (nums.length == 2) {
            System.out.println("Second Largest Element in array is" + " : " + sLargest);
        }

        for (int i : nums) {
            if (i > largest) {
                sLargest = largest;
                largest = i;
            } else if (i < largest && i > sLargest) {
                sLargest = i;
            }
        }
        sLargest = (sLargest == largest) ? -1 : sLargest;
        System.out.println("Second Largest Element in array is" + " : " + sLargest);
    }

    private static void largestElement(int[] nums) {

        int max = nums[0];
        for (int i : nums) {
            if (max < i)
                max = i;
        }
        System.out.println("Largest Element in array is" + " : " + max);
    }

    private static void secondSmallestElement(int[] nums) {
        if (nums.length < 2) {
            System.out.println("The array size is less than 2");
            return;
        }

        int smallest = Math.min(nums[0], nums[1]);
        int sSmallest = Math.max(nums[0], nums[1]);
        if (nums.length == 2) {
            System.out.println("Second Smallest Element in array is" + " : " + sSmallest);
        }

        for (int i : nums) {
            if (i < smallest) {
                sSmallest = smallest;
                smallest = i;
            } else if (i > smallest && i < sSmallest) {
                smallest = sSmallest;
                sSmallest = i;
            }
        }
        sSmallest = (sSmallest == smallest) ? -1 : sSmallest;
        System.out.println("Second Smallest Element in array is" + " : " + sSmallest);
    }
}
