// problem link: https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/

#include <vector>
#include <algorithm>
#include <cmath>

class Greedy // 32ms beats 21%
{
public:
    int minimizeMax(std::vector<int> &nums, int p)
    {
        if (nums.size() == 1 || p == 0)
        {
            return 0;
        }

        std::sort(nums.begin(), nums.end());

        int low = 0;
        int high = nums[nums.size() - 1];
        int ans = high;

        while (low <= high)
        {
            int middle = low + (high - low) / 2;

            if (greedy(nums, middle, p))
            {
                ans = middle;
                high = middle - 1;
            }
            else
            {
                low = middle + 1;
            }
        }

        return ans;
    }

private:
    bool greedy(std::vector<int> &nums, int middle, int count)
    {

        for (int i = 1; i < nums.size(); i++)
        {
            if (nums[i] - nums[i - 1] <= middle)
            {
                --count;
                ++i;
                if (count == 0)
                {
                    return true;
                }
            }
        }
        return false;
    }
};