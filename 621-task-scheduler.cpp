/* 
    Time Complexity                              :  O(2*N) for the 2 loops
    Space Complexity                             :  O(N) to store the freq in the map
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  


class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        
        int mf = INT_MIN, mc=0;
        unordered_map<char,int> mp;
        for(auto task : tasks) {
            mp[task]++;
            mf = max(mf, mp[task]);
        }
        
        for(auto m : mp) {
            if(m.second == mf)
                mc++;
        }
        
        int part = mf - 1;
        int emptySlots = part * (n - (mc - 1));
        int pendingTasks = tasks.size() - mf*mc;
        int idle = max(0, emptySlots - pendingTasks);
        
        return idle+tasks.size();
        
    }
};