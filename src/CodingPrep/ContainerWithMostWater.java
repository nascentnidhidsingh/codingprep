package CodingPrep;

class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int area = Integer.MIN_VALUE;

        while (start <= end) {
            if (height[start] > height[end]) {
                area = Math.max(area, height[end] * (end-start));
                end--;
            } else {
                area = Math.max(area, height[start] * (end-start));
                start++;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[] ar = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(ar));
    }
}