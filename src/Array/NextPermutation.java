package Array;


class NextPermutation {

    public static void main(String[] args) {
        int[] ar = {2, 1, 5, 4, 3, 0, 0};
        nextPermutation(ar);
        for (int i : ar) {
            System.out.print(i + " ");
        }
    }

    public static void nextPermutation(int[] nums) {
        //eg - 2154300, O/P - 2354100
        int n = nums.length;
        int index = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(nums, 0, n - 1);
        } else {
            for (int i = n - 1; i >= index; i--) {
                if (nums[i] > nums[index]) {
                    swap(nums, i, index);
                    break;
                }
            }
            reverse(nums, index + 1, n - 1);
        }
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}