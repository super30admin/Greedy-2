/* 
    Time Complexity                              :  O(2*N) used in the 2 for loops. 
    Space Complexity                             :  O(1)
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  


class Solution {
public:
    vector<int> partitionLabels(string s) {
        int n = s.size();
        vector<int> ans;
        vector<int> chars(26,0);
        for(int i=0;i<n;i++) {
            int idx = s[i] - 'a';
            chars[idx] = i;
        }
        
        int mx=0,count=0;
        for(int i=0;i<n;i++) {
            int idx = s[i]-'a';
            int cmx = chars[idx];
            
            
            if(cmx > mx) {
                mx = cmx;
            } 
            
            count++;
            if(i == mx) {
                ans.push_back(count);
                count=0;
            }
        }
        
        return ans;
    }
};