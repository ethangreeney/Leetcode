// problem link: https://leetcode.com/problems/car-fleet

#include <algorithm>
#include <vector>

class Solution {  // 29ms beats 89%
 public:
  int carFleet(int target, std::vector<int>& position,
               std::vector<int>& speed) {
    int num_fleets = 0;
    double slowest_so_far = 0.0;

    std::vector<std::pair<int, int>> cars;
    cars.reserve(position.size());

    for (int i = 0; i < position.size(); ++i) {
      cars.emplace_back(position[i], speed[i]);
    }

    std::sort(cars.begin(), cars.end(),
              [](const auto& a, const auto& b) { return a.first > b.first; });

    for (const auto& car : cars) {
      double time_to_finish =
          (target - car.first) / static_cast<double>(car.second);

      if (time_to_finish > slowest_so_far) {
        ++num_fleets;
        slowest_so_far = time_to_finish;
      }
    }
    return num_fleets;
  }
};