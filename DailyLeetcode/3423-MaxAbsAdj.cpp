// problem link: https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/

#include <vector>
#include <cmath>

class Solution { // 0ms beats 100%
public:
    int maxAdjacentDistance(std::vector<int>& nums) {
        
        int maxDiff = 0;

        maxDiff = std::max(maxDiff, std::abs(nums[0] - nums[nums.size() - 1]));
        
        for(int i = 1; i < nums.size(); i ++){
            maxDiff = std::max(maxDiff,std::abs( nums[i] - nums[i - 1]));
        }

        return maxDiff;

    }
}; 