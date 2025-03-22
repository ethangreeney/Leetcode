// problem link: https://leetcode.com/problems/container-with-most-water/

package TwoPointers;

class Solution {
    public int maxArea(int[] height) {

        int l = 0;
        int r = height.length - 1;

        int maxVolume = 0;

        while (l < r) {

            int minHeight = Math.min(height[l], height[r]);
            maxVolume = Math.max(maxVolume, minHeight * (r - l));

            while (l < r && height[l] <= minHeight) {
                l++;
            }
            while (l < r && height[r] <= minHeight) {
                r--;
            }
        }

        return maxVolume;

    }
}