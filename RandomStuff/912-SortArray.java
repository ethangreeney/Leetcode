package RandomStuff;

import java.util.LinkedList;
import java.util.Queue;

// Problem link: https://leetcode.com/problems/sort-an-array/

import java.util.Random;

class QuickSortRandomPivot { // 2210ms beats 5%

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

class CountingSort { // 4ms beats 99.2%

    public int[] sortArray(int[] nums) {

        if (nums.length < 2) {
            return nums;
        }

        int min = nums[0];
        int max = nums[1];

        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        int[] bins = new int[max - min + 1];

        for (int i : nums) {
            bins[i - min]++;
        }

        int index = 0;

        for (int i = 0; i < bins.length; i++) {

            while (bins[i] != 0) {
                nums[index++] = i + min;
                bins[i]--;
            }

        }

        return nums;

    }

}

class RadixSort { // Only works with positive values

    public int[] sortArray(int[] nums) {

        if (nums.length < 2) {
            return nums;
        }

        int max = nums[0];

        for (int i : nums) {
            max = Math.max(max, i);
        }

        for (int exponent = 1; max / exponent > 0; exponent *= 10) {

            int[] bins = new int[10];
            int[] output = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                bins[nums[i] / exponent % 10]++;
            }

            for (int i = 1; i < 10; i++) {
                bins[i] += bins[i - 1];
            }

            for (int i = nums.length - 1; i >= 0; i--) {
                output[--bins[nums[i] / exponent % 10]] = nums[i];
            }

            nums = output;

        }

        return nums;

    }

}