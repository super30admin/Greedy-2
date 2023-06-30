// Time Complexity : O(n)
// Space Complexity : O(1) ( map has only 26 characters)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Greedy 

class Solution {
public:
    vector<int> partitionLabels(string s) {
        if(s.size()==1) return {1};
        unordered_map<char,int>map;
        int n = s.size();
        for(int i = 0;i<n;i++){
            char c = s[i];
            map[c] = i;
        }
        vector<int>ans;
        int start = 0;
        int end = 0;
        for(int i = 0;i<n;i++)
        {
            char c = s[i];
            end = max(end,map[c]);
            if(i==end){
                ans.push_back(end-start+1);
                start = end + 1;
            }
        }
        return ans;
    }
};