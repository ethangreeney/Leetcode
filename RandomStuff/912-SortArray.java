package RandomStuff;

// Problem link: https://leetcode.com/problems/sort-an-array/

import java.util.Random;

class Solution { // 2210ms beats 5%

    public int[] sortArray(int[] nums) {

        sortArray(nums, 0, nums.length - 1);
        return nums;

    }

    public Random rand = new Random();

    private void sortArray(int[] nums, int l, int r) {

        if (r - l <= 0) {
            return;
        }
        int randint = rand.nextInt(l, r);

        swap(nums, randint, r);

        int lessThanPivot = l - 1;

        for (int i = l; i < r; i++) {

            if (nums[i] < nums[r]) {
                swap(nums, i, ++lessThanPivot);
            }

        }

        swap(nums, r, ++lessThanPivot);

        sortArray(nums, l, lessThanPivot - 1);
        sortArray(nums, lessThanPivot + 1, r);

    }

    private void swap(int[] nums, int r, int l) {
        int temp = nums[r];
        nums[r] = nums[l];
        nums[l] = temp;
    }
}