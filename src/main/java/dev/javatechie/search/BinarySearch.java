package dev.javatechie.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12, 15};
        int target = 7;
        final BinarySearch bs = new BinarySearch();
        System.out.println(bs.binarySearch(nums, target));
    }

    public int binarySearch(final int[] nums, final int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
