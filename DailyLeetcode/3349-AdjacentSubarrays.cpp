// problem link: https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i

#include <vector>

using namespace std;

class Solution { // 12ms beats 70%
public:
    bool hasIncreasingSubarrays(vector<int>& nums, int k) {
        
        if(nums.size() < 2 * k) return false;
        if(k == 1 && nums.size() >= 2) return true;

        vector<bool> res;
        res.reserve(nums.size() - 1);

        for(int i = 1; i < nums.size(); ++i){
            res.push_back(nums[i] > nums[i-1]);
        }

        int l = (k-1) * 2 + 1;

        for(int i = l; i <= res.size(); ++i){
            bool valid = true;
            for(int j = i-l; j < i; ++j){
                if(j == i-k)continue;
                if(!res[j]){
                    valid = false;
                    break;
                }
            }
            if(valid) return true;
        }

        return false;

    }
};