/*
Time complexity: O(n)
Space complexity: O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution {
public:
    vector<int> partitionLabels(string s) {
        unordered_map<char,int>mp;
        for(int i = 0; i < s.size(); i++){
            char ch = s[i];
            mp[ch] = i;
        }
        vector<int> res;
        int prev = -1;
        int maxi = 0;
        
        for(int i = 0; i < s.size(); i++){
            maxi = max(maxi, mp[s[i]]);
            if(maxi == i){
                res.push_back(maxi - prev);
                prev = maxi;
            }
        }
        return res;
    }
};