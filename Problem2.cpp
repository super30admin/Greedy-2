// Time Complexity : O(nlogn) + O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We first sort the people list w.r.t max height and then if it's same then
// according to ascending order of people
// 2. Then we keep inserting at the index equal to how many taller people ahead
// of them
// 3. Since we have sorted earlier with max heights, inserting at the index
// ensures everyone sees the same number of heighted people

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  vector<vector<int>> reconstructQueue(vector<vector<int>> &people) {
    vector<vector<int>> res;
    // sort with max height and then ascending order of people
    sort(begin(people), end(people), [](vector<int> a, vector<int> b) {
      if (a[0] != b[0]) {
        return a[0] > b[0];
      }
      return b[1] > a[1];
    });

    for (auto it : people) {
      res.insert(res.begin() + it[1], it);
    }

    return res;
  }
};
