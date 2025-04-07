// https://leetcode.com/problems/partition-labels/description/
// Test Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public:
        vector<int> partitionLabels(string s) {
            int n = s.length();
            unordered_map<char,int> mp;
            for(int i=0; i<n; i++){
                mp[s[i]] = i;
            }
            int start=0; int end=0;
            vector<int> ans;
            for(int i=0; i<n; i++){
                end = max(end,mp[s[i]]);
                if(i == end){
                    ans.push_back(end-start+1);
                    start = i+1;
                }
            }
            return ans;
        }
    };