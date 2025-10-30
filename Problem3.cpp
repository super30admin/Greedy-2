// Time Complexity : O(n)
// Space Complexity : O(26) ~ O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We create a hashmap with the char and it's last occured index
// 2. Then we start apporaching greedily, and keep expanding our end, with the
// max of curr char's end
// 3. If end == index, we push the window length and update start to end + 1
#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
  vector<int> partitionLabels(string s) {
    // last occurence index
    unordered_map<char, int> u;
    for (int i = 0; i < s.size(); i++) {
      u[s[i]] = i;
    }

    vector<int> res;
    int start = 0;
    int end = 0;
    for (int i = 0; i < s.size(); i++) {
      end = max(end, u[s[i]]);
      if (end == i) {
        res.push_back(end - start + 1);
        start = end + 1;
      }
    }

    return res;
  }
};
