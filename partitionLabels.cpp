// Time Complexity :O(n) where n in the number elements in the string
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    vector<int> partitionLabels(string s) {
        unordered_map<char,int> hMap;
        for(int i = 0;i < s.length();i++){
            hMap[s[i]] = i;
        }
        int end = -1;
        int start = 0;
        vector<int> ans;
        for(int i = 0;i < s.length();i++){
            end = max(end,hMap[s[i]]);
            if(i == end){
                ans.push_back(end-start+1);
                start = end+1;
            }
        }
        return ans;
    }
};