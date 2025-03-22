// problem link: https://leetcode.com/problems/container-with-most-water/

package TwoPointers;

class Solution {
    public int maxArea(int[] height) {

        int l = 0;
        int r = height.length - 1;

        int maxVolume = 0;

        while (l < r) {

            maxVolume = Math.max(maxVolume, Math.min(height[l], height[r]) * (r - l));

            if (l < r && height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxVolume;

    }
}