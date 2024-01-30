class TwoSumInputArraySorted {
    public int[] twoSum(int[] numbers, int target) {

        int start = 0;
        int end = numbers.length - 1;
        int[] output = new int[2];

        while (start <= end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) {
                output[0] = start + 1;
                output[1] = end + 1;
                break;
            } else if (sum > target)
                end--;
            else {
                start++;
            }
        }
        return output;
    }
}