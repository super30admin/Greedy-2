// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We first get the maxfreq and keys that have maxfreq
// 2. The least interval is when max frequenices task are clubbed together
// 3. We calculate number of idles between these max frequency tasks
// 3. Therefore our ans would be no of tasks length + idle time we have to wait

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int leastInterval(vector<char> &tasks, int n) {
    unordered_map<char, int> u;
    int maxfreq = 0;
    for (auto task : tasks) {
      u[task]++;
      maxfreq = max(maxfreq, u[task]);
    }

    int maxfreqkeys = 0;
    for (auto it : u) {
      if (it.second == maxfreq) {
        maxfreqkeys++;
      }
    }

    int partitions = (maxfreq - 1);
    int availableSlots = (n - (maxfreqkeys - 1)) * partitions;
    int pendingTasks = (int)tasks.size() - maxfreq * maxfreqkeys;
    int idle = max(0, availableSlots - pendingTasks);
    return (int)tasks.size() + idle;
  }
};
