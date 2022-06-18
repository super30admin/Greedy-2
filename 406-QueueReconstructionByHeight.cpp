/* 
    Time Complexity                              :  O(N^2) to insert in the ans vector.
    Space Complexity                             :  O(1)
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

class Solution {
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        int n = people.size();
        sort(begin(people),end(people),cmp);
        vector<vector<int>> ans;
        for(int j=0;j<n;j++) {
            auto p = people[j];
            ans.insert(begin(ans)+p[1],p);
        }
        return ans;
    }
    
    static bool cmp(vector<int>& a, vector<int>& b) {
        return (a[0] != b[0]) ? a[0] > b[0] : a[1] < b[1];
    }
};